/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author murilo
 */
import javax.swing.JOptionPane;

//NÃO MEXER!
public class conectaBanco {
    
    static String url = "jdbc:postgresql://localhost:5432/solp";
    static String username = "postgres";
    static String password = "admin";
    
    /** Método responsável por criar uma nova conexão com o banco de dados
     * 
     * @return Retorna a conexão criada
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public Connection getConnection() throws SQLException, ClassNotFoundException{
         
        Connection conn = null;
         
         try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
            //JOptionPane.showMessageDialog(null, "Connection Succeded!"); 
         } catch (SQLException error){
             JOptionPane.showMessageDialog(null, "Erro ao tentar conectar com o banco de dados");
         }
         
         return conn;         
    }
}
