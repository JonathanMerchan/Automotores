/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/** @author Marce */
public class cls_moto extends cls_automotor{
    private String modelo;
    private String tipo_rines;

    public cls_moto(String modelo, String tipo_rines, String num_cambios, String num_ruedas, String Annio_fabricacion, String color, int id_motor) {
        super(num_cambios, num_ruedas, Annio_fabricacion, color, id_motor);
        this.modelo = modelo;
        this.tipo_rines = tipo_rines;
    }

    

    
    public String zigzagiar(){
    return "Zigzagea";
    }
    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the tipo_rines
     */
    public String getTipo_rines() {
        return tipo_rines;
    }

    /**
     * @param tipo_rines the tipo_rines to set
     */
    public void setTipo_rines(String tipo_rines) {
        this.tipo_rines = tipo_rines;
    }

     @Override
     public String mover(){
     return "La moto se esta moviendo";
     }
    
      @Override
     public String detener(){
     return "La moto se esta deteniendo";
     }
   
    
    

    
}
