package modelo;

/*@author Marce*/
import clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class modelo_motor {

    model_db dbData;

    public modelo_motor() {
        this.dbData = new model_db();
    }

    public boolean crearmotor(cls_motor motor) {
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "INSERT INTO tb_motor(cilindraje_cc,tipo_combustible,codigo) VALUES (?,?,?)";
            /*inserta datos */
            PreparedStatement statement_motor = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement_motor.setInt(1, motor.getCilindraje_cc());
            statement_motor.setString(2, motor.getTipo_combustible());
            statement_motor.setString(3, motor.getCodigo());
            int rowInserted = statement_motor.executeUpdate();
            if (rowInserted > 0) {

                /*System.out.println("Se creo el registro exitosamente.");*/
            }
            conn.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public cls_motor buscarmotor(String codigo) {
        cls_motor motorconsulta = null;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_motor WHERE codigo = ?";
            /*inserta datos */
            PreparedStatement statement_motor = conn.prepareStatement(query);
            statement_motor.setString(1, codigo);
            ResultSet result = statement_motor.executeQuery();
            System.out.println("try modelo buscar motor");
            while (result.next()) {
                System.out.println(result.getInt(1));
                System.out.println(result.getInt(2));
                System.out.println(result.getString(3));
                String motorId = result.getString(1);
                int cilindraje = result.getInt(2);
                String tcombustible = result.getString(3);
                motorconsulta = new cls_motor(motorId, cilindraje, tcombustible);
            }
            System.out.println(motorconsulta.toString());
            conn.close();
            /*System.out.println(R.get(0)+" - "+ R.get(1) + " - " + R.get(2)  );*/
            return motorconsulta;
        } catch (Exception e) {
            System.out.println("entro al catch en el modelo buscar" + e);
            return motorconsulta;
        }
    }

    public boolean actualizarmotor(cls_motor motor) {
        boolean M = false;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "UPDATE tb_motor     SET cilindraje_cc=?, tipo_combustible =? WHERE codigo =?";
            /*inserta datos */
            PreparedStatement statement_motor = conn.prepareStatement(query);
            statement_motor.setInt(1, motor.getCilindraje_cc());
            statement_motor.setString(2, motor.getTipo_combustible());
            statement_motor.setString(3, motor.getCodigo());
            int rowInserted = statement_motor.executeUpdate();

            if (rowInserted > 0) {
                M = true;
            }
            conn.close();
            return M;
        } catch (Exception e) {
            return M;
        }
    }

    public LinkedList<cls_motor> buscarEliminarmotor(String codigo) {
        LinkedList<cls_motor> motorconsulta = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_motor WHERE codigo = ?";
            /*inserta datos */
            PreparedStatement statement_motor = conn.prepareStatement(query);
            statement_motor.setString(1, codigo);
            ResultSet result = statement_motor.executeQuery();
            while (result.next()) {
                String motorId = result.getString(1);
                int cilindraje = result.getInt(2);
                String tcombustible = result.getString(3);
                cls_motor temporal;
                temporal = new cls_motor(motorId, cilindraje, tcombustible);
                motorconsulta.add(temporal);
                String query1 = "DELETE FROM tb_motor WHERE codigo = ?";
                /*inserta datos */
                PreparedStatement statement_DELETEmotor = conn.prepareStatement(query1);
                statement_DELETEmotor.setString(1, codigo);
                boolean result1 = statement_DELETEmotor.execute();
                System.out.println(result1);
                statement_DELETEmotor.execute();}
            return motorconsulta;
        } catch (Exception e) {
            System.out.println("entro al catch en el modelo ELIMINAR  " + e);
            return motorconsulta;
        }
    }
    
    public boolean eliminarmotor(String codigo) {
        boolean result1=true;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
                String query1 = "DELETE FROM tb_motor WHERE codigo = ?";
                /*inserta datos */
                PreparedStatement statement_DELETEmotor = conn.prepareStatement(query1);
                statement_DELETEmotor.setString(1, codigo);
                result1 = statement_DELETEmotor.execute();
                System.out.println(result1);                
        return result1;
        } catch (Exception e) {
            System.out.println("entro al catch en el modelo ELIMINAR  " + e);
            return result1;
        }
    }
    
    public LinkedList<cls_motor> ListadoMotor(){
        LinkedList<cls_motor> motorList = new LinkedList<>();
        try(Connection conn = DriverManager.getConnection(dbData.getUrl(),dbData.getUser(),dbData.getPassword())){
            String query = "SELECT * FROM tb_motor";
            PreparedStatement statementMotor = conn.prepareStatement(query);
            ResultSet result = statementMotor.executeQuery();
            while (result.next()){
                int motorId = result.getInt(1);
                int cilindraje = result.getInt(2);
                String tipcombustible = result.getString(3);
                String codigomotor = result.getString(4);
                cls_motor listmotor = new cls_motor(motorId,codigomotor, cilindraje, tipcombustible);
                motorList.add(listmotor);
            }
            return motorList;
        }catch (Exception e){
            return motorList;
        }
    }
    
    
    
}
