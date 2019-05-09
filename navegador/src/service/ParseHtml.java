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

    public String parseArvore(String parse) {

        Pattern p = Pattern.compile("<(.[^>]*)>(.*)");
        Matcher m = p.matcher(parse);
        Nos raiz = new Nos(" ");
        while (m.find()) {
            Nos n = new Nos(m.group(1));
            raiz.noChildren.add(n);
            if (!m.group(0).isEmpty()) {
                Nos filho1 = new Nos(m.group(1));
                n.noChildren.add(filho1);
                Matcher mFilho = p.matcher(m.group(0));
                while (mFilho.find()) {
                    Nos neto1 = new Nos(mFilho.group(1));
                    filho1.noChildren.add(neto1);
                }
            }
        }
        int i;
        for (i = 0; i < raiz.noChildren.size(); i++) {
            System.out.println(raiz.noChildren.get(i).getNameTag());
            //ler a arvore, encontrar um jeito
            while (raiz.noChildren.contains(i)) {
                System.out.println(raiz.getNameTag());
            }
        }
        return parse;
    }
}

}
