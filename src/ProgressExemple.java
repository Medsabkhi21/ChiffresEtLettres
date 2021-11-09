//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressExemple extends Thread {
    JFrame f = new JFrame("Please wait");
    JProgressBar barre_progression = new JProgressBar();
    static final int MINIMUM = 0;
    static final int MAXIMUM = 100;

    public ProgressExemple() {
        this.f.add(this.barre_progression);
        this.barre_progression.setMinimum(0);
        this.barre_progression.setMaximum(100);
        JPanel pnl = new JPanel();
        pnl.add(this.barre_progression);
        this.f.setLocationRelativeTo((Component)null);
        this.f.setPreferredSize(new Dimension(250, 200));
        this.f.setTitle("Chargement");
        this.f.setResizable(false);
        this.f.setDefaultCloseOperation(3);
        this.f.setContentPane(pnl);
        this.f.pack();
        this.f.setVisible(true);

        for(int i = 0; i <= 100; ++i) {
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
        }

        Thread.currentThread().interrupt();
        this.f.setVisible(false);
    }

    public void updateBar(int newValue) {
        this.barre_progression.setValue(newValue);
    }
}
