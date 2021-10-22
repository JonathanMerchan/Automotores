/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import Interface.*;

/** * @author Marce */
public class cls_automotor implements i_lujos{
    
    private String num_cambios;
    private String num_ruedas;
    private String Annio_fabricacion;
    private String color;
    private int id_motor;

    public cls_automotor(String num_cambios, String num_ruedas, String Annio_fabricacion, String color, int id_motor) {
        this.num_cambios = num_cambios;
        this.num_ruedas = num_ruedas;
        this.Annio_fabricacion = Annio_fabricacion;
        this.color = color;
        this.id_motor = id_motor;
    }

    
   
    public String mover(){
    return "En movimiento";
    }
   
    public String detener(){
    return "Detenido";
    }
    /**
     * @return the num_cambios
     */
    public String getNum_cambios() {
        return num_cambios;
    }

    /**
     * @param num_cambios the num_cambios to set
     */
    public void setNum_cambios(String num_cambios) {
        this.num_cambios = num_cambios;
    }

    /**
     * @return the num_ruedas
     */
    public String getNum_ruedas() {
        return num_ruedas;
    }

    /**
     * @param num_ruedas the num_ruedas to set
     */
    public void setNum_ruedas(String num_ruedas) {
        this.num_ruedas = num_ruedas;
    }

    /**
     * @return the Annio_fabricacion
     */
    public String getAnnio_fabricacion() {
        return Annio_fabricacion;
    }

    /**
     * @param Annio_fabricacion the Annio_fabricacion to set
     */
    public void setAnnio_fabricacion(String Annio_fabricacion) {
        this.Annio_fabricacion = Annio_fabricacion;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the motor
     */
    
    
    
      @Override
    public String luces_lujo(){
        return "Se han aplicado luces de lujo";
    }

    /**
     * @return the id_motor
     */
    public int getId_motor() {
        return id_motor;
    }

    /**
     * @param id_motor the id_motor to set
     */
    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }
    
    
    
    
  
    
    
    
}
