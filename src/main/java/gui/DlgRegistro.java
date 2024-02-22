package gui;

import control.Validaciones;
import java.util.Date;
import javax.swing.JOptionPane;
import objetos.Cliente;

/**
 *
 * @author abelc
 */
public class DlgRegistro extends javax.swing.JDialog {

    private final Cliente cliente;
    private final int operacion;
    private final Validaciones validacion;

    /**
     * Creates new form DlgRegistro
     *
     * @param parent frame paren
     * @param modal true
     * @param cliente cliente recibido
     * @param operacion operacion a realizar y reutilizar codigo
     */
    public DlgRegistro(java.awt.Frame parent, boolean modal, Cliente cliente, int operacion) {
        super(parent, modal);
        this.cliente = cliente;
        this.operacion = operacion;
        validacion = new Validaciones();
        initComponents();

        if (operacion == 1) {
            jLabel1.setText("registrarme");
            registrarseBoton.setText("Registrarme");
            nombresTextField.setEditable(true);
            apPaternoTextField.setEditable(true);
            apMaternoTextField.setEditable(true);
            jDateChooser1.setEnabled(true);
            calleTextField.setEditable(true);
            coloniaTextField.setEditable(true);
            cpTextField.setEditable(true);
            jPasswordField1.setEditable(true);
            jPasswordField2.setEditable(true);
        }
        if (operacion == 2) {
            jLabel1.setText("Actualizar informacion");
            registrarseBoton.setText("Actualizar");
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            nombresTextField.setText(cliente.getNombre());
            apPaternoTextField.setText(cliente.getApellido_paterno());
            apMaternoTextField.setText(cliente.getApellido_materno());
            calleTextField.setText(cliente.getCalle());
            coloniaTextField.setText(cliente.getColonia());
            cpTextField.setText(cliente.getCodigo_postal());
            jDateChooser1.setDate(cliente.getFecha_nacimiento());

            nombresTextField.setEditable(true);
            apPaternoTextField.setEditable(true);
            apMaternoTextField.setEditable(true);
            jDateChooser1.setEnabled(false);
            calleTextField.setEditable(true);
            coloniaTextField.setEditable(true);
            cpTextField.setEditable(true);
            jPasswordField1.setEditable(false);
            jPasswordField1.setVisible(false);
            jPasswordField2.setEditable(false);
            jPasswordField2.setVisible(false);
        }
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombresTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        apPaternoTextField = new javax.swing.JTextField();
        apMaternoTextField = new javax.swing.JTextField();
        calleTextField = new javax.swing.JTextField();
        coloniaTextField = new javax.swing.JTextField();
        cpTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        registrarseBoton = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Registrarse");

        nombresTextField.setBackground(new java.awt.Color(176, 186, 195));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre(s)");

        apPaternoTextField.setBackground(new java.awt.Color(176, 186, 195));

        apMaternoTextField.setBackground(new java.awt.Color(176, 186, 195));

        calleTextField.setBackground(new java.awt.Color(176, 186, 195));

        coloniaTextField.setBackground(new java.awt.Color(176, 186, 195));

        cpTextField.setBackground(new java.awt.Color(176, 186, 195));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Apellido Paterno");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Apellido Materno");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Calle");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Colonia");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("C.P");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Contraseña");

        jPasswordField1.setBackground(new java.awt.Color(176, 186, 195));

        jPasswordField2.setBackground(new java.awt.Color(176, 186, 195));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Confirmar contraseña");

        registrarseBoton.setBackground(new java.awt.Color(249, 237, 50));
        registrarseBoton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registrarseBoton.setText("Registrarse");
        registrarseBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarseBotonActionPerformed(evt);
            }
        });

        jDateChooser1.setBackground(new java.awt.Color(153, 153, 153));
        jDateChooser1.setDateFormatString("y MMM d");
        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Fecha de nacimiento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(registrarseBoton)
                            .addGap(60, 60, 60))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(cpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(coloniaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10)
                    .addComponent(apPaternoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(apMaternoTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombresTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apPaternoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apMaternoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(coloniaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(registrarseBoton)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para mandar un registro de cliente a la base de datos.
     *
     * @param evt
     */
    private void registrarseBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarseBotonActionPerformed
        if (operacion == 1) {
             String contrasena1 = jPasswordField1.getText();
             String contrasena2 = jPasswordField2.getText();
            if (validacion.esMayorDeEdad(jDateChooser1.getDate()) && validacion.validarNumeros(cpTextField.getText())
                    && validacion.validarNombre(nombresTextField.getText()) && validacion.validarNombre(apPaternoTextField.getText())
                    && validacion.validarNombre(apMaternoTextField.getText())&&validacion.validarContrasena(contrasena1)) {
                cliente.setNombre(nombresTextField.getText());
                cliente.setApellido_paterno(apPaternoTextField.getText());
                cliente.setApellido_materno(apMaternoTextField.getText());
                Date fechaSeleccionada = jDateChooser1.getDate();
                java.sql.Date fechaNacimiento = new java.sql.Date(fechaSeleccionada.getTime());
                cliente.setFecha_nacimiento(fechaNacimiento);
                cliente.setCalle(calleTextField.getText());
                cliente.setColonia(coloniaTextField.getText());
                cliente.setCodigo_postal(cpTextField.getText());
               
                if (contrasena1.equals(contrasena2)) { //revisa que los dos campos tengan la misma contraseña
                    cliente.setPassw(contrasena1);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                if (!validacion.esMayorDeEdad(jDateChooser1.getDate())) {
                    JOptionPane.showMessageDialog(null, "Tiene que ser mayor de edad para registrarse", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!validacion.validarNumeros(cpTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "El codigo postal solo acepta valores numericos", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!validacion.validarNombre(nombresTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "El nombre solo acepta valores numericos", "Error", JOptionPane.ERROR_MESSAGE);

                }
                if (!validacion.validarNombre(apPaternoTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "El apellido solo acepta valores numericos", "Error", JOptionPane.ERROR_MESSAGE);

                }
                if (!validacion.validarNombre(apMaternoTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "El apellido solo acepta valores numericos", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!validacion.validarContrasena(contrasena1)) {
                    JOptionPane.showMessageDialog(null, "La contraseña no es segura", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        if (validacion.validarNumeros(cpTextField.getText()) && 
                validacion.validarNombre(nombresTextField.getText()) && validacion.validarNombre(apPaternoTextField.getText())
                && validacion.validarNombre(apMaternoTextField.getText())) {
            if (operacion == 2) {
                cliente.setNombre(nombresTextField.getText());
                cliente.setApellido_paterno(apPaternoTextField.getText());
                cliente.setApellido_materno(apMaternoTextField.getText());
                Date fechaSeleccionada = jDateChooser1.getDate();
                java.sql.Date fechaNacimiento = new java.sql.Date(fechaSeleccionada.getTime());
                cliente.setFecha_nacimiento(fechaNacimiento);
                cliente.setCalle(calleTextField.getText());
                cliente.setColonia(coloniaTextField.getText());
                cliente.setCodigo_postal(cpTextField.getText());
                dispose();
            } else {
              
                if (!validacion.validarNumeros(cpTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "El codigo postal solo acepta valores numericos", "Error", JOptionPane.ERROR_MESSAGE);
                }
                if (!validacion.validarNombre(nombresTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "El nombre solo acepta valores numericos", "Error", JOptionPane.ERROR_MESSAGE);

                }
                if (!validacion.validarNombre(apPaternoTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "El apellido solo acepta valores numericos", "Error", JOptionPane.ERROR_MESSAGE);

                }
                if (!validacion.validarNombre(apMaternoTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "El apellido solo acepta valores numericos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        }
    }//GEN-LAST:event_registrarseBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apMaternoTextField;
    private javax.swing.JTextField apPaternoTextField;
    private javax.swing.JTextField calleTextField;
    private javax.swing.JTextField coloniaTextField;
    private javax.swing.JTextField cpTextField;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField nombresTextField;
    private javax.swing.JButton registrarseBoton;
    // End of variables declaration//GEN-END:variables
}
