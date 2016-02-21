/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
import model.Cliente;

/**
 *
 * @author murilo
 */
public class ClienteDAO {

    private Connection conn = null;
    private Statement stm = null;
    
    /** Método contrutor da classe (Responsável por criar uma conexão com o banco)
     * 
     * @throws ClassNotFoundException 
     */
    public ClienteDAO() throws ClassNotFoundException{
        try {
            this.conn = new conectaBanco().getConnection();
        } catch (SQLException ex) {
           // Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /** Método responsável por fechar a conexão com o banco
     * 
     * @throws SQLException 
     */
    public void destroy() throws SQLException{
        conn.close();
    }
    
    /** Método responsável pela inserção de um novo  cliente no banco de dados
     *  fará também a inserção de todos os enderecos relacionados com o cliente
     * 
     * @param cliente um objeto do tipo Cliente a ser inserido
     * @return Retorna um inteiro correspondente ao id do cliente cadastrado
     * @throws ClassNotFoundException
     * @throws NoSuchAlgorithmException
     * @throws SQLException 
     */
    public int add(Cliente cliente) throws ClassNotFoundException, NoSuchAlgorithmException, SQLException{
        EnderecoDAO Endconn = new EnderecoDAO();
        List<Integer> ids = new ArrayList<>();
        List<Endereco> enderecos = cliente.getListaEndereco();
        int n = enderecos.size();
        int aux;
        int id;
        ResultSet rs;
        for(int i=0; i< n; i++){
            aux = Endconn.add(enderecos.get(i));
            ids.add(aux);
        }
        
        stm = conn.createStatement();
        String end = "{";
        for(int i=0;i<n;i++){
            end += ids.get(i).toString();
            if(i<n-1)
                end += ",";
        }
        end += "}";
        
        String sql = "INSERT INTO cliente(cnpj, razaosocial, nomefantasia, endereco) values('"+cliente.getCnpj()+"','"+cliente.getRazaoSocial()+"','"+cliente.getNomeFantasia()+"','"+end+"') RETURNING id";
        rs = stm.executeQuery(sql);
        rs.next();
        id = rs.getInt("id");
        stm.close();
        //conn.close();
        return id;
    }
    
    /** Método responsável pela consulta de todos os clientes no banco
     * 
     * @return Retorna uma lista de clientes contendo todos os clientes cadastrados
     * @throws SQLException 
     */
    public List<Cliente> consultar() throws SQLException{
        List<Cliente> lista = new ArrayList<>();
        ResultSet rs = null;
        ResultSet rsEnd;
        String strEnd;
        int n;
        try {
            stm = conn.createStatement();
            String sql = "SELECT * from cliente ORDER by nomefantasia";
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(rs.next()){
            Cliente aux = new Cliente();
            List<Endereco> EndAux = new ArrayList<>();
            String[] split;
            aux.setId(rs.getInt("id"));
            aux.setCnpj(rs.getString("cnpj"));
            aux.setRazaoSocial(rs.getString("razaosocial"));
            aux.setNomeFantasia(rs.getString("nomefantasia"));
            strEnd = rs.getString("endereco");
            strEnd = strEnd.replaceAll("\\{", "");
            strEnd = strEnd.replaceAll("\\}", "");
            split = strEnd.split(",");
            n = split.length;
            for(int i=0; i<n; i++){
                try (Statement stmEnd = conn.createStatement()) {
                    String sql = "SELECT * from endereco WHERE id = "+split[i];
                    rsEnd = stmEnd.executeQuery(sql);
                    rsEnd.next();
                    Endereco end = new Endereco();
                    end.setId(rsEnd.getInt("id"));
                    end.setRua(rsEnd.getString("rua"));
                    end.setNum(rsEnd.getInt("num"));
                    end.setBairro(rsEnd.getString("bairro"));
                    end.setCidade(rsEnd.getString("cidade"));
                    end.setEstado(rsEnd.getString("estado"));
                    EndAux.add(end);
                    stmEnd.close();
                }
            }
            aux.setListaEndereco(EndAux);
            lista.add(aux);
        }
        stm.close();
        //conn.close();
        return lista;  
    }
    
    /** Método responsável pela consulta de um cliente pelo seu nome fantasia e razão social
     * 
     * @param nomeFantasia uma String contendo o nome fantasia do cliente desejado
     * @param razaoSocial uma String contendo a razao social do cliente desejado
     * @return Retorna uma lista de clientes que contenham o nome fantasia e razão social desejados
     * @throws SQLException 
     */
    public List<Cliente> consultar(String nomeFantasia, String razaoSocial) throws SQLException{
        List<Cliente> lista = new ArrayList<>();
        ResultSet rs = null;
        ResultSet rsEnd = null;
        PreparedStatement ps;
        String strEnd;
        Object[] test = null;
        int n;
        try {
            stm = conn.createStatement();
            String sql = "SELECT * from cliente WHERE nomefantasia like '%"+nomeFantasia+"%' and razaosocial like '%"+razaoSocial+"%' ORDER by nomefantasia";
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(rs.next()){
            Cliente aux = new Cliente();
            List<Endereco> EndAux = new ArrayList<>();
            String[] split;
            aux.setId(rs.getInt("id"));
            aux.setCnpj(rs.getString("cnpj"));
            aux.setRazaoSocial(rs.getString("razaosocial"));
            aux.setNomeFantasia(rs.getString("nomefantasia"));
            strEnd = rs.getString("endereco");
            strEnd = strEnd.replaceAll("\\{", "");
            strEnd = strEnd.replaceAll("\\}", "");
            split = strEnd.split(",");
            n = split.length;
            for(int i=0; i<n; i++){
                try (Statement stmEnd = conn.createStatement()) {
                    String sql = "SELECT * from endereco WHERE id = "+split[i];
                    rsEnd = stmEnd.executeQuery(sql);
                    rsEnd.next();
                    Endereco end = new Endereco();
                    end.setId(rsEnd.getInt("id"));
                    end.setRua(rsEnd.getString("rua"));
                    end.setNum(rsEnd.getInt("num"));
                    end.setBairro(rsEnd.getString("bairro"));
                    end.setCidade(rsEnd.getString("cidade"));
                    end.setEstado(rsEnd.getString("estado"));
                    EndAux.add(end);
                    stmEnd.close();
                }
            }
            aux.setListaEndereco(EndAux);
            lista.add(aux);
        }
        stm.close();
        //conn.close();
        return lista;   
    }
    
    /** Método resposável pela exclusão de um cliente do banco de dados
     * 
     * @param cliente um objeto do tipo Cliente correspondente ao cliente que se deseja excluir
     * @return Retorna true em caso de sucesso e false em caso de falha
     */
    public boolean excluir(Cliente cliente){
        try {
            stm = conn.createStatement();
            String sql = String.format("DELETE FROM cliente WHERE id=%s", cliente.getId());
            stm.executeUpdate(sql);
            stm.close();
            //conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
