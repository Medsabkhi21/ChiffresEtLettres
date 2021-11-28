//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.naming.Name;
import javax.swing.*;

public  class ProgressExemple extends Thread {
    JFrame f;
    JProgressBar barre_progression;
    static final int MINIMUM = 0;
    static final int MAXIMUM = 150;
    JLabel gibName;
    public JTextField Namefield1,Namefield2;
    public JButton submitNames;
  public  Player p1,p2;


    public ProgressExemple() {

        gibName = new JLabel("donner Les noms des joueurs");

        JTextField Namefield1 = new JTextField("name player 1");
        JTextField   Namefield2 = new JTextField("name player 2");

        submitNames = new JButton("Submit");

        f = new JFrame("Players Names:");



        JPanel pnl = new JPanel();
        pnl.add(gibName);

        pnl.add(Namefield1);
        pnl.add(Namefield2);
        pnl.add(submitNames);
        f.setLocationRelativeTo((Component)null);
        f.setPreferredSize(new Dimension(250, 200));
        f.setTitle("Please wait");
        f.setResizable(false);

        f.setContentPane(pnl);
        f.pack();
        f.setVisible(true);



        submitNames.addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {

                                              p1 = new Player(Namefield1.getText());

                                              p2 = new Player(Namefield2.getText());

                                              ProgressionBar(pnl);
                                              f.revalidate();
                                              f.repaint();
                                              Thread.currentThread().interrupt();

                                              f.setVisible(false);
                                              new Controleur(p1,p2);



                                          }

                                      }
        );


    }
    public void  ProgressionBar(JPanel pnl) {
        barre_progression= new JProgressBar();

        barre_progression.setMinimum(0);
        barre_progression.setMaximum(100);
        pnl.add(barre_progression);

        f.setContentPane(pnl);
        f.setDefaultCloseOperation(1);

        for(int i = 0; i <= 30; ++i) {
            final int percent = i;

            try {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        ProgressExemple.this.updateBar(percent);
                    }
                });
                Thread.sleep(20L);
            } catch (InterruptedException var5) {
            }
}}

    public void updateBar(int newValue) {
        this.barre_progression.setValue(newValue);
    }
}
