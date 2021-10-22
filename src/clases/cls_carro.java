/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/*** * @author Marce */
public class cls_carro extends cls_automotor{
    private Boolean airbag;
    private String modelo;
    private String tipo_rines;

    public cls_carro(Boolean airbag, String modelo, String tipo_rines, String num_cambios, String num_ruedas, String Annio_fabricacion, String color, int id_motor) {
        super(num_cambios, num_ruedas, Annio_fabricacion, color, id_motor);
        this.airbag = airbag;
        this.modelo = modelo;
        this.tipo_rines = tipo_rines;
    }

    

    /**
     * @return the airbag
     */
    public Boolean getAirbag() {
        return airbag;
    }

    /**
     * @param airbag the airbag to set
     */
    public void setAirbag(Boolean airbag) {
        this.airbag = airbag;
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
     return "El carro se esta moviendo";
     }

@Override
     public String detener(){
     return "El carro se esta deteniendo";
     }    
    
   
}
