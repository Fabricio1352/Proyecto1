
package dao;

import dao.interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La clase ConexionDB implementa la interfaz IConexion y proporciona métodos para establecer
 * conexiones con una base de datos utilizando una cadena de conexión, un nombre de usuario y
 * una contraseña.
 * Esta clase debe ser instanciada con los parámetros necesarios para establecer la conexión
 * con la base de datos.
 * @author fabri
 */
public class ConexionDB implements IConexion {

    private final String cadenaConexion;
    private final String usuario;
    private final String contra;
/**
     * Constructor de la clase ConexionDB.
     *
     * @param cadenaConexion La cadena de conexión a la base de datos.
     * @param usuario El nombre de usuario para acceder a la base de datos.
     * @param contra La contraseña del usuario para acceder a la base de datos.
     */
    public ConexionDB(String cadenaConexion, String usuario, String contra) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contra = contra;
    }

    /**
     * Crea la conexion utilizando la clase Connection de JAVA
     * @return regresa una conexion activa
     * @throws SQLException falla la conexion
     */
    @Override
    public Connection crearConexion() throws SQLException {
        Connection c = DriverManager.getConnection(cadenaConexion, usuario, contra);
        return c;
    }

}
