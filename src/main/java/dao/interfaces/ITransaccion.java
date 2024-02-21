/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.interfaces;

import dao.excepciones.PersistenciaException;
import objetos.Transaccion;

/**
 * La interfaz ITransaccion define las operaciones que pueden ser realizadas sobre objetos Transaccion.
 * Estas operaciones incluyen el registro, edición, eliminación y visualización de transacciones en un sistema.
 */
public interface ITransaccion {
    
    /**
     * Registra una nueva transacción en el sistema.
     *
     * @param t La transacción a ser registrada.
     * @return La transacción registrada.
     * @throws PersistenciaException Si ocurre un error durante la operación de registro.
     */
    Transaccion registrarTransaccion(Transaccion t) throws PersistenciaException;

    /**
     * Edita la información de una transacción existente en el sistema.
     *
     * @param t La transacción con la información actualizada.
     * @return La transacción con la información actualizada.
     * @throws PersistenciaException Si ocurre un error durante la operación de edición.
     */
    Transaccion editarTransaccion(Transaccion t) throws PersistenciaException;

    /**
     * Elimina una transacción existente del sistema.
     *
     * @param t La transacción a ser eliminada.
     * @return La transacción eliminada.
     * @throws PersistenciaException Si ocurre un error durante la operación de eliminación.
     */
    Transaccion eliminarTransaccion(Transaccion t) throws PersistenciaException;

    /**
     * Obtiene y retorna una transacción del sistema basada en su identificador.
     *
     * @param id El identificador de la transacción a buscar.
     * @return La transacción encontrada.
     * @throws PersistenciaException Si ocurre un error durante la operación de búsqueda.
     */
    Transaccion verTransaccion(int id) throws PersistenciaException;
}