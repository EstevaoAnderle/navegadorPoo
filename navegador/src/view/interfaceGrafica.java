/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import service.Nos;
import service.ParseHtml;
import service.Render;
import service.navegadorService;

/**
 *
 * @author Lenon
 */
public class interfaceGrafica extends javax.swing.JFrame {

    navegadorService nav = new navegadorService();
    Render rend = new Render();

    /**
     * Creates new form interfaceGrafica
     */
    public interfaceGrafica() {
        initComponents();
        //Isso faz com que ele sempre inicie centralizado
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu = new javax.swing.JPopupMenu();
        jMIHistorico = new javax.swing.JMenuItem();
        jMFavoritos = new javax.swing.JMenu();
        jMIAddFavorito = new javax.swing.JMenuItem();
        jSeparador2 = new javax.swing.JPopupMenu.Separator();
        jMIFavRecentes = new javax.swing.JMenuItem();
        jMIFav1 = new javax.swing.JMenuItem();
        jMIFav2 = new javax.swing.JMenuItem();
        jMIFav3 = new javax.swing.JMenuItem();
        jMIFav4 = new javax.swing.JMenuItem();
        jMIFav5 = new javax.swing.JMenuItem();
        jSeparador3 = new javax.swing.JPopupMenu.Separator();
        jMIExibirFavoritos = new javax.swing.JMenuItem();
        jSeparador1 = new javax.swing.JPopupMenu.Separator();
        jMIModoPrivado = new javax.swing.JMenuItem();
        jTPAbas = new javax.swing.JTabbedPane();
        jPAba1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPNavegacao = new javax.swing.JPanel();
        jBVoltar = new javax.swing.JButton();
        jBAvancar = new javax.swing.JButton();
        jPUrl = new javax.swing.JPanel();
        jTFUrl = new javax.swing.JTextField();
        jBBuscarUrl = new javax.swing.JButton();
        jBUser = new javax.swing.JButton();
        jBMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pagina = new javax.swing.JEditorPane();

        jMIHistorico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMIHistorico.setText("Histórico");
        jMIHistorico.setToolTipText("Acessar histórico");
        jMIHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIHistoricoActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMIHistorico);

        jMFavoritos.setText("Favoritos");
        jMFavoritos.setToolTipText("Ver favoritos");
        jMFavoritos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMIAddFavorito.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMIAddFavorito.setText("Adicionar página aos favoritos");
        jMIAddFavorito.setToolTipText("Salvar página como favorito");
        jMFavoritos.add(jMIAddFavorito);
        jMFavoritos.add(jSeparador2);

        jMIFavRecentes.setText("Favoritos recentes");
        jMIFavRecentes.setEnabled(false);
        jMFavoritos.add(jMIFavRecentes);

        jMIFav1.setText("<Vazio>");
        jMFavoritos.add(jMIFav1);

        jMIFav2.setText("<Vazio>");
        jMFavoritos.add(jMIFav2);

        jMIFav3.setText("<Vazio>");
        jMFavoritos.add(jMIFav3);

        jMIFav4.setText("<Vazio>");
        jMFavoritos.add(jMIFav4);

        jMIFav5.setText("<Vazio>");
        jMFavoritos.add(jMIFav5);
        jMFavoritos.add(jSeparador3);

