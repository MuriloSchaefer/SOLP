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
        
    public static boolean add(MateriaPrima materiaPrima) throws ClassNotFoundException, SQLException{
        int add;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        add = conn.add(materiaPrima);
        conn.destroy();
        return add >=0;
    }
    
    public static List<MateriaPrima> consultar() throws ClassNotFoundException, SQLException{
        List<MateriaPrima> lista;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        lista = conn.consultar();
        conn.destroy();
        return lista;
    }
    
    public static List<MateriaPrima> consultar(int id) throws ClassNotFoundException, SQLException{
        List<MateriaPrima> lista;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        lista = conn.consultar(id);
        conn.destroy();
        return lista;
    }
    
    public static List<MateriaPrima> consultar(int id, int fornecedor) throws ClassNotFoundException, SQLException{
        List<MateriaPrima> lista;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        lista = conn.consultar(id, fornecedor);
        conn.destroy();
        return lista;
    }
    public static List<MateriaPrima> consultar(String nome) throws ClassNotFoundException, SQLException{
        List<MateriaPrima> lista;
        materiaPrimaDAO conn = new materiaPrimaDAO();
        lista = conn.consultar(nome);
        conn.destroy();
        return lista;
    }
    public static boolean excluir(MateriaPrima materiaPrima) throws ClassNotFoundException, SQLException{
        materiaPrimaDAO conn = new materiaPrimaDAO();
        boolean excluir = conn.excluir(materiaPrima);
        conn.destroy();
        return excluir;
    }
}
