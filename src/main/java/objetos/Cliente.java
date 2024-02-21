package objetos;

import java.sql.Date;

/**
 * La clase Cliente representa un cliente del sistema. Contiene información
 * personal como identificador, nombre, apellidos, dirección, fecha de
 * nacimiento, contraseña y edad.
 */
public class Cliente {

    private int id; // Identificador del cliente
    private String nombre; // Nombre del cliente
    private String apellido_paterno; // Apellido paterno del cliente
    private String apellido_materno; // Apellido materno del cliente
    private String calle; // Calle de la dirección del cliente
    private String colonia; // Colonia de la dirección del cliente
    private String codigo_postal; // Código postal de la dirección del cliente
    private Date fecha_nacimiento; // Fecha de nacimiento del cliente
    private String passw; // Contraseña del cliente
    private int edad; // Edad del cliente

    // Constructores
    /**
     * Constructor de Cliente sin parámetros.
     */
    public Cliente() {
    }

    /**
     * Constructor de Cliente con todos los parámetros.
     *
     * @param id Identificador del cliente.
     * @param nombre Nombre del cliente.
     * @param apellido_paterno Apellido paterno del cliente.
     * @param apellido_materno Apellido materno del cliente.
     * @param calle Calle de la dirección del cliente.
     * @param colonia Colonia de la dirección del cliente.
     * @param codigo_postal Código postal de la dirección del cliente.
     * @param fecha_nacimiento Fecha de nacimiento del cliente.
     * @param passw Contraseña del cliente.
     * @param edad Edad del cliente.
     */
    public Cliente(int id, String nombre, String apellido_paterno, String apellido_materno, String calle, String colonia, String codigo_postal, Date fecha_nacimiento, String passw, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.calle = calle;
        this.colonia = colonia;
        this.codigo_postal = codigo_postal;
        this.fecha_nacimiento = fecha_nacimiento;
        this.passw = passw;
        this.edad = edad;
    }

    /**
     * Constructor de Cliente con todos los parámetros excepto el ID.
     *
     * @param nombre Nombre del cliente.
     * @param apellido_paterno Apellido paterno del cliente.
     * @param apellido_materno Apellido materno del cliente.
     * @param calle Calle de la dirección del cliente.
     * @param colonia Colonia de la dirección del cliente.
     * @param codigo_postal Código postal de la dirección del cliente.
     * @param fecha_nacimiento Fecha de nacimiento del cliente.
     * @param passw Contraseña del cliente.
     */
    public Cliente(String nombre, String apellido_paterno, String apellido_materno, String calle, String colonia, String codigo_postal, Date fecha_nacimiento, String passw) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.calle = calle;
        this.colonia = colonia;
        this.codigo_postal = codigo_postal;
        this.fecha_nacimiento = fecha_nacimiento;
        this.passw = passw;
    }

    /**
     * Constructor de Cliente con solo el ID.
     *
     * @param id Identificador del cliente.
     */
    public Cliente(int id) {
        this.id = id;
    }

    // Getters y Setters
    /**
     * Obtiene el identificador del cliente.
     *
     * @return El identificador del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del cliente.
     *
     * @param id El identificador del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     *
     * @return El apellido paterno del cliente.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     *
     * @param apellido_paterno El apellido paterno del cliente.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     *
     * @return El apellido materno del cliente.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno del cliente.
     *
     * @param apellido_materno El apellido materno del cliente.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtiene la calle de la dirección del cliente.
     *
     * @return La calle de la dirección del cliente.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección del cliente.
     *
     * @param calle La calle de la dirección del cliente.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia de la dirección del cliente.
     *
     * @return La colonia de la dirección del cliente.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección del cliente.
     *
     * @param colonia La colonia de la dirección del cliente.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el código postal de la dirección del cliente.
     *
     * @return El código postal de la dirección del cliente.
     */
    public String getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Establece el código postal de la dirección del cliente.
     *
     * @param codigo_postal El código postal de la dirección del cliente.
     */
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     *
     * @return La fecha de nacimiento del cliente.
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     *
     * @param fecha_nacimiento La fecha de nacimiento del cliente.
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Obtiene la edad del cliente.
     *
     * @return La edad del cliente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del cliente.
     *
     * @param edad La edad del cliente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene la contraseña del cliente.
     *
     * @return La contraseña del cliente.
     */
    public String getPassw() {
        return passw;
    }

    /**
     * Establece la contraseña del cliente.
     *
     * @param passw La contraseña del cliente.
     */
    public void setPassw(String passw) {
        this.passw = passw;
    }

    /**
     * Devuelve una representación en cadena del objeto Cliente.
     *
     * @return La representación en cadena del objeto Cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", calle=" + calle + ", colonia=" + colonia + ", codigo_postal=" + codigo_postal + ", fecha_nacimiento=" + fecha_nacimiento + ", passw=" + passw + ", edad=" + edad + '}';
    }
}
