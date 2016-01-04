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
import control.controladorMateriaPrima;
import model.MateriaPrima;
import model.MateriaPrimaPorProduto;
import model.Produto;

/**
 *
 * @author murilo
 */
public class ProdutoDAO {
    private Connection conn = null;
    private Statement stm = null;
    
    public ProdutoDAO() throws ClassNotFoundException{
        try {
            this.conn = new conectaBanco().getConnection();
        } catch (SQLException ex) {
           // Logger.getLogger(Funcion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public int add(Produto produto) throws ClassNotFoundException, SQLException{
        MateriaPrimaPorProdutoDAO MateriaPrimaConn = new MateriaPrimaPorProdutoDAO();
        List<MateriaPrimaPorProduto> listaMateriaPrima = produto.getMateriasPrimas();
        ResultSet rs;
        int qntd = listaMateriaPrima.size();
        Integer add;
        String mat = "{";
        for(int i=0; i<qntd; i++){
            add = MateriaPrimaConn.add(listaMateriaPrima.get(i));
            mat += add.toString();
            if(i<qntd-1)
                mat += ", ";
        }
        mat += "}";
        System.out.println(mat);
        stm = conn.createStatement();
        String sql = "INSERT INTO produto(nome, descricao, total, materiasprima) values('"+produto.getNome()+"', '"+produto.getDescricao()+"', '"+produto.getTotal()+"', '"+mat+"') RETURNING id";
        rs = stm.executeQuery(sql);
        rs.next();
        add = rs.getInt("id");
        stm.close();
        return add;
    }
    
    public List<Produto> consultar() throws SQLException, ClassNotFoundException{
        List<Produto> listaProduto = new ArrayList<>();
        ResultSet rs, rsMateriasPrimas;
        int n;
        
        stm = conn.createStatement();
        String sql = "SELECT * FROM produto ORDER BY nome";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            Produto produto = new Produto();
            List<MateriaPrimaPorProduto> listaMateriaPrima = new ArrayList<>();
            List<MateriaPrima> lista = new ArrayList<>();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setTotal(rs.getDouble("total"));
            
            
            String[] split;
            String strMateriasPrimas;
            Statement stmMateriaPrima;
            strMateriasPrimas = rs.getString("materiasprima");
            strMateriasPrimas = strMateriasPrimas.replaceAll("\\{", "");
            strMateriasPrimas = strMateriasPrimas.replaceAll("\\}", "");
            split = strMateriasPrimas.split(",");
            n = split.length;
            for(int i=0; i<n; i++){
                sql = "SELECT * FROM materiaprimaporproduto WHERE id="+split[i];
                stmMateriaPrima = conn.createStatement();
                rsMateriasPrimas = stmMateriaPrima.executeQuery(sql);
                rsMateriasPrimas.next();
                MateriaPrimaPorProduto materiaPrima = new MateriaPrimaPorProduto();
                materiaPrima.setId(rsMateriasPrimas.getInt("id"));
                
                int idMateria = rsMateriasPrimas.getInt("materiaprima");
                lista = controladorMateriaPrima.consultar(idMateria);
                MateriaPrima materia = lista.get(0);
                materiaPrima.setMateriaPrima(materia);
                materiaPrima.setQuantidade(rsMateriasPrimas.getDouble("quantidade"));
                materiaPrima.setTotalAcumulado(rsMateriasPrimas.getDouble("valoracumulado"));
                listaMateriaPrima.add(materiaPrima);
                stmMateriaPrima.close();
            }
            produto.setMateriasPrimas(listaMateriaPrima);
            listaProduto.add(produto);
        }
        stm.close();
        return listaProduto;
    }
    
