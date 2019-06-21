/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lenon
 */
public class BotaoEvento implements ActionListener {
//    interfaceGrafica in = new interfaceGrafica("foda=se");

    public JButton botao;

    public void BotaoEvento(JEditorPane pagina, String text, JTextField jt, String href) {
        JFrame frame = new JFrame();
        JPanel p = new JPanel();
        JLabel j = new JLabel(text);
        j.setForeground(Color.blue);
        j.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                jt.setText(href);
            }

            @Override
            public void mousePressed(MouseEvent me) {

            }

            @Override
            public void mouseReleased(MouseEvent me) {

            }

            @Override
            public void mouseEntered(MouseEvent me) {

            }

            @Override
            public void mouseExited(MouseEvent me) {

            }

        });
        p.setBackground(Color.white);
        p.add(j);
        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 80);
        frame.setVisible(true);
        pagina.add(frame.getContentPane());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
