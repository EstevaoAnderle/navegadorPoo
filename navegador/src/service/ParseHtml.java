/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Pagination;
import view.interfaceGrafica;

/**
 *
 * @author lenon.060194
 */
public class ParseHtml extends interfaceGrafica {

    ArrayList<String> saida = new ArrayList<String>();

    public Nos parseArvore(String parse, Nos raiz) {
        if (raiz == null) {
            raiz = new Nos("", "", "");
        }
        Pattern p = Pattern.compile("(?s)<(.*)(\\s?\\w*\\s.*?)?>(.*?)<(\\/\\1)>");
        Matcher m = p.matcher(parse);
        while (m.find()) {
            Nos n = new Nos(m.group(1), m.group(2), " ");
            if (detectaTexto(m.group(3))) {
                n.texto = m.group(3);
            }

            raiz.noChildren.add(parseArvore(m.group(3), n));
        }
        return raiz;
    }

    public void render(Nos parser) {

        for (Iterator<Nos> it = parser.getNoChildren().iterator(); it.hasNext();) {
            Nos item = it.next();
            if (item.texto == " ") {
                render(item);
            } else {
                renderFinal(item);
            }

        }
    }

    public void renderFinal(Nos parser) {
        switch (parser.nameTag) {
            case "a":
                
                break;
            case "img":
                
                break;
            case "h1":
                parser.texto = "<B>" + parser.texto;
                break;
        }
        saida.add(parser.texto);
    }

    public ArrayList<String> getSaida() {
        return saida;
    }

    public boolean detectaTexto(String parse) {
        Pattern p = Pattern.compile("^\\b\\w.*[^<>]$");
        Matcher m = p.matcher(parse);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public String linkImage(String parse) {
        String linkImage = null;
        Pattern p = Pattern.compile("<img\\s+[^>]*src=\"([^\"]*)\"[^>]*>");
        Matcher m = p.matcher(parse);
        if (m.find()) {
            linkImage = m.group(0);
        }
        return linkImage;
    }
}
