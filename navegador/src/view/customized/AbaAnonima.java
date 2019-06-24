package view.customized;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.bean.Favorito;
import model.bean.Historico;
import model.bean.Usuario;
import model.dao.favoritoDAO;
import model.dao.historicoDAO;
import service.Nos;
import service.ParseHtml;
import service.Pilha;
import service.Render;
import service.navegadorService;
import view.ConfigRede;
import view.MenuFavoritos;
import view.MenuHistorico;
import view.TelaLogin;

/**
 * Classe onde as novas abas são criadas para as janelas anônimas. Nela, ocorre
 * a estilização da mesma seguindo o padrão da primeira aba, juntamente com as
 * demais ações.
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class AbaAnonima extends JPanel {

    protected JPanel jPNavegacao;
    protected JButton jBVoltar;
    protected JButton jBAvancar;
    protected JPanel jPUrl;
    protected JTextField jTFUrl;
    protected JButton jBBuscarUrl;
    protected JScrollPane jSPPagina;
    protected JEditorPane pagina;

    /**
     * Inicia a nova aba e seus componentes.
     */
    public AbaAnonima() {
        super();
        init();

    }

    /**
     * Define o layout dos componentes, juntamente com ações e atributos.
     */
    private void init() {
        navegadorService nav = new navegadorService();
        ConfigRede rede = new ConfigRede();
        Pilha pilha = new Pilha();
        Render rend = new Render();
        ParseHtml p = new ParseHtml();
        TelaLogin login = new TelaLogin();

        //Variáveis
        jPNavegacao = new JPanel();
        jBVoltar = new JButton();
        jBAvancar = new JButton();
        jPUrl = new JPanel();
        jTFUrl = new JTextField();
        jBBuscarUrl = new JButton();
        pagina = new JEditorPane();
        jSPPagina = new JScrollPane(pagina);

        if (pilha.pilhaEsquerda.empty()) {
            jBVoltar.setEnabled(false);
        }
        if (pilha.pilhaDireita.empty()) {
            jBAvancar.setEnabled(false);
        }

        //Propriedades
        javax.swing.GroupLayout jPAba1Layout = new javax.swing.GroupLayout(this);
        this.setLayout(jPAba1Layout);
        jPAba1Layout.setHorizontalGroup(
                jPAba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                        .addGroup(jPAba1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jSPPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPAba1Layout.setVerticalGroup(
                jPAba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPAba1Layout.createSequentialGroup()
                                .addComponent(jPNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSPPagina, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPNavegacao.setPreferredSize(new java.awt.Dimension(626, 55));

        jBVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/voltar.png"))); // NOI18N
        jBVoltar.setToolTipText("Voltar uma página");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ultimaUrl = pilha.pilhaEsquerda.empty() ? "" : pilha.voltar();
                jTFUrl.setText(ultimaUrl);
                jBBuscarUrl.addActionListener(this);
                if (pilha.pilhaEsquerda.empty()) {
                    jBVoltar.setEnabled(false);
                }
                jBAvancar.setEnabled(true);
            }

        });

        jBAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/avancar.png"))); // NOI18N
        jBAvancar.setToolTipText("Avançar uma página");
        jBAvancar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String proximaUrl = pilha.pilhaDireita.empty() ? "" : pilha.avancar();
                jTFUrl.setText(proximaUrl);
                jBBuscarUrl.addActionListener(this);
                if (pilha.pilhaDireita.empty()) {
                    jBAvancar.setEnabled(false);
                }
                if (pilha.pilhaEsquerda.empty()) {
                    jBVoltar.setEnabled(false);
                }
            }

        });

        jPUrl.setBackground(new java.awt.Color(255, 255, 255));
        jTFUrl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == Event.ENTER) {
                    try {
                        File file = new File("page.html");
                        verificarRequest(jTFUrl.getText(), file);

                        if (!pilha.pilhaEsquerda.empty()) {
                            jBVoltar.setEnabled(true);
                        } else {
                            jBVoltar.setEnabled(false);
                        }
                        pilha.pilhaEsquerda.push(jTFUrl.getText());
                        if (evt.getSource().equals(jBBuscarUrl)) {
                            pilha.limparPilhaDireita();
                            jBAvancar.setEnabled(false);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }

            public void verificarRequest(String address, File file) throws Exception {
                ArrayList<String> imagens = new ArrayList<String>();
                String urlAcesso = jTFUrl.getText();
                String texto = null;
                String titulo = null;
                String problema = null;
                try {
                    problema = nav.urlRequest(address, file);
                    if (!problema.equalsIgnoreCase(null)) {
                        JOptionPane.showMessageDialog(null, problema);
                        new Exception(problema);
                        return;
                    }
                } catch (Exception ex) {
                }
                texto = nav.urlDown(urlAcesso, file);
                titulo = p.extrairTitulo(texto);
//                int aba = jTPAbas.getSelectedIndex();
//                jTPAbas.setTitleAt(aba, titulo);
                imagens = p.linkImage(texto, urlAcesso);
                Nos arvore = p.parseArvore(texto, null);
                rend.render(arvore, pagina, jTFUrl);
                rend.renderTela(pagina, imagens);

            }
        });

        jBBuscarUrl.setBackground(new java.awt.Color(255, 255, 255));
        jBBuscarUrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/busca_url.png"))); // NOI18N
        jBBuscarUrl.setToolTipText("Ir para endereço digitado");
        jBBuscarUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    File file = new File("page.html");
                    verificarRequest(jTFUrl.getText(), file);

                    if (!pilha.pilhaEsquerda.empty()) {
                        jBVoltar.setEnabled(true);
                    } else {
                        jBVoltar.setEnabled(false);
                    }
                    pilha.pilhaEsquerda.push(jTFUrl.getText());
                    if (evt.getSource().equals(jBBuscarUrl)) {
                        pilha.limparPilhaDireita();
                        jBAvancar.setEnabled(false);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            //Adicionar todas ações abaixo disso

            public void verificarRequest(String address, File file) throws Exception {
                ArrayList<String> imagens = new ArrayList<String>();
                String urlAcesso = jTFUrl.getText();
                String texto = null;
                String titulo = null;
                String problema = null;
                try {
                    problema = nav.urlRequest(address, file);
                    if (!problema.equalsIgnoreCase(null)) {
                        JOptionPane.showMessageDialog(null, problema);
                        new Exception(problema);
                        return;
                    }
                } catch (Exception ex) {
                }
                texto = nav.urlDown(urlAcesso, file);
                titulo = p.extrairTitulo(texto);
//                int aba = jTPAbas.getSelectedIndex();
//                jTPAbas.setTitleAt(aba, titulo);
                imagens = p.linkImage(texto, urlAcesso);
                Nos arvore = p.parseArvore(texto, null);
                rend.render(arvore, pagina, jTFUrl);
                rend.renderTela(pagina, imagens);
            }

        });

        javax.swing.GroupLayout jPUrlLayout = new javax.swing.GroupLayout(jPUrl);
        jPUrl.setLayout(jPUrlLayout);
        jPUrlLayout.setHorizontalGroup(
                jPUrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPUrlLayout.createSequentialGroup()
                                .addComponent(jTFUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jBBuscarUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPUrlLayout.setVerticalGroup(
                jPUrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPUrlLayout.createSequentialGroup()
                                .addGroup(jPUrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jBBuscarUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTFUrl))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPNavegacaoLayout = new javax.swing.GroupLayout(jPNavegacao);
        jPNavegacao.setLayout(jPNavegacaoLayout);
        jPNavegacaoLayout.setHorizontalGroup(
                jPNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPNavegacaoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jBAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        jPNavegacaoLayout.setVerticalGroup(
                jPNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNavegacaoLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jBAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jSPPagina.setPreferredSize(new java.awt.Dimension(593, 22));

        pagina.setEditable(false);
        pagina.setContentType(""); // NOI18N
        pagina.setToolTipText("");
        pagina.setPreferredSize(new java.awt.Dimension(593, 20));
        jSPPagina.setViewportView(pagina);
    }

}
