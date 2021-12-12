//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public  class ProgressExemple extends Thread {
    JFrame f;
    JLabel gibName;
    public JTextField Namefield1,Namefield2;
    public JButton submitNames;
  public  Player p1,p2;


    public ProgressExemple() {
        //creating attributes needed for players names submition
        gibName = new JLabel("donner Les noms des joueurs");
        Namefield1 = new JTextField("nom player 1");
        Namefield2 = new JTextField("nom player 2");
        submitNames = new JButton("Submit");
        f = new JFrame("Players Names:");
        JPanel pnl = new JPanel();

        //adding giName, Namefield1&2, submitNamesBtn to Jpanel
        pnl.add(gibName);
        pnl.add(Namefield1);
        pnl.add(Namefield2);
        pnl.add(submitNames);

        //setting frame sizes and location
        f.setLocationRelativeTo((Component)null);
        f.setPreferredSize(new Dimension(250, 200));
        f.setTitle("Please wait");
        f.setResizable(false);

        f.setContentPane(pnl);
        f.pack();
        f.setVisible(true);


        //listening to submitNames and sending players names to controleur class

        submitNames.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {

                                              p1 = new Player(Namefield1.getText());

                                              p2 = new Player(Namefield2.getText());

                                              f.revalidate();
                                              f.repaint();
                                              Thread.currentThread().interrupt();
                                              //interrupting the current thread.
                                              f.setVisible(false);
                                              new Controleur(p1,p2);



                                          }

                                      }
        );


    }

}

