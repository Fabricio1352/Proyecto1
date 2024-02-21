/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import control.Conversiones;
import dao.ClienteDAO;
import dao.ConexionDB;
import dao.CuentaDAO;
import dao.TransaccionDAO;
import dao.interfaces.IConexion;
import gui.DlgCuentas;
import gui.DlgSeleccionarcuenta;
import javax.swing.DefaultComboBoxModel;
import objetos.Cliente;
import objetos.Cuenta;

/**
 *
 * @author abelc
 */
public class NewMain3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conversiones con = new Conversiones();
        DefaultComboBoxModel<String> cuentasComboBoxModel;
//        Cliente cliente = new Cliente();
        String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
        String user = "root";
        String password = "root";
        IConexion conexionDB = new ConexionDB(cadenaConexion, user, password);
        ClienteDAO dao1 = new ClienteDAO(conexionDB);
        Cliente cliente1 = dao1.buscarCliente(1);
        // Supongamos que tienes un DAO para obtener las cuentas del cliente
        CuentaDAO cuentaDAO = new CuentaDAO(conexionDB);
        Cuenta cuenta1 = cuentaDAO.buscarCuenta("1");
//        
//        // Crear un DefaultComboBoxModel con las cuentas del cliente
//        cuentasComboBoxModel = con.cuentasComboBoxModel(cuentaDAO.buscarCuentaPorCliente(cliente.getId()));
//        
//        // Crear un diálogo para que el usuario seleccione una cuenta
//        DlgSeleccionarcuenta dlgCuenta = new DlgSeleccionarcuenta(null, true, cliente, cuentasComboBoxModel, null);
//        
//        // Mostrar el diálogo
//        dlgCuenta.setVisible(true);

        DlgCuentas dlg = new DlgCuentas(null, true, cliente1,cuenta1 );
        dlg.setVisible(true);
//        TransaccionDAO daoTrans = new TransaccionDAO(conexionDB);
//        System.out.println(daoTrans.verHistorial("0601518060075587"));
    



    }

}
