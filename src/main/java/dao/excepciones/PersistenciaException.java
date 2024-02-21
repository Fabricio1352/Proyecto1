
package dao.excepciones;

/**
 * La clase PersistenciaException representa una excepción relacionada con la persistencia de datos.
 * Puede ser lanzada en situaciones donde ocurren errores durante operaciones de persistencia, como
 * registro, edición, eliminación o búsqueda de objetos en un sistema de persistencia de datos.
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor de PersistenciaException sin parámetros.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor de PersistenciaException que acepta un mensaje descriptivo del error.
     *
     * @param mensaje El mensaje descriptivo del error.
     */
    public PersistenciaException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor de PersistenciaException que acepta una causa subyacente del error.
     *
     * @param t La causa subyacente del error.
     */
    public PersistenciaException(Throwable t) {
        super(t);
    }

    /**
     * Constructor de PersistenciaException que acepta un mensaje descriptivo del error y una causa subyacente.
     *
     * @param mensaje El mensaje descriptivo del error.
     * @param t La causa subyacente del error.
     * @param b Indica si se debe habilitar la supresión de este error.
     * @param b2 Indica si se debe habilitar el seguimiento de este error.
     */
    public PersistenciaException(String mensaje, Throwable t, boolean b, boolean b2) {
        super(mensaje, t, b, b2);
    }
}


