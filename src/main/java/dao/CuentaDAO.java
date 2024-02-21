/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import control.Negocio;
import dao.interfaces.IConexion;
import dao.interfaces.ICuenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;
import objetos.Cuenta;

/**
 * La clase CuentaDAO implementa la interfaz ICuenta y proporciona métodos para realizar
 * operaciones relacionadas con las cuentas en la base de datos.
 * Utiliza una instancia de IConexion para establecer conexiones con la base de datos.
 * Esta clase permite el registro, edición, eliminación y búsqueda de cuentas.
 * Debe ser instanciada con un objeto que implemente la interfaz IConexion para funcionar correctamente.
 * @author fabri
 */
public class CuentaDAO implements ICuenta {

    private final IConexion conexion;
    /**
     * Constructor de la clase CuentaDAO.
     *
     * @param conexion Una instancia de IConexion para establecer conexiones con la base de datos.
     */
    public CuentaDAO(IConexion conexion) {
        this.conexion = conexion;

    }

    public boolean transferencia(String idOrigen, int monto, String idDestino) {
        try {
            Connection con = conexion.crearConexion();

            CallableStatement callableStatement = con.prepareCall("{CALL transferencia(?,?,?)}");
            callableStatement.setString(1, idOrigen);
            callableStatement.setInt(2, monto);
            callableStatement.setString(3, idDestino);
            callableStatement.execute();

        } catch (SQLException e) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la transferencia, todos los datos han sido reestablecidos", e);
            return false;
        }

        return true;

    }

    @Override
    public Cuenta registrarCuenta(Cuenta cuenta) {
        String creaCuenta = "INSERT INTO cuenta"
                + "(id_cuenta,saldo, id_cliente,estado)"
                + "VALUES (?,?,?,?)";

        Cuenta cuentaCreada = new Cuenta();
        Negocio logNegocio = new Negocio();

        try {
            logNegocio.generarNumCuenta(cuenta);
            Connection con = conexion.crearConexion();
            PreparedStatement st = con.prepareStatement(creaCuenta);
            st.setString(1, cuenta.getIdCuenta());
            st.setInt(2, cuenta.getSaldo());
            st.setInt(3, cuenta.getCliente().getId());
           st.setString(4,"vigente");
            int filasAfectadas = st.executeUpdate();

            if (filasAfectadas > 0) {
                cuentaCreada.setIdCuenta(cuenta.getIdCuenta());
            }

        } catch (SQLException e) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la operacion", e);

        }
        cuentaCreada.setCliente(cuenta.getCliente());
        cuentaCreada.setFechaApertura(cuenta.getFechaApertura());
        cuentaCreada.setSaldo(cuenta.getSaldo());
        cuentaCreada.setEstado("vigente");
        return cuentaCreada;

    }

    @Override
    public Cuenta editarCuenta(Cuenta cuenta) {

        String updateCuenta = "UPDATE cuenta SET saldo = ? WHERE id_cuenta = ?";
        Cuenta cuentaActualizada = new Cuenta();

        if (cuenta != null) {
            try {
                Connection c = conexion.crearConexion();
                PreparedStatement updateStatement = c.prepareStatement(updateCuenta);

                updateStatement.setInt(1, cuenta.getSaldo());
                updateStatement.setString(2, cuenta.getIdCuenta());

                int filasAfectadas = updateStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    cuentaActualizada.setSaldo(cuenta.getSaldo());

                }

            } catch (SQLException e) {
                Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la operacion, recuerda que solo puedes "
                        + "modificar el saldo de la cuenta, todo lo demas ya esta "
                        + "predefinido y esta prohibido eliminar o cambiar", e);
            }
        }

        return cuentaActualizada;

    }
/**
 * Cancelar cuenta
 * @param cuenta
 * @return 
 */
    @Override
    public Cuenta cancelarCuenta(Cuenta cuenta) {
String updateCuenta = "UPDATE cuenta SET estado = 'cancelado' WHERE id_cuenta = ?";
    Cuenta cuentaCancelada = null;

    if (cuenta != null) {
        try {
            Connection c = conexion.crearConexion();
            PreparedStatement updateStatement = c.prepareStatement(updateCuenta);
            updateStatement.setString(1, cuenta.getIdCuenta());
            int filasAfectadas = updateStatement.executeUpdate();
            if (filasAfectadas > 0) {
                cuentaCancelada = new Cuenta();
                cuentaCancelada.setIdCuenta(cuenta.getIdCuenta());
                cuentaCancelada.setSaldo(cuenta.getSaldo());
                cuentaCancelada.setFechaApertura(cuenta.getFechaApertura());
                cuentaCancelada.setCliente(cuenta.getCliente());
                cuentaCancelada.setEstado("cancelado");
            }
        } catch (SQLException e) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error al intentar cancelar la cuenta", e);
        }
    }

    return cuentaCancelada;

    }

    @Override
    public Cuenta buscarCuenta(String id) {
        String selectCuenta
                = "SELECT c.id_cuenta, c.fecha_apertura, c.saldo, cli.id "
                + "FROM cuenta c "
                + "JOIN cliente cli ON c.id_cliente = cli.id "
                + "WHERE c.id_cuenta = ?";
        Cuenta cuentaEncontrada = null;

        try {
            Connection c = conexion.crearConexion();
            PreparedStatement selectStatement = c.prepareStatement(selectCuenta);

            selectStatement.setString(1, id);

            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                cuentaEncontrada = new Cuenta();
                cuentaEncontrada.setIdCuenta(resultSet.getString("id_cuenta"));
                cuentaEncontrada.setSaldo(resultSet.getInt("saldo"));
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cuentaEncontrada.setCliente(cliente);

            }

        } catch (SQLException e) {
            Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la operacion, verifica los datos", e);

        }
        return cuentaEncontrada;
    }

    public ArrayList<Cuenta> buscarCuentaPorCliente(int id) {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
    String selectCuenta
            = "SELECT c.id_cuenta, c.fecha_apertura, c.saldo, cli.id "
            + "FROM cuenta c "
            + "JOIN cliente cli ON c.id_cliente = cli.id "
            + "WHERE c.id_cliente = ? AND c.estado = 'vigente'"; 

    try {
        Connection c = conexion.crearConexion();
        PreparedStatement selectStatement = c.prepareStatement(selectCuenta);

        selectStatement.setInt(1, id);

        ResultSet resultSet = selectStatement.executeQuery();

        while (resultSet.next()) {
            Cuenta cuentaEncontrada = new Cuenta();
            cuentaEncontrada.setIdCuenta(resultSet.getString("id_cuenta"));
            cuentaEncontrada.setFechaApertura(resultSet.getDate("fecha_apertura"));
            cuentaEncontrada.setSaldo(resultSet.getInt("saldo"));
            Cliente cliente = new Cliente();
            cliente.setId(resultSet.getInt("id"));
            cuentaEncontrada.setCliente(cliente);
            cuentas.add(cuentaEncontrada);
        }

    } catch (SQLException e) {
        Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la operacion, verifica los datos", e);
    }
    return cuentas;
    }

}
