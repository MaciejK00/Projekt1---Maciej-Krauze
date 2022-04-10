package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame implements ActionListener {
    private final JFrame okno;
    private final JButton przycisk1;
    private final JButton przycisk3;
    private final JButton przycisk4;

    private final JPanel panel1;
    JLabel pomoc;
    JLabel pomoc2;


    public Okno() {
        okno = new JFrame("Projekt 1 - Maciej Krauze");
        okno.setLayout( new GridLayout(2,1));
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setSize(500, 500);
        okno.setLocationRelativeTo(null);

        GridBagConstraints skala = new GridBagConstraints();

        panel1 = new JPanel();

        panel1.setLayout(new GridBagLayout());

        przycisk1 = new JButton("Lab3");
        skala.gridx=0;
        skala.gridy=5;
        panel1.add(przycisk1,skala);
        przycisk1.addActionListener(this);

        pomoc = new JLabel("    ");
        skala.gridx=0;
        skala.gridy=2;
        panel1.add(pomoc,skala);

        przycisk3 = new JButton("Lab1");
        skala.gridx=0;
        skala.gridy=0;
        panel1.add(przycisk3,skala);
        przycisk3.addActionListener(this);

        pomoc2 = new JLabel("    ");
        skala.gridx=0;
        skala.gridy=4;
        panel1.add(pomoc2,skala);

        przycisk4 = new JButton("Lab2");
        skala.gridx=0;
        skala.gridy=3;
        panel1.add(przycisk4,skala);
        przycisk4.addActionListener(this);



        okno.setContentPane(panel1);
        okno.getContentPane().setBackground(new Color(45,45,45));
        okno.setVisible(true);
        okno.setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==przycisk1){
            KrzyweBeziera MK = new KrzyweBeziera();
            int x=100;

            int[] Mx = new int[]{x+50,x+37,x+37,x+25};
            int[] My = new int[]{600-70,620-70,620-70,600-70};

            int[] Mx2 = new int[]{x+25,x+12,x+12,x+25};
            int[] My2 = new int[]{600-70,525-70,525-70,400-70};

            int[] Mx3 = new int[]{x+25,x+90,x+90,x+100};
            int[] My3 = new int[]{400-70,500-70,500-70,550-70};

            int[] Mx4 = new int[]{x+100,x+90,x+190,x+175};
            int[] My4 = new int[]{550-70,500-70,500-70,400-70};

            int[] Mx5 = new int[]{x+175,x+160,x+160,x+175};
            int[] My5 = new int[]{400-70,520-70,520-70,600-70};

            int[] Mx6 = new int[]{x+175,x+162,x+162,x+150};
            int[] My6 = new int[]{600-70,580-70,580-70,600-70};

            int[] Mx7 = new int[]{x+150,x+125,x+125,x+150};
            int[] My7 = new int[]{600-70,550-70,550-70,500-70};

            int[] Mx8 = new int[]{x+150,x+135,x+135,x+100};
            int[] My8 = new int[]{500-70,540-70,540-70,580-70};

            int[] Mx9 = new int[]{x+100,x+60,x+60,x+50};
            int[] My9 = new int[]{580-70,540-70,540-70,500-70};

            int[] Mx10 = new int[]{x+50,x+40,x+40,x+50};
            int[] My10 = new int[]{500-70,560-70,560-70,600-70};

            int[] Kx = new int[]{320,320,350,350};
            int[] Ky = new int[]{300,300,300,300};

            int[] Kx2 = new int[]{350,325,325,350};
            int[] Ky2 = new int[]{300,300,400,400};

            int[] Kx3 = new int[]{350,350,400,450};
            int[] Ky3 = new int[]{400,400,375,320};

            int[] Kx4 = new int[]{450,450,460,460};
            int[] Ky4 = new int[]{320,320,355,355};

            int[] Kx5 = new int[]{460,460,350,350};
            int[] Ky5 = new int[]{355,355,440,440};

            int[] Kx6 = new int[]{350,350,470,470};
            int[] Ky6 = new int[]{440,440,560,485};

            int[] Kx7 = new int[]{470,470,450,450};
            int[] Ky7 = new int[]{485,485,510,510};

            int[] Kx8 = new int[]{450,450,350,350};
            int[] Ky8 = new int[]{510,510,470,470};

            int[] Kx9 = new int[]{350,350,350,350};
            int[] Ky9 = new int[]{470,470,520,520};

            int[] Kx10 = new int[]{350,350,320,320};
            int[] Ky10 = new int[]{520,520,520,520};

            int[] Kx11 = new int[]{320,300,300,320};
            int[] Ky11 = new int[]{520,520,300,300};

            MK.bezier(Mx,My);
            MK.bezier(Mx2,My2);
            MK.bezier(Mx3,My3);
            MK.bezier(Mx4,My4);
            MK.bezier(Mx5,My5);
            MK.bezier(Mx6,My6);
            MK.bezier(Mx7,My7);
            MK.bezier(Mx8,My8);
            MK.bezier(Mx9,My9);
            MK.bezier(Mx10,My10);

            MK.bezier(Kx,Ky);
            MK.bezier(Kx2,Ky2);
            MK.bezier(Kx3,Ky3);
            MK.bezier(Kx4,Ky4);
            MK.bezier(Kx5,Ky5);
            MK.bezier(Kx6,Ky6);
            MK.bezier(Kx7,Ky7);
            MK.bezier(Kx8,Ky8);
            MK.bezier(Kx9,Ky9);
            MK.bezier(Kx10,Ky10);
            MK.bezier(Kx11,Ky11);
        }
        else if(e.getSource() == przycisk4){
            try {
                new oknoGry();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource() == przycisk3){
            try {
                new oknoGrafiki();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
