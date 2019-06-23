package service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import view.BotaoEvento;

/**
 * Classe Render, é reponsavel em renderizar o html na pagina
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class Render {

    JEditorPane pa = new JEditorPane();
    BotaoEvento bt = new BotaoEvento();
    String txt = " ";

    /**
     * Método percore os Nós ate encontrar a folha "texto"
     *
     * @param parser Nós com as tags html populadas
     * @param pagina JEditorPane pagina do navegador
     */
    public void render(Nos parser, JEditorPane pagina, JTextField jt) {
        for (Nos item : parser.getNoChildren()) {
            if (item.texto == " ") {
                render(item, pagina, jt);
            } else {
                renderFinal(item, pagina, jt);
            }
        }
    }

    /**
     * Método percorre a tag presente no Nó, aplicando um estilo
     *
     * @param parser Nós
     */
    public void renderFinal(Nos parser, JEditorPane pagina, JTextField j) {
        String botao = "";
        switch (parser.nameTag) {
            case "a":
//                txt += "<br><a " + parser.atributosTag + ">" + parser.texto + "</b></font>";
                Pattern p = Pattern.compile("href=[\\'\"]?([^\\'\" >]+)");
                Matcher m = p.matcher(parser.getAtributosTag());
                if (m.find()) {
                    bt.BotaoEvento(pagina, parser.atributosTag, j, m.group(1));
                }
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
     * Método renderiza na pagina todo texto encontrado na estrutura dos Nós
     *
     * @param pagina JEditorPane pagina para exibição
     * @param imagem ArrayList de imagens para ser exibida na pagina
     */
    public void renderTela(JEditorPane pagina, ArrayList imagem) {
        for (int i = 0; i < imagem.size(); i++) {
            txt += "<img src=" + imagem.get(i).toString() + ">";
        }
        pagina.setContentType("text/html");
        pagina.setText(txt);
        txt = "";
    }

}
