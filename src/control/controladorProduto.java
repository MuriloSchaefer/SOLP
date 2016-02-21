/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ProdutoDAO;
import dao.MateriaPrimaPorProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import model.Produto;
import model.MateriaPrimaPorProduto;

/**
 *
 * @author murilo
 */
public class controladorProduto {
    
    /** Método para inserção de um novo produto no banco de dados
     * 
     * @param produto um objeto do tipo Produto a ser inserido no banco de dados
     * @return Retorna true em caso de sucesso e false em caso de falha
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static boolean add(Produto produto) throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        int id;
        id = conn.add(produto);
        conn.destroy();
        return id >= 0;
    }
    
    /** Método responsável pela consulta de todos os produtos cadastrados
     * 
     * @return Retorna uma lista de produtos contendo todos os produtos cadastrados
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<Produto> consultar() throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        List<Produto> lista = conn.consultar();
        conn.destroy();
        return lista;
    }
    
    /** Método responsável pela consulta de um produto buscando seu id
     * 
     * @param id um numero inteiro correspondendo ao id do produto desejado
     * @return Retorna uma lista de produtos que contenham aquele id
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<Produto> consultar(int id) throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        List<Produto> lista = conn.consultar(id);
        conn.destroy();
        return lista;
    }
    
    /** Método responsável pela consulta de um produto buscando-o pelo nome
     * 
     * @param nome uma String contendo o nome do produto desejado
     * @return Retorna uma lista de produtos que conhenham o nome desejado
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<Produto> consultar(String nome) throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        List<Produto> lista = conn.consultar(nome);
        conn.destroy();
        return lista;
    }
    
    /** Método responsável pela exclusão de um produto do banco de dados
     * 
     * @param produto um objeto do tipo Produto a ser excluido
     * @return Retorna true em caso de sucesso e false em caso de falha
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static boolean excluir(Produto produto) throws ClassNotFoundException, SQLException{
        ProdutoDAO conn = new ProdutoDAO();
        MateriaPrimaPorProdutoDAO MateriaPrimaConn = new MateriaPrimaPorProdutoDAO();
        List<MateriaPrimaPorProduto> listaMaterias = produto.getMateriasPrimas();
        int n = listaMaterias.size();
        for(int i=0;i<n;i++){
            MateriaPrimaConn.excluir(listaMaterias.get(i));
        }
        boolean excluir = conn.excluir(produto);
        conn.destroy();
        return excluir;
    }
}
