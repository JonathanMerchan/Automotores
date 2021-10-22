/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/** * @author Marce */
public class cls_piloto {
    private String licencia;
    private cls_automotor automotor;

    public cls_piloto(String licencia) {
        this.licencia = licencia;
    }

    public String acelera(){
    return "Acelera";
    }
    
    public String frenar(){
    return "Acelera";
    }
    
    public String girar(){
        return "gira";
    }

    /**
     * @return the licencia
     */
    public String getLicencia() {
        return licencia;
    }

    /**
     * @param licencia the licencia to set
     */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    /**
     * @return the automotor
     */
    public cls_automotor getAutomotor() {
        return automotor;
    }

    /**
     * @param automotor the automotor to set
     */
    public void setAutomotor(cls_automotor automotor) {
        this.automotor = automotor;
    }
    }
   




   
    

   