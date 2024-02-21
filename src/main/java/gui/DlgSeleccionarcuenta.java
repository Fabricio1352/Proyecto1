
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

        contraseñaPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        crearBtn = new javax.swing.JButton();
        cuentasComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        seleccionarBtn = new javax.swing.JButton();
        regresarBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        crearCuentaLabel = new javax.swing.JLabel();

        contraseñaPanel.setBackground(new java.awt.Color(255, 255, 255));
        contraseñaPanel.setVisible(false);

        jLabel3.setText("Está apunto de crear una cuenta a su nombre, ingrese su contraseña");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(249, 237, 50));
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        crearBtn.setBackground(new java.awt.Color(249, 237, 50));
        crearBtn.setText("Crear");

        javax.swing.GroupLayout contraseñaPanelLayout = new javax.swing.GroupLayout(contraseñaPanel);
        contraseñaPanel.setLayout(contraseñaPanelLayout);
        contraseñaPanelLayout.setHorizontalGroup(
            contraseñaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contraseñaPanelLayout.createSequentialGroup()
                .addGroup(contraseñaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contraseñaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(contraseñaPanelLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contraseñaPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(crearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        contraseñaPanelLayout.setVerticalGroup(
            contraseñaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contraseñaPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(contraseñaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    
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

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed

    }//GEN-LAST:event_jPasswordField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contraseñaPanel;
    private javax.swing.JButton crearBtn;
    private javax.swing.JLabel crearCuentaLabel;
    private javax.swing.JComboBox<String> cuentasComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JButton regresarBtn;
    private javax.swing.JButton seleccionarBtn;
    // End of variables declaration//GEN-END:variables
}
