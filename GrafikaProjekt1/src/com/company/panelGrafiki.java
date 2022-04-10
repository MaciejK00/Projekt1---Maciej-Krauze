package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class panelGrafiki extends JPanel implements Runnable, MouseListener {
    int FPS = 60;
    Thread watek;

    public final int szerokosc = 770;
    public final int wysokosc = 575;
    Color brown = new Color(120, 68, 1);
    Color green = new Color(2, 170, 0);
    Color green2 = new Color(2, 70, 0);
    Color przezroczysty = new Color(0,0,0,1);
    Rectangle kolo;
    Rectangle komin;
    Rectangle chmura;
    Rectangle drzewo;

    BufferedImage dymek;
    BufferedImage dymek2;
    BufferedImage piorunPNG;
    BufferedImage ogien1;

    BufferedImage dymekFIN= null;

    int licznik=0;
    int licznik2=0;
    int deszczSpada=0;
    int liczKlik=0;


    boolean dymekON=true;
    boolean dzien = true;
    boolean deszcz = false;
    boolean piorun=false;

    public panelGrafiki() {
        this.setPreferredSize(new Dimension(szerokosc,wysokosc));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addMouseListener(this);

        if(dymekON) {
            try {
                dymek = ImageIO.read(new File("grafika/dymek.png"));
                dymek2 = ImageIO.read(new File("grafika/dymek2.png"));
                piorunPNG = ImageIO.read(new File("grafika/piorun.png"));
                ogien1 = ImageIO.read(new File("grafika/ogien1.png"));
                dymekFIN = dymek2;
            } catch (IOException ignored) {
            }
        }
    }
    public void startWatek(){
        watek = new Thread(this);
        watek.start();
    }

    @Override
    public void run() {
        double rysujI = 1000000000/FPS;
        double czasX = System.nanoTime()+ rysujI;

        while(watek != null){
            update();
            repaint();
            try {
                double pozostaly = czasX-System.nanoTime();
                pozostaly = pozostaly/1000000;
                if(pozostaly < 0 ){
                    pozostaly=0;
                }
                Thread.sleep( (long) pozostaly);
                czasX += rysujI;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        licznik++;
        if (dymekON) {
            if (licznik > 35) {
                if (dymekFIN == dymek2) {
                    dymekFIN = dymek;
                } else if (dymekFIN == dymek) {
                    dymekFIN = dymek2;
                }

                licznik = 0;
            }
        }
        if(deszcz){
            deszczSpada+=3;
            if(82+deszczSpada>100){
                deszczSpada=0;
            }
        }
        if(piorun){
            licznik2++;
            if(licznik2>50){
                piorun = false;
                licznik2=0;
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if(dzien) {
            g2d.setColor(Color.cyan);
        }
        else{
            g2d.setColor(Color.black);
        }
        g2d.fillRect(0, 0, 770, 450);

        g2d.setColor(green);
        g2d.fillRect(0,450,350,575);

        g2d.setColor(brown);
        g2d.fillRect(350,450,420,575);

        g2d.setColor(green);
        g2d.fillRect(420,450,770,575);

        g2d.setColor(Color.red);
        g2d.fillRect(260,250,250,200);

        g2d.setColor(Color.black);
        g2d.fillRect(365,375,40,75);

        g2d.setColor(Color.GRAY);
        g2d.fillRect(270,175,20,55);

        g2d.setColor(przezroczysty);
        komin = new Rectangle(270,175,20,55);

        g2d.setColor(brown);
        g2d.fillPolygon(new int[]{250,390,520},new int[]{250,100,250}, 3);

        if(dzien) g2d.setColor(Color.WHITE);
        else g2d.setColor(Color.YELLOW);

        g2d.fillRect(270,270,40,75);
        g2d.fillRect(460,270,40,75);
        g2d.fillRect(360,280,50,40);

        g2d.drawImage(dymekFIN,243,105,75,75,this);

        if(dzien) g2d.setColor(Color.yellow);
        else g2d.setColor(Color.WHITE);
        g2d.fillOval(700,40,50,50);

        kolo = new Rectangle(702,45,46,40);

        if(dzien) g2d.setColor(Color.white);
        else g2d.setColor(Color.DARK_GRAY);
        g2d.fillOval(75,40,40,40);
        g2d.fillOval(100,40,40,40);
        g2d.fillOval(125,40,40,40);
        g2d.fillOval(150,40,40,40);

        g2d.fillOval(87,30,40,40);
        g2d.fillOval(112,30,40,40);
        g2d.fillOval(137,30,40,40);

        g2d.fillOval(105,15,30,30);
        g2d.fillOval(128,15,30,30);

        chmura = new Rectangle(75,15,115,65);

        if(deszcz){
            g2d.setColor(Color.BLUE);
            g2d.drawLine(80,82+deszczSpada,80,85+deszczSpada);
            g2d.drawLine(90,82+deszczSpada,90,85+deszczSpada);
            g2d.drawLine(100,82+deszczSpada,100,85+deszczSpada);
            g2d.drawLine(110,82+deszczSpada,110,85+deszczSpada);
            g2d.drawLine(120,82+deszczSpada,120,85+deszczSpada);
            g2d.drawLine(130,82+deszczSpada,130,85+deszczSpada);
            g2d.drawLine(140,82+deszczSpada,140,85+deszczSpada);
            g2d.drawLine(150,82+deszczSpada,150,85+deszczSpada);
            g2d.drawLine(160,82+deszczSpada,160,85+deszczSpada);
            g2d.drawLine(170,82+deszczSpada,170,85+deszczSpada);
            g2d.drawLine(180,82+deszczSpada,180,85+deszczSpada);


            g2d.drawLine(85,92+deszczSpada,85,95+deszczSpada);
            g2d.drawLine(95,92+deszczSpada,95,95+deszczSpada);
            g2d.drawLine(105,92+deszczSpada,105,95+deszczSpada);
            g2d.drawLine(115,92+deszczSpada,115,95+deszczSpada);
            g2d.drawLine(125,92+deszczSpada,125,95+deszczSpada);
            g2d.drawLine(135,92+deszczSpada,135,95+deszczSpada);
            g2d.drawLine(145,92+deszczSpada,145,95+deszczSpada);
            g2d.drawLine(155,92+deszczSpada,155,95+deszczSpada);
            g2d.drawLine(165,92+deszczSpada,165,95+deszczSpada);
            g2d.drawLine(175,92+deszczSpada,175,95+deszczSpada);
        }

        g2d.setColor(brown);
        g2d.fillRect(135,400,8,75);

        g2d.setColor(green2);

        g2d.fillOval(107,340,70,70);
        drzewo = new Rectangle(107,340,70,70);

        if(piorun){
            g2d.drawImage(piorunPNG,110,85,100,150,this);
            g2d.drawImage(ogien1,120,300,50,50,this);

        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(kolo.contains(e.getPoint())){
            if(dzien) dzien=false;
            else dzien =true;
        }
        if(komin.contains(e.getPoint())){
            if(dymekON) {
                dymekON=false;
                dymekFIN=null;
            }
            else{
                dymekON =true;
                dymekFIN=dymek2;
            }
        }
        if(chmura.contains(e.getPoint())){
            if(!deszcz) deszcz=true;
            else deszcz =false;

        }

        if(drzewo.contains(e.getPoint())){
            if(deszcz) {
                liczKlik++;
                if(liczKlik==3) {
                    piorun = true;
                    liczKlik=0;
                }
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
