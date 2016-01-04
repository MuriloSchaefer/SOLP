/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solp.control;

import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import solp.model.Produto;

/**
 *
 * @author murilo
 */
public class controladorProduto {
    
    public static boolean add(Produto produto) throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        int id;
        id = conn.add(produto);
        return id >= 0;
    }
    
    public static List<Produto> consultar() throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        List<Produto> lista = conn.consultar();
        return lista;
    }
    
    
    public static List<Produto> consultar(int id) throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        List<Produto> lista = conn.consultar(id);
        return lista;
    }
    
    public static List<Produto> consultar(String nome) throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        List<Produto> lista = conn.consultar(nome);
        return lista;
    }
    
    public static boolean excluir(Produto produto) throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        return conn.excluir(produto);
    }
}
