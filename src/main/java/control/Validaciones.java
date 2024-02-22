/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase con la funcion de validar que se inserte lo necesario en la gui
 *
 * @author abelc
 */
public class Validaciones {

    /**
     * Metodo que verifica que en un campo solo se inserten valores numericos
     *
     * @param texto valores numericos en forma de String
     * @return true si el texto en el parametro son solo valores numericos y
     * false si hay caracteres
     */
    public boolean validarNumeros(String texto) {
        if (texto.matches("\\d+")) {
            return true;
        } else {
            return false;
        }
    }

    
    /**
     * Metodo que recibe una fecah y que a partir de la fecha actual calcula si el usuario a registrarse es 
     * mayor de edad o no
     * @param fechaNacimiento
     * @return retorna true si el usuario es mayor y false si es menor
     */
    public boolean esMayorDeEdad(Date fechaNacimiento) {

        LocalDate fechaNacimientoLocal = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimientoLocal, fechaActual);
        int edad = periodo.getYears();

        return edad >= 18;
    }
    /**
     * Metodo que verifica si el string que recibe este formado solo por caracteres alfabeticos
     * @param nombre
     * @return True si el nombre coincide con lo establecido, false si no
     */
      public boolean validarNombre(String nombre) {
        String patronNombre = "^[a-zA-ZáéíóúüÁÉÍÓÚÜñÑ\\s]+$";
        Pattern patron = Pattern.compile(patronNombre);
        Matcher matcher = patron.matcher(nombre);
        return matcher.matches();
    }
      /**
       * Metodo con funcion de validar si una contraseña es segura,
       * 1 digito o un caracter especial, tambien una mayuscula
       * @param contrasena
       * @return false si la contraseña no coincide con las restricciones, true si la contraseña cumple
       */
       public boolean validarContrasena(String contrasena) {
       
        String patronContrasena = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern patron = Pattern.compile(patronContrasena);
        Matcher matcher = patron.matcher(contrasena);
        return matcher.matches();
    }
}
