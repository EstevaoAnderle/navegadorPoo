/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.UIManager;
import view.interfaceGrafica;

/**
 *
 * @author Lenon
 */
public class Render {
    JEditorPane pa = new JEditorPane();
    String txt = " ";
/**
 * 
 * @param parser Nós com as tags html populadas
 * @param pagina JEditorPane para exibição
 */
    public void render(Nos parser, JEditorPane pagina) {
        txt = " ";
        for (Nos item : parser.getNoChildren()) {
            if (item.texto == " ") {
                render(item, pagina);
            } else {
                renderFinal(item);
            }
        }
    }
/**
 * 
 * @param parser Nós com as tags populadas
 * Metodo aplica estilo as tags e concatna a uma string
 */
    public void renderFinal(Nos parser) {
        
        switch (parser.nameTag) {
            case "a":
                txt += "<br><a " + parser.atributosTag + ">" + parser.texto + "</b></font>";
                
                break;
            case "h1":
                txt += "<br><font size=\"6\"><b>" + parser.texto + "</b></font>";
                break;
            case "h2":
                txt += "<br><font size=\"5\"><b>" + parser.texto + "</b></font>";
                break;
            default:
                txt += "<br><p>" + parser.texto + "</p>";
                break;
        }

    }
    /**
     * 
     * @param pagina JEditorPane para exibição
     * @param imagem ArrayList de imagens para ser exibida na pagina
     */
    public void renderTela(JEditorPane pagina, ArrayList imagem) {
        for (int i = 0; i < imagem.size(); i++) {
         txt += "<img src="+imagem.get(i).toString()+">";
        }
        pagina.setContentType("text/html");
        pagina.setText(txt);
    }
}
