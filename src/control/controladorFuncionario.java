/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Funcionario;
import dao.FuncionarioDAO;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Endereco;

/**
 *
 * @author murilo
 */
public class controladorFuncionario {
    
    //Inserção com o cadastro de um novo endereco
    public static boolean add(Endereco endereco, Funcionario funcionario) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
        FuncionarioDAO con = new FuncionarioDAO(); //cria uma nova conexão com o banco de dados
        List<Funcionario> lista; //cria uma lista de funcionarios
        lista = con.consultar(); // preenche a lista com o resultado da consulta
        int n = lista.size(); //pega o tamanho da lista
        int add; 
        for(int i=0;i<n; i++){ //percorre a lista verificando se o cpf já esta cadastrado
            if(lista.get(i).getCpf().equals(funcionario.getCpf())){
                JOptionPane.showMessageDialog(null, "CPF Já cadastrado");
                return false;
            }                
        }
        add = con.add(endereco, funcionario); //add recebe o id de inserção no banco; add = -1 no caso de erro
        
        return add >= 0; // retorna true caso add >= 0 ou false se add < 0
    }
    
    //Inserção com um endereço já cadastrado
    public static boolean add(Funcionario funcionario) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
        FuncionarioDAO con = new FuncionarioDAO(); //cria uma nova conexão com o banco de dados
        List<Funcionario> lista; //cria uma lista de funcionarios
        lista = con.consultar(); //preenche esta lista com o resultado da consulta
        int n = lista.size(); // pega o tamanho da lista
        //parei de comentar neste momento, o resto pra baixo é tudo a mesma bosta, só ler.
        int add;
        for(int i=0;i<n; i++){ 
            if(lista.get(i).getCpf().equals(funcionario.getCpf())){
                JOptionPane.showMessageDialog(null, "CPF Já cadastrado");
                return false;
            }                
        }
        add = con.add(funcionario);
        
        return add >= 0;
    }
    public static List<Funcionario> consultar() throws ClassNotFoundException, SQLException{
        FuncionarioDAO con = new FuncionarioDAO(); 
        List<Funcionario> rs;
        rs = con.consultar();
        return rs;
    }
    public static List<Funcionario> consultar(String nome) throws ClassNotFoundException, SQLException{
        FuncionarioDAO con = new FuncionarioDAO(); 
        List<Funcionario> rs;
        rs = con.consultar(nome);
        return rs;
    }
    public static boolean excluir(Funcionario funcionario) throws ClassNotFoundException{
        FuncionarioDAO con = new FuncionarioDAO(); 
        return(con.excluir(funcionario));
    }
}
