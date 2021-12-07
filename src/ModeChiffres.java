import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import static java.lang.Math.floor;
import static java.lang.Math.round;

public class ModeChiffres extends JPanel {
    Player p1;
    Player p2;
    int tour;
    String p_name;
    JLabel label1, label2, WhosTour,Jsum, JTarget;
    JButton reinitialiser,valider;
    JPanel RandomNumbersPanel = new JPanel( new GridLayout(4, 4));
    double JtargetValue;
    String s0, s1, s2;
    JButton Jminus,Jplus,Jmult;
JPanel  PanelRight,PanelLeft;
int randomnb;
    public double GenerateRandomNumber(){return ( round(Math.random()*100));};

    public void UpdateRandomNumbersPanel(JPanel RandomNumbersPanel) {
        for (Component label : RandomNumbersPanel.getComponents()) {
           double number =GenerateRandomNumber();
           System.out.println("number generated:" + number);
            ((JButton) label).setText(String.valueOf(number));
            RandomNumbersPanel.add(Jplus);
            RandomNumbersPanel.add(Jminus);
            RandomNumbersPanel.add(Jmult);

        }

        RandomNumbersPanel.revalidate();
        RandomNumbersPanel.repaint();
    }

    JPanel GenerateRandomNumbersPanel(JPanel randomcharspanel) {
        for (int i = 0; i < 11; i++)
            randomcharspanel.add(
                    new JButton(String.valueOf(GenerateRandomNumber())));

        RandomNumbersPanel.add(Jplus);
        RandomNumbersPanel.add(Jminus);
    return randomcharspanel;
    }

    ModeChiffres(Player pl1,Player pl2){
        this.p1 = pl1;
        this.p2 =pl2;
        s0 = s1 = s2 = "";

        tour =1;
        p_name =p1.getName();
        Jplus = new JButton("+");
        Jminus = new JButton("-");
        Jmult= new JButton("*");


        label1 = new JLabel("Chiffres Et Lettres");
        label2 = new JLabel("Mode Chiffres");
        WhosTour = new JLabel("¨Tour du joueur: "+p_name);

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

       panel1.add(label1);
        panel2.add(label2);
        scoring.add(Jtour);
        scoring.add(new JLabel(""));
        scoring.add(labelp1);
        scoring.add(labelScore1);
        scoring.add(labelp2);
        scoring.add(labelScore2);

        JtargetValue=GenerateRandomNumber();
        JTarget=new JLabel(String.valueOf(JtargetValue));
        this.add("Target: ",JTarget);
        valider = new JButton("valider");
        reinitialiser = new JButton("Reinitialiser");

        pan0.add(WhosTour);

        RandomNumbersPanel=GenerateRandomNumbersPanel(RandomNumbersPanel);

        this.add(panel1);
        this.add(panel2);
        this.add(scoring);
       // this.add(RandomNumbersPanel);
        this.add(pan0);
        pan1.add(valider);
        pan1.add(reinitialiser);
       // this.add(RandomNumbersPanel);
     PanelRight = createRightPanel();
     PanelLeft = createLeftPanel();

    this.add(PanelRight);
    this.add(PanelLeft);

    this.add(pan1);
























        valider.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (floor(tour/2) == 3){
                    this.GameEnd();
                }

            //    Jsum=ResultofEssay();
                    if(tour % 2 == 1){
                        p1.storeScore(p1.calculateScoreN(Integer.parseInt(Jsum.getText()),Integer.parseInt((JTarget.getText()))));
                        p_name=p2.Name;
                        labelScore1.setText(Double.toString(p1.getScore()));
                        scoring.revalidate();
                        scoring.repaint();
                        tour++;
                        Jtour.setText("Tour Number:"+floor(tour/2));
                        UpdateRandomNumbersPanel(RandomNumbersPanel);

                    }
                    else{
                        p2.storeScore(p2.calculateScoreN(Integer.parseInt(Jsum.getText()),Integer.parseInt((JTarget.getText()))));
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


    public JPanel createLeftPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        for (int index = 0; index < 11; index++) {
            randomnb= (int)GenerateRandomNumber();
            JButton btn = new JButton(String.valueOf(randomnb));
            panel.add(btn, gbc);
            btn.setTransferHandler(new ValueExportTransferHandler(String.valueOf(randomnb)));

            btn.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                    TransferHandler handle = button.getTransferHandler();
                    handle.exportAsDrag(button, e, TransferHandler.COPY);
                }
            });
        }

        panel.add(Jplus);
        Jplus.setTransferHandler(new ValueExportTransferHandler("+"));
        Jmult.setTransferHandler(new ValueExportTransferHandler("-"));
        Jminus.setTransferHandler(new ValueExportTransferHandler("*"));
        panel.add(Jmult);
        panel.add(Jminus);
        Jplus.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                TransferHandler handle = button.getTransferHandler();
                handle.exportAsDrag(button, e, TransferHandler.COPY);
            }
        });
        Jminus.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                TransferHandler handle = button.getTransferHandler();
                handle.exportAsDrag(button, e, TransferHandler.COPY);
            }
        });
        Jmult.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                TransferHandler handle = button.getTransferHandler();
                handle.exportAsDrag(button, e, TransferHandler.COPY);
            }
        });

        return panel;
    }

    protected JPanel createRightPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("Drop in");
        label.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY), new EmptyBorder(20, 20, 20, 20)));
        label.setTransferHandler(new ValueImportTransferHandler());
        panel.add(label);
        return panel;
    }

}

class ValueExportTransferHandler extends TransferHandler {

    public  final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;
    private String value;

    public ValueExportTransferHandler(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int getSourceActions(JComponent c) {
        return DnDConstants.ACTION_COPY_OR_MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        Transferable t = new StringSelection(getValue());
        return t;
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action) {
        super.exportDone(source, data, action);
        System.out.println(data);
        System.out.println(source.getTransferHandler());
        System.out.println(value);// Decide what to do after the drop has been accepted
    }

}

class ValueImportTransferHandler extends TransferHandler {

    public static final DataFlavor SUPPORTED_DATE_FLAVOR = DataFlavor.stringFlavor;

    public ValueImportTransferHandler() {
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        return support.isDataFlavorSupported(SUPPORTED_DATE_FLAVOR);
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport support) {
        boolean accept = false;
        if (canImport(support)) {
            try {
                Transferable t = support.getTransferable();
                Object value = t.getTransferData(SUPPORTED_DATE_FLAVOR);
                if (value instanceof String) {
                    Component component = support.getComponent();
                    if (component instanceof JLabel) {
                        ((JLabel) component).setText(value.toString());
                        accept = true;
                    }
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
        return accept;
    }
}

