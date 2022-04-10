package com.company;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class oknoGry extends JFrame implements MouseListener {
    Panel panel;
    public oknoGry() {
        this.setResizable(false);
        this.setTitle("Gra");
        panel = new Panel();
        this.addMouseListener(this);
        this.add(panel);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        panel.startWatek();
    }





    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(panel.koniec) {
            if (e.getButton() == MouseEvent.BUTTON1) {


                this.remove(panel);
                panel = new Panel();
                panel.setFocusable(true);
                this.add(panel);
                panel.requestFocusInWindow();
                this.pack();
                panel.startWatek();
                SwingUtilities.updateComponentTreeUI(this);
            }
        }

    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
