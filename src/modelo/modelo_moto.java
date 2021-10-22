package modelo;

import clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** * @author Marce */
public class modelo_moto {
    
    model_db dbData;
        
    public modelo_moto(){
        this.dbData = new model_db();
    }
    
    public boolean crearmoto(cls_moto moto) throws SQLException{
    
        try( /*abre base datos*/ Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "INSERT INTO tbl_automorot (num_cambios,num_ruedas,anio_fabricacion,color) VALUES (?,?,?,?)"; /*inserta datos */
            PreparedStatement statement_automotor = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement_automotor.setString(1, moto.getAnnio_fabricacion()); /* se establece el valor de la variable*/
            statement_automotor.setString(2, moto.getColor());
            statement_automotor.setString(3, moto.getModelo());
            int rowInserted =statement_automotor.executeUpdate();
            /*como ya se modifico la tabla padre, se modifica la tabla hijo*/
            if (rowInserted>0) {
                ResultSet generatedKeys = statement_automotor.getGeneratedKeys();
                if (generatedKeys.next()){
                    int idAutomotor = generatedKeys.getInt(1);
                    query ="INSERT INTO tbl_moto(nombre de las colunas en la tabla,,,) VALUES (?,?,?)";
                    PreparedStatement statement_moto = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                     statement_moto.setString(1, moto.getNum_ruedas()); /* se establece el valor de la variable*/
                     statement_moto.setString(2, moto.getTipo_rines());
                     statement_moto.setString(3, moto.luces_lujo());
                     statement_moto.setInt(4, idAutomotor);
                }
            }
            
        
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean editarmoto(cls_moto moto){
    try{         
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean eliminarmoto(cls_moto moto){
    try{         
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean actualizarmoto(cls_moto moto){
    try{         
            return true;
        }catch (Exception e){
            return false;
        }
    }
    
    
}
