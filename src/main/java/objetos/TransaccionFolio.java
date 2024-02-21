/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.sql.Date;
import java.sql.Timestamp;


/**
 *
 * @author fabri
 */
public class TransaccionFolio {
    
    
    private int idTransaccion;
    private String folioTransaccion;
    private String passwordTransaccion;
    private String estado;
    private Timestamp tiempo;

    public Timestamp getTiempo() {
        return tiempo;
    }

    public void setTiempo(Timestamp tiempo) {
        this.tiempo = tiempo;
    }



 

    public TransaccionFolio() {
    }

    public TransaccionFolio(int idTransaccion, String folioTransaccion, String passwordTransaccion, String estado) {
        this.idTransaccion = idTransaccion;
        this.folioTransaccion = folioTransaccion;
        this.passwordTransaccion = passwordTransaccion;
        this.estado = estado;
    }

    public TransaccionFolio(String estado) {
        this.estado = estado;
    }

    public TransaccionFolio(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getFolioTransaccion() {
        return folioTransaccion;
    }

    public void setFolioTransaccion(String folioTransaccion) {
        this.folioTransaccion = folioTransaccion;
    }

    public String getPasswordTransaccion() {
        return passwordTransaccion;
    }

    public void setPasswordTransaccion(String passwordTransaccion) {
        this.passwordTransaccion = passwordTransaccion;
    }

    
    
    
    
    
    
    
    
    
}
