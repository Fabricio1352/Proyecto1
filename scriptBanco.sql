

/*Trigger que funciona para que cada que se inserte una transaccion, dependiendo si su tipo es 0 o 1, 
automaticamente genere el respectivo tipo de transaccion que le corresponda, siendo 1 para las transacciones normales
 y 0 para las de con folio*/
DELIMITER $$
CREATE TRIGGER Tipo_transaccion
AFTER INSERT ON Transaccion
FOR EACH ROW
BEGIN
    DECLARE id INT;
    
    SET id = NEW.id_transaccion; # se declaran variables
    IF NEW.tipo_transaccion = 1 THEN
        INSERT INTO TransaccionNormalCliente (id_transaccion) VALUES (id); # crea la transaccion normal si el tipo es 1
    ELSE
        INSERT INTO TransaccionFolioCliente (id_transaccion) VALUES (id); # Crea una transacción con folio si es 0
        CALL folio(id); # Asigna un folio
        CALL passw(id); # Asignamos una contraseña
    END IF;
END$$
DELIMITER ;

/*
Procedimiento almacenado para generar una password aleatoria
*/
DELIMITER $$
CREATE PROCEDURE passw(IN idtransaccion int) # Recibe como parametro el id de la transaccion insertada, el cual viene de un trigger
BEGIN 
	DECLARE caracteres VARCHAR(100) DEFAULT 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'; # La password es una combinacion de todos estos caracteres
	DECLARE passsword VARCHAR(255) DEFAULT ''; # Declaramos la que sera la password, empieza estando vacia, adelante se agregan los caracteres
	DECLARE i INT DEFAULT 0; # contador, en este caso sera menor a 8, ya que el requerimiento es que la pw sea de 8 caracteres
WHILE i < 8 DO
SET passsword := CONCAT(passsword,     SUBSTRING(caracteres, FLOOR(1 + RAND() * LENGTH(caracteres)), 1)         ); 
	#CONCAT: concatena cadenas de texto
    #SUBSTRING: Extrae una parte del texto, en este caso, va extraer una letra de indice aleatorio. La longitud es especificada de un solo caracter
			# caracteres es la cadena a subtraer texto 
			#FLOOR( 1 -> se le suma uno, por si sale cero, ya que RAND() es un valor aleatorio entre 0 y 1, multiplicado por long caracteres, tenemos un indice, de tam 1
    #FLOOR: Redondea y da el numero entero mas bajo. En este caso, el entero abajo de 1 + num aleatorio * longitud de los caracteres
    #LENGTH: Devuelve el numero de caracteres, en este caso de la variable "caracteres"
    # := -> asignar valor
SET i := i + 1; # Aumentamos el contador
END WHILE;
UPDATE TransaccionFolioCliente SET password_transaccion = passsword WHERE id_transaccion = idtransaccion; # Actualizamos la transferencia que se realizo, seteamos la pw a la que creamos
END $$
DELIMITER ; 








/*
	Mismo procedimiento que en el procedimiento passw(), pero para crear el folio
*/
DELIMITER $$
CREATE PROCEDURE folio(IN idtransaccion int)

BEGIN 
	DECLARE caracteresFolio VARCHAR(100) DEFAULT 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
	DECLARE folio VARCHAR(255) DEFAULT '';
DECLARE i INT DEFAULT 0;
WHILE i < 20 DO  # La unica diferencia, es que, en este caso vamos a hacer un folio de 20 caracteres, el problema no especifico del folio
	SET folio := CONCAT(folio, SUBSTRING(caracteresFolio, FLOOR(1 + RAND() * LENGTH(caracteresFolio)), 1));
	SET i := i + 1;
END WHILE;
UPDATE TransaccionFolioCliente SET folio_transaccion = folio WHERE id_transaccion = idtransaccion;

END$$
DELIMITER ;






/*
	Este procedimiento es solo para mostrar la informacion de un cliente, sus transacciones
    se pasa como parametro el id de la cuenta, el cual pertenece a un cliente.
    Si el cliente tiene varias cuentas, aqui se introduce la cuenta que quiera ver.
    
    No utilizamos funcion aqui porque una funcion no puede retornar una tabla, puede retornar
    valores en linea sin formato, pero no era muy presentable, asi que usamos un procedure
    
*/

