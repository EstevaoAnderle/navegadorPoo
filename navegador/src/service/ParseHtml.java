/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lenon.060194
 */
public class ParseHtml {

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

            
//            System.out.println(n.getNameTag());
//            System.out.println(n.getAtributosTag());
//            System.out.println(n.getTexto());
            raiz.noChildren.add(parseArvore(m.group(3), n));
        }
        return raiz;
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
    
   public String linkImage(String parse){
       String linkImage = null;
       Pattern p = Pattern.compile("<img\\s+[^>]*src=\"([^\"]*)\"[^>]*>");
        Matcher m = p.matcher(parse);
        if (m.find()) {
           linkImage = m.group(0);
       }
        return linkImage;
   }
}
