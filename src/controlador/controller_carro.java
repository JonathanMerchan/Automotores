/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.*;
import java.util.LinkedList;
import modelo.modelo_carro;
import modelo.modelo_motor;

/**
 *
 * @author Marce
 */
public class controller_carro {

    public controller_carro() {

    }

    public boolean crear_carro(cls_carro carro) {
        boolean K=false;
        try {
            modelo_carro Mcarro = new modelo_carro();
            if (Mcarro.crearcarro(carro)) {
                K=true;
            }
        } catch (Exception e) {
            return K;
        }
        return K;
    }

    public cls_carro buscar_carro(String modelo) {
        cls_carro RR = null;
        try {
            if (modelo != null) {
                modelo_carro Mcarro = new modelo_carro();
                RR = Mcarro.buscarcarro(modelo);
            }
            return RR;
        } catch (Exception e) {
            return RR;
        }

    }

    public boolean actualizar_carro(cls_carro carro) {
        boolean R = false;
        try {
            modelo_carro Mcarro = new modelo_carro();
            if (Mcarro.actualizarcarro(carro)) {
                R=true;
            }
        } catch (Exception e) {
            return R;
        }
        return R;

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

    public LinkedList<cls_motor> listado_motor() {
        LinkedList<cls_motor> motorlista = null;
        try {
            modelo_motor Lmotor = new modelo_motor();
            motorlista = Lmotor.ListadoMotor();
            return motorlista;
        } catch (Exception e) {
            return null;
        }
    }

}