        jMIExibirFavoritos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIExibirFavoritos.setText("Mostrar favoritos");
        jMIExibirFavoritos.setToolTipText("Acessar favoritos");
        jMIExibirFavoritos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIExibirFavoritosActionPerformed(evt);
            }
        });
        jMFavoritos.add(jMIExibirFavoritos);

        jPopupMenu.add(jMFavoritos);
        jPopupMenu.add(jSeparador1);

        jMIModoPrivado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMIModoPrivado.setText("Modo privativo");
        jMIModoPrivado.setToolTipText("Navegar de forma privada");
        jPopupMenu.add(jMIModoPrivado);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Navegador");

        javax.swing.GroupLayout jPAba1Layout = new javax.swing.GroupLayout(jPAba1);
        jPAba1.setLayout(jPAba1Layout);
        jPAba1Layout.setHorizontalGroup(
            jPAba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        jPAba1Layout.setVerticalGroup(
            jPAba1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTPAbas.addTab("Aba", jPAba1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTPAbas.addTab("+", jPanel2);

        jBVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/voltar.png"))); // NOI18N
        jBVoltar.setToolTipText("Voltar uma página");

        jBAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/avancar.png"))); // NOI18N
        jBAvancar.setToolTipText("Avançar uma página");

        jPUrl.setBackground(new java.awt.Color(255, 255, 255));

        jTFUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFUrlActionPerformed(evt);
            }
        });

        jBBuscarUrl.setBackground(new java.awt.Color(255, 255, 255));
        jBBuscarUrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/busca_url.png"))); // NOI18N
        jBBuscarUrl.setToolTipText("Ir para endereço digitado");
        jBBuscarUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarUrlActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPUrlLayout = new javax.swing.GroupLayout(jPUrl);
        jPUrl.setLayout(jPUrlLayout);
        jPUrlLayout.setHorizontalGroup(
            jPUrlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUrlLayout.createSequentialGroup()
                .addComponent(jTFUrl)
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

        jBUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/user.png"))); // NOI18N

        jBMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/menu.png"))); // NOI18N
        jBMenu.setToolTipText("Abrir menu");
        jBMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMenuActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jBMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        jPNavegacaoLayout.setVerticalGroup(
            jPNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPNavegacaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPNavegacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pagina.setContentType(""); // NOI18N
        pagina.setToolTipText("");
        jScrollPane1.setViewportView(pagina);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPAbas)
            .addComponent(jPNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTPAbas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMenuActionPerformed
        //conferir com o professor se pode ser dessa forma
        jPopupMenu.show(jBMenu, WIDTH - 160, jBMenu.getY() + 27);
    }//GEN-LAST:event_jBMenuActionPerformed

    private void jBBuscarUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarUrlActionPerformed
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
            File file = new File("C:\\Users\\Lenon\\Desktop\\page.html");

            texto = nav.urlDown(url, file);
            //Imagem
            //Parser Texto
            ParseHtml p = new ParseHtml();
            imagens = p.linkImage(texto, titulo);
            Nos arvore = p.parseArvore(texto, null);
            rend.render(arvore, pagina);
            rend.renderTela(pagina, imagens);
        } catch (Exception e) {
        }


    }//GEN-LAST:event_jBBuscarUrlActionPerformed

    private void jTFUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFUrlActionPerformed

    private void jMIHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIHistoricoActionPerformed
        MenuHistorico historico = new MenuHistorico();
        historico.setVisible(true);
    }//GEN-LAST:event_jMIHistoricoActionPerformed

    private void jMIExibirFavoritosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIExibirFavoritosActionPerformed
        MenuFavoritos favoritos = new MenuFavoritos();
        favoritos.setVisible(true);
    }//GEN-LAST:event_jMIExibirFavoritosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaceGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaceGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaceGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaceGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaceGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAvancar;
    private javax.swing.JButton jBBuscarUrl;
    private javax.swing.JButton jBMenu;
    private javax.swing.JButton jBUser;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JMenu jMFavoritos;
    private javax.swing.JMenuItem jMIAddFavorito;
    private javax.swing.JMenuItem jMIExibirFavoritos;
    private javax.swing.JMenuItem jMIFav1;
    private javax.swing.JMenuItem jMIFav2;
    private javax.swing.JMenuItem jMIFav3;
    private javax.swing.JMenuItem jMIFav4;
    private javax.swing.JMenuItem jMIFav5;
    private javax.swing.JMenuItem jMIFavRecentes;
    private javax.swing.JMenuItem jMIHistorico;
    private javax.swing.JMenuItem jMIModoPrivado;
    private javax.swing.JPanel jPAba1;
    private javax.swing.JPanel jPNavegacao;
    private javax.swing.JPanel jPUrl;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparador1;
    private javax.swing.JPopupMenu.Separator jSeparador2;
    private javax.swing.JPopupMenu.Separator jSeparador3;
    private javax.swing.JTextField jTFUrl;
    private javax.swing.JTabbedPane jTPAbas;
    public javax.swing.JEditorPane pagina;
    // End of variables declaration//GEN-END:variables

    public void paintComponent(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
