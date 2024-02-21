/**
 * Clase creada el 02/
 */
package objetos;

import java.sql.Date;

/**
 * La clase Cuenta representa una cuenta bancaria asociada a un cliente.
 * Contiene información como el identificador de la cuenta, la fecha de apertura,
 * el saldo actual y el cliente asociado a la cuenta.
 */
public class Cuenta {
    private String idCuenta; // Identificador de la cuenta
    private Date fechaApertura; // Fecha de apertura de la cuenta
    private int saldo; // Saldo actual de la cuenta
    private Cliente cliente; // Cliente asociado a la cuenta
   private String estado;
    // Constructores

    /**
     * Constructor de Cuenta sin parámetros.
     */
    public Cuenta() {
    }

    /**
     * Constructor de Cuenta que recibe todos los atributos como parámetros.
     */
    public Cuenta(String idCuenta, Date fechaApertura, int saldo, Cliente cliente) {
        this.idCuenta = idCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    /**
     * Constructor de Cuenta que recibe el saldo y el cliente como parámetros.
     * No incluye el identificador ni la fecha de apertura.
     */
    public Cuenta(int saldo, Cliente cliente) {
        this.saldo = saldo;
        this.cliente = cliente;
    }

    /**
     * Constructor de Cuenta que recibe la fecha de apertura, el saldo y el cliente como parámetros.
     * No incluye el identificador.
     */
    public Cuenta(Date fechaApertura, int saldo, Cliente cliente) {
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    /**
     * Regresa el estado de la cuenta
     * @return 
     */
    public String getEstado() {
        return estado;
    }
/**
 * le asigna el estado
 * @param estado 
 */
    // Getters y Setters
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el identificador de la cuenta.
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el identificador de la cuenta.
     */
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Devuelve la fecha de apertura de la cuenta.
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Establece la fecha de apertura de la cuenta.
     */
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Devuelve el saldo actual de la cuenta.
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo actual de la cuenta.
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * Devuelve el cliente asociado a la cuenta.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la cuenta.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Otros métodos

    /**
     * Retorna una representación en cadena del saldo de la cuenta.
     */
    @Override
    public String toString() {
        return  "  $" + saldo;
    }

}
