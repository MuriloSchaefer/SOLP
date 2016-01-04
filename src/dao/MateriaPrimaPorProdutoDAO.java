/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.MateriaPrimaPorProduto;

/**
 *
 * @author murilo
 */
public class MateriaPrimaPorProdutoDAO {
    private Connection conn = null;
    private Statement stm = null;
    
    public MateriaPrimaPorProdutoDAO() throws ClassNotFoundException{
        try {
            this.conn = new conectaBanco().getConnection();
        } catch (SQLException ex) {
           // Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public int add(MateriaPrimaPorProduto materiaprima) throws SQLException{
        stm = conn.createStatement();
        ResultSet rs;
        String sql = "INSERT INTO materiaprimaporproduto(materiaprima, quantidade, valoracumulado) values("+materiaprima.getMateriaPrima().getId()+", "+materiaprima.getQuantidade()+", "+materiaprima.getTotalAcumulado()+") RETURNING id";
        System.out.println(sql);
        rs = stm.executeQuery(sql);
        rs.next();
        int id = rs.getInt("id");
        stm.close();
        return id;
    }
}
