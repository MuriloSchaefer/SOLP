/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

//import dao.EnderecoDAO;

import dao.EnderecoDAO;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import model.Endereco;


/**
 *
 * @author murilo
 */
public class controladorEndereco {
    
    public static boolean add(Endereco endereco) throws ClassNotFoundException, NoSuchAlgorithmException{
        EnderecoDAO con = new EnderecoDAO(); //abre uma nova conexão com o banco
        int add = con.add(endereco); //faz a inserção do endereço
        return add >=0; // retorna true caso o add >=0; add é o id que foi inserido no banco, é -1 caso de erro
    }
    
    public static List<Endereco> consultar() throws ClassNotFoundException, SQLException{
        EnderecoDAO con = new EnderecoDAO(); //abre uma nova conexão com o banco
        List<Endereco> rs; // cria uma lista de enderecos
        rs = con.consultar(); //preenche a lista de enderecos com o resultado da consulta ao banco
        
        return rs; // retorna a lista preenchida
    }
}
