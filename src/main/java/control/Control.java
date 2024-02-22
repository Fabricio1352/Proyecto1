package control;

import dao.ClienteDAO;
import dao.ConexionDB;
import dao.CuentaDAO;
import dao.TransaccionDAO;
import dao.TransaccionFolioDAO;
import dao.excepciones.PersistenciaException;
import dao.interfaces.IConexion;
import gui.DlgRegistro;
import gui.DlgSeleccionarcuenta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import objetos.Cliente;
import objetos.Cuenta;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import objetos.Transaccion;
import objetos.TransaccionFolio;

/**
 * Clase que representa la conexion de capa dao con las gui
 *
 * @author abelc
 */
public class Control {
    
    Conversiones conversiones;
    private final String cadenaConexion = "jdbc:mysql://localhost:3306/banco";
    private final String user = "root";
    private final String password = "root";
    private final IConexion conexionDB = new ConexionDB(cadenaConexion, user, password);
    private final ClienteDAO clienteDAO;
    private final CuentaDAO cuentaDAO;
    private final TransaccionDAO transaccionDAO;
    private final TransaccionFolioDAO transFolioDao;
    
    public Control() {
        clienteDAO = new ClienteDAO(conexionDB);
        cuentaDAO = new CuentaDAO(conexionDB);
        transaccionDAO = new TransaccionDAO(conexionDB);
        transFolioDao = new TransaccionFolioDAO(conexionDB);
        conversiones = new Conversiones();
        
    }

