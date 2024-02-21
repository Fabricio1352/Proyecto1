
package dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * La interfaz IConexion define el contrato para crear una conexión a una base de datos.
 * Las clases que implementen esta interfaz deben proporcionar una implementación para
 * crear y establecer una conexión con la base de datos.
 */
public interface IConexion {

    /**
     * Crea y establece una conexión con la base de datos.
     *
     * @return La conexión establecida con la base de datos.
     * @throws SQLException Si ocurre un error al intentar establecer la conexión.
     */
    Connection crearConexion() throws SQLException;
}