    public List<Produto> consultar(int id) throws SQLException, ClassNotFoundException{
        List<Produto> listaProduto = new ArrayList<>();
        ResultSet rs, rsMateriasPrimas;
        int n;
        
        stm = conn.createStatement();
        String sql = "SELECT * FROM produto WHERE id="+id+" ORDER BY nome";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            Produto produto = new Produto();
            List<MateriaPrimaPorProduto> listaMateriaPrima = new ArrayList<>();
            List<MateriaPrima> lista = new ArrayList<>();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setTotal(rs.getDouble("total"));
            
            
            String[] split;
            String strMateriasPrimas;
            Statement stmMateriaPrima;
            strMateriasPrimas = rs.getString("materiasprima");
            strMateriasPrimas = strMateriasPrimas.replaceAll("\\{", "");
            strMateriasPrimas = strMateriasPrimas.replaceAll("\\}", "");
            split = strMateriasPrimas.split(",");
            n = split.length;
            for(int i=0; i<n; i++){
                sql = "SELECT * FROM materiaprimaporproduto WHERE id="+split[i];
                stmMateriaPrima = conn.createStatement();
                rsMateriasPrimas = stmMateriaPrima.executeQuery(sql);
                rsMateriasPrimas.next();
                MateriaPrimaPorProduto materiaPrima = new MateriaPrimaPorProduto();
                materiaPrima.setId(rsMateriasPrimas.getInt("id"));
                
                int idMateria = rsMateriasPrimas.getInt("materiaprima");
                lista = controladorMateriaPrima.consultar(idMateria);
                MateriaPrima materia = lista.get(0);
                materiaPrima.setMateriaPrima(materia);
                materiaPrima.setQuantidade(rsMateriasPrimas.getDouble("quantidade"));
                materiaPrima.setTotalAcumulado(rsMateriasPrimas.getDouble("valoracumulado"));
                listaMateriaPrima.add(materiaPrima);
                stmMateriaPrima.close();
            }
            produto.setMateriasPrimas(listaMateriaPrima);
            listaProduto.add(produto);
        }
        stm.close();
        return listaProduto;
    }
    
    public List<Produto> consultar(String nome) throws SQLException, ClassNotFoundException{
        List<Produto> listaProduto = new ArrayList<>();
        ResultSet rs, rsMateriasPrimas;
        int n;
        
        stm = conn.createStatement();
        String sql = "SELECT * FROM produto WHERE nome like '%"+nome+"%' ORDER BY nome";
        rs = stm.executeQuery(sql);
        while(rs.next()){
            Produto produto = new Produto();
            List<MateriaPrimaPorProduto> listaMateriaPrima = new ArrayList<>();
            List<MateriaPrima> lista = new ArrayList<>();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setTotal(rs.getDouble("total"));
            
            
            String[] split;
            String strMateriasPrimas;
            Statement stmMateriaPrima;
            strMateriasPrimas = rs.getString("materiasprima");
            strMateriasPrimas = strMateriasPrimas.replaceAll("\\{", "");
            strMateriasPrimas = strMateriasPrimas.replaceAll("\\}", "");
            split = strMateriasPrimas.split(",");
            n = split.length;
            for(int i=0; i<n; i++){
                sql = "SELECT * FROM materiaprimaporproduto WHERE id="+split[i];
                stmMateriaPrima = conn.createStatement();
                rsMateriasPrimas = stmMateriaPrima.executeQuery(sql);
                rsMateriasPrimas.next();
                MateriaPrimaPorProduto materiaPrima = new MateriaPrimaPorProduto();
                materiaPrima.setId(rsMateriasPrimas.getInt("id"));
                
                int idMateria = rsMateriasPrimas.getInt("materiaprima");
                lista = controladorMateriaPrima.consultar(idMateria);
                MateriaPrima materia = lista.get(0);
                materiaPrima.setMateriaPrima(materia);
                materiaPrima.setQuantidade(rsMateriasPrimas.getDouble("quantidade"));
                materiaPrima.setTotalAcumulado(rsMateriasPrimas.getDouble("valoracumulado"));
                listaMateriaPrima.add(materiaPrima);
                stmMateriaPrima.close();
            }
            produto.setMateriasPrimas(listaMateriaPrima);
            listaProduto.add(produto);
        }
        stm.close();
        return listaProduto;
    }
    
    public boolean excluir(Produto produto) throws SQLException{
        try {
            stm = conn.createStatement();
            String sql = String.format("DELETE FROM produto WHERE id=%s", produto.getId());
            stm.executeUpdate(sql);
            stm.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
