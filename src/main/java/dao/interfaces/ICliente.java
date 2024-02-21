/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao.interfaces;

import dao.excepciones.PersistenciaException;
import objetos.Cliente;

/**
 * La interfaz ICliente define las operaciones que pueden ser realizadas sobre objetos Cliente.
 * Estas operaciones incluyen el registro, edición, eliminación y búsqueda de clientes en un sistema.
 */
public interface ICliente {

    /**
     * Registra un nuevo cliente en el sistema.
     *
     * @param cliente El cliente a ser registrado.
     * @return El cliente registrado.
     * @throws PersistenciaException Si ocurre un error durante la operación de registro.
     */
    Cliente registrarCliente(Cliente cliente) throws PersistenciaException;

    /**
     * Edita la información de un cliente existente en el sistema.
     *
     * @param cliente El cliente con la información actualizada.
     * @return El cliente con la información actualizada.
     * @throws PersistenciaException Si ocurre un error durante la operación de edición.
     */
    Cliente editarCliente(Cliente cliente) throws PersistenciaException;

    /**
     * Elimina un cliente existente del sistema.
     *
     * @param cliente El cliente a ser eliminado.
     * @return El cliente eliminado.
     * @throws PersistenciaException Si ocurre un error durante la operación de eliminación.
     */
    Cliente eliminarCliente(Cliente cliente) throws PersistenciaException;

    /**
     * Busca un cliente en el sistema por su identificador.
     *
     * @param id El identificador del cliente a buscar.
     * @return El cliente encontrado.
     * @throws PersistenciaException Si ocurre un error durante la operación de búsqueda.
     */
    Cliente buscarCliente(int id) throws PersistenciaException;
}
