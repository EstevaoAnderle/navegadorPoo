/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParserTest;

import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import service.ParseHtml;

/**
 *
 * @author Lenon
 */
public class ParserTest {

    public ParserTest() {
    }

    @Test
    public void ObterTitle() {
        ParseHtml p = new ParseHtml();
        String html = "<html><title>Pudim</title><body><p>Testando</p></body></html>";
        assertEquals("Pudim", p.extrairTitulo(html));
    }

    @Test
    public void detectaTexto() {
        ParseHtml p = new ParseHtml();
        assertTrue(p.detectaTexto("FOLHA"));
        assertFalse(p.detectaTexto("<p>FOLHA<p>"));
    }

    @Test
    public void detectaImagem() {
        ParseHtml p = new ParseHtml();
        ArrayList<String> imagem = new ArrayList();
        String html = "<html><body><div><img src=\"pudim.jpg\" alt=\"\"></div></body></html>";
        imagem = p.linkImage("<img src=\"pudim.jpg\" alt=\"\">", "http://www.pudim.com.br/");
        assertEquals("http://www.pudim.com.br/pudim.jpg", imagem.get(0).toString());
    }

}
