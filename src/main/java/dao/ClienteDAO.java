/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import control.Negocio;
import dao.excepciones.PersistenciaException;
import dao.interfaces.ICliente;
import dao.interfaces.IConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;

/**
 * La clase ClienteDAO implementa la interfaz ICliente y proporciona métodos
 * para realizar operaciones relacionadas con los clientes en la base de datos.
 * Utiliza una instancia de IConexion para establecer conexiones con la base de
 * datos. Esta clase permite el registro, edición, eliminación y búsqueda de
 * clientes. Debe ser instanciada con un objeto que implemente la interfaz
 * IConexion para funcionar correctamente.
 *
 * @author fabri
 */
public class ClienteDAO implements ICliente {

    private final IConexion conexion;

    /**
     * Constructor de la clase ClienteDAO.
     *
     * @param conexion Una instancia de IConexion para establecer conexiones con
     * la base de datos.
     */
    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws PersistenciaException {

        String creaTransaccion = "INSERT INTO Cliente"
                + "(id,nombre, apellido_paterno, apellido_materno, calle, colonia, codigo_postal, fecha_nacimiento,passw)"
                + "VALUES (?,?,?,?,?,?,?,?,?)";

        Cliente clienteCreado = new Cliente();
        Negocio logNegocio = new Negocio();

        try {
            logNegocio.generarID(cliente);
            Connection con = conexion.crearConexion();
            PreparedStatement st = con.prepareStatement(creaTransaccion);
            st.setInt(1, cliente.getId());
            st.setString(2, cliente.getNombre());
            st.setString(3, cliente.getApellido_materno());
            st.setString(4, cliente.getApellido_paterno());
            st.setString(5, cliente.getCalle());
            st.setString(6, cliente.getColonia());
            st.setString(7, cliente.getCodigo_postal());
            st.setDate(8, cliente.getFecha_nacimiento());
            st.setString(9, cliente.getPassw());

            int filasAfectadas = st.executeUpdate();

            if (filasAfectadas > 0) {
                clienteCreado.setId(cliente.getId());
            }
        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "Error en la operacion", e);
        }
        clienteCreado.setNombre(cliente.getNombre());
        return clienteCreado;

    }

    @Override
    public Cliente editarCliente(Cliente cliente) {

        String updateCliente = "UPDATE cliente SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, calle = ?, colonia = ?, codigo_postal = ?, fecha_nacimiento = ?, passw = ?  WHERE id = ?";
        Cliente clienteActualizado = new Cliente();

        if (cliente != null) {
            try {
                Connection c = conexion.crearConexion();
                PreparedStatement updateStatement = c.prepareStatement(updateCliente);

                updateStatement.setString(1, cliente.getNombre());
                updateStatement.setString(2, cliente.getApellido_paterno());
                updateStatement.setString(3, cliente.getApellido_materno());
                updateStatement.setString(4, cliente.getCalle());
                updateStatement.setString(5, cliente.getColonia());
                updateStatement.setString(6, cliente.getCodigo_postal());
                updateStatement.setDate(7, cliente.getFecha_nacimiento());
                updateStatement.setString(8, cliente.getPassw());
                updateStatement.setInt(9, cliente.getId());

                int filasAfectadas = updateStatement.executeUpdate();

                if (filasAfectadas > 0) {
                    clienteActualizado.setNombre(cliente.getNombre());
                    clienteActualizado.setApellido_paterno(cliente.getApellido_paterno());
                    clienteActualizado.setApellido_materno(cliente.getApellido_materno());
                    clienteActualizado.setColonia(cliente.getColonia());
                    clienteActualizado.setCalle(cliente.getCalle());
                    clienteActualizado.setCodigo_postal(cliente.getCodigo_postal());
                    clienteActualizado.setFecha_nacimiento(cliente.getFecha_nacimiento());
                }

            } catch (SQLException e) {
                Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la operacion de editar", e);
            }
        }

        return clienteActualizado;
    }

    @Override
    public Cliente eliminarCliente(Cliente cliente) {

        String deleteCliente = "DELETE FROM cliente WHERE id = ?";
        Cliente clienteEliminado = new Cliente();

        if (cliente != null) {
            try {
                Connection c = conexion.crearConexion();
                PreparedStatement deleteStatement = c.prepareStatement(deleteCliente);
                deleteStatement.setInt(1, cliente.getId());
                int filasAfectadas = deleteStatement.executeUpdate();
                if (filasAfectadas > 0) {
                    clienteEliminado.setId(cliente.getId());
                    clienteEliminado.setNombre(cliente.getNombre());

                }

            } catch (SQLException e) {
                Logger.getLogger(CuentaDAO.class.getName()).log(Level.SEVERE, "Error en la operacion de editar", e);
            }
        }

        return clienteEliminado;

    }

    @Override
    public Cliente buscarCliente(int id) {
        String selectCliente
                = "SELECT * FROM cliente WHERE id = ?";

        Cliente clienteEncontrado = null;

        try {
            Connection c = conexion.crearConexion();
            PreparedStatement selectStatement = c.prepareStatement(selectCliente);

            selectStatement.setInt(1, id);

            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                clienteEncontrado = new Cliente();
                clienteEncontrado.setId(resultSet.getInt("id"));
                clienteEncontrado.setNombre(resultSet.getString("nombre"));
                clienteEncontrado.setApellido_materno(resultSet.getString("apellido_materno"));
                clienteEncontrado.setApellido_paterno(resultSet.getString("apellido_paterno"));
                clienteEncontrado.setCalle(resultSet.getString("calle"));
                clienteEncontrado.setColonia(resultSet.getString("colonia"));
                clienteEncontrado.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
                clienteEncontrado.setCodigo_postal(resultSet.getString("codigo_postal"));
                clienteEncontrado.setPassw(resultSet.getString("passw"));
            }

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, "Error en la operacion", e);
        }

        return clienteEncontrado;
    }

}
