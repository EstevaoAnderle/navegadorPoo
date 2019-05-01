/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.bean.Usuario;

/**
 *
 * @author Lenon
 */
public class navegadorService {

    public navegadorService() {
        Usuario user = new Usuario("default", "dafault", "default");
    }

    public void urlDown(URL url, File file) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        String inputLine;
        boolean isHtml = false;
        while ((inputLine = in.readLine()) != null) {
            // Grava pagina no arquivo
            out.write(inputLine);
            out.newLine();
        }
        in.close();
        out.flush();
        out.close();
    }

    private boolean empty(String group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
