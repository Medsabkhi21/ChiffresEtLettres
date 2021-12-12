
import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

//controleur class is the menu class where you can choose to play which game: chiffres or lettres
public class Controleur extends JFrame implements ActionListener {
	//declaring our variables
	JPanel pan;
	Menu menu;
	Barre barre;
	Player p1, p2;
	Controleur( Player p1, Player p2) {
		 super("Le plus long mot"); // controleur extends from JFrame, so we can add the bar title using super.
	        menu = new Menu(); // we add a menu
	        barre = new Barre(); // we add a bar
	        pan = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	        //we give each player its specific name and initiate scores.
	        this.p1 = p1;
	        this.p2 = p2;

	        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	        //we add barre, pan, menu to our JFrame and set its size and visibility
	        pan.add(barre);
	        this.add(pan);
	        this.add(menu);
	        this.setPreferredSize(new Dimension(700, 500));
	        this.pack();
	        this.setVisible(true);
	        this.setResizable(false);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //initiate action listeners for menu and barre items
	        this.menu.getBoutonMJ().addActionListener(this);
	        this.menu.getBoutonMO().addActionListener(this);

	        this.barre.getItemModeJoueur().addActionListener(this);
	        this.barre.getItemModeChiff().addActionListener(this);
	        this.barre.getItemFermer().addActionListener(this);

	        this.barre.getItemHelp().addActionListener(this);
	        this.barre.getItemInformation().addActionListener(this);

	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//go to mode lettres game
		if (e.getSource() == menu.getBoutonMJ()) {
			this.getContentPane().removeAll();
			ModeLettres modeLettres = new ModeLettres(p1,p2);
			this.setContentPane(modeLettres);
			
			this.setVisible(true);	
			this.revalidate();
			this.repaint();
		}
		if (e.getSource() == menu.getBoutonMO()) {
			//go to mode chiffres game
			this.getContentPane().removeAll();
			ModeChiffres modeChiffres = new ModeChiffres(p1,p2);
			this.setContentPane(modeChiffres);
			this.setVisible(true);	
			this.revalidate();
			this.repaint();
		}
	}}
