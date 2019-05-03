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

        Pattern p = Pattern.compile("<(.*)>.*<(\\/\\1)>");
        Matcher m = p.matcher(parse);
        while (m.find()) {
            Nos n = new Nos("<" + m.group(1) + ">" + "<" + m.group(2) + ">");
            n.noChildren.add(n);

            if (!m.group(0).isEmpty()) {
                String filho = m.group(0).replaceAll("<" + m.group(1) + ">", "");
                filho = filho.replaceAll("</" + m.group(1) + ">", "");
                Nos filho1 = new Nos("<" + m.group(1) + ">" + "<" + m.group(2) + ">");
                n.noChildren.add(filho1);
                Matcher mFilho = p.matcher(filho);
                while (mFilho.find()) {
                    Nos neto1 = new Nos("<" + mFilho.group(1) + ">" + "<" + mFilho.group(2) + ">");
                    filho1.noChildren.add(neto1);
                    if (!mFilho.group(0).isEmpty()) {
                        String neto = mFilho.group(0).replaceAll("<" + mFilho.group(1) + ">", "");
                        neto = neto.replaceAll("</" + mFilho.group(1) + ">", "");
                    }
                }
            }
            int i;
            for (i = 0; i < n.noChildren.size(); i++) {
                System.out.println(n.noChildren.get(i).getNameTag());
            }
        }
        return parse;
    }
}
