/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EnderecoDAO;
import dao.FornecedorDAO;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Fornecedor;

/**
 *
 * @author murilo
 */
public class controladorFornecedor {
    
    public static boolean add(Fornecedor fornecedor) throws ClassNotFoundException, NoSuchAlgorithmException, SQLException{
        FornecedorDAO con = new FornecedorDAO(); //cria uma nova conexão com o banco de dados
        List<Fornecedor> lista = con.consultar(); //cria uma lista de fornecedores e preenche esta com o resultado da consulta
        int n = lista.size(); //pega o tamanho da lista
        // --- analisa cada um dos fornecedores para ver se o cnpj já não esta cadastrado
        for(int i=0; i<n;i++){
            if (lista.get(i).getCnpj() == null ? fornecedor.getCnpj() == null : lista.get(i).getCnpj().equals(fornecedor.getCnpj())){
                JOptionPane.showMessageDialog(null, "CNPJ Já cadastrado");
                return false;
            }
        }
        //---------------------------
        int add;
        add = con.add(fornecedor); // add = id de inserção no banco; add é -1 no caso de falha
        return add >=0; //retorna true caso o add >=0 e false caso seja -1
    }
    
    //Consulta com parametros de nome fantasia e razão social
    public static List<Fornecedor> consultar(String nomeFantasia, String razaoSocial) throws ClassNotFoundException, SQLException{
        FornecedorDAO con = new FornecedorDAO(); //cria uma nova conexão com o banco de dados
        List<Fornecedor> rs; //cria uma lista de fornecedores
        rs = con.consultar(nomeFantasia, razaoSocial); //preenche a lista com o resultado da consulta
        return rs; // retorna a lista
    }
    
    //Consulta sem paramentros (retorna todos os elementos cadastrados)
    public static List<Fornecedor> consultar() throws ClassNotFoundException, SQLException{
        FornecedorDAO con = new FornecedorDAO(); //cria uma nova conexão com o banco de dados
        List<Fornecedor> rs; // cria uma lista de fornecedores
        rs = con.consultar(); // preenche a lista com o resultado da consulta
        return rs; // retorna a lista
    }
    
    public static boolean excluir(Fornecedor fornecedor) throws ClassNotFoundException, SQLException{
        EnderecoDAO EndConn = new EnderecoDAO(); //cria uma nova conexão com o banco (tabela endereco)
        FornecedorDAO FornecedorConn = new FornecedorDAO(); //cria uma nova conexão com o banco (tabela fornecedor)
        List<Endereco> enderecos = fornecedor.getListaEndereco(); // cria uma lista de enderecos e preenche com a lista de enderecos do fornecedor que se quer excluir
        int n = enderecos.size(); //pega a quantidade de enderecos deste fornecedor
        for(int i=0; i<n; i++){ // percorre a lista
            EndConn.excluir(enderecos.get(i)); //exclui do banco o endereço na posição i da lista
        }
        return(FornecedorConn.excluir(fornecedor)); //exclui o fornecedor e então retorna true ou false;
    }
}
