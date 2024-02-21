/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.sql.Timestamp;

/**
 * La clase Transaccion representa una transacción realizada en una cuenta.
 * Contiene información como el identificador de la transacción, la fecha y hora de la transacción,
 * el tipo de transacción, la cantidad involucrada y la cuenta asociada.
 *@author fabri
 */
public class Transaccion {

    private String formatoTipoTransaccion;
    private int id_transaccion;
    private Timestamp fechahora_transaccion;
    private boolean tipo_transaccion;
    private int cantidad;
    private Cuenta cuenta;
/**
     * Constructor de Transaccion que recibe todos los atributos como parámetros.
     */
    public Transaccion(int id_transaccion, Timestamp fechahora_transaccion, boolean tipo_transaccion, int cantidad, Cuenta cuenta) {
        this.id_transaccion = id_transaccion;
        this.fechahora_transaccion = fechahora_transaccion;
        this.tipo_transaccion = tipo_transaccion;
        this.cantidad = cantidad;
        this.cuenta = cuenta;
    }
 /**
     * Constructor de Transaccion utilizado para ciertos tipos de transacción.
     * No incluye el ID de la transacción ni la cuenta asociada.
     */
    public Transaccion(Timestamp fechahora_transaccion, String formatoTipoTransaccion, int cantidad) {
        this.fechahora_transaccion = fechahora_transaccion;
        this.formatoTipoTransaccion = formatoTipoTransaccion;
        this.cantidad = cantidad;
    }
 /**
     * Constructor de Transaccion sin parámetros.
     */
    public Transaccion() {
    }
 /**
     * Constructor de Transaccion utilizado para ciertos tipos de transacción.
     * No incluye el ID de la transacción ni la cuenta asociada.
     */
    public Transaccion(Timestamp fechahora_transaccion, boolean tipo_transaccion, int cantidad, Cuenta cuenta) {
        this.fechahora_transaccion = fechahora_transaccion;
        this.tipo_transaccion = tipo_transaccion;
        this.cantidad = cantidad;
        this.cuenta = cuenta;
    }
 /**
     * Constructor de Transaccion utilizado para ciertos tipos de transacción.
     * No incluye el ID de la transacción.
     */
    public Transaccion(boolean tipo_transaccion, int cantidad, Cuenta cuenta) {
        this.tipo_transaccion = tipo_transaccion;
        this.cantidad = cantidad;
        this.cuenta = cuenta;
    }
/**
 * Metodo get que regresa el id de una transaccion
 * @return idTransaccion
 */
    public int getId_transaccion() {
        return id_transaccion;
    }
/**
 * metodo set que asigna valor al id
 * @param id_transaccion 
 */
    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }
/**
 * Metodo get que regresa la facha y hora
 * @return fechahora_transaccion
 */
    public Timestamp getFechahora_transaccion() {
        return fechahora_transaccion;
    }
/**
 * Metodo set que establece valor a la fecha
 * @param fechahora_transaccion 
 */
    public void setFechahora_transaccion(Timestamp fechahora_transaccion) {
        this.fechahora_transaccion = fechahora_transaccion;
    }
/**
 * retorna el tipo de transaccion, si es 1 transferencia si es 0 con folio
 * @return 
 */
    public boolean isTipo_transaccion() {
        return tipo_transaccion;
    }
/**
 * Setea valor al tipo de transaccion
 * @param tipo_transaccion 
 */
    public void setTipo_transaccion(boolean tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }
/**
 * metodo get que regresa la cantidad de dinero que se involucra
 * @return cantidad
 */
    public int getCantidad() {
        return cantidad;
    }
/**
 * metodo que establece valor a cantidad
 * @param cantidad 
 */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
/**
 * metodo que regresa el objeto cuenta al cual pertenece la transferencia
 * @return 
 */
    public Cuenta getCuenta() {
        return cuenta;
    }
/**
 * Establece un objeto cuenta 
 * @param cuenta 
 */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Regresa el formato de la transaccion
     * @return 
     */
    public String getFormatoTipoTransaccion() {
        return formatoTipoTransaccion;
    }
/**
 * Establece el valor al formato del tipo de transaccion
 * @param formatoTipoTransaccion 
 */
    public void setFormatoTipoTransaccion(String formatoTipoTransaccion) {
        this.formatoTipoTransaccion = formatoTipoTransaccion;
    }

    /**
     * Retorna una representación en cadena de la transacción.
     */
    @Override
    public String toString() {
        return "\nTransaccion: " + formatoTipoTransaccion + "\nFecha: " + fechahora_transaccion + "\nCantidad: " + cantidad + "\n";
    }

}
