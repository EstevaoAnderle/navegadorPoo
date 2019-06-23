package view.customized;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;

/**
 * Classe que adiciona o botão para fechar nas abas.
 *
 * @author Estêvão Anderle, Lenon de Paula
 */
public class ButtonTabComponent extends JPanel {

    private final JTabbedPane pane;

    /**
     * Construtor do botão
     *
     * @param pane aba do navegador
     */
    public ButtonTabComponent(final JTabbedPane pane) {
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = pane;
        setOpaque(false);

        //Faz a JLabel ler o título do JTabbedPane
        JLabel label = new JLabel() {
            public String getText() {
                int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };

        add(label);
        //Adiciona mais espaço entre a label e o botão
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //Tab button
        JButton button = new TabButton();
        add(button);
        //Adiciona mais espaço para o topo do componente
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }

    /**
     * Define as características do botão "Fechar".
     */
    private class TabButton extends JButton implements ActionListener {

        public TabButton() {
            int size = 17;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("Fechar aba");
            //Faz o botão ser igual para todas as Laf's
            setUI(new BasicButtonUI());
            //Torna-o transparente
            setContentAreaFilled(false);
            //Não necessita de estar com focusable
            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            //Fazendo um efeito de rolagem
            //Usamos o mesmo listener para todos os botões
            addMouseListener(buttonMouseListener);
            setRolloverEnabled(true);
            //Fecha a guia apropriada, clicando no botão
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfTabComponent(ButtonTabComponent.this);
            if (i != -1) {
                pane.remove(i);
            }
        }

        /**
         * Utilizada para pintar o botão
         *
         * @param g
         */
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            //Mudança na imagem para botões pressionados
            if (getModel().isPressed()) {
                g2.translate(1, 1);
            }
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.BLACK);
            if (getModel().isRollover()) {
                g2.setColor(Color.RED);
            }
            int delta = 6;
            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
            g2.dispose();
        }
    }

    /**
     * Define os eventos de entrada e de saída do mouse.
     */
    private final static MouseListener buttonMouseListener = new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }

        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };
}
