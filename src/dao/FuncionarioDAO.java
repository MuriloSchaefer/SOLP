/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import solp.model.Endereco;
import solp.model.Funcionario;

/**
 *
 * @author murilo
 */
public class FuncionarioDAO {
    private Connection conn = null;
    private Statement stm = null;
    
    public static String convertPasswordToMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
 
        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
 
        return String.format("%32x", hash);
    }
    
    
    public FuncionarioDAO() throws ClassNotFoundException{
        try {
            this.conn = new conectaBanco().getConnection();
        } catch (SQLException ex) {
           // Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public int add(Endereco endereco, Funcionario funcionario) throws NoSuchAlgorithmException, ClassNotFoundException{
        try {
            ResultSet rs;
            EnderecoDAO end = new EnderecoDAO();
            int id_endereco = end.add(endereco);
            
            stm = conn.createStatement();
            String sql = String.format("INSERT INTO funcionario(nome, cpf, rg, usuario, senha, permissoes, endereco) values('%s', '%s', '%s', '%s', '%s', %s, %s) RETURNING id", funcionario.getNome(), funcionario.getCpf(), funcionario.getRg(), funcionario.getUsuario(), convertPasswordToMD5(funcionario.getSenha()), funcionario.getPermissoes(), id_endereco);
            rs = stm.executeQuery(sql);
            rs.next();
            int id_funcionario = rs.getInt("id");
            stm.close();
            return id_funcionario;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }    
    public int add(Funcionario funcionario) throws NoSuchAlgorithmException, ClassNotFoundException{
        try {
            ResultSet rs;
            stm = conn.createStatement();
            String sql = String.format("INSERT INTO funcionario(nome, cpf, rg, usuario, senha, permissoes, endereco) values('%s', '%s', '%s', '%s', '%s', %s, %s) RETURNING id", funcionario.getNome(), funcionario.getCpf(), funcionario.getRg(), funcionario.getUsuario(), convertPasswordToMD5(funcionario.getSenha()), funcionario.getPermissoes(), funcionario.getEndereco());
            rs = stm.executeQuery(sql);
            rs.next();
            int id_funcionario = rs.getInt("id");
            stm.close();
            return id_funcionario;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }    
    public boolean excluir(Funcionario funcionario){
        try {
            stm = conn.createStatement();
            String sql = String.format("DELETE FROM funcionario WHERE id=%s", funcionario.getId());
            stm.executeUpdate(sql);
            stm.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public List<Funcionario> consultar() throws SQLException{
        List<Funcionario> lista = new ArrayList<>();
        ResultSet rs = null;
        
        try {
            stm = conn.createStatement();
            String sql = String.format("SELECT * from funcionario ORDER BY nome");
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            Funcionario aux = new Funcionario();
            aux.setId(rs.getInt("id"));
            aux.setNome(rs.getString("nome"));
            aux.setCpf(rs.getString("cpf"));
            aux.setRg(rs.getString("rg"));
            aux.setUsuario(rs.getString("usuario"));
            aux.setSenha(rs.getString("senha"));
            aux.setPermissoes(rs.getInt("permissoes"));
            
            lista.add(aux);
        }
        
        stm.close();
        return lista;   
    }
    public List<Funcionario> consultar(String nome) throws SQLException{
        List<Funcionario> lista = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement ps;
        try {
            stm = conn.createStatement();
            String sql = "SELECT * from funcionario WHERE nome like '%"+nome+"%'";
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(rs.next()){
            Funcionario aux = new Funcionario();
            aux.setId(rs.getInt("id"));
            aux.setNome(rs.getString("nome"));
            aux.setCpf(rs.getString("cpf"));
            aux.setRg(rs.getString("rg"));
            aux.setUsuario(rs.getString("usuario"));
            aux.setSenha(rs.getString("senha"));
            aux.setPermissoes(rs.getInt("permissoes"));
            
            lista.add(aux);
        }
        stm.close();
        return lista;   
    }
    
    public List<Funcionario> consultar(String usuario, String senha) throws SQLException{
        List<Funcionario> lista = new ArrayList<>();
        ResultSet rs = null;
        
        try {
            stm = conn.createStatement();
            String sql = String.format("SELECT * from funcionario WHERE usuario='%s' AND senha= '%s'", usuario, senha);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(rs.next()){
            Funcionario aux = new Funcionario();
            aux.setId(rs.getInt("id"));
            aux.setNome(rs.getString("nome"));
            aux.setCpf(rs.getString("cpf"));
            aux.setRg(rs.getString("rg"));
            aux.setUsuario(rs.getString("usuario"));
            aux.setSenha(rs.getString("senha"));
            aux.setPermissoes(rs.getInt("permissoes"));
            lista.add(aux);
        }
        
        stm.close();
        return lista;   
    }
}
