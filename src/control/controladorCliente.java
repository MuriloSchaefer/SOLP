/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ClienteDAO;
import dao.EnderecoDAO;
import dao.ClienteDAO;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;
import model.Endereco;

/**
 *
 * @author Mateus
 */
public class controladorCliente {

    /** Método contrutor */
    public controladorCliente() {
    }
    
    /** Método para a inserção de um novo cliente no banco de dados
     * 
     * 
     * @param cliente - Um objeto do tipo Cliente que será inserido no banco
     * @return - True caso o cadastro tenha ocorrido com sucesso e False em caso de falha
     * @throws ClassNotFoundException
     * @throws NoSuchAlgorithmException
     * @throws SQLException 
     */
    public static boolean add(Cliente cliente) throws ClassNotFoundException, NoSuchAlgorithmException, SQLException{
     ClienteDAO con = new ClienteDAO();
     int add = con.add(cliente);
     con.destroy();
     return add >=0;
    }
    
    
    /** Método para a consulta de um Cliente pelo nome fantasia e / ou razão social
     * Caso os dois parametros não forem nulos o retorno será a interseção entre as 2 pesquisas
     * 
     * @param nomeFantasia - String contendo o nome fantasia do cliente
     * @param razaoSocial - String contendo a razão social do cliente
     * @return Lista de Clientes que contenham aquele nome fantasia e / ou razão social
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<Cliente> consultar(String nomeFantasia, String razaoSocial) throws ClassNotFoundException, SQLException{
        ClienteDAO con = new ClienteDAO(); //cria uma nova conexão com o banco de dados
        List<Cliente> rs; //cria uma lista de Clientees
        rs = con.consultar(nomeFantasia, razaoSocial); //preenche a lista com o resultado da consulta
        con.destroy();
        return rs; // retorna a lista
    }
    
    /** Método para a consulta de todos os clientes cadastrados no banco de dados
     * 
     * @return Uma lista de clientes contendo todos os clientes cadastrados
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<Cliente> consultar() throws ClassNotFoundException, SQLException{
        ClienteDAO con = new ClienteDAO(); //cria uma nova conexão com o banco de dados
        List<Cliente> rs; // cria uma lista de Clientees
        rs = con.consultar(); // preenche a lista com o resultado da consulta
        con.destroy();
        return rs; // retorna a lista
    }
    
    /** Método para exclusão de um cliente (também fará a exclusão de todos os endereços vinculados a este cliente)
     * 
     * @param Cliente Cliente que deseja ser excluido
     * @return True caso o cliente tenha sido excluido com sucesso e False em caso de falha
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static boolean excluir(Cliente Cliente) throws ClassNotFoundException, SQLException{
        EnderecoDAO EndConn = new EnderecoDAO(); //cria uma nova conexão com o banco (tabela endereco)
        ClienteDAO ClienteConn = new ClienteDAO(); //cria uma nova conexão com o banco (tabela Cliente)
        List<Endereco> enderecos = Cliente.getListaEndereco(); // cria uma lista de enderecos e preenche com a lista de enderecos do Cliente que se quer excluir
        int n = enderecos.size(); //pega a quantidade de enderecos deste Cliente
        for(int i=0; i<n; i++){ // percorre a lista
            EndConn.excluir(enderecos.get(i)); //exclui do banco o endereço na posição i da lista
        }
        EndConn.destroy();
        ClienteConn.destroy();
        return(ClienteConn.excluir(Cliente)); //exclui o Cliente e então retorna true ou false;
    }
    
}
