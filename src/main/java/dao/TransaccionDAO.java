
package dao;

import dao.interfaces.IConexion;
import dao.interfaces.ITransaccion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cuenta;
import objetos.Transaccion;

/**
 * La clase TransaccionDAO implementa la interfaz ITransaccion y proporciona
 * métodos para realizar operaciones relacionadas con las transacciones en la
 * base de datos. Utiliza una instancia de IConexion para establecer conexiones
 * con la base de datos. Esta clase permite el registro, edición, eliminación y
 * visualización de transacciones. También incluye un método adicional para ver
 * el historial de transacciones de una cuenta específica. Debe ser instanciada
 * con un objeto que implemente la interfaz IConexion para funcionar
 * correctamente. Esta clase maneja las excepciones relacionadas con la
 * persistencia de datos.
 *
 * @author fabri
 */
public class TransaccionDAO implements ITransaccion {

    private final IConexion conexion;

    /**
     * Constructor de la clase TransaccionDAO.
     *
     * @param conexion Una instancia de IConexion para establecer conexiones con
     * la base de datos.
     */
    public TransaccionDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    /**
     * Registra una nueva transacción en el sistema.
     *
     * @param t La transacción a ser registrada.
     * @return La transacción registrada.
     */
    @Override
    public Transaccion registrarTransaccion(Transaccion t) {
        ResultSet rs;
        String creaTransaccion = "INSERT INTO Transaccion "
                + "(cantidad, tipo_transaccion, id_cuenta)"
                + "VALUES (?, ?, ?)";

        Transaccion tr = new Transaccion();

        try {
            Connection con = conexion.crearConexion();
            PreparedStatement st = con.prepareStatement(creaTransaccion, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, t.getCantidad());
            st.setBoolean(2, t.isTipo_transaccion());
            st.setString(3, t.getCuenta().getIdCuenta());

            int filasAfectadas = st.executeUpdate();
            if (filasAfectadas > 0) {

                rs = st.getGeneratedKeys();

                if (rs.next()) { 
                    int idGenerado = rs.getInt(1);
                    tr.setId_transaccion(idGenerado);
                }

            }

        } catch (SQLException e) {
            Logger.getLogger(TransaccionDAO.class.getName()).log(Level.SEVERE, "Error al intentar registrar la cuenta", e);

        }
        return tr;
    }

        /**
     * Edita la información de una transacción existente en el sistema.
     *
     * @param t La transacción con la información actualizada.
     * @return La transacción con la información actualizada.
     */
    @Override
    public Transaccion editarTransaccion(Transaccion t) {
        Logger.getLogger(TransaccionDAO.class.getName()).log(Level.SEVERE, "No puedes editar transacciones ...");
        return null;

    }
    /**
     * Elimina una transacción existente del sistema.
     *
     * @param t La transacción a ser eliminada.
     * @return La transacción eliminada.
     */
    @Override
    public Transaccion eliminarTransaccion(Transaccion t) {
        String deleteTransaccion = "DELETE FROM transaccion WHERE id_transaccion = ?";
        Transaccion transaccionEliminada = new Transaccion();

        if (t != null) {
            try {
                Connection c = conexion.crearConexion();
                PreparedStatement deleteStatement = c.prepareStatement(deleteTransaccion);
                deleteStatement.setInt(1, t.getId_transaccion());
                int filasAfectadas = deleteStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    transaccionEliminada.setId_transaccion(t.getId_transaccion());
                    transaccionEliminada.setFechahora_transaccion(t.getFechahora_transaccion());
                    transaccionEliminada.setCantidad(t.getCantidad());
                    transaccionEliminada.setTipo_transaccion(t.isTipo_transaccion());
                    transaccionEliminada.setCuenta(t.getCuenta());
                }

            } catch (SQLException e) {
                Logger.getLogger(TransaccionDAO.class.getName()).log(Level.SEVERE, "Error al intentar eliminar la cuenta", e);
            }
        }

        return transaccionEliminada;

    }
    /**
     * Obtiene y retorna una transacción del sistema basada en su identificador.
     *
     * @param id El identificador de la transacción a buscar.
     * @return La transacción encontrada.
     */
    @Override
    public Transaccion verTransaccion(int id) {

        String selectTransaccion
                = "SELECT t.id_transaccion, t.fecha_hora_transaccion, "
                + "t.cantidad, t.tipo_transaccion, c.id_cuenta "
                + "FROM transaccion t "
                + "JOIN cuenta c ON t.id_cuenta = c.id_cuenta "
                + "WHERE t.id_transaccion = ?";
        Transaccion transaccionEncontrada = null;

        try {
            Connection c = conexion.crearConexion();
            PreparedStatement selectStatement = c.prepareStatement(selectTransaccion);

            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                transaccionEncontrada = new Transaccion();
                transaccionEncontrada.setId_transaccion(resultSet.getInt("id_transaccion"));
                transaccionEncontrada.setFechahora_transaccion(resultSet.getTimestamp("fecha_hora_transaccion"));
                transaccionEncontrada.setTipo_transaccion(resultSet.getBoolean("tipo_transaccion"));
                transaccionEncontrada.setCantidad(resultSet.getInt("cantidad"));

                Cuenta cuenta = new Cuenta();
                cuenta.setIdCuenta(resultSet.getString("id_cuenta"));

                transaccionEncontrada.setCuenta(cuenta);

            }

        } catch (SQLException e) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la operacion, verifica los datos", e);

        }
        return transaccionEncontrada;
    }


    /**
     * Metodo para llamar al procedimiento historial de la base de datos
     * 
     * @param id id a buscar
     * @return  lista de transacciones
     */
    public ArrayList<Transaccion> verHistorial(String id) {
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        try {
            Connection con = conexion.crearConexion();
            String verHistorialState = "{CALL verHistorial(?)}";
            CallableStatement callableStatement = con.prepareCall(verHistorialState);
            callableStatement.setString(1, id);
            boolean results = callableStatement.execute();

            while (results) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    Timestamp fechaTransaccion = resultSet.getTimestamp("Fecha");
                    int monto = resultSet.getInt("Monto");
                    String tipoTransaccion = resultSet.getString("Tipo de Transacción");
                    Transaccion transaccion = new Transaccion(fechaTransaccion, tipoTransaccion, monto);
                    transacciones.add(transaccion);

                }
                results = callableStatement.getMoreResults();

            }

        } catch (SQLException e) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "No ha sido posible recuperar los datos", e);

        }
        return transacciones;
    }

    /**
     * metodo que llama al procedure para relaizar el cobro de un retiro si es
     * posible
     *
     * @param folio
     * @param passw
     * @return
     */
    public boolean retiro(String folio, String passw) {
        try {
            Connection con = conexion.crearConexion();

            CallableStatement callableStatement = con.prepareCall("{CALL CobrarTransaccion(?,?)}");
            callableStatement.setString(1, folio);
            callableStatement.setString(2, passw);
            callableStatement.executeQuery();

        } catch (SQLException e) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la transferencia, todos los datos han sido reestablecidos", e);
            return false;
        }
        return true;

    }
    
    
    /**
     * Metodo para obtener el password en un retiro sin cliente destino asociado
     * @param idTransaccion id de la transaccion
     * @return password
     */
    public String obtenerPwTransaccionNoCliente(int idTransaccion) {
        String selectTransaccion
                = "SELECT password_transaccion FROM transaccionfoliocliente WHERE id_transaccion = ?";

        String pw = null;
        try {
            Connection c = conexion.crearConexion();
            PreparedStatement selectStatement = c.prepareStatement(selectTransaccion);

            selectStatement.setInt(1, idTransaccion);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                pw = resultSet.getString("password_transaccion");
            }

        } catch (SQLException e) {

        }
        return pw;

    }

    
    /**
     * Metodo para obtener el folio de un retiro sin cuenta, de la base de datos
     * 
     * @param idTransaccion id de la transaccion
     * @return folio
     */
    public String obtenerFolioTransaccionNoCliente(int idTransaccion) {
        String selectTransaccion
                = "SELECT folio_transaccion FROM transaccionfoliocliente WHERE id_transaccion = ?";

        String folio = null;
        try {
            Connection c = conexion.crearConexion();
            PreparedStatement selectStatement = c.prepareStatement(selectTransaccion);

            selectStatement.setInt(1, idTransaccion);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                folio = resultSet.getString("folio_transaccion");
            }

        } catch (SQLException e) {

        }
        return folio;

    }

}
