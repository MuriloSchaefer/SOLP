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
import model.Fornecedor;

/**
 *
 * @author murilo
 */
public class FornecedorDAO {

    private Connection conn = null;
    private Statement stm = null;
    
    public FornecedorDAO() throws ClassNotFoundException{
        try {
            this.conn = new conectaBanco().getConnection();
        } catch (SQLException ex) {
           // Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public int add(Fornecedor fornecedor) throws ClassNotFoundException, NoSuchAlgorithmException, SQLException{
        EnderecoDAO Endconn = new EnderecoDAO();
        List<Integer> ids = new ArrayList<>();
        List<Endereco> enderecos = fornecedor.getListaEndereco();
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
        
        String sql = "INSERT INTO fornecedor(cnpj, razaosocial, nomefantasia, endereco) values('"+fornecedor.getCnpj()+"','"+fornecedor.getRazaoSocial()+"','"+fornecedor.getNomeFantasia()+"','"+end+"') RETURNING id";
        rs = stm.executeQuery(sql);
        rs.next();
        id = rs.getInt("id");
        stm.close();
        return id;
    }
    
    public List<Fornecedor> consultar() throws SQLException{
        List<Fornecedor> lista = new ArrayList<>();
        ResultSet rs = null;
        ResultSet rsEnd;
        String strEnd;
        int n;
        try {
            stm = conn.createStatement();
            String sql = "SELECT * from fornecedor ORDER by nomefantasia";
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(rs.next()){
            Fornecedor aux = new Fornecedor();
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
        return lista;  
    }
    
    public List<Fornecedor> consultar(String nomeFantasia, String razaoSocial) throws SQLException{
        List<Fornecedor> lista = new ArrayList<>();
        ResultSet rs = null;
        ResultSet rsEnd = null;
        PreparedStatement ps;
        String strEnd;
        Object[] test = null;
        int n;
        try {
            stm = conn.createStatement();
            String sql = "SELECT * from fornecedor WHERE nomefantasia like '%"+nomeFantasia+"%' and razaosocial like '%"+razaoSocial+"%' ORDER by nomefantasia";
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(rs.next()){
            Fornecedor aux = new Fornecedor();
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
        return lista;   
    }
    
    public boolean excluir(Fornecedor fornecedor){
        try {
            stm = conn.createStatement();
            String sql = String.format("DELETE FROM fornecedor WHERE id=%s", fornecedor.getId());
            stm.executeUpdate(sql);
            stm.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
