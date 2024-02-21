package objetos;

import java.sql.Date;

/**
 * La clase Cuenta representa una cuenta bancaria asociada a un cliente.
 * Contiene información como el identificador de la cuenta, la fecha de
 * apertura, el saldo actual y el cliente asociado a la cuenta.
 */
public class Cuenta {

    private String idCuenta; // Identificador de la cuenta
    private Date fechaApertura; // Fecha de apertura de la cuenta
    private int saldo; // Saldo actual de la cuenta
    private Cliente cliente; // Cliente asociado a la cuenta
    private String estado; // Estado de la cuenta (activo, inactivo, etc.)

    // Constructores
    /**
     * Constructor de Cuenta sin parámetros.
     */
    public Cuenta() {
    }

    /**
     * Constructor de Cuenta que recibe todos los atributos como parámetros.
     *
     * @param idCuenta Identificador de la cuenta.
     * @param fechaApertura Fecha de apertura de la cuenta.
     * @param saldo Saldo actual de la cuenta.
     * @param cliente Cliente asociado a la cuenta.
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
     *
     * @param saldo Saldo actual de la cuenta.
     * @param cliente Cliente asociado a la cuenta.
     */
    public Cuenta(int saldo, Cliente cliente) {
        this.saldo = saldo;
        this.cliente = cliente;
    }

    /**
     * Constructor de Cuenta que recibe la fecha de apertura, el saldo y el
     * cliente como parámetros. No incluye el identificador.
     *
     * @param fechaApertura Fecha de apertura de la cuenta.
     * @param saldo Saldo actual de la cuenta.
     * @param cliente Cliente asociado a la cuenta.
     */
    public Cuenta(Date fechaApertura, int saldo, Cliente cliente) {
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    // Getters y Setters
    /**
     * Devuelve el estado de la cuenta.
     *
     * @return El estado de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la cuenta.
     *
     * @param estado El estado de la cuenta.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Devuelve el identificador de la cuenta.
     *
     * @return El identificador de la cuenta.
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el identificador de la cuenta.
     *
     * @param idCuenta El identificador de la cuenta.
     */
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Devuelve la fecha de apertura de la cuenta.
     *
     * @return La fecha de apertura de la cuenta.
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Establece la fecha de apertura de la cuenta.
     *
     * @param fechaApertura La fecha de apertura de la cuenta.
     */
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Devuelve el saldo actual de la cuenta.
     *
     * @return El saldo actual de la cuenta.
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo actual de la cuenta.
     *
     * @param saldo El saldo actual de la cuenta.
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /**
     * Devuelve el cliente asociado a la cuenta.
     *
     * @return El cliente asociado a la cuenta.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la cuenta.
     *
     * @param cliente El cliente asociado a la cuenta.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Otros métodos
    /**
     * Retorna una representación en cadena del saldo de la cuenta.
     *
     * @return Una cadena que representa el saldo de la cuenta.
     */
    @Override
    public String toString() {
        return "  $" + saldo;
    }

}
