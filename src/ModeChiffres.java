import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Math.floor;

public class ModeChiffres extends JPanel{
    Player p1;
    Player p2;
    int tour;
    String p_name;
    JLabel label1, label2, WhosTour;
    JButton reinitialiser,valider;

   public int GenerateRandomNumber(){return ((int) Math.random()*100);};

    public void UpdateRandomNumbersPanel(JPanel RandomNumbersPanel) {
        for (Component label : RandomNumbersPanel.getComponents()) {
           int number =GenerateRandomNumber();
            ((JButton) label).setText(String.valueOf(number));

        }
    }

    void GenerateRandomNumbersPanel(JPanel randomcharspanel) {
        for (int i = 0; i < 11; i++)
            randomcharspanel.add(
                    new JButton(String.valueOf(GenerateRandomNumber())));

    }

    ModeChiffres(Player pl1,Player pl2){
        this.p1 = pl1;
        this.p2 =pl2;

        tour =1;
        p_name =p1.getName();

        Font fontTitre1 = new Font("Times new roman", Font.BOLD, 48);
        Font fontTitre2 = new Font("Times new roman", Font.BOLD, 18);
        Font fontTitre3 = new Font("Times new roman", Font.BOLD, 20);
        label1 = new JLabel("Chiffres Et Lettres");
        label1.setFont(fontTitre1);
        label2 = new JLabel("Mode Chiffres");
        WhosTour = new JLabel("¨Tour du joueur: "+p_name);
        label2.setFont(fontTitre2);
        label2.setForeground(new Color(128, 0, 120, 0));

        JLabel labelp1 = new JLabel(p1.Name);
        JLabel labelp2 = new JLabel(p2.Name);

        JLabel labelScore1 = new JLabel(Double.toString(p1.getScore()));
        JLabel labelScore2 = new JLabel(Double.toString(p2.getScore()));

        JLabel Jtour = new JLabel("Tour Number:"+floor(tour/2));



        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 3));
        JPanel scoring = new JPanel( new GridLayout(3, 1));

        JPanel pan0 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        Barre barre = new Barre();
        this.add(barre);
        panel1.add(label1);
        panel2.add(label2);
        scoring.add(Jtour);
        scoring.add(new JLabel(""));
        scoring.add(labelp1);
        scoring.add(labelScore1);
        scoring.add(labelp2);
        scoring.add(labelScore2);

        valider = new JButton("valider");
        reinitialiser = new JButton("Reinitialiser");

        pan0.add(WhosTour);
        JPanel RandomNumbersPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        GenerateRandomNumbersPanel(RandomNumbersPanel);

        this.add(panel1);
        this.add(panel2);
        this.add(scoring);

        this.add(pan0);





        JTextField field1 = new JTextField("enter word here");
        pan1.add(field1);
        pan1.add(valider);
        pan1.add(reinitialiser);
        this.add(RandomNumbersPanel);
        this.add(pan1);


        valider.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (floor(tour/2) == 3){
                    this.GameEnd();
                }


                    if(tour % 2 == 1){
                        p1.storeScore(p1.calculateScore(field1.getText().toUpperCase(),RandomNumbersPanel));
                        p_name=p2.Name;
                        labelScore1.setText(Double.toString(p1.getScore()));
                        scoring.revalidate();
                        scoring.repaint();
                        tour++;
                        Jtour.setText("Tour Number:"+floor(tour/2));
                        UpdateRandomNumbersPanel(RandomNumbersPanel);

                    }
                    else{
                        p2.storeScore((p2).calculateScore(field1.getText().toUpperCase(),RandomNumbersPanel));
                        labelScore2.setText(Double.toString(p2.getScore()));

                        p_name = p1.Name;
                        scoring.revalidate();
                        scoring.repaint();
                        tour++;
                        Jtour.setText("Tour Number:"+floor(tour/2));
                        UpdateRandomNumbersPanel(RandomNumbersPanel);
                    }
                }




            private void GameEnd() {
                String winner;

                float s1=Float.parseFloat(labelScore1.getText());
                float s2=Float.parseFloat(labelScore2.getText());

                if(s1>s2)
                    winner = p1.getName();
                else if (s1<s2)
                    winner =p2.getName();
                else
                    winner ="players! it's a draw";

                JOptionPane.showMessageDialog(null, "Game Finished!\n Congrats "+winner);


            }
        });

        reinitialiser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("RAZ");
                p1= p1.RAZscore();
                System.out.println("scoreee"+p1.getScore());
                p2= p2.RAZscore();
                tour =0;
                Jtour.setText("Tour Number:"+floor(tour/2));
                labelScore1.setText(Double.toString(p1.getScore()));
                labelScore2.setText(Double.toString(p2.getScore()));


            }
        });
    }

}
