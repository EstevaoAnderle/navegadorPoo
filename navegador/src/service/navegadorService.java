package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import model.bean.Usuario;

/**
 * Classe navegadorService, responsável por baixar o conteudo do site.
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class navegadorService {

    public static boolean usaProxy = false;
    public static String ip;
    public static int porta;

    /**
     * Construtor da classe e que é chamado na inicialização do navegador, já
     * definindo o usuário padrão.
     */
    public navegadorService() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
    }

    /**
     * Método responsável por realizar a conexão e baixar o HTML da página
     * acessada caso não seja encontrada nenhuma exceção. Se alguma exceção for
     * encontrada, o arquivo de log será alimentado/criado.
     *
     * @param address url do site
     * @param file que será baixado
     * @return se foi possível acessar a página ou não
     * @throws Exception encontrada
     */
    public String urlRequest(String address, File file) throws Exception {

        BufferedReader in = null;
        BufferedWriter out = null;
        String inputLine;
        String problema = null;
        Log log = new Log();

        if (usaProxy) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, porta));
            try {
                URL url = new URL(address);
                URLConnection connection = url.openConnection(proxy);
                connection.connect();
            } catch (MalformedURLException ex) {
                //Lançada para indicar que a URL foi informada com algum problema. Nenhum protocolo
                //legal pôde ser encontrado em uma cadeia de especificação ou a mesma não pôde ser analisada.
//                JOptionPane.showMessageDialog(null, "Protocolo de segurança não informado ou inválido. Verifique!");
                log.gravaErro(ex);
                problema = "Protocolo de segurança não informado ou inválido. Verifique!";
                return problema;
            } catch (ConnectException ex) {
                //Sinaliza que ocorreu um erro ao tentar conectar um soquete a um endereço e uma porta remotos.
                //Normalmente, a conexão foi recusada remotamente (por exemplo, nenhum processo está escutando no endereço / porta remota).
//                JOptionPane.showMessageDialog(null, "Falha na conexão com a rede");
                log.gravaErro(ex);
                problema = "Falha na conexão com a rede";
                return problema;

            } catch (UnknownHostException ex) {
                //Lançada para indicar que o endereço IP de um host não pôde ser encontrado.
//                JOptionPane.showMessageDialog(null, "Página não encontrada. Verifique a URL"
//                        + " e se você possui conexão com a internet.");
                log.gravaErro(ex);
                problema = "Página não encontrada. Verifique a URL e se você possui conexão com a internet.";
                return problema;

            } catch (IOException ex) {
                //Lançada em caso de falha na URL e alguns outros erros não mapeados.
//                JOptionPane.showMessageDialog(null, "Falha na URL informada. Verifique e tente novamente!");
                log.gravaErro(ex);
                problema = "Falha na URL informada. Verifique e tente novamente!";
                return problema;

            }
        } else {
            try {
                URL url = new URL(address);
                URLConnection connection = url.openConnection();
                connection.connect();
            } catch (MalformedURLException ex) {
                //Lançada para indicar que a URL foi informada com algum problema. Nenhum protocolo
                //legal pôde ser encontrado em uma cadeia de especificação ou a mesma não pôde ser analisada.
//                JOptionPane.showMessageDialog(null, "Protocolo de segurança não informado ou inválido. Verifique!");
                log.gravaErro(ex);
                problema = "Protocolo de segurança não informado ou inválido. Verifique!";
                return problema;

            } catch (ConnectException ex) {
                //Sinaliza que ocorreu um erro ao tentar conectar um soquete a um endereço e uma porta remotos.
                //Normalmente, a conexão foi recusada remotamente (por exemplo, nenhum processo está escutando no endereço / porta remota).
//                JOptionPane.showMessageDialog(null, "Falha na conexão com a rede.");
                log.gravaErro(ex);
                problema = "Falha na conexão com a rede";
                return problema;

            } catch (UnknownHostException ex) {
                //Lançada para indicar que o endereço IP de um host não pôde ser encontrado.
//                JOptionPane.showMessageDialog(null, "Página não encontrada. Verifique a URL"
//                        + " e se você possui conexão com a internet.");
                log.gravaErro(ex);
                problema = "Página não encontrada. Verifique a URL e se você possui conexão com a internet.";
                return problema;

            } catch (IOException ex) {
                //Lançada em caso de falha na URL e alguns outros erros não mapeados.
//                JOptionPane.showMessageDialog(null, "Falha na URL informada. Verifique e tente novamente!");
                log.gravaErro(ex);
                problema = "Falha na URL informada. Verifique e tente novamente!";
                return problema;
            }

        }
        return problema;
    }

    /**
     * Realiza o download do HTML.
     *
     * @param address url da página
     * @param file arquivo que será baixado
     * @return o texto do HTML
     * @throws IOException se caso for encontrada alguma falha na entrada
     */
    public String urlDown(String address, File file) throws IOException {
        URL url = new URL(address);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter out = new BufferedWriter(new FileWriter(file));
        String inputLine;
        String texto = null;
        while ((inputLine = in.readLine()) != null) {
            // Grava pagina no arquivo
            texto = texto + "" + inputLine;
            out.write(inputLine);
            out.newLine();
        }
        in.close();
        out.flush();
        out.close();
        return texto;
    }
}
