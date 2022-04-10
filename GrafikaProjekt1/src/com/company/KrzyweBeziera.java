package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class KrzyweBeziera extends JFrame {
    Shape kropki;
    Shape punkty;
    public void bezier(int[] x, int[] y) {
        JComponent odcinek= new JComponent() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                for (double i = 0; i < 1; i += 0.001) {
                    double xt = Math.pow(1 - i, 3) * x[0] + 3 * i * Math.pow(1 - i, 2) * x[1] + 3 * Math.pow(i, 2) * (1 - i) * x[2] + Math.pow(i, 3) * x[3];
                    double yt = Math.pow(1 - i, 3) * y[0] + 3 * i * Math.pow(1 - i, 2) * y[1] + 3 * Math.pow(i, 2) * (1 - i) * y[2] + Math.pow(i, 3) * y[3];
                    kropki = new Line2D.Double(xt, yt, xt, yt);
                    g2.draw(kropki);
                }
                for (int i = 0; i < 4; i++) {
                    punkty = new Line2D.Double(x[i],y[i],x[i],y[i]);
                    g2.draw(punkty);
                }
            }
        };
        this.add(odcinek);
        this.setSize(700, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
