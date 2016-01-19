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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.Fornecedor;
import model.MateriaPrima;

/**
 *
 * @author murilo
 */
public class materiaPrimaDAO {
    private Connection conn = null;
    private Statement stm = null;
    
    public materiaPrimaDAO() throws ClassNotFoundException{
        try {
            this.conn = new conectaBanco().getConnection();
        } catch (SQLException ex) {
           // Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void destroy() throws SQLException{
        conn.close();
    }
    
    public int add(MateriaPrima materiaPrima) throws SQLException{
        ResultSet rs;
        stm = conn.createStatement();
        String sql = "INSERT INTO materiaprima(fornecedor, nome, descricao, und, valorund) values("+materiaPrima.getFornecedor().getId()+", '"+materiaPrima.getNome()+"', '"+materiaPrima.getDescricao()+"', '"+materiaPrima.getUnd()+"', "+materiaPrima.getValorUnd()+") RETURNING id";
        rs = stm.executeQuery(sql);
        rs.next();
        int id = rs.getInt("id");
        stm.close();
        //conn.close();
        return id;
    }
    
    public List<MateriaPrima> consultar() throws SQLException{
        List<MateriaPrima> lista = new ArrayList<>();
        ResultSet rs, rsFornecedor;
        stm = conn.createStatement();
        int idFornecedor;
        Statement stmFornecedor = conn.createStatement();
        String sql = "SELECT * FROM materiaprima ORDER BY nome";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            MateriaPrima aux = new MateriaPrima();
            Fornecedor FornecedorAux = new Fornecedor();
            List<Endereco> EndAux = new ArrayList<>();
            String[] split;
            ResultSet rsEnd;
            
            aux.setId(rs.getInt("id"));
            aux.setNome(rs.getString("nome"));
            aux.setDescricao(rs.getString("descricao"));
            aux.setUnd(rs.getString("und"));
            aux.setValorUnd(rs.getDouble("valorund"));
            
            idFornecedor = rs.getInt("fornecedor");
            sql = "SELECT * FROM fornecedor WHERE id="+idFornecedor;
            rsFornecedor = stmFornecedor.executeQuery(sql);
            rsFornecedor.next();
            FornecedorAux.setId(rsFornecedor.getInt("id"));
            FornecedorAux.setCnpj(rsFornecedor.getString("cnpj"));
            FornecedorAux.setNomeFantasia(rsFornecedor.getString("nomefantasia"));
            FornecedorAux.setRazaoSocial(rsFornecedor.getString("razaosocial"));
            
            String strEnd = rsFornecedor.getString("endereco");
            strEnd = strEnd.replaceAll("\\{", "");
            strEnd = strEnd.replaceAll("\\}", "");
            split = strEnd.split(",");
            int n = split.length;
            for(int i=0; i<n; i++){
                try (Statement stmEnd = conn.createStatement()) {
                    sql = "SELECT * from endereco WHERE id = "+split[i];
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
            FornecedorAux.setListaEndereco(EndAux);
            aux.setFornecedor(FornecedorAux);
            lista.add(aux);
        }
        stmFornecedor.close();
        stm.close();
        //conn.close();
        return lista;
    }    
    
    public List<MateriaPrima> consultar(int id, int fornecedor) throws SQLException{
        List<MateriaPrima> lista = new ArrayList<>();
        ResultSet rs, rsFornecedor;
        stm = conn.createStatement();
        int idFornecedor;
        Statement stmFornecedor = conn.createStatement();
        String sql = "SELECT * FROM materiaprima WHERE fornecedor="+fornecedor;
        rs = stm.executeQuery(sql);
        while(rs.next()){
            MateriaPrima aux = new MateriaPrima();
            Fornecedor FornecedorAux = new Fornecedor();
            List<Endereco> EndAux = new ArrayList<>();
            String[] split;
            ResultSet rsEnd;
            
            aux.setId(rs.getInt("id"));
            aux.setNome(rs.getString("nome"));
            aux.setDescricao(rs.getString("descricao"));
            aux.setUnd(rs.getString("und"));
            aux.setValorUnd(rs.getDouble("valorund"));
            
            idFornecedor = rs.getInt("fornecedor");
            sql = "SELECT * FROM fornecedor WHERE id="+idFornecedor;
            rsFornecedor = stmFornecedor.executeQuery(sql);
            rsFornecedor.next();
            FornecedorAux.setId(rsFornecedor.getInt("id"));
            FornecedorAux.setCnpj(rsFornecedor.getString("cnpj"));
            FornecedorAux.setNomeFantasia(rsFornecedor.getString("nomefantasia"));
            FornecedorAux.setRazaoSocial(rsFornecedor.getString("razaosocial"));
            
            String strEnd = rsFornecedor.getString("endereco");
            strEnd = strEnd.replaceAll("\\{", "");
            strEnd = strEnd.replaceAll("\\}", "");
            split = strEnd.split(",");
            int n = split.length;
            for(int i=0; i<n; i++){
                try (Statement stmEnd = conn.createStatement()) {
                    sql = "SELECT * from endereco WHERE id = "+split[i];
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
            FornecedorAux.setListaEndereco(EndAux);
            aux.setFornecedor(FornecedorAux);
            lista.add(aux);
        }
        stmFornecedor.close();
        stm.close();
        //conn.close();
        return lista;
    } 
    
    public List<MateriaPrima> consultar(int id) throws SQLException{
        List<MateriaPrima> lista = new ArrayList<>();
        ResultSet rs, rsFornecedor;
        stm = conn.createStatement();
        int idFornecedor;
        Statement stmFornecedor = conn.createStatement();
        String sql = "SELECT * FROM materiaprima WHERE id="+id;
        rs = stm.executeQuery(sql);
        while(rs.next()){
            MateriaPrima aux = new MateriaPrima();
            Fornecedor FornecedorAux = new Fornecedor();
            List<Endereco> EndAux = new ArrayList<>();
            String[] split;
            ResultSet rsEnd;
            
            aux.setId(rs.getInt("id"));
            aux.setNome(rs.getString("nome"));
            aux.setDescricao(rs.getString("descricao"));
            aux.setUnd(rs.getString("und"));
            aux.setValorUnd(rs.getDouble("valorund"));
            
            idFornecedor = rs.getInt("fornecedor");
            sql = "SELECT * FROM fornecedor WHERE id="+idFornecedor;
            rsFornecedor = stmFornecedor.executeQuery(sql);
            rsFornecedor.next();
            FornecedorAux.setId(rsFornecedor.getInt("id"));
            FornecedorAux.setCnpj(rsFornecedor.getString("cnpj"));
            FornecedorAux.setNomeFantasia(rsFornecedor.getString("nomefantasia"));
            FornecedorAux.setRazaoSocial(rsFornecedor.getString("razaosocial"));
            
            String strEnd = rsFornecedor.getString("endereco");
            strEnd = strEnd.replaceAll("\\{", "");
            strEnd = strEnd.replaceAll("\\}", "");
            split = strEnd.split(",");
            int n = split.length;
            for(int i=0; i<n; i++){
                try (Statement stmEnd = conn.createStatement()) {
                    sql = "SELECT * from endereco WHERE id = "+split[i];
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
            FornecedorAux.setListaEndereco(EndAux);
            aux.setFornecedor(FornecedorAux);
            lista.add(aux);
        }
        stmFornecedor.close();
        stm.close();
        //conn.close();
        return lista;
    } 
    
    
    public List<MateriaPrima> consultar(String nome) throws SQLException{
        List<MateriaPrima> lista = new ArrayList<>();
        ResultSet rs, rsFornecedor;
        stm = conn.createStatement();
        int idFornecedor;
        Statement stmFornecedor = conn.createStatement();
        String sql = "SELECT * FROM materiaprima WHERE nome like '%"+nome+"%' ORDER BY nome";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            MateriaPrima aux = new MateriaPrima();
            Fornecedor FornecedorAux = new Fornecedor();
            List<Endereco> EndAux = new ArrayList<>();
            String[] split;
            ResultSet rsEnd;
            
            aux.setId(rs.getInt("id"));
            aux.setNome(rs.getString("nome"));
            aux.setDescricao(rs.getString("descricao"));
            aux.setUnd(rs.getString("und"));
            aux.setValorUnd(rs.getDouble("valorund"));
            
            idFornecedor = rs.getInt("fornecedor");
            sql = "SELECT * FROM fornecedor WHERE id="+idFornecedor;
            rsFornecedor = stmFornecedor.executeQuery(sql);
            rsFornecedor.next();
            FornecedorAux.setId(rsFornecedor.getInt("id"));
            FornecedorAux.setCnpj(rsFornecedor.getString("cnpj"));
            FornecedorAux.setNomeFantasia(rsFornecedor.getString("nomefantasia"));
            FornecedorAux.setRazaoSocial(rsFornecedor.getString("razaosocial"));
            
            String strEnd = rsFornecedor.getString("endereco");
            strEnd = strEnd.replaceAll("\\{", "");
            strEnd = strEnd.replaceAll("\\}", "");
            split = strEnd.split(",");
            int n = split.length;
            for(int i=0; i<n; i++){
                try (Statement stmEnd = conn.createStatement()) {
                    sql = "SELECT * from endereco WHERE id = "+split[i];
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
            FornecedorAux.setListaEndereco(EndAux);
            aux.setFornecedor(FornecedorAux);
            lista.add(aux);
        }
        stmFornecedor.close();
        stm.close();
        //conn.close();
        return lista;
    } 
    
    public boolean excluir(MateriaPrima materiaPrima) throws SQLException{
        try {
            stm = conn.createStatement();
            String sql = String.format("DELETE FROM materiaprima WHERE id=%s", materiaPrima.getId());
            stm.executeUpdate(sql);
            stm.close();
            //conn.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
