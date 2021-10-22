/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import clases.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Marce
 */
public class modelo_carro {

    model_db dbData;

    public modelo_carro() {
        this.dbData = new model_db();
    }

    public boolean crearcarro(cls_carro carro) {
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "INSERT INTO tb_automotor(num_cambios, num_ruedas,anio_fabricacion, color,id_motor) VALUES (?,?,?,?,?)";
            /*inserta datos */
            PreparedStatement statement_carro = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement_carro.setString(1, carro.getNum_cambios());
            statement_carro.setString(2, carro.getNum_ruedas());
            statement_carro.setString(3, carro.getAnnio_fabricacion());
            statement_carro.setString(4, carro.getColor());
            statement_carro.setInt(5, carro.getId_motor());
            int rowInserted = statement_carro.executeUpdate();
            if (rowInserted > 0) {
                ResultSet generatedKeys = statement_carro.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id_automotor = generatedKeys.getInt(1);
                    String query1 = "INSERT INTO tb_carro (modelo, tipo_rines, id_automotor) VALUES (?,?,?)";
                    /*inserta datos */
                    PreparedStatement statement_carro1 = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
                    statement_carro1.setString(1, carro.getModelo());
                    statement_carro1.setString(2, carro.getTipo_rines());
                    statement_carro1.setInt(3, id_automotor);
                    int rowInserted1 = statement_carro1.executeUpdate();
                    if (rowInserted1 > 0) {
                        return true;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public cls_carro buscarcarro(String modelo) {
        cls_carro carroconsulta = null;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_carro WHERE modelo = ?";
            /*inserta datos */
            PreparedStatement statement_carro = conn.prepareStatement(query);
            statement_carro.setString(1, modelo);
            ResultSet result = statement_carro.executeQuery();
            System.out.println("try modelo buscar carro");
            while (result.next()) {
                String carroId = result.getString(1);
                String tipo_rines = result.getString(3);
                int id_automotor = result.getInt(4);
                String query1 = "SELECT * FROM tb_automotor WHERE id = ?";
                /*inserta datos */
                PreparedStatement statement_automotor = conn.prepareStatement(query1);
                statement_automotor.setInt(1, id_automotor);
                ResultSet result1 = statement_automotor.executeQuery();
                while (result1.next()) {
                    String num_cambios = result1.getString(2);
                    String num_ruedas = result1.getString(3);
                    String anio_fab = result1.getString(4);
                    String color = result1.getString(5);
                    int id_motor = result1.getInt(6);
                    carroconsulta = new cls_carro(false, modelo, tipo_rines, num_cambios, num_ruedas, anio_fab, color, id_motor);
                }

            }
            System.out.println(carroconsulta.toString());
            conn.close();
            /*System.out.println(R.get(0)+" - "+ R.get(1) + " - " + R.get(2)  );*/
            return carroconsulta;
        } catch (Exception e) {
            System.out.println("entro al catch en el modelo buscar" + e);
            return carroconsulta;
        }
    }

    public boolean actualizarcarro(cls_carro carro) {
        boolean M = false;
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {

            String query1 = "UPDATE tb_carro SET tipo_rines=? WHERE modelo=?";
            /*inserta datos */
            PreparedStatement statement_carro1 = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
            statement_carro1.setString(1, carro.getTipo_rines());
            statement_carro1.setString(2, carro.getModelo());
            int rowInserted1 = statement_carro1.executeUpdate();
            System.out.println(rowInserted1+"   rowss ");
            if (rowInserted1 > 0) {
                String query2 = "SELECT * FROM tb_carro WHERE modelo = ?";
                PreparedStatement statement_carro2 = conn.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
                statement_carro2.setString(1, carro.getModelo());
                int rowInserted2 = statement_carro2.executeUpdate();
                System.out.println(rowInserted2+"   rowss2 ");
                if (rowInserted2 > 0) {
                    ResultSet generatedKeys2 = statement_carro2.getGeneratedKeys();
                    int id_automotor = generatedKeys2.getInt(1);
                    System.out.println(id_automotor+"  ID");
                    if (generatedKeys2.next()) {
                        
                        String query = "UPDATE tb_automotor SET num_cambios=?, num_ruedas=?,anio_fabricacion=?, color=?,id_motor=? WHERE id=?";
                        /*inserta datos */
                        PreparedStatement statement_carro = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                        statement_carro.setString(1, carro.getNum_cambios());
                        statement_carro.setString(2, carro.getNum_ruedas());
                        statement_carro.setString(3, carro.getAnnio_fabricacion());
                        statement_carro.setString(4, carro.getColor());
                        statement_carro.setInt(5, carro.getId_motor());
                        statement_carro.setInt(6, id_automotor);
                        int rowInserted = statement_carro.executeUpdate();
                        if (rowInserted > 0) {
                            return true;
                        }
                    }
                }
            }

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
                statement_DELETEmotor.execute();

            }
            return motorconsulta;
        } catch (Exception e) {
            System.out.println("entro al catch en el modelo ELIMINAR  " + e);
            return motorconsulta;
        }
    }

    public boolean eliminarmotor(String codigo) {
        boolean result1 = true;
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

    public LinkedList<cls_motor> ListadoMotor() {
        LinkedList<cls_motor> motorList = new LinkedList<>();
        try (Connection conn = DriverManager.getConnection(dbData.getUrl(), dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_motor";
            PreparedStatement statementMotor = conn.prepareStatement(query);
            ResultSet result = statementMotor.executeQuery();
            while (result.next()) {
                int motorId = result.getInt(1);
                int cilindraje = result.getInt(2);
                String tipcombustible = result.getString(3);
                String codigomotor = result.getString(4);
                cls_motor listmotor = new cls_motor(motorId, codigomotor, cilindraje, tipcombustible);
                motorList.add(listmotor);
            }
            return motorList;
        } catch (Exception e) {
            return motorList;
        }
    }

}
