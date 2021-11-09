import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Fenetre extends JFrame implements ActionListener{
	JPanel pan = new JPanel();
	JPanel panleft = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JLabel l1 = new JLabel("Which Game would you like to play ?");
	
	JButton b1 = new JButton("Lettres");
	JButton b2 = new JButton("Numbers");
	JPanel panel4 = new JPanel();

	
	public Fenetre() {

this.setSize(600,150);
this.setLocationRelativeTo(null);
b1.addActionListener(new LettersBtn());
b2.addActionListener(new NumbersBtn());

panleft.setLayout(new FlowLayout());
panleft.add(l1);

panel2.setLayout(new GridLayout(2,1));
panel2.add(b1);
panel2.add(b2);



this.setContentPane(pan);

pan.add(panleft);
pan.add(panel2);



this.setContentPane(pan);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
}



class NumbersBtn implements ActionListener{
	public void actionPerformed(ActionEvent e) {

		System.out.println("initiating Numbers Game..");
		FenetreN fen = new FenetreN();
	}	
}

class LettersBtn implements ActionListener{
	public void actionPerformed(ActionEvent e) {

		System.out.println("initiating Letters Game..");
		FenetreL fen = new FenetreL();

		
		
	}	
}

@Override
public void actionPerformed(ActionEvent e) {
	
	
	
}}