DELIMITER $$ 
CREATE PROCEDURE verHistorial(IN id VARCHAR(16))
BEGIN
	SELECT
		id_transaccion AS 'Id',
        fecha_hora_transaccion AS 'Fecha',
        cantidad AS 'Monto',
			CASE 
				# para que no se muestren 0 y 1, le damos formato usando WHEN
                # tambien se pudo cambiar el atributo de la columna tipo_transaccion a un ENUM
                # que guarde valores de 'folio' y 'cliente' pero es mas facil operar con true y false
				WHEN tipo_transaccion = 0 THEN 'Transferencia'
                WHEN tipo_transaccion = 1 THEN 'Cliente'
			END AS 'Tipo de Transacción'

    FROM
		transaccion
	WHERE id = transaccion.id_cuenta
     ORDER BY
        fecha_hora_transaccion DESC;
END$$
DELIMITER ;





/*
	Trigger para calcular la edad cuando se inserte un cliente
*/
DELIMITER $$
CREATE TRIGGER calcularEdad
BEFORE INSERT ON cliente
FOR EACH ROW 
BEGIN
    SET NEW.edad = TIMESTAMPDIFF(YEAR,NEW.fecha_nacimiento,CURDATE());
    # metodo NEW y atributo edad, sql sabe cual editar, y le setea la edad
END$$

DELIMITER ;







/*
	Procedimiento almacenado para realizar transferencias. Pide como parametros cuenta destino, monto, y cuenta origen
    
	Tambien esta la opcion de hacer este metodo de transferencia en la capa de aplicacion, pero optamos por hacerlo 
		aqui para usar transacciones directamente en la bd y hacerlo un poco mas seguro
*/

DELIMITER $$
CREATE PROCEDURE transferencia(IN id_cuenta_origen VARCHAR(16), monto INT, id_cuenta_destino VARCHAR(16))
BEGIN 
			# Declaramos las variables que seran los saldos de las cuentas
		DECLARE saldo_origen INT; 
        
        # Inicializamos esas variables al saldo que tengan las cuentas
        SELECT saldo INTO saldo_origen FROM cuenta WHERE id_cuenta = id_cuenta_origen;
        
			# Si el saldo de la cuenta origen, es mayor al monto, significa que si tiene dinero suficiente para la transferencia
        IF saldo_origen >= monto THEN
        
				# Hacemos una transaccion para cumplir con el principio ACID
			START TRANSACTION;
            
            UPDATE cuenta SET saldo = saldo - monto WHERE id_cuenta = id_cuenta_origen;
            UPDATE cuenta SET saldo = saldo + monto WHERE id_cuenta = id_cuenta_destino;
				# El usuario tiene dinero, y no hubo errores, guardamos todos los cambios
	    INSERT INTO Transaccion (cantidad, tipo_transaccion, id_cuenta) VALUES (-monto, 1, id_cuenta_origen); #Genera la transaccion de retiro
        /* en la transaccion de retiro considere poner el monto en negativo para representar el retiro en las consultas de historial
        no se si lo quieras dejar asi o cambiarlo*/
        INSERT INTO Transaccion (cantidad, tipo_transaccion, id_cuenta) VALUES (monto, 1, id_cuenta_destino); #Genera la Transacción de depósito
            COMMIT; 
            
		else
				# El usuario no tiene suficiente dinero, revertimos todos los cambios
			ROLLBACK;
		END IF;
        
END$$

DELIMITER ;

/*
Trigger que encripta contraseña del cliente
*/
DELIMITER $$

CREATE TRIGGER encriptar_passw
BEFORE INSERT ON Cliente
FOR EACH ROW
BEGIN
    SET NEW.passw = SHA2(NEW.passw, 256);
END$$

DELIMITER ;




