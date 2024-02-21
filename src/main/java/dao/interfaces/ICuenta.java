
package dao.interfaces;

import dao.excepciones.PersistenciaException;
import java.util.ArrayList;
import objetos.Cuenta;

/**
 *
 * @author fabri
 */
/**
 * La interfaz ICuenta define las operaciones que pueden ser realizadas sobre
 * objetos Cuenta. Estas operaciones incluyen el registro, edición, eliminación
 * y búsqueda de cuentas en un sistema.
 */
public interface ICuenta {

    /**
     * Registra una nueva cuenta en el sistema.
     *
     * @param cuenta La cuenta a ser registrada.
     * @return La cuenta registrada.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * registro.
     */
    Cuenta registrarCuenta(Cuenta cuenta) throws PersistenciaException;

    /**
     * Edita la información de una cuenta existente en el sistema.
     *
     * @param cuenta La cuenta con la información actualizada.
     * @return La cuenta con la información actualizada.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * edición.
     */
    Cuenta editarCuenta(Cuenta cuenta) throws PersistenciaException;

    /**
     * Elimina una cuenta existente del sistema.
     *
     * @param cuenta La cuenta a ser eliminada.
     * @return La cuenta eliminada.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * eliminación.
     */
    Cuenta cancelarCuenta(Cuenta cuenta) throws PersistenciaException;

    /**
     * Busca una cuenta en el sistema por su identificador.
     *
     * @param id El identificador de la cuenta a buscar.
     * @return La cuenta encontrada.
     * @throws PersistenciaException Si ocurre un error durante la operación de
     * búsqueda.
     */
    Cuenta buscarCuenta(String id) throws PersistenciaException;

    /**
     * Metodo para buscar cuentas por el id del cliente.
     *
     * @param id id de cliente
     * @return regresa las cuentas asociadas al cliente
     * @throws dao.excepciones.PersistenciaException
     */
    ArrayList<Cuenta> buscarCuentaPorCliente(int id) throws PersistenciaException;
}
