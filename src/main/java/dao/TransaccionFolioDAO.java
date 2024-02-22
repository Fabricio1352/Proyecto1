
package dao;

import dao.interfaces.IConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Transaccion;
import objetos.TransaccionFolio;

/**
 * Data Access Object de la entidad transaccionFolio
 * 
 * @author fabri
 */
public class TransaccionFolioDAO {

    private final IConexion conexion;

    public TransaccionFolioDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Metodo para buscar una transaccion mediante el folio generado y el pw
     * 
     * @param folio folio existente
     * @param pw password existente
     * @return regresa la transaccion
     */
    public TransaccionFolio buscarTransaccionPorFolioPw(String folio, String pw) {
        String select = "SELECT * FROM transaccionfoliocliente WHERE folio_transaccion = ? AND password_transaccion = ?";
        TransaccionFolio tEncontrada = null;
        try {
            Connection c = conexion.crearConexion();
            PreparedStatement selectStatement = c.prepareStatement(select);

            selectStatement.setString(1, folio);
            selectStatement.setString(2, pw);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                tEncontrada = new TransaccionFolio();
                tEncontrada.setIdTransaccion(resultSet.getInt("id_transaccion"));
                tEncontrada.setEstado(resultSet.getString("estado"));
                tEncontrada.setPasswordTransaccion("password_transaccion");
                tEncontrada.setFolioTransaccion("folio_transaccion");
                tEncontrada.setTiempo(resultSet.getTimestamp("tiempo"));

            }

        } catch (SQLException e) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la operacion, verifica los datos", e);

        }
        return tEncontrada;
    }

    
    /**
     * Metodo para ver la transaccion especifica que haya sido mediante uso de folio y pw solamente
     * 
     * 
     * @param id id transaccion
     * @return  regresa la transaccion
     */
    public TransaccionFolio verTransaccionFolio(int id) {
        String select = "SELECT * FROM transaccionfoliocliente WHERE id_transaccion = ?";
        TransaccionFolio tEncontrada = null;

        try {
            Connection c = conexion.crearConexion();
            PreparedStatement selectStatement = c.prepareStatement(select);

            selectStatement.setInt(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                tEncontrada = new TransaccionFolio();
                tEncontrada.setIdTransaccion(resultSet.getInt("id_transaccion"));
                tEncontrada.setEstado(resultSet.getString("estado"));
                tEncontrada.setPasswordTransaccion("password_transaccion");
                tEncontrada.setFolioTransaccion("folio_transaccion");
                tEncontrada.setTiempo(resultSet.getTimestamp("tiempo"));

            }

        } catch (SQLException e) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la operacion, verifica los datos", e);

        }
        return tEncontrada;
    }

    
    /**
     * Metodo para ver el historial de transacciones, utilizando el procedure 'verHistoria'
     * 
     * @param id id de la cuenta asociada
     * @return regresa la lista de transacciones
     */
    public ArrayList<Transaccion> verHistorial(String id) {
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        try {
            Connection con = conexion.crearConexion();
            String verHistorialState = "{CALL verHistorial(?)}";
            CallableStatement callableStatement = con.prepareCall(verHistorialState);
            callableStatement.setString(1, id);
//            ResultSet resultSet = callableStatement.executeQuery();
            boolean results = callableStatement.execute();

            while (results) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    // int idTransaccion = resultSet.getInt("Id");
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
 * Metodo que se encarga de generar una lista de trandaccionFolio llamando al procedure veriHistorialRetiros
 * @param id id de la cuenta asociada
 * @return lista de transacciones
 */
public ArrayList<TransaccionFolio> verHistorialRetiros(String id) { 
    ArrayList<TransaccionFolio> transacciones= new ArrayList<>();
        try {
            Connection con = conexion.crearConexion();
            String verHistorialState = "{CALL verHistorialRetiros(?)}";
            CallableStatement callableStatement = con.prepareCall(verHistorialState);
            callableStatement.setString(1, id);
            boolean results = callableStatement.execute();
                      while (results) {
                ResultSet resultSet = callableStatement.getResultSet();
                while (resultSet.next()) {
                    // int idTransaccion = resultSet.getInt("Id");
                    Timestamp fechaTransaccion = resultSet.getTimestamp("Fecha");
                    int monto = resultSet.getInt("Monto");
                    String tipoTransaccion = resultSet.getString("Tipo de Transacción");
                    String estado=resultSet.getString("Estado");
                    TransaccionFolio transaccion = new TransaccionFolio(fechaTransaccion, tipoTransaccion, monto,estado);
                    transacciones.add(transaccion);

                }
                results = callableStatement.getMoreResults();

            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionFolioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return transacciones;
}
/**
 * Metodo que guarda en una lista transferencias cuyo tipo de transaccion sea "Transferencia";
 * @param id
 * @return lista de transferencias
 */
public ArrayList<Transaccion> verHistorialTransaccion(String id) {
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
                String tipoTransaccion = resultSet.getString("Tipo de Transacción");
                // Verifica si el tipo de transacción es "Transferencia"
                if ("Transferencia".equals(tipoTransaccion)) {
                    Timestamp fechaTransaccion = resultSet.getTimestamp("Fecha");
                    int monto = resultSet.getInt("Monto");
                    Transaccion transaccion = new Transaccion(fechaTransaccion, tipoTransaccion, monto);
                    transacciones.add(transaccion);
                }
            }
            results = callableStatement.getMoreResults();
        }

    } catch (SQLException e) {
        Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "No ha sido posible recuperar los datos", e);
    }
    return transacciones;
}
    
    /**
     * Metodo para editar una transaccion de tipo 'Folio' (sin cuenta asociada)
     * Lo unico editable, es el estado, se utilizara internamente para la logica de cobrado, no cobrado y vencido
     * 
     * @param t transaccion
     * @return regresa la transaccion
     */
    public TransaccionFolio editarTransaccion(TransaccionFolio t) {
        String editarTrans = "UPDATE transaccionfoliocliente SET estado = ?, tiempo = ? WHERE id_transaccion = ?";

        TransaccionFolio tr = new TransaccionFolio();

        try {
            Connection con = conexion.crearConexion();
            PreparedStatement updateStatement = con.prepareStatement(editarTrans);
            updateStatement.setString(1, t.getEstado());
            updateStatement.setTimestamp(2, t.getTiempo());
            updateStatement.setInt(3, t.getIdTransaccion());

            int filasAfectadas = updateStatement.executeUpdate();

            if (filasAfectadas > 0) {
                tr.setEstado(t.getEstado());
                tr.setTiempo(t.getTiempo());
            }

        } catch (SQLException e) {
            Logger.getLogger(TransaccionDAO.class.getName()).log(Level.SEVERE, "Error al intentar registrar la cuenta", e);

        }
        return tr;
    }
    
    

}
