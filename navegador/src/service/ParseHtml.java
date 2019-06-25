package service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe Parser, é reponsavel em verificar a estrutura hmtl passada e na
 * criação dos nós.
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class ParseHtml {

    ArrayList<String> imagens = new ArrayList<String>();

    /**
     * Percorre a string instanciando um novo Nó
     *
     * @param parse string com o html
     * @param raiz Nó principal
     * @return método retorno um nó com todos os nós filhos presentes
     */
    public Nos parseArvore(String parse, Nos raiz) {
        if (raiz == null) {
            raiz = new Nos("", "", "");
            Pattern p = Pattern.compile("(?s)<(.*)(\\s?\\w*\\s.*?)?>(.*?)<(\\/\\1)>");
            Matcher m = p.matcher(parse);
            while (m.find()) {
                Nos n = new Nos(m.group(1), m.group(2), " ");
                if (detectaTexto(m.group(3))) {
                    n.texto = m.group(3);
                }

                raiz.noChildren.add(parseArvore(m.group(3), n));
            }
        } else {
            Pattern p = Pattern.compile("(?s)<(.*)(\\s?\\w*\\s.*?)?>(.*?)<(\\/\\1)>");
            Matcher m = p.matcher(parse);
            while (m.find()) {
                Nos n = new Nos(m.group(1), m.group(2), " ");
                if (detectaTexto(m.group(3))) {
                    n.texto = m.group(3);
                }
                raiz.noChildren.add(parseArvore(m.group(3), n));
            }
        }
        return raiz;
    }

    /**
     * Método verifica se o nó é folha
     *
     * @param parse match contendo o conteudo parseado
     * @return true se for a folha, false ao contrario disso
     */
    public boolean detectaTexto(String parse) {
        Pattern p = Pattern.compile("^\\b\\w.*[^<>]$");
        Matcher m = p.matcher(parse);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo extrai o TITLE do html passado
     *
     * @param parse strig com o html
     * @return Retorna o TITLE do html
     */
    public String extrairTitulo(String parse) {
        Pattern p = Pattern.compile("<title>(.*)<\\/title>");
        Matcher m = p.matcher(parse);
        String titulo = null;
        if (m.find()) {
            titulo = m.group(1);
        }
        return titulo;
    }

    /**
     * Método extrai todas a imagens presente no hmtl
     *
     * @param parse strig com o html
     * @param url url de acesso para se preciso, definir caminho do servidor
     * @return Retorna um array contendo as imagens do html
     */
    public ArrayList<String> linkImage(String parse, String url) {
        String linkImage = null;
        Pattern p = Pattern.compile("<img\\s+[^>]*src=\"([^\"]*)\"[^>]*>");
        Matcher m = p.matcher(parse);
        while (m.find()) {
            Pattern p2 = Pattern.compile("http:?[\\/\\/]?.*?");
            Matcher m2 = p.matcher(m.group(1));
            if (m2.find()) {
                imagens.add(m.group(1));
            } else {
                imagens.add(url + m.group(1));
            }
        }
        return imagens;
    }

    /**
     * Método responsavél para verificar má formação no html
     *
     * @param html strig com o html
     * @return Retorna true caso mal formatado, false ao contrario disso.
     */
    public boolean isBadlyFormatted(String html) {

        Pattern p = Pattern.compile("<(\\w*\\s?<)|>(\\w*\\s?>)");
        Matcher m = p.matcher(html);
        if (m.find()) {
            System.out.println(m.group(0));
            return true;
        }
        return false;
    }
}
