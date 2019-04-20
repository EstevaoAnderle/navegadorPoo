/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenon
 */
public class usuarioDAOTest {
    
    public usuarioDAOTest() {
    }

    @Test
    public void inserir() {
        Usuario user = new Usuario("lenon", "lenon", "123");
        usuarioDAO dao = new usuarioDAO();
        
        if (dao.save(user)) {
            System.out.println("Salvo com sucesso");
        } else {
            System.out.println("Erro ao salvar");
        }
    }
    
}
