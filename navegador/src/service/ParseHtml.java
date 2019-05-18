/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lenon.060194
 */
public class ParseHtml {

    Nos raiz = new Nos(" ");

    public String parseArvore(String parse) {

        Pattern p = Pattern.compile("<(.*)(\\s?\\w*\\s.*?)?>(.*)<(\\/\\1)>");
        Matcher m = p.matcher(parse);
        while (m.find()) {
            System.out.println(m.group(1));
            if (m.group(3).isEmpty()) {
                System.out.println(m.group(3));
                return m.group(3);
            }
            raiz.noChildren.add(new Nos(m.group(1)));
            System.out.println(m.group(3));
            return parseArvore(m.group(3));
        }
        return "teste";
    }
}