    /**
     * Metodo para registrar un nuevo cliente en la base de datos. `
     *
     * @param frame formulario donde pide datos
     *
     * @return true si se pudo registrar, false caso contrario.
     */
    public boolean registrarCliente(JFrame frame) {
        Cliente cliente = new Cliente();
        Cuenta cuenta = new Cuenta();
        DlgRegistro dlgRegistro;
        dlgRegistro = new DlgRegistro(frame, true, cliente, 1);
        try {
            clienteDAO.registrarCliente(cliente);
            cuenta.setCliente(cliente);
            cuenta.setSaldo(1000);
            cuentaDAO.registrarCuenta(cuenta);
            if (clienteDAO.buscarCliente(cliente.getId())!=null) {
              JOptionPane.showMessageDialog(frame, "Cliente registrado con éxito. ID del cliente: " + cliente.getId(), "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);  
            }
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /**
     * Metodo para actualizar un cliente en la base de datos, usando una
     * instancia de DAO.
     *
     * @param cliente cliente a actualizar.
     * @return true si se pudo editar, false caso contrario.
     */
    public boolean actualizarCliente(Cliente cliente) {
        Cuenta cuenta = new Cuenta();
        DlgRegistro dlgRegistro;
        dlgRegistro = new DlgRegistro(null, true, cliente, 2);
        clienteDAO.editarCliente(cliente);
        return true;
    }

    /**
     * Metodo que encripta la contraseña de un cliente con el mismo formato con
     * el que se guardan en la base de datos
     *
     * @param cliente
     * @return objeto cliente con la contraseña encriptada
     */
    private Cliente encriptarPassw(Cliente cliente) {
        String contraseña = cliente.getPassw();
        
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            byte[] hashBytes = md.digest(contraseña.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            
            String hash = sb.toString();
            
            cliente.setPassw(hash);
            
            return cliente;
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            
            return cliente;
        }
    }

    /**
     * Metodo para encripar la password antes de crearla en la base de datos
     *
     * @param passw password creada
     * @return password encriptada
     */
    public String encriptarPassw(String passw) {
 
        
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            byte[] hashBytes = md.digest(passw.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            
            String hash = sb.toString();
            
            return hash;
            
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            
            return passw;
        }
    }

    /**
     * Metodo para iniciar sesion verificando el usuario en la base de datos.
     *
     * @param cliente cliente a verificar
     * @return cliente verificado
     */
    public Cliente iniciarSesion(Cliente cliente) {
        
        Cliente clienteEncontrado = clienteDAO.buscarCliente(cliente.getId());
        
        if (clienteEncontrado == null) {
            return null;
        }
        
        String contraseñaEncriptadaCliente = encriptarPassw(cliente).getPassw();
        
        if (clienteEncontrado.getPassw().equals(contraseñaEncriptadaCliente)) {
            
            return clienteEncontrado;
        } else {
            
            return null;
        }
        
    }

    /**
     * Metodo para crear un ComboBoxModel y seleccionar una cuenta
     *
     * @param cliente cliente asociado
     * @param frame frame parent
     * @return regresa la cuenta creado
     */
    public Cuenta seleccionarCuenta(Cliente cliente, JFrame frame) {
        Cuenta cuenta;
        DefaultComboBoxModel<String> cuentasComboBoxModel;
        DlgSeleccionarcuenta dlgCuenta;
        String numCuenta = null;
        cuentasComboBoxModel = conversiones.cuentasComboBoxModel(cuentaDAO.buscarCuentaPorCliente(cliente.getId()));
        dlgCuenta = new DlgSeleccionarcuenta(frame, true, cliente, cuentasComboBoxModel, numCuenta);
        numCuenta = dlgCuenta.getNumCuenta();
        
        cuenta = cuentaDAO.buscarCuenta(numCuenta);
        
        return cuenta;
    }

    /**
     * Metodo para agregar una nueva cuenta al cliente asociado.
     *
     * @param cliente cliente asociado
     * @return la cuenta creada
     */
    public Cuenta agregarCuentaCliente(Cliente cliente) throws PersistenciaException {
        cliente = clienteDAO.buscarCliente(cliente.getId());
        Cuenta cuenta = new Cuenta(1000, cliente);
        cuentaDAO.registrarCuenta(cuenta);
        return cuenta;
    }

    /**
     * Metodo para cancelar una cuenta
     *
     * @param cuenta cuenta recibida
     * @return true si se pudo, false caso contrario
     */
    public Cuenta cancelarCuenta(Cuenta cuenta) {
        cuenta = cuentaDAO.cancelarCuenta(cuenta);
        return cuenta;
    }

    /**
     * Metodo para hacer un retiro con folio y password
     *
     * @param folio folio generado
     * @param passw password generada
     * @return true si se pudo, false caso contrario
     */
    public boolean retiroFolio(String folio, String passw) {
        boolean retiroExitoso = transaccionDAO.retiro(folio, passw);
        
        return retiroExitoso;
    }

    /**
     * Metodo para simplificar las transacciones y dividir mas la aplicacion,
     * haciendo que con una sola instancia de control podamos acceder al dao,
     * sin tener que esta haciendo varias instancais de dao en cada clase
     *
     * @param idOrigen cuenta origen
     * @param monto cantidad
     * @param idDestino cuenta destino
     * @param saldo saldo de la cuenta
     * @return true si se realizo, false caso contrario
     */
    public boolean transferir(String idOrigen, String monto, String idDestino, int saldo) {
        if (!regex("^\\d+$", String.valueOf(monto)) || monto == null || idDestino == null) {
            return false;
        } else {
            int monto2 = Integer.parseInt(monto);
            if (monto2 > saldo) {
                JOptionPane.showMessageDialog(null, "No tienes suficiente saldo, la operacion ha sido revertida");
            }
            cuentaDAO.transferencia(idOrigen, monto2, idDestino);
            return true;
        }
        
    }

    /**
     * Metodo para obtener la password de la base de datos, mediante el
     * identificador de cada transaccion
     *
     * @param idTrans id de la transacccion
     * @return regresa la password
     */
    public String getPw(int idTrans) {
        return transaccionDAO.obtenerPwTransaccionNoCliente(idTrans);
        
    }

    /**
     * Metodo para obtener el folio dd la base de datos, mediante el id de la
     * transaccion
     *
     * @param idTrans id de la transaccion
     * @return folio
     */
    public String getFolio(int idTrans) {
        return transaccionDAO.obtenerFolioTransaccionNoCliente(idTrans);
        
    }

    /**
     * Metodo auxiliar para actualizar los estados de cuenta, para que traiga el
     * historial de transacciones
     *
     * @param idCuenta id de la cuenta
     * @return lista de transacciones
     */
    public ArrayList<Transaccion> obtenerListaTransacciones(String idCuenta) {
        return transaccionDAO.verHistorial(idCuenta);
        
    }
    /**
     * Metodo auxiliar para actualizar los estados de cuenta,trae una lista de retiros
     * @param idCuenta id de la cuenta
     * @return lista de retiros
     */
  public ArrayList<TransaccionFolio> obtenerListaretiros(String idCuenta) {
        return transFolioDao.verHistorialRetiros(idCuenta);  
    }
  /**
   * Metodo auxiliar para actualizar estados de cuenta, trae las transferencias cuyo tipo es 
   * "transferencia"
   * @param idCuenta
   * @return lista de transferencias
   */
   public ArrayList<Transaccion> obtenerListaTransferencias(String idCuenta) {
        return transFolioDao.verHistorialTransaccion(idCuenta);
        
    }
    /**
     * Metodo PRINCIPAL para verificar que las tareas esten vencidas o no, cada
     * vez que ingresas folio y pw el sistema detecta y compara la hora de
     * generacion del folio, con la hora a la que quieres sacar el dinero
     *
     * @param folio folio generado
     * @param passw password generada
     * @return
     */
    public boolean verificarVencimiento(String folio, String passw) {
        if (folio.equals("") || passw.equals("")) {
            return false;
        } else {
            TransaccionFolio tfol;
            tfol = transFolioDao.buscarTransaccionPorFolioPw(folio, passw);
            Timestamp fechaHoraActual = new Timestamp(System.currentTimeMillis());
            System.out.println(fechaHoraActual);
            System.out.println(tfol.getTiempo());
            if (tfol.getTiempo().before(fechaHoraActual)) {
                tfol.setEstado("vencido");
                transFolioDao.editarTransaccion(tfol);
                JOptionPane.showMessageDialog(null, "Esta operacion ha vencido, haz otra");
                return false;
            }
        }
        
        return true;
    }

    /**
     * Metodo auxiliar para expirar el tiempo, aunque terminamos no utilizandolo
     * tanto, decidimos dejarlo aqui
     *
     * @param cantidadRetirar cantidad a retirar
     * @param saldo saldo
     * @param cuenta cuenta
     * @return true // false
     */
    public int crearTimerExpiracion(String cantidadRetirar, int saldo, Cuenta cuenta) {
        if (!regex("^\\d+$", cantidadRetirar)) {
            JOptionPane.showMessageDialog(null, "Verifica los datos introducidos");
            return -1;
        } else {
            
            int montoReal = Integer.parseInt(cantidadRetirar);
            
            if (saldo < montoReal) {
                JOptionPane.showMessageDialog(null, "No tienes suficiente dinero");
                return -1;
            } else if (montoReal < 100) {
                JOptionPane.showMessageDialog(null, "El minimo para retirar son 100 pesos");
                return -1;
            }
            Transaccion t = transaccionDAO.registrarTransaccion(new Transaccion(false, montoReal, cuenta));
            int idTransaccion = t.getId_transaccion();
            
            TransaccionFolio trans = transFolioDao.verTransaccionFolio(idTransaccion);
            
            Timestamp fechaHoraActual = new Timestamp(System.currentTimeMillis());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaHoraActual);
            calendar.add(Calendar.MINUTE, 10);
            
            Timestamp fechaHoraCon10MinutosMas = new Timestamp(calendar.getTimeInMillis());
            trans.setTiempo(fechaHoraCon10MinutosMas);
            transFolioDao.editarTransaccion(trans);
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                
                @Override
                public void run() {
                    if (transFolioDao.verTransaccionFolio(trans.getIdTransaccion()).getEstado().equals("Generado")) {
                        trans.setEstado("no cobrado");
                        transFolioDao.editarTransaccion(trans);
                    }
                    
                }
            }, fechaHoraCon10MinutosMas);
            return trans.getIdTransaccion();
        }
    }

    /**
     * Metodo auxiliar para hacer regex mas facil
     *
     * @param regex expresion regular
     * @param texto texto a verificar
     * @return
     */
    private boolean regex(String regex, String texto) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "Verifica los datos introducidos");
            return false;
        }
        return true;
    }
    
}
