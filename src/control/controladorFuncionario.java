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
    
    /** Método para inserção de um novo Funcionário no banco de dados
     * Não será feito o cadastro caso já exista um funcionário com o mesmo cpf
     * 
     * @param endereco um objeto do tipo Endereco contendo o endereco do funcionario a ser cadastrado
     * @param funcionario um objeto do tipo Funcionario contendo o funcionario a ser cadastrado
     * @return Retorna true em caso de sucesso na inserção e false em caso de falha
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NoSuchAlgorithmException 
     */
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
        con.destroy();
        return add >= 0; // retorna true caso add >= 0 ou false se add < 0
    }
    
    /** Método para inserção de um novo Funcionário no banco de dados
     *  Não será feito o cadastro caso já exista um funcionário com o mesmo cpf
     * 
     * @param funcionario um objeto do tipo Funcionario contendo o funcionario a ser cadastrado
     * @return Retorna true em caso de sucesso e false em caso de falha
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NoSuchAlgorithmException 
     */
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
        con.destroy();
        return add >= 0;
    }
    
    /** Método para consulta de todos os Funcionários cadastrados no banco de dados
     * 
     * @return Retorna uma lista de funcionarios contendo todos os funcionários cadastrados
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<Funcionario> consultar() throws ClassNotFoundException, SQLException{
        FuncionarioDAO con = new FuncionarioDAO(); 
        List<Funcionario> rs;
        rs = con.consultar();
        con.destroy();
        return rs;
    }
    
    /** Método para a consulta de um funcionário pelo nome
     * 
     * @param nome uma String contendo o nome do funcionário
     * @return Retorna uma lista de funcionarios contendo os funcionarios que tenham aquele nome
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<Funcionario> consultar(String nome) throws ClassNotFoundException, SQLException{
        FuncionarioDAO con = new FuncionarioDAO(); 
        List<Funcionario> rs;
        rs = con.consultar(nome);
        con.destroy();
        return rs;
    }
    
    /** Método para Exclusão de um funcionário
     * 
     * @param funcionario um objeto do tipo Funcionario que será excluido do banco de dados
     * @return Retorna true em caso de sucesso e false em caso de falha
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static boolean excluir(Funcionario funcionario) throws ClassNotFoundException, SQLException{
        FuncionarioDAO con = new FuncionarioDAO(); 
        boolean excluir = con.excluir(funcionario);
        con.destroy();
        return(excluir);
    }
}
