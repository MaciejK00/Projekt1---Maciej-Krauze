package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Panel extends JPanel implements Runnable {
    final int rozmiar = 16;
    final int skala = 3;
    final int rS = rozmiar * skala;
    final int maxScreenK = 16;
    final int maxScreenW = 12;
    public final int szerokosc = rS * maxScreenK;
    public final int wysokosc = rS * maxScreenW;

    private final int czas=80;

    private int aktCzas=0;

    int FPS = 60;
    Klawisze klawisze = new Klawisze();
    Thread watek;

    Rectangle ptak;
    int ptakX =100;
    int ptakY =100;



    BufferedImage ptak2;
    BufferedImage tlo;
    BufferedImage ptakA;
    BufferedImage ptakFIn = null;

    ArrayList<Rectangle> tuby= new ArrayList<>();

    Random random;
    int licznik=0;

   public boolean koniec;
    public double punkty=0;

    public Panel() {

        this.setPreferredSize(new Dimension(szerokosc,wysokosc));
        this.setDoubleBuffered(true);
        this.addKeyListener(klawisze);
        this.setFocusable(true);
        random = new Random();
        ptak = new Rectangle();
        koniec=false;

        try {
            ptak2 = ImageIO.read(new File("grafika/ptak.png"));
            ptakA = ImageIO.read(new File("grafika/ptak2POPRAWA.png"));
            tlo = ImageIO.read(new File("grafika/tlo.png"));
            ptakFIn=ptak2;

        }catch (IOException ignored) {
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

       if(!koniec) {
           ptakY += 5;
           if (klawisze.wcisniety) {
               ptakY -= 15;
           }
           licznik++;

           aktCzas++;
           if (aktCzas == czas) {
               aktCzas = 0;
               int wys = random.nextInt(wysokosc - 150);
               int y = wys + 150;
               int wys2 = wysokosc - y;

               tuby.add(new Rectangle(szerokosc, 0, 50, wys));
               tuby.add(new Rectangle(szerokosc, y, 50, wys2));
           }
           for (int i = 0; i < tuby.size(); i++) {
               Rectangle tub = tuby.get(i);
               tub.x -= 5;

               if (tub.x + tub.width <= 0) {
                   tuby.remove(i--);
               }
           }
           for (int j = 0; j < tuby.size(); j++) {
               if (ptak.intersects(tuby.get(j)) || ptak.getY() <= 0 || ptak.getY() >= wysokosc) {


                   koniec = true;

               }
           }
           for (int i = 0; i < tuby.size(); i++) {
               if (tuby.get(i).getX() + tuby.get(i).getWidth() == 98) {
                   punkty += 0.5;
               }
           }
           if (licznik > 15) {
               if (ptakFIn == ptak2)
                   ptakFIn = ptakA;
               else if (ptakFIn == ptakA)
                   ptakFIn = ptak2;
               licznik = 0;
           }
       }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        g.drawImage(tlo,0,0,szerokosc,wysokosc,this);
        g2d.drawImage(ptakFIn,ptakX,ptakY,rS,rS,this);

        ptak = new Rectangle(ptakX+10,ptakY+15,rS-25,rS-30);


        for (int i = 0; i < tuby.size() ; i++) {
            g2d.setColor(Color.RED);
            Rectangle tuba = tuby.get(i);
            g2d.fillRect(tuba.x,tuba.y,tuba.width,tuba.height);

        }
        g2d.setFont(new Font("czcionka",Font.BOLD,25));
        g2d.setColor(Color.black);
        int pom = (int) punkty;
        g2d.drawString("Punkty: "+pom,20,20);

        if(koniec){
            g2d.setFont(new Font("koniec",Font.BOLD,50));
            g2d.setColor(Color.black);
            g2d.drawString("GAME OVER",szerokosc/2-185,wysokosc/2-150);
            g2d.drawString("Punkty: "+pom,szerokosc/2-150,wysokosc/2);
            g2d.setFont(new Font("koniec",Font.BOLD,30));
            g2d.drawString("KLIKNIJ LPM ABY ZAGRAC PONOWNIE",szerokosc/2-300,wysokosc/2+150);

        }

        g2d.dispose();
    }




}
