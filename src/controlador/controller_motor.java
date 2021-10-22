package controlador;

import clases.cls_motor;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import modelo.*;

/**
 * * @author Marce
 */
public class controller_motor {

    public controller_motor() {

    }

    public boolean crear_motor(cls_motor motor) {
        try {
            if (motor.getCilindraje_cc() > 0) {
                if (motor.getCodigo() != "") {
                    modelo_motor Mmotor = new modelo_motor();
                    Mmotor.crearmotor(motor);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public cls_motor buscar_motor(String codigo) {
        cls_motor RR = null;
        try {
            if (codigo != null) {
                modelo_motor Mmotor = new modelo_motor();
                RR = Mmotor.buscarmotor(codigo);
            }
            return RR;
        } catch (Exception e) {
            return RR;
        }

    }

    public boolean actualizar_motor(cls_motor motor) {
        boolean R = false;
        try {
            if (motor.getCilindraje_cc() > 0) {
                if (motor.getCodigo() != "") {
                    modelo_motor Mmotor = new modelo_motor();
                    if (Mmotor.actualizarmotor(motor)) {
                        R = true;
                    }
                }
            }
            return R;
        } catch (Exception e) {
            return R;
        }

    }

    public LinkedList<cls_motor> buscarEliminar_motor(String codigo) {
        LinkedList<cls_motor> RR = null;
        try {
            if (codigo != null) {
                modelo_motor Mmotor = new modelo_motor();
                RR = Mmotor.buscarEliminarmotor(codigo);
            }
            return RR;
        } catch (Exception e) {
            return RR;
        }

    }
    
    public boolean eliminar_motor(String codigo) {
        boolean RR = false;
        try {
            if (codigo != null) {
                modelo_motor Mmotor = new modelo_motor();
                RR = Mmotor.eliminarmotor(codigo);
            }
            return RR;
        } catch (Exception e) {
            return RR;
        }

    }

    public LinkedList<cls_motor> listado_motor(){
        LinkedList<cls_motor> motorlista = null;
        try{
            modelo_motor Lmotor = new modelo_motor();
            motorlista = Lmotor.ListadoMotor();
        return motorlista;
    }catch (Exception e){
        return null;
    }
    }
    
    
    
    
}
