
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

public class Controleur extends JFrame implements ActionListener {
	JPanel pan;
	Menu menu;
	Barre barre;
	Controleur() {
		 super("Le plus long mot");
	        menu = new Menu();
	        barre = new Barre();
	       // modechiffres = new ModeChiffres(dico);
	      ModeLettres  ModeLettres = new ModeLettres();
	        pan = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

	        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

	        pan.add(barre);
	        this.add(pan);
	        this.add(menu);
	        this.setPreferredSize(new Dimension(800, 650));
	        this.pack();
	        this.setVisible(true);
	        this.setResizable(false);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		if (e.getSource() == menu.getBoutonMJ()) {
			System.out.println("test");
			this.getContentPane().removeAll();
			ModeLettres modeLettres = new ModeLettres();
			this.setContentPane(modeLettres);
			
			this.setVisible(true);	
			this.revalidate();
			this.repaint();
		}
		if (e.getSource() == menu.getBoutonMO()) {
			System.out.println("test");
			this.getContentPane().removeAll();
		//	ModeLettres modeChiffres = new ModeChiffres();
			
			this.setVisible(true);	
			this.revalidate();
			this.repaint();
		}
	}}
