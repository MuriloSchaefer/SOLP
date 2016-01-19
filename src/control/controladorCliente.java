/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ClienteDAO;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import model.Cliente;

/**
 *
 * @author Mateus
 */
public class controladorCliente {

    public controladorCliente() {
    }
    
    public static boolean add(Cliente cliente) throws ClassNotFoundException, NoSuchAlgorithmException, SQLException{
     ClienteDAO con = new ClienteDAO();
     int add = con.add(cliente);
     con.destroy();
     return add >=0;
    }
    
}
