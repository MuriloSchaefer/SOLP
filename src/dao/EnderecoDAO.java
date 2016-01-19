/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
    
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
/**
 *
 * @author murilo
 */
public class EnderecoDAO {
    private Connection conn = null;
    private Statement stm = null;
    
    public EnderecoDAO() throws ClassNotFoundException{ //método construtor, cria uma nova conexão com o banco
        try {
            this.conn = new conectaBanco().getConnection(); //responsavel pela conexão no banco
        } catch (SQLException ex) {
           // Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void destroy() throws SQLException{
        conn.close();
    }
    //Inserção de um novo endereco no banco
    public int add(Endereco endereco) throws NoSuchAlgorithmException{
        try {
            ResultSet rs; //retorno do sql
            stm = conn.createStatement(); //cria um statement;
            String sql = String.format("INSERT INTO endereco(rua, num, bairro, cidade, estado) values('%s', %s, '%s', '%s', '%s') RETURNING id", endereco.getRua(), endereco.getNum(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado()); //sql de busca
            rs = stm.executeQuery(sql); // executa sql e salva retorno em rs
            rs.next(); //avança o ponteiro de rs, é sempre necessário fazer isto
            int id_endereco = rs.getInt("id"); //pega o id retornado pelo sql
            stm.close(); //fecha o statement
            ;
            return id_endereco;//retorna o id
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1; //retorna -1 em caso de erro
        }
    }  
    //Consulta sem parametros, retorna todos os elementos do banco
    public List<Endereco> consultar() throws SQLException{
        List<Endereco> lista = new ArrayList<>(); //cria uma lista de endereco
        ResultSet rs = null; //retorno do sql
        
        try {
            stm = conn.createStatement(); //cria um statement
            String sql = String.format("SELECT * from endereco ORDER BY rua"); //sql de busca
            rs = stm.executeQuery(sql); //executa sql
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //le rs (retorno do sql) e cria os objetos conforme resultados da consulta
        while(rs.next()){ // enquanto houver um proximo valor em rs
            Endereco aux = new Endereco(); // cria um endereco auxiliar
            aux.setId(rs.getInt("id")); //atribui os valores ao endereco
            aux.setRua(rs.getString("rua"));
            aux.setNum(rs.getInt("num"));
            aux.setBairro(rs.getString("bairro"));
            aux.setCidade(rs.getString("cidade"));
            aux.setEstado(rs.getString("estado"));
            
            lista.add(aux); //adiciona o endereco a lista de enderecos
        }
        stm.close(); //fecha o statement
        ;
        return lista;   // retorna a lista
    } 
    
    public boolean excluir(Endereco endereco) throws SQLException{
        try {
            stm = conn.createStatement();
            String sql = String.format("DELETE FROM endereco WHERE id=%s", endereco.getId());
            stm.executeUpdate(sql);
            stm.close();
            ;
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
