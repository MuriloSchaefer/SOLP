/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.FuncionarioDAO;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import model.Funcionario;

/**
 *
 * @author murilo
 */
public class controladorLogin {
    
    //criptografa a senha
    public static String convertPasswordToMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
 
        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
 
        return String.format("%32x", hash);
    }
    
    
   public static List<Funcionario> validaLogin(String usuario, String senha) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
        FuncionarioDAO con = new FuncionarioDAO(); //cria uma nova conexão com o banco
        String senhaMD5 = convertPasswordToMD5(senha); //criptografa a senha
        System.out.println(senhaMD5); // imprime no console a senha criptografada (será retirado depois)
        List<Funcionario> rs; // cria uma lista de funcionarios 
        rs = con.consultar(usuario, senhaMD5); //preenche a lista com o resultado da busca, com aquele usuario e com aquela senha
        con.destroy();
        return rs; //retorna lista com os usuarios
   }
   
    
}
