package objetos;

import java.sql.Timestamp;

/**
 * La clase Transaccion representa una transacción realizada en una cuenta.
 * Contiene información como el identificador de la transacción, la fecha y hora
 * de la transacción, el tipo de transacción, la cantidad involucrada y la
 * cuenta asociada.
 *
 * @author fabri
 */
public class Transaccion {

    private String formatoTipoTransaccion; // Formato del tipo de transacción
    private int id_transaccion; // Identificador de la transacción
    private Timestamp fechahora_transaccion; // Fecha y hora de la transacción
    private boolean tipo_transaccion; // Tipo de transacción (true: transferencia, false: con folio)
    private int cantidad; // Cantidad de la transacción
    private Cuenta cuenta; // Cuenta asociada a la transacción

    /**
     * Constructor de Transaccion que recibe todos los atributos como
     * parámetros.
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
     * Método get que regresa el ID de la transacción.
     *
     * @return El ID de la transacción.
     */
    public int getId_transaccion() {
        return id_transaccion;
    }

    /**
     * Método set que asigna valor al ID de la transacción.
     *
     * @param id_transaccion El ID de la transacción.
     */
    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    /**
     * Método get que regresa la fecha y hora de la transacción.
     *
     * @return La fecha y hora de la transacción.
     */
    public Timestamp getFechahora_transaccion() {
        return fechahora_transaccion;
    }

    /**
     * Método set que establece valor a la fecha y hora de la transacción.
     *
     * @param fechahora_transaccion La fecha y hora de la transacción.
     */
    public void setFechahora_transaccion(Timestamp fechahora_transaccion) {
        this.fechahora_transaccion = fechahora_transaccion;
    }

    /**
     * Método que retorna el tipo de transacción.
     *
     * @return true si es una transferencia, false si es con folio.
     */
    public boolean isTipo_transaccion() {
        return tipo_transaccion;
    }

    /**
     * Método set que establece el tipo de transacción.
     *
     * @param tipo_transaccion true si es una transferencia, false si es con
     * folio.
     */
    public void setTipo_transaccion(boolean tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }

    /**
     * Método get que regresa la cantidad de dinero que se involucra en la
     * transacción.
     *
     * @return La cantidad de dinero involucrada en la transacción.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Método set que establece valor a la cantidad de dinero involucrada en la
     * transacción.
     *
     * @param cantidad La cantidad de dinero involucrada en la transacción.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Método que regresa el objeto cuenta al cual pertenece la transacción.
     *
     * @return El objeto cuenta asociado a la transacción.
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Método que establece un objeto cuenta asociado a la transacción.
     *
     * @param cuenta El objeto cuenta asociado a la transacción.
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Método get que regresa el formato del tipo de transacción.
     *
     * @return El formato del tipo de transacción.
     */
    public String getFormatoTipoTransaccion() {
        return formatoTipoTransaccion;
    }

    /**
     * Método set que establece valor al formato del tipo de transacción.
     *
     * @param formatoTipoTransaccion El formato del tipo de transacción.
     */
    public void setFormatoTipoTransaccion(String formatoTipoTransaccion) {
        this.formatoTipoTransaccion = formatoTipoTransaccion;
    }

    /**
     * Retorna una representación en cadena de la transacción.
     *
     * @return Una cadena que representa la transacción.
     */
    @Override
    public String toString() {
        return "\nTransaccion: " + formatoTipoTransaccion + "\nFecha: " + fechahora_transaccion + "\nCantidad: " + cantidad + "\n";
    }
}
