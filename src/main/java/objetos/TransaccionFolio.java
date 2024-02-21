package objetos;

import java.sql.Timestamp;

/**
 * La clase TransaccionFolio representa una transacción realizada con folio.
 * Contiene información como el identificador de la transacción, el folio de la
 * transacción, la contraseña asociada, el estado de la transacción y el tiempo
 * en que se realizó.
 *
 * @author fabri
 */
public class TransaccionFolio {

    private int idTransaccion; // Identificador de la transacción
    private String folioTransaccion; // Folio de la transacción
    private String passwordTransaccion; // Contraseña asociada a la transacción
    private String estado; // Estado de la transacción
    private Timestamp tiempo; // Tiempo en que se realizó la transacción

    /**
     * Constructor de TransaccionFolio sin parámetros.
     */
    public TransaccionFolio() {
    }

    /**
     * Constructor de TransaccionFolio que recibe todos los atributos como
     * parámetros.
     */
    public TransaccionFolio(int idTransaccion, String folioTransaccion, String passwordTransaccion, String estado) {
        this.idTransaccion = idTransaccion;
        this.folioTransaccion = folioTransaccion;
        this.passwordTransaccion = passwordTransaccion;
        this.estado = estado;
    }

    /**
     * Constructor de TransaccionFolio que recibe el estado como parámetro. No
     * incluye el ID de la transacción, el folio ni la contraseña.
     */
    public TransaccionFolio(String estado) {
        this.estado = estado;
    }

    /**
     * Constructor de TransaccionFolio que recibe el ID de la transacción como
     * parámetro. No incluye el folio, la contraseña ni el estado.
     */
    public TransaccionFolio(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Método get que regresa el estado de la transacción.
     *
     * @return El estado de la transacción.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método set que establece el estado de la transacción.
     *
     * @param estado El estado de la transacción.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método get que regresa el ID de la transacción.
     *
     * @return El ID de la transacción.
     */
    public int getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Método set que asigna valor al ID de la transacción.
     *
     * @param idTransaccion El ID de la transacción.
     */
    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Método get que regresa el folio de la transacción.
     *
     * @return El folio de la transacción.
     */
    public String getFolioTransaccion() {
        return folioTransaccion;
    }

    /**
     * Método set que establece el folio de la transacción.
     *
     * @param folioTransaccion El folio de la transacción.
     */
    public void setFolioTransaccion(String folioTransaccion) {
        this.folioTransaccion = folioTransaccion;
    }

    /**
     * Método get que regresa la contraseña asociada a la transacción.
     *
     * @return La contraseña asociada a la transacción.
     */
    public String getPasswordTransaccion() {
        return passwordTransaccion;
    }

    /**
     * Método set que establece la contraseña asociada a la transacción.
     *
     * @param passwordTransaccion La contraseña asociada a la transacción.
     */
    public void setPasswordTransaccion(String passwordTransaccion) {
        this.passwordTransaccion = passwordTransaccion;
    }

    /**
     * Método get que regresa el tiempo en que se realizó la transacción.
     *
     * @return El tiempo en que se realizó la transacción.
     */
    public Timestamp getTiempo() {
        return tiempo;
    }

    /**
     * Método set que establece el tiempo en que se realizó la transacción.
     *
     * @param tiempo El tiempo en que se realizó la transacción.
     */
    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }
}
