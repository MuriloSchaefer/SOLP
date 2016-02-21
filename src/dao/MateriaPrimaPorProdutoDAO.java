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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MateriaPrimaPorProduto;

/**
 *
 * @author murilo
 */
public class MateriaPrimaPorProdutoDAO {
    private Connection conn = null;
    private Statement stm = null;
    
    /** Método contrutor reponsável por criar uma nova conexão com o banco de dados
     * 
     * @throws ClassNotFoundException 
     */
    public MateriaPrimaPorProdutoDAO() throws ClassNotFoundException{
        try {
            this.conn = new conectaBanco().getConnection();
        } catch (SQLException ex) {
           // Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /** Método responsável por fechar a conexão com o banco de dados
     * 
     * @throws SQLException 
     */
    public void destroy() throws SQLException{
        conn.close();
    }
    
    /** Método responsável pela inserção de uma nova matéria prima no banco de dados
     * 
     * @param materiaprima objeto do tipo MateriaPrima correspondente a matéria prima a ser inserida
     * @return Retorna um inteiro equivalente ao id da matéria prima inserida
     * @throws SQLException 
     */
    public int add(MateriaPrimaPorProduto materiaprima) throws SQLException{
        stm = conn.createStatement();
        ResultSet rs;
        String sql = "INSERT INTO materiaprimaporproduto(materiaprima, quantidade, valoracumulado) values("+materiaprima.getMateriaPrima().getId()+", "+materiaprima.getQuantidade()+", "+materiaprima.getTotalAcumulado()+") RETURNING id";
        System.out.println(sql);
        rs = stm.executeQuery(sql);
        rs.next();
        int id = rs.getInt("id");
        stm.close();
        //conn.close();
        return id;
    }
    
    
    /** Método responsável pela exclusão de uma matéria prima
     * 
     * @param materia um objeto do tipo MateriaPrima correspondente a matéria prima a ser excluida
     * @return Retorna true em caso de sucesso e false em caso defalha
     */
    public boolean excluir(MateriaPrimaPorProduto materia){
        try {
            stm = conn.createStatement();
            String sql = String.format("DELETE FROM materiaprimaporproduto WHERE id=%s", materia.getId());
            stm.executeUpdate(sql);
            stm.close();
            //conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MateriaPrimaPorProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
