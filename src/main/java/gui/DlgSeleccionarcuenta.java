
package gui;

import control.Control;
import dao.ConexionDB;
import dao.CuentaDAO;
import dao.excepciones.PersistenciaException;
import dao.interfaces.IConexion;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import objetos.Cliente;
import objetos.Cuenta;

/**
 *
 * @author abelc
 */
public class DlgSeleccionarcuenta extends javax.swing.JDialog {

    private final Cliente cliente;
    private final DefaultComboBoxModel cuentas;
    private String numCuenta;
    private final Control control;
    private CuentaDAO dao;

    /**
     * Constructor del frame
     * 
     * @param parent frame parent
     * @param modal true
     * @param cliente cliente recibido
     * @param cuentas cuentas en formato combobox
     * @param numCuenta numero de cuenta o id
     */
    public DlgSeleccionarcuenta(java.awt.Frame parent, boolean modal, Cliente cliente, DefaultComboBoxModel cuentas, String numCuenta) {
        super(parent, modal);
        this.cliente = cliente;
        this.cuentas = cuentas;
        this.numCuenta = numCuenta;
        control = new Control();
        initComponents();
        setVisible(true);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cuentasComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        seleccionarBtn = new javax.swing.JButton();
        regresarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        crearCuentaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(383, 308));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        cuentasComboBox.setModel(cuentas);
        getContentPane().add(cuentasComboBox);
        cuentasComboBox.setBounds(90, 90, 200, 22);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Seleccione una de sus cuentas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 50, 210, 16);

        seleccionarBtn.setBackground(new java.awt.Color(249, 237, 50));
        seleccionarBtn.setText("Seleccionar");
        seleccionarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(seleccionarBtn);
        seleccionarBtn.setBounds(220, 150, 120, 23);

        regresarBtn.setBackground(new java.awt.Color(249, 237, 50));
        regresarBtn.setText("Regresar");
        getContentPane().add(regresarBtn);
        regresarBtn.setBounds(70, 150, 100, 23);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Hola "+cliente.getNombre());
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 10, 70, 16);

        crearCuentaLabel.setBackground(new java.awt.Color(50, 94, 249));
        crearCuentaLabel.setForeground(new java.awt.Color(50, 94, 249));
        crearCuentaLabel.setText("Añadir nueva cuenta");
        crearCuentaLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crearCuentaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearCuentaLabelMouseClicked(evt);
            }
        });
        getContentPane().add(crearCuentaLabel);
        crearCuentaLabel.setBounds(130, 200, 140, 16);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Metodo para mostrar la interfaz de cuentas del usuario.
     * 
     * @param evt 
     */
    private void seleccionarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarBtnActionPerformed
        numCuenta = (String) cuentasComboBox.getSelectedItem();
        IConexion conexionDB = new ConexionDB("jdbc:mysql://localhost:3306/banco", "root", "root");

        dao = new CuentaDAO(conexionDB);
        DlgCuentas dlgc = new DlgCuentas(null, true, cliente, dao.buscarCuenta(numCuenta));
        this.dispose();
        dlgc.setVisible(true);

        dispose();
    }//GEN-LAST:event_seleccionarBtnActionPerformed

    
    /**
     * Metodo para crear una cuenta
     * 
     * @param evt 
     */
    private void crearCuentaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearCuentaLabelMouseClicked
        String password = JOptionPane.showInputDialog(this, "Ingrese su contraseña:", "Confirmación de contraseña", JOptionPane.PLAIN_MESSAGE);

        password=control.encriptarPassw(password);
        if (password != null && password.equals(cliente.getPassw())) {
            Cuenta nuevaCuenta = null;
            try {
                nuevaCuenta = control.agregarCuentaCliente(cliente);
                cuentas.addElement(nuevaCuenta.getIdCuenta());
            } catch (PersistenciaException ex) {
                Logger.getLogger(DlgSeleccionarcuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Contraseña correcta. se ha creado la tarjeta " + nuevaCuenta.getIdCuenta(), "Contraseña correcta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "La contraseña ingresada no es válida. Inténtelo de nuevo.", "Contraseña incorrecta", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_crearCuentaLabelMouseClicked
    public String getNumCuenta() {
        return numCuenta;
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel crearCuentaLabel;
    private javax.swing.JComboBox<String> cuentasComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JButton seleccionarBtn;
    // End of variables declaration//GEN-END:variables
}
