package gui;

import control.Control;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Cliente;
import objetos.Cuenta;
import objetos.Transaccion;
import objetos.TransaccionFolio;

/**
 * Esta clase es la interfaz donde el usuario va interactuar con su cuenta y sus
 * finanzas Buscamos reutilizar codigo y hacer metodos para que este mas limpio.
 *
 * @author fabri
 */
public class DlgCuentas extends javax.swing.JDialog {

    private final Cliente cliente;
    private Cuenta cuenta;
    private final Control control;

    /**
     * Inicializamos los valores del parametro. Se crean tambien componentes que
     * se utilizaran despues
     *
     * @param parent parent
     * @param modal true
     * @param cliente cliente que se crea anteriormente al iniciar sesion
     * @param cuenta Cuenta que el usuario elige
     */
    public DlgCuentas(java.awt.Frame parent, boolean modal, Cliente cliente, Cuenta cuenta) {
        super(parent, modal);
        this.cliente = cliente;
        this.cuenta = cuenta;
        control = new Control();
        initComponents();
btnActualizar.setVisible(false);
        agregarComponentes(componentTransferencia, 300, 170, 687, 415);
        agregarComponentes(componentTablaHistorial, 270, 100, 687, 415);
        agregarComponentes(componentPanelFolios, 350, 170, 687, 415);
        agregarComponentes(componentConfig, 450, 170, 687, 415);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        componentTransferencia = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSaldoActual = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JTextField();
        labelDestino = new javax.swing.JTextField();
        componentTablaHistorial = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        jTipoComboBox = new javax.swing.JComboBox<>();
        componentConfig = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cerrarSesionBtn = new javax.swing.JLabel();
        cancelarCuentaBtn = new javax.swing.JLabel();
        ActualizarBtn = new javax.swing.JLabel();
        componentPanelFolios = new javax.swing.JPanel();
        labelPw = new javax.swing.JLabel();
        btnAceptarFolios = new javax.swing.JLabel();
        labelGenerarFolio = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelCantidadRetirar = new javax.swing.JTextField();
        labelMostrarFolio = new javax.swing.JLabel();
        labelMostrarPw = new javax.swing.JLabel();
        btnTransf = new javax.swing.JLabel();
        txtBienvenido = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnHistorial = new javax.swing.JLabel();
        btnFolio1 = new javax.swing.JLabel();
        btnAjustes = new javax.swing.JLabel();
        btnRegresarMenuPrincipal = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JLabel();

        componentTransferencia.setVisible(false);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel4.setText("Saldo Actual:");

        txtSaldoActual.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        txtSaldoActual.setBackground(new Color(176, 186, 195));

        btnAceptar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel6.setText("Monto");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel7.setText("Numero de Cuenta");

        labelCantidad.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        labelCantidad.setBorder(null);
        labelCantidad.setBackground(new Color(176, 186, 195));

        labelDestino.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        labelDestino.setBorder(null);
        labelDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelDestinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout componentTransferenciaLayout = new javax.swing.GroupLayout(componentTransferencia);
        componentTransferencia.setLayout(componentTransferenciaLayout);
        componentTransferenciaLayout.setHorizontalGroup(
            componentTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(componentTransferenciaLayout.createSequentialGroup()
                .addGroup(componentTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(componentTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, componentTransferenciaLayout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addGroup(componentTransferenciaLayout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, componentTransferenciaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6)))
                .addGap(40, 40, 40)
                .addGroup(componentTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(componentTransferenciaLayout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(54, 54, 54)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        componentTransferenciaLayout.setVerticalGroup(
            componentTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(componentTransferenciaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(componentTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtSaldoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(componentTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(componentTransferenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(32, 32, 32))
        );

        componentTablaHistorial.setVisible(false);
        componentTablaHistorial.setBackground(new java.awt.Color(255, 255, 255));
        componentTablaHistorial.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        componentTablaHistorial.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                componentTablaHistorialformComponentShown(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N

        tablaHistorial.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 12)); // NOI18N
        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Fecha", "Monto", "Transaccion"
            }
        ));
        tablaHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tablaHistorial.setEnabled(false);
        jScrollPane1.setViewportView(tablaHistorial);

        jTipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Transferencias", "Retiros" }));

        javax.swing.GroupLayout componentTablaHistorialLayout = new javax.swing.GroupLayout(componentTablaHistorial);
        componentTablaHistorial.setLayout(componentTablaHistorialLayout);
        componentTablaHistorialLayout.setHorizontalGroup(
            componentTablaHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(componentTablaHistorialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(componentTablaHistorialLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        componentTablaHistorialLayout.setVerticalGroup(
            componentTablaHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, componentTablaHistorialLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jTipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        componentConfig.setVisible(false);
        componentConfig.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 17)); // NOI18N
        jLabel1.setText("Mi cuenta");
        componentConfig.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 17)); // NOI18N
        jLabel2.setText("Numero de cuenta: "+cuenta.getIdCuenta());
        componentConfig.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 270, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 17)); // NOI18N
        jLabel3.setText("Propietario: "+cliente.getNombre()+" "+cliente.getApellido_paterno()+" "+cliente.getApellido_materno());
        componentConfig.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        cerrarSesionBtn.setBackground(new java.awt.Color(255, 255, 153));
        cerrarSesionBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 17)); // NOI18N
        cerrarSesionBtn.setText("Cerrar sesión");
        cerrarSesionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarSesionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesionBtnMouseClicked(evt);
            }
        });
        componentConfig.add(cerrarSesionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        cancelarCuentaBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 17)); // NOI18N
        cancelarCuentaBtn.setText("Cancelar cuenta");
        cancelarCuentaBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelarCuentaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarCuentaBtnMouseClicked(evt);
            }
        });
        componentConfig.add(cancelarCuentaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        ActualizarBtn.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 17)); // NOI18N
        ActualizarBtn.setText("Actualizar Datos");
        ActualizarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ActualizarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActualizarBtnMouseClicked(evt);
            }
        });
        componentConfig.add(ActualizarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        componentPanelFolios.setVisible(false);
        componentPanelFolios.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                componentPanelFoliosformComponentShown(evt);
            }
        });
        componentPanelFolios.setLayout(null);

        labelPw.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        componentPanelFolios.add(labelPw);
        labelPw.setBounds(164, 188, 175, 31);

        btnAceptarFolios.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        btnAceptarFolios.setText("Aceptar");
        btnAceptarFolios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptarFolios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarFoliosMouseClicked(evt);
            }
        });
        componentPanelFolios.add(btnAceptarFolios);
        btnAceptarFolios.setBounds(276, 249, 63, 25);

        labelGenerarFolio.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        componentPanelFolios.add(labelGenerarFolio);
        labelGenerarFolio.setBounds(164, 137, 175, 31);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel8.setText("Cantidad a retirar: ");
        componentPanelFolios.add(jLabel8);
        jLabel8.setBounds(58, 53, 143, 33);
        componentPanelFolios.add(labelCantidadRetirar);
        labelCantidadRetirar.setBounds(219, 56, 120, 33);

        labelMostrarFolio.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        labelMostrarFolio.setText("Folio: ");
        labelMostrarFolio.setVisible(false);
        componentPanelFolios.add(labelMostrarFolio);
        labelMostrarFolio.setBounds(59, 137, 36, 33);

        labelMostrarPw.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        labelMostrarPw.setText("Contrasena:");
        labelMostrarPw.setVisible(false);
        componentPanelFolios.add(labelMostrarPw);
        labelMostrarPw.setBounds(59, 188, 72, 33);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1250, 630));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnTransf.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 27)); // NOI18N
        btnTransf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTransf.setText("Transferir");
        btnTransf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTransf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransfMouseClicked(evt);
            }
        });

        txtBienvenido.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 36)); // NOI18N
        txtBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 36)); // NOI18N
        jLabel5.setText("¿Qué operación desea realizar?   ");
        //jLabel5.setLocation(625, 100);

        btnHistorial.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 27)); // NOI18N
        btnHistorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnHistorial.setText("Estado de Cuenta");
        btnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHistorialMouseClicked(evt);
            }
        });

        btnFolio1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 27)); // NOI18N
        btnFolio1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnFolio1.setText("Generar Folio");
        btnFolio1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFolio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFolio1MouseClicked(evt);
            }
        });

        btnAjustes.setFont(new java.awt.Font("Yu Gothic UI", 0, 27)); // NOI18N
        btnAjustes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAjustes.setText("Ajustes");
        btnAjustes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAjustesMouseClicked(evt);
            }
        });

        btnRegresarMenuPrincipal.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 27)); // NOI18N
        btnRegresarMenuPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegresarMenuPrincipal.setText("Regresar");
        btnRegresarMenuPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarMenuPrincipal.setVisible(false);
        btnRegresarMenuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarMenuPrincipalMouseClicked(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 27)); // NOI18N
        btnActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresarMenuPrincipal.setVisible(false);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel5)
                .addContainerGap(352, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnTransf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                        .addComponent(btnHistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(btnFolio1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(137, 137, 137)
                .addComponent(btnAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnRegresarMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(198, 198, 198)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFolio1)
                    .addComponent(btnAjustes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHistorial)
                    .addComponent(btnTransf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(192, 192, 192)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresarMenuPrincipal)
                    .addComponent(btnActualizar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mostrar componente de transferencias
     *
     * @param evt
     */
    private void btnTransfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransfMouseClicked
        mostrarPanelTransferencias();
    }//GEN-LAST:event_btnTransfMouseClicked

    /**
     * Evento al abrir la ventana, se crea un mensaje de bienvenida
     *
     * @param evt
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        txtBienvenido.setText("Bienvenido " + cliente.getNombre());
    }//GEN-LAST:event_formWindowOpened

    /**
     * Evento para mostrar el historial de transacciones
     *
     * @param evt
     */
    private void btnHistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseClicked
        tablaHistorial.removeAll();
        mostrarHistorial();
        componentTablaHistorial.setVisible(true);

    }//GEN-LAST:event_btnHistorialMouseClicked

    /**
     * Evento para hacer una transferencia, usando el metodo de la clase control
     *
     * @param evt
     */
    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        if (!control.transferir(cuenta.getIdCuenta(), labelCantidad.getText(), labelDestino.getText(), cuenta.getSaldo())) {
            labelCantidad.setText("");
            labelDestino.setText("");

        } else {
            mostrarDlgPrincipal();

        }


    }//GEN-LAST:event_btnAceptarMouseClicked

    private void labelDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelDestinoActionPerformed

    }//GEN-LAST:event_labelDestinoActionPerformed

    /**
     * Boton para mostrar el componente de generar folios
     *
     * @param evt
     */
    private void btnFolio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFolio1MouseClicked
        mostrarPanelFolio();
    }//GEN-LAST:event_btnFolio1MouseClicked

    /**
     * Metodo para crear el componente del historial
     *
     * @param evt
     */
    private void componentTablaHistorialformComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_componentTablaHistorialformComponentShown
        crearTablaHistorial();
    }//GEN-LAST:event_componentTablaHistorialformComponentShown

    /**
     * Metodo para simular un cierre de sesion
     *
     * @param evt
     */
    private void cerrarSesionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionBtnMouseClicked
        dispose();
    }//GEN-LAST:event_cerrarSesionBtnMouseClicked

    /**
     * Metodo para actualizar a un cliente y refrescar cambios
     *
     * @param evt
     */
    private void ActualizarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActualizarBtnMouseClicked
        control.actualizarCliente(cliente);
        jLabel2.setText("Numero de cuenta: " + cuenta.getIdCuenta());
        jLabel3.setText("Propietario: " + cliente.getNombre() + " " + cliente.getApellido_paterno() + " " + cliente.getApellido_materno());
    }//GEN-LAST:event_ActualizarBtnMouseClicked

    /**
     * Metodo para mostrar el componente de ajustes
     *
     * @param evt
     */
    private void btnAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseClicked
        mostrarPanelAjustes();

    }//GEN-LAST:event_btnAjustesMouseClicked

    /**
     * Metodo para cancelar una cuenta
     *
     * @param evt
     */
    private void cancelarCuentaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarCuentaBtnMouseClicked
        cuenta = control.cancelarCuenta(cuenta);
        System.out.println(cuenta.getEstado());
        if ("cancelado".equals(cuenta.getEstado())) {
            JOptionPane.showMessageDialog(this, "La cuenta ha sido cancelada exitosamente.");
            dispose();
        }

    }//GEN-LAST:event_cancelarCuentaBtnMouseClicked

    /**
     * Metodo para aceptar cambios y mostrar un componente
     *
     * @param evt
     */
    private void btnAceptarFoliosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarFoliosMouseClicked
        if (labelCantidadRetirar.getText().equals("")) {
        } else {
            mostrarFolioPw();

        }


    }//GEN-LAST:event_btnAceptarFoliosMouseClicked


    private void componentPanelFoliosformComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_componentPanelFoliosformComponentShown
        labelPw.setText("");
        labelGenerarFolio.setText("");
        labelMostrarFolio.setVisible(false);
        labelMostrarPw.setVisible(false);
        labelCantidadRetirar.setText("");
    }//GEN-LAST:event_componentPanelFoliosformComponentShown

    private void btnRegresarMenuPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMenuPrincipalMouseClicked
        mostrarDlgPrincipal();
    }//GEN-LAST:event_btnRegresarMenuPrincipalMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        if (jTipoComboBox.getSelectedItem()=="Todas") {
            crearTablaHistorial();
        }
        if (jTipoComboBox.getSelectedItem()=="Retiros") {
            crearTablaRetiros(control.obtenerListaretiros(cuenta.getIdCuenta()));
        }
        if (jTipoComboBox.getSelectedItem()=="Transferencias") {
            crearTablaTransferencias(control.obtenerListaTransferencias(cuenta.getIdCuenta()));
        }
    }//GEN-LAST:event_btnActualizarMouseClicked

    /**
     * Metodo para reutilizar codigo y mostrar un componente
     */
    private void mostrarPanelFolio() {
        componentPanelFolios.setVisible(true);
        btnTransf.setVisible(false);
        btnFolio1.setVisible(false);
        btnHistorial.setVisible(false);
        btnAjustes.setVisible(false);
        btnActualizar.setVisible(false);
        btnRegresarMenuPrincipal.setVisible(true);

    }

    /**
     * Metodo para reutilizar codigo y mostrar un componente
     */
    private void mostrarDlgPrincipal() {
        txtBienvenido.setText("Bienvenido " + cliente.getNombre());
        componentTransferencia.setVisible(false);
        componentPanelFolios.setVisible(false);
        componentConfig.setVisible(false);
        txtBienvenido.setVisible(false);
        jLabel5.setVisible(false);
        btnTransf.setVisible(true);
        btnFolio1.setVisible(true);
        btnHistorial.setVisible(true);
        btnAjustes.setVisible(true);
        componentTablaHistorial.setVisible(false);
        btnRegresarMenuPrincipal.setVisible(false);
        btnActualizar.setVisible(false);

    }

    /**
     * Metodo para reutilizar codigo y mostrar un componente
     */
    private void mostrarHistorial() {
        txtBienvenido.setVisible(false);
        jLabel5.setVisible(false);
        btnTransf.setVisible(false);
        btnFolio1.setVisible(false);
        btnHistorial.setVisible(true);
        btnAjustes.setVisible(false);
        componentTransferencia.setVisible(false);
        btnHistorial.setVisible(false);
        btnRegresarMenuPrincipal.setVisible(true);
        btnActualizar.setVisible(true);

    }

    /**
     * Metodo para reutilizar codigo y mostrar un componente
     */
    private void mostrarPanelTransferencias() {
        txtBienvenido.setVisible(false);
        jLabel5.setVisible(false);
        btnTransf.setVisible(false);
        componentTransferencia.setVisible(true);
        txtSaldoActual.setText(String.valueOf(cuenta.getSaldo()));
        btnAjustes.setVisible(false);
        btnHistorial.setVisible(false);
        btnFolio1.setVisible(false);
        btnRegresarMenuPrincipal.setVisible(true);

    }

    /**
     * Metodo para reutilizar codigo y mostrar un componente
     */
    private void mostrarPanelAjustes() {
        txtBienvenido.setVisible(false);
        jLabel5.setVisible(false);
        btnAjustes.setVisible(false);
        btnTransf.setVisible(false);
        btnFolio1.setVisible(false);
        btnHistorial.setVisible(false);
        componentConfig.setVisible(true);
        btnRegresarMenuPrincipal.setVisible(true);
    }

    /**
     * Metodo para generar el folio y el password, y crear un timer
     *
     */
    private void mostrarFolioPw() {
        String cantidadRetirar = labelCantidadRetirar.getText();
        int result = control.crearTimerExpiracion(cantidadRetirar, cuenta.getSaldo(), cuenta);
        if (result != -1) {
            String pw = control.getPw(result);
            String folio = control.getFolio(result);
            labelPw.setText(pw);
            labelGenerarFolio.setText(folio);
            labelMostrarFolio.setVisible(true);
            labelMostrarPw.setVisible(true);
            labelCantidadRetirar.setText("");
        } else if(result == -1) {
            labelMostrarFolio.setVisible(false);
            labelMostrarPw.setVisible(false);
            labelPw.setText("");
            labelGenerarFolio.setText("");
            labelCantidadRetirar.setText("");

        }

    }

    /**
     * Metodo auxiliar para reutilizar codigo, en caso de que se requiera
     * agregar mas componentes (paneles) al frame
     *
     * @param componente
     * @param x
     * @param y
     * @param width
     * @param height
     */
    private void agregarComponentes(Component componente, int x, int y, int width, int height) {
        getContentPane().add(componente);
        componente.setBounds(x, y, width, height);

    }

    /**
     * Metodo para crear la tabla de estado de cuentas
     */
    private void crearTablaHistorial() {
        tablaHistorial.removeAll();
        DefaultTableModel modelTable = new DefaultTableModel();
        String ids[] = {"Transaccion ", "Fecha ", "Cantidad "};
        modelTable.setColumnIdentifiers(ids);
        tablaHistorial.setModel(modelTable);
        ArrayList<Transaccion> transacciones = control.obtenerListaTransacciones(cuenta.getIdCuenta());
        for (Transaccion i : transacciones) {
            modelTable.addRow(new Object[]{i.getFormatoTipoTransaccion(), i.getFechahora_transaccion(), i.getCantidad()});
        }
    }
    /**
     * Metodo crea tabla cuando en el combobox es seleccionada la opcion de retiros
     * @param retiros lista de retiros ya sea ordenada o por periodo(pendiente)
     */
    private void crearTablaRetiros(ArrayList<TransaccionFolio> retiros){
    tablaHistorial.removeAll();
    DefaultTableModel modelTable = new DefaultTableModel();
        String ids[] = {"Transaccion ", "Fecha ", "Cantidad ", "Estado "};
        modelTable.setColumnIdentifiers(ids);
        tablaHistorial.setModel(modelTable);
        
        ArrayList<TransaccionFolio> retirosMostrar=retiros;
        for (TransaccionFolio i:retirosMostrar) {
             modelTable.addRow(new Object[]{i.getFormatoTipoTransaccion(), i.getFechahora_transaccion(), i.getCantidad(),i.getEstado()});
        }
    }
    private void crearTablaTransferencias(ArrayList<Transaccion> transferencias){
    tablaHistorial.removeAll();
     DefaultTableModel modelTable = new DefaultTableModel();
        String ids[] = {"Transaccion ", "Fecha ", "Cantidad "};
        modelTable.setColumnIdentifiers(ids);
        tablaHistorial.setModel(modelTable);
         for (Transaccion i : transferencias) {
            modelTable.addRow(new Object[]{i.getFormatoTipoTransaccion(), i.getFechahora_transaccion(), i.getCantidad()});
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActualizarBtn;
    private javax.swing.JLabel btnAceptar;
    private javax.swing.JLabel btnAceptarFolios;
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JLabel btnAjustes;
    private javax.swing.JLabel btnFolio1;
    private javax.swing.JLabel btnHistorial;
    private javax.swing.JLabel btnRegresarMenuPrincipal;
    private javax.swing.JLabel btnTransf;
    private javax.swing.JLabel cancelarCuentaBtn;
    private javax.swing.JLabel cerrarSesionBtn;
    private javax.swing.JPanel componentConfig;
    private javax.swing.JPanel componentPanelFolios;
    private javax.swing.JPanel componentTablaHistorial;
    private javax.swing.JPanel componentTransferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jTipoComboBox;
    private javax.swing.JTextField labelCantidad;
    private javax.swing.JTextField labelCantidadRetirar;
    private javax.swing.JTextField labelDestino;
    private javax.swing.JLabel labelGenerarFolio;
    private javax.swing.JLabel labelMostrarFolio;
    private javax.swing.JLabel labelMostrarPw;
    private javax.swing.JLabel labelPw;
    private javax.swing.JTable tablaHistorial;
    private javax.swing.JLabel txtBienvenido;
    private javax.swing.JLabel txtSaldoActual;
    // End of variables declaration//GEN-END:variables
}
