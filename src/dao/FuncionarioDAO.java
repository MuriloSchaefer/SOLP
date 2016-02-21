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
import model.Endereco;
import model.Funcionario;

/**
 *
 * @author murilo
 */
public class FuncionarioDAO {
    private Connection conn = null;
    private Statement stm = null;
    
    /** Método responsável pela criptografia
     *  
     * @param password String contendo a senha a ser criptografada
     * @return Retorna um String com a senha criptografada
     * @throws NoSuchAlgorithmException 
     */
    public static String convertPasswordToMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
 
        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
 
        return String.format("%32x", hash);
    }
    
    /** Método responsável por fechar a conexão com o banco de dados
     * 
     * @throws SQLException 
     */
    public void destroy() throws SQLException{
        conn.close();
    }
    
    /** Método construtor responsável por criar uma nova conexão com o banco de dados
     * 
     * @throws ClassNotFoundException 
     */
    public FuncionarioDAO() throws ClassNotFoundException{
        try {
            this.conn = new conectaBanco().getConnection();
        } catch (SQLException ex) {
           // Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    /** Método responsável pela inserção de um novo Funcionário no banco de dados
     *  Fará também o cadastro de um novo Endereco
     * 
     * @param endereco um objeto do tipo Endereco correspondente ao endereco a ser cadastrado
     * @param funcionario um objeto do tipo Funcionario correspondente ao funcionario a ser inserido
     * @return Retorna um numero inteiro correspondente ao id do funcionário inserido
     * @throws NoSuchAlgorithmException
     * @throws ClassNotFoundException 
     */
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
            //conn.close();
            return id_funcionario;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }    
    /** Método responsável pela inserção de um novo funcionario no banco de dados
     * 
     * @param funcionario um objeto do tipo Funcionario correspondendo ao funcionario a ser inserido
     * @return Retorna um inteiro com o id do funcionario cadastrado
     * @throws NoSuchAlgorithmException
     * @throws ClassNotFoundException 
     */
    public int add(Funcionario funcionario) throws NoSuchAlgorithmException, ClassNotFoundException{
        try {
            ResultSet rs;
            stm = conn.createStatement();
            String sql = String.format("INSERT INTO funcionario(nome, cpf, rg, usuario, senha, permissoes, endereco) values('%s', '%s', '%s', '%s', '%s', %s, %s) RETURNING id", funcionario.getNome(), funcionario.getCpf(), funcionario.getRg(), funcionario.getUsuario(), convertPasswordToMD5(funcionario.getSenha()), funcionario.getPermissoes(), funcionario.getEndereco());
            rs = stm.executeQuery(sql);
            rs.next();
            int id_funcionario = rs.getInt("id");
            stm.close();
            //conn.close();
            return id_funcionario;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }    
    /** Método responsavel pela exclusão de um funcionario
     * 
     * @param funcionario um objeto do tipo Funcionario correspondente ao funcionario a ser excluido
     * @return 
     */
    public boolean excluir(Funcionario funcionario){
        try {
            stm = conn.createStatement();
            String sql = String.format("DELETE FROM funcionario WHERE id=%s", funcionario.getId());
            stm.executeUpdate(sql);
            stm.close();
            //conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /** Método responsável pela consulta a todos os funcionarios cadastrados
     * 
     * @return Retorna uma lista de funcionario contendo todos os funcionarios cadastrados
     * @throws SQLException 
     */
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
        //conn.close();
        return lista;   
    }
    /** Método responsável pela consulta de um funcionario pelo nome do mesmo
     * 
     * @param nome String contendo o nome do funcionario desejado
     * @return Retorna uma lista de funcionarios que contenham o nome desejado
     * @throws SQLException 
     */
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
        //conn.close();
        return lista;   
    }
    /** Método responsável pela consulta de um funcionario pelo usuario e senha
     * 
     * @param usuario String contendo o nome de usuario desejado
     * @param senha String contendo a senha
     * @return Retorna uma lista de funcionarios que contenham aquele login e senha
     * @throws SQLException 
     */
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
        //conn.close();
        return lista;   
    }
}