drop procedure cobrartransaccion;
DELIMITER $$
CREATE PROCEDURE CobrarTransaccion(
    IN folioTransaccion VARCHAR(255),
    IN passwTransaccion VARCHAR(8)
)
BEGIN
    DECLARE idTransaccion INT;
    DECLARE estadoTransaccion VARCHAR(20);
    DECLARE montoTransaccion INT;
    DECLARE cuentaID VARCHAR(16);

    -- Buscar el id_transaccion asociado al folio y contraseña 
    SELECT id_transaccion, estado INTO idTransaccion, estadoTransaccion
    FROM TransaccionFolioCliente
    WHERE folio_transaccion = folioTransaccion AND password_transaccion = passwTransaccion;

    -- Verificar si se encontró alguna transacción con el folio y contraseña proporcionados
    IF idTransaccion IS NOT NULL THEN
        -- Obtener el estado de la transacción
        IF estadoTransaccion = 'no cobrado' THEN
            -- Obtener la cantidad de la transacción y la cuenta asociada
            SELECT cantidad, id_cuenta INTO montoTransaccion, cuentaID
            FROM Transaccion
            WHERE id_transaccion = idTransaccion;

            -- Actualizar el estado de la transacción a 'cobrado'
            UPDATE TransaccionFolioCliente
            SET estado = 'cobrado'
            WHERE id_transaccion = idTransaccion;

            -- Restar el monto de la transacción al saldo de la cuenta asociada
            UPDATE Cuenta
            SET saldo = saldo - montoTransaccion
            WHERE id_cuenta = cuentaID;
        END IF;
    END IF;
END$$
DELIMITER ;










-- ---------------------------------------------------------- TABLAS ------------------------------------------------------------------------------------
CREATE DATABASE banco;
USE BANCO;

CREATE TABLE Cliente(
	id INT PRIMARY KEY NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	apellido_paterno VARCHAR(50) NOT NULL,
	apellido_materno VARCHAR(50) NOT NULL,
	calle VARCHAR(255) NOT NULL,
	colonia VARCHAR(255),
	codigo_postal VARCHAR(255) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
    passw VARCHAR(100) NOT NULL,
	edad INT NULL DEFAULT 0
    
);


/*
	Datos de la cuenta del cliente
    Un cliente puede tener una cuenta
    La cuenta no se puede borrar, puede ser cancelada o actualizada, pero no borrada
*/
CREATE TABLE Cuenta(
	id_cuenta VARCHAR(16) PRIMARY KEY NOT NULL,     -- numero de cuenta
	fecha_apertura TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	saldo BIGINT,	
    id_cliente INT NOT NULL,
    estado VARCHAR(16) DEFAULT 'vigente',
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id)
);



/*
	Una cuenta puede generar 1:N transacciones
    Una transaccion, puede ser de un cliente, o puede ser generada por folio y pw
    
		TIPO OPERACION:
			0 = NO ES CLIENTE -> SE DESENCADENA TRIGGER, SE GENERA PW Y FOLIO
            1 = ES CLIENTE -> TRANSFERENCIA NORMAL
*/
CREATE TABLE Transaccion(
	id_transaccion INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	fecha_hora_transaccion  DATETIME DEFAULT CURRENT_TIMESTAMP, -- establece fecha y hora automaticamente cuando se hace una insercion
	cantidad INT NOT NULL, 
    tipo_transaccion BOOLEAN DEFAULT TRUE, -- 0 NO ES CLIENTE, 1 ES CLIENTE. La funcion verHistorial() le da el formato para que se vea el tipo de transaccion
    id_cuenta VARCHAR(16) NOT NULL,
    FOREIGN KEY (id_cuenta) REFERENCES Cuenta(id_cuenta)
    
);


/*
	En caso de que sea una transferencia normal de un cliente
*/
CREATE TABLE TransaccionNormalCliente(
id_transaccion INT, -- guardamos sin pk, solo referenciamos a la entidad padre
FOREIGN KEY  (id_transaccion) REFERENCES   Transaccion(id_transaccion)
);




/*
	Si noe s cliente, guardamos los datos
		folio_transaccion = empieza siendo null, trigger se activa -> se genera folio y se asigna a este atributo
        password_transaccion = lo mismo
        estado = 
			0 -> no se ha cobrado, deberia de empezar un timer, si 'estado' no cambia a '1', el timer va seguir hasta expirar y eliminar los datos por seguridad
            1 -> ya se cobro, la transaccion se guarda en el historial
		tiempo = aqui  se deberia guardar el tiempo actual, con 10 minutos mas, y se valida que no hayan pasado los 10 minutos. NOW() > tiempo -> expira y se elimina
*/
CREATE TABLE TransaccionFolioCliente(
id_transaccion INT PRIMARY KEY,
folio_transaccion VARCHAR(255),
password_transaccion VARCHAR(8),
estado VARCHAR(20) DEFAULT 'no cobrado',
 tiempo TIMESTAMP DEFAULT NULL  ,
FOREIGN KEY  (id_transaccion) REFERENCES Transaccion(id_transaccion )
);
