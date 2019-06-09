/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import model.bean.Usuario;
import model.dao.usuarioDAO;

/**
 *
 * @author Lenon
 */
public class navegadorService {

    Image imagemPagina;

    public navegadorService() {
        usuarioDAO dao = new usuarioDAO();
    }

    public String urlDown(URL url, File file) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        String inputLine;
        String texto = null;
        while ((inputLine = in.readLine()) != null) {
            // Grava pagina no arquivo
            texto = texto + "" + inputLine;
            out.write(inputLine);
            out.newLine();
        }
        in.close();
        out.flush();
        out.close();
        return texto;
    }

}
