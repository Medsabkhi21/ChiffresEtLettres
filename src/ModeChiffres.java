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
import java.util.ArrayList;
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
    double JtargetValue;
    ArrayList<String> s0;
    JButton Jminus,Jplus,Jmult;
JPanel  PanelRight,PanelLeft;
    JLabel labelScore1, labelScore2;
int randomnb;
    public double GenerateRandomNumber(){return ( round(Math.random()*100));};


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



    public JPanel createLeftPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        s0 = new ArrayList<String>(3);
        for (int index = 0; index < 11; index++) {
            randomnb= (int)GenerateRandomNumber();
            JButton btn = new JButton(String.valueOf(randomnb));
            panel.add(btn, gbc);
            btn.setTransferHandler(new ValueExportTransferHandler(String.valueOf(randomnb)));

            btn.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    JButton button = (JButton) e.getSource();
                   s0.add(button.getText());
                    TransferHandler handle = button.getTransferHandler();
                    handle.exportAsDrag(button, e, TransferHandler.COPY);
                }
            });
        }

        Jplus.setTransferHandler(new ValueExportTransferHandler("+"));
        Jmult.setTransferHandler(new ValueExportTransferHandler("-"));
        Jminus.setTransferHandler(new ValueExportTransferHandler("*"));

               panel.add(Jmult);
        panel.add(Jplus);
        panel.add(Jminus);
        return panel;
    }

    double  ResultofEssay(ArrayList<String> s0) {
        double n1 = Double.parseDouble(s0.get(0));
        double n2 = Double.parseDouble(s0.get(2));
        String op = s0.get(1);
        double r = 0;
        switch (op) {
            case "+":
                r =n1 + n2;
                break;
            case "-":
                r= n1 - n2;
                break;
            case "*":
                r= n1 * n2;
                break;

        }
        return r;
    }

    protected JPanel createRightPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel label = new JLabel("Drop in");
        label.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY), new EmptyBorder(20, 20, 20, 20)));
        label.setTransferHandler(new ValueImportTransferHandler());
        panel.add(label);

        return panel;
    }


    ModeChiffres(Player pl1,Player pl2){
        this.p1 = pl1;
        this.p2 =pl2;


        tour =0;
        p_name =p1.getName();
        Jplus = new JButton("+");
        Jminus = new JButton("-");
        Jmult= new JButton("*");


        label1 = new JLabel("Chiffres Et Lettres");
        label2 = new JLabel("Mode Chiffres");
        WhosTour = new JLabel("¨Tour du joueur: "+p_name);

        JLabel labelp1 = new JLabel(p1.Name);
        JLabel labelp2 = new JLabel(p2.Name);

         labelScore1 = new JLabel(Double.toString(p1.getScore()));
         labelScore2 = new JLabel(Double.toString(p2.getScore()));

        JLabel Jtour = new JLabel("Tour Number:"+floor(tour/2));
        Jsum= new JLabel("result score: ");


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
        System.out.println("targett::"+JTarget.getText());
        valider = new JButton("valider");
        reinitialiser = new JButton("Reinitialiser");

        pan0.add(WhosTour);
        pan0.add(Jsum);

        this.add(panel1);
        this.add(panel2);
        this.add(scoring);
        this.add(pan0);
        pan1.add(valider);
        pan1.add(reinitialiser);
     PanelRight = createRightPanel();
     PanelLeft = createLeftPanel();


    this.add(PanelRight);
    this.add(PanelLeft);

    this.add(pan1);



        Jplus.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                s0.add(button.getText());

                TransferHandler handle = button.getTransferHandler();
                handle.exportAsDrag(button, e, TransferHandler.COPY);
            }
        });
        Jminus.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                s0.add(button.getText());

                TransferHandler handle = button.getTransferHandler();
                handle.exportAsDrag(button, e, TransferHandler.COPY);
            }
        });
        Jmult.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                s0.add(button.getText());

                TransferHandler handle = button.getTransferHandler();
                handle.exportAsDrag(button, e, TransferHandler.COPY);

            }
        });


        valider.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(s0);
                if (floor(tour/2) == 3){
                    GameEnd();
                }



                double result =ResultofEssay(s0);
                System.out.println("result"+result);
                Jsum.setText("Result score:"+ String.valueOf(result));
System.out.println("tour::"+tour);
                    if(tour % 2 == 1){

                        p1.storeScore(p1.calculateScoreN(result,Double.parseDouble(JTarget.getText())));
                        p_name=p2.Name;
                        labelScore1.setText(Double.toString(p1.getScore()));
                        scoring.revalidate();
                        scoring.repaint();
                        tour++;
                        WhosTour.setText("Tour du joueur: "+p_name);

                        Jtour.setText("Tour Number:"+floor(tour/2));

                        s0=new ArrayList<String>(3);

                    }
                    else{
                        p2.storeScore(p2.calculateScoreN(result,Double.parseDouble(JTarget.getText())));
                        labelScore2.setText(Double.toString(p2.getScore()));

                        p_name = p1.Name;
                        scoring.revalidate();
                        scoring.repaint();
                        tour++;
                        Jtour.setText("Tour Number:"+floor(tour/2));
                        WhosTour.setText("Tour du joueur: "+p_name);


                        s0=new ArrayList<String>(3);

                    }
                }



        });

        reinitialiser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelLeft= createLeftPanel();

                System.out.println("RAZ");
                p1= p1.RAZscore();
                System.out.println("scoreee"+p1.getScore());
                p2= p2.RAZscore();
                tour =0;
                Jtour.setText("Tour Number:"+floor(tour/2));
                labelScore1.setText(Double.toString(p1.getScore()));
                labelScore2.setText(Double.toString(p2.getScore()));
                s0=new ArrayList<String>(3);

            }
        });
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
    // Decide what to do after the drop has been accepted
    }

}

class ValueImportTransferHandler extends TransferHandler {
    public String test;
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
                         test += value.toString();
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

