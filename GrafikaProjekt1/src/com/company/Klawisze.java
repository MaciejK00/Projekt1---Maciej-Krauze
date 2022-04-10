package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Klawisze implements KeyListener {

    public boolean wcisniety;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int numer = e.getKeyCode();
        if(numer== KeyEvent.VK_SPACE) {
            wcisniety = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int numer = e.getKeyCode();
        if(numer== KeyEvent.VK_SPACE) {
            wcisniety = false;
        }

    }
}
