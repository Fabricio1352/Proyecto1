
import dao.ConexionDB;
import dao.TransaccionFolioDAO;
import java.util.ArrayList;
import objetos.TransaccionFolio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author abelc
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionDB db=new ConexionDB("jdbc:mysql://localhost:3306/banco","root","root");
       TransaccionFolioDAO transaccionFolioDAO = new TransaccionFolioDAO(db); // Suponiendo que tienes una instancia de TransaccionFolioDAO
    
    // Supongamos que tienes un ID de cuenta para el cual quieres obtener el historial de retiros
    String idCuenta = "2270527092623917"; // Debes reemplazar esto con el ID real de la cuenta
    
    // Llamar al método para obtener el historial de retiros
    ArrayList<TransaccionFolio> historialRetiros = transaccionFolioDAO.verHistorialRetiros(idCuenta);
    
    // Imprimir los detalles de las transacciones de retiro
    for (TransaccionFolio transaccion : historialRetiros) {
        System.out.println("Fecha: " + transaccion.getFechahora_transaccion());
        System.out.println("Monto: " + transaccion.getCantidad());
        System.out.println("Tipo de Transacción: " + transaccion.getFormatoTipoTransaccion());
        System.out.println("Estado: " + transaccion.getEstado());
        System.out.println("-----------------------------------------");
    }
    }
    
}
