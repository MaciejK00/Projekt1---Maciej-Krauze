package com.company;

import javax.swing.*;

public class oknoGrafiki extends JFrame  {
    panelGrafiki panelGrafiki;
    public oknoGrafiki(){
        this.setResizable(false);
        this.setTitle("Grafika");
        panelGrafiki = new panelGrafiki();

        this.add(panelGrafiki);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        panelGrafiki.startWatek();
    }
}
