/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/*** @author Marce */
public class cls_motor {
    private int id;
    private String codigo;
    private int cilindraje_cc;
    private String tipo_combustible;

    public cls_motor(String codigo, int cilindraje_cc, String tipo_combustible) {
        this.codigo = codigo;
        this.cilindraje_cc = cilindraje_cc;
        this.tipo_combustible = tipo_combustible;
    }

    public cls_motor(int id, String codigo, int cilindraje_cc, String tipo_combustible) {
        this.id = id;
        this.codigo = codigo;
        this.cilindraje_cc = cilindraje_cc;
        this.tipo_combustible = tipo_combustible;
    }

    
       public String encender(){
        return "Encendido";
    }
    
    public String apagar(){
        return "apagado";
    }
    /**
     * @return the cilindraje_cc
     */
    public int getCilindraje_cc() {
        return cilindraje_cc;
    }

    /**
     * @param cilindraje_cc the cilindraje_cc to set
     */
    public void setCilindraje_cc(int cilindraje_cc) {
        this.cilindraje_cc = cilindraje_cc;
    }

    /**
     * @return the tipo_combiustible
     */
    public String getTipo_combustible() {
        return tipo_combustible;
    }

    /**
     * @param tipo_combiustible the tipo_combiustible to set
     */
    public void setTipo_combustible(String tipo_combiustible) {
        this.tipo_combustible = tipo_combiustible;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
    
}
