/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.sql.Date;

/**
 * La clase Cliente representa un cliente del sistema.
 * Contiene información personal como identificador, nombre, apellidos, dirección, fecha de nacimiento, contraseña y edad.
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
     * Constructor de Cliente que recibe todos los atributos como parámetros.
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
     * Constructor de Cliente que recibe la información básica y la fecha de nacimiento como parámetros.
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
     * Constructor de Cliente que recibe solo el ID como parámetro.
     */
    public Cliente(int id) {
        this.id = id;
    }

    // Getters y Setters

    /**
     * Devuelve el identificador del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido paterno del cliente.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Devuelve el apellido materno del cliente.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno del cliente.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Devuelve la calle de la dirección del cliente.
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle de la dirección del cliente.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Devuelve la colonia de la dirección del cliente.
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia de la dirección del cliente.
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Devuelve el código postal de la dirección del cliente.
     */
    public String getCodigo_postal() {
        return codigo_postal;
    }

    /**
     * Establece el código postal de la dirección del cliente.
     */
    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    /**
     * Devuelve la fecha de nacimiento del cliente.
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     * Devuelve la edad del cliente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del cliente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve la contraseña del cliente.
     */
    public String getPassw() {
        return passw;
    }

    /**
     * Establece la contraseña del cliente.
     */
    public void setPassw(String passw) {
        this.passw = passw;
    }

    // Otros métodos

    /**
     * Retorna una representación en cadena del objeto Cliente.
     */
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", calle=" + calle + ", colonia=" + colonia + ", codigo_postal=" + codigo_postal + ", fecha_nacimiento=" + fecha_nacimiento + ", passw=" + passw + ", edad=" + edad + '}';
    }
}
