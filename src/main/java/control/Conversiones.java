
package control;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import objetos.Cuenta;


public class Conversiones {
/**
 * La clase Conversiones proporciona métodos para realizar conversiones y
 * manipular datos. Este método convierte una lista de objetos Cuenta en un
 * modelo de combobox. Cada elemento del combobox corresponde al identificador
 * de una cuenta. El método devuelve un DefaultComboBoxModel que puede
 * ser utilizado para configurar un componente JComboBox en la interfaz de
 * usuario.
 *
 * @author abelc
 *
 * @param listaCuentas La lista de cuentas que se desea convertir en el modelo
 * de combobox.
 * @return Un DefaultComboBoxModel que contiene los identificadores de
 * las cuentas.
 */
    public DefaultComboBoxModel<String> cuentasComboBoxModel(List<Cuenta> listaCuentas) {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        for (Cuenta cuenta : listaCuentas) {
            comboBoxModel.addElement(cuenta.getIdCuenta());
        }

        return comboBoxModel;
    }
}
