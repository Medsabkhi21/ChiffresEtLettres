/*
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

import static java.lang.Math.round;

public class DragnDrop extends JPanel {

    JButton testing;

    public double GenerateRandomNumber(){return ( round(Math.random()*100));};

    public DragnDrop() {
        this.setLayout(new GridLayout(1, 4));
        this.add(createLeftPanel());
        this.add(createRightPanel());


    }
            public JPanel createLeftPanel() {
                JPanel panel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.weightx = 1;

                for (int index = 0; index < 11; index++) {
                    JButton btn = new JButton(String.valueOf(GenerateRandomNumber()));
                    panel.add(btn, gbc);
                    btn.setTransferHandler(new ValueExportTransferHandler(Integer.toString(index + 1)));

                    btn.addMouseMotionListener(new MouseAdapter() {
                        @Override
                        public void mouseDragged(MouseEvent e) {
                            JButton button = (JButton) e.getSource();
                            TransferHandler handle = button.getTransferHandler();
                            handle.exportAsDrag(button, e, TransferHandler.COPY);
                        }
                    });
                }
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
                // Decide what to do after the drop has been accepted
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
        }*/

// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {
    // create a frame
    static JFrame f;

    // create a textfield
    static JTextField l;

    // store operator and operands
    String s0, s1, s2;

    // default constructor
    calculator()
    {
        s0 = s1 = s2 = "";
    }

    // main function
    public static void main(String args[])
    {
        // create a frame
        f = new JFrame("calculator");

        try {
            // set look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // create a object of class
        calculator c = new calculator();

        // create a textfield
        l = new JTextField(16);

        // set the textfield to non editable
        l.setEditable(false);

        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

        // create number buttons
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");

        // equals button
        beq1 = new JButton("=");

        // create operator buttons
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        beq = new JButton("C");

        // create . button
        be = new JButton(".");

        // create a panel
        JPanel p = new JPanel();

        // add action listeners
        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);

        // add elements to panel
        p.add(l);
        p.add(ba);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bs);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bm);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bd);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);

        // set Background of panel
        p.setBackground(Color.blue);

        // add panel to frame
        f.add(p);

        f.setSize(200, 220);
        f.show();
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();

        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            // set the value of text
            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";

            // set the value of text
            l.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == '=') {

            double te;

            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            // set the value of text
            l.setText(s0 + s1 + s2 + "=" + te);

            // convert it to string
            s0 = Double.toString(te);

            s1 = s2 = "";
        }
        else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
                // else evaluate
            else {
                double te;

                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                // convert it to string
                s0 = Double.toString(te);

                // place the operator
                s1 = s;

                // make the operand blank
                s2 = "";
            }

            // set the value of text
            l.setText(s0 + s1 + s2);
        }
    }
}

