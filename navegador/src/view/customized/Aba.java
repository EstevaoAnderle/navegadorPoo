package view.customized;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import service.Nos;
import service.ParseHtml;
import service.Render;

/**
 * Classe onde as novas abas são criadas. Nela, ocorre a estilização da mesma
 * seguindo o padrão da primeira aba, juntamente com as demais ações.
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class Aba extends JPanel {

    protected JPanel jPNavegacao;
    protected JButton jBVoltar;
    protected JButton jBAvancar;
    protected JPanel jPUrl;
    protected JTextField jTFUrl;
    protected JButton jBBuscarUrl;
    protected JScrollPane jSPPagina;
    protected JEditorPane pagina;

    Render rend = new Render();

    /**
     * Inicia a nova aba e seus componentes.
     */
    public Aba() {
        super();
        init();
    }

    /**
     * Define o layout dos componentes, juntamente com ações e atributos.
     */
    private void init() {
        //Variáveis
        jPNavegacao = new JPanel();
        jBVoltar = new JButton();
        jBAvancar = new JButton();
        jPUrl = new JPanel();
        jTFUrl = new JTextField();
        jBBuscarUrl = new JButton();
        pagina = new JEditorPane();
        jSPPagina = new JScrollPane(pagina);

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

        jBAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/avancar.png"))); // NOI18N
        jBAvancar.setToolTipText("Avançar uma página");

        jPUrl.setBackground(new java.awt.Color(255, 255, 255));

        jBBuscarUrl.setBackground(new java.awt.Color(255, 255, 255));
        jBBuscarUrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/busca_url.png"))); // NOI18N
        jBBuscarUrl.setToolTipText("Ir para endereço digitado");
        jBBuscarUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jBBuscarUrlActionPerformed(evt);
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

    /**
     * Armazena o histórico para o usuário logado, fazendo o download do HTML e
     * realizando o parse juntamente com o render.
     *
     * @param evt - ação do clique do mouse.
     */
    private void jBBuscarUrlActionPerformed(java.awt.event.ActionEvent evt) {
        //Historico h = new Historico();
        //historicoDAO hDAO = new historicoDAO();
        //adicionar tratamento para pegar o Title
        //h.setPagina(pagina);
        //h.setUrl(jTFUrl.getText());
        //h.setData_acesso();
        //hDAO.create(h);

        ArrayList<String> imagens = new ArrayList<String>();
        String titulo = jTFUrl.getText();
        try {
            //testes com arquivo local, html mais simples
            String texto = null;
//            JFileChooser chooser = new JFileChooser();
//            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
//
//            }
//            BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile()));
//            String linha = "";
//            while (br.ready()) {
//                while (br.ready()) {
//                    linha += br.readLine();
//                }
//            }
//            br.close();
//            br.close();

            URL url = new URL(jTFUrl.getText());
            File file = new File("page.html");

            //texto = nav.urlDown(url, file);
            //Imagem
            //Parser Texto
            ParseHtml p = new ParseHtml();
            imagens = p.linkImage(texto, titulo);
            Nos arvore = p.parseArvore(texto, null);
            rend.render(arvore, pagina);
            rend.renderTela(pagina, imagens);
        } catch (Exception e) {
        }
    }

    //Adicionar todas ações abaixo disso
}
