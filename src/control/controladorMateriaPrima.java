/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.materiaPrimaDAO;
import java.sql.SQLException;
import java.util.List;
import model.MateriaPrima;

/**
 *
 * @author murilo
 */
public class controladorMateriaPrima {
       
    /** Método para inserção de uma nova matéria prima no banco de dados
     * 
     * @param materiaPrima um objeto do tipo MateriaPrima a ser inserido no banco de dados
     * @return Retorna true em caso de sucesso e false em caso de falha
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static boolean add(MateriaPrima materiaPrima) throws ClassNotFoundException, SQLException{
        int add;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        add = conn.add(materiaPrima);
        conn.destroy();
        return add >=0;
    }
    
    /** Método responsável pela consulta de todas as matérias primas cadastradas
     * 
     * @return Retorna uma lista de matérias primas contendo todas as matérias primas cadastradas
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<MateriaPrima> consultar() throws ClassNotFoundException, SQLException{
        List<MateriaPrima> lista;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        lista = conn.consultar();
        conn.destroy();
        return lista;
    }
    
    /** Método responsável pela consulta de materia prima pelo id
     * 
     * @param id um numero inteiro correspondente ao id desejado
     * @return Retorna uma lista de matéria prima contendo todas as matérias primas com aquele id
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<MateriaPrima> consultar(int id) throws ClassNotFoundException, SQLException{
        List<MateriaPrima> lista;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        lista = conn.consultar(id);
        conn.destroy();
        return lista;
    }
    
    /** Método para consultar uma matéria prima dado um id da matéria prima e um id do fornecedor
     * 
     * @param id um numero inteiro correspondente ao id da matéria prima
     * @param fornecedor um numero inteiro correspondente ao id do fornecedor
     * @return Retorna true em caso de sucesso e false em caso de falha
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<MateriaPrima> consultar(int id, int fornecedor) throws ClassNotFoundException, SQLException{
        List<MateriaPrima> lista;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        lista = conn.consultar(id, fornecedor);
        conn.destroy();
        return lista;
    }
    
    /** Método para consulta de uma matéria prima pelo nome
     * 
     * @param nome uma String contendo o nome da matéria prima desejada
     * @return Retorna uma lista de matérias primas contendo todas as matérias primas com aquele nome
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static List<MateriaPrima> consultar(String nome) throws ClassNotFoundException, SQLException{
        List<MateriaPrima> lista;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        lista = conn.consultar(nome);
        conn.destroy();
        return lista;
    }
    
    /** Método para exclusão de uma matéria prima do banco de dados
     * 
     * @param materiaPrima um objeto do tipo MateriaPrima que será excluido
     * @return Retorna true em caso de sucesso e false em caso de falha
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public static boolean excluir(MateriaPrima materiaPrima) throws ClassNotFoundException, SQLException{
        materiaPrimaDAO conn = new materiaPrimaDAO();
        boolean excluir = conn.excluir(materiaPrima);
        conn.destroy();
        return excluir;
    }
}
