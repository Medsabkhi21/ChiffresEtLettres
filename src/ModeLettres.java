import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.floor;
import static java.lang.Math.random;


public class ModeLettres extends JPanel {


	private JButton valider;
	private JButton reinitialiser;
	private JLabel affichage, label1, label2;
	private JCheckBox Validate;
	private JLabel WhosTour;
	String[] lettresAlea = new String[10];
	Player p1, p2;
	int tour;
	String p_name;
	JPanel RandomLettersPanelFull;
	JLabel labelScore2, labelScore1;
	JLabel labelp1, labelp2;

	String RandomChar() {//random character generator
		Random random = new Random();
		int i = random.nextInt(26) + 65;
		String convertedChar = Character.toString((char) i);
		return convertedChar;
	}

	void GenerateRandomLettersPanel(JPanel randomcharspanel) { //generate a panel with random characters
		for (int i = 0; i < 11; i++)
			randomcharspanel.add(new JLabel(RandomChar()));

	}

	public void UpdateRandomLettersPanel(JPanel RandomLettersPanel) { //updating panel with other random characters
		for (Component label : RandomLettersPanel.getComponents()) {
			((JLabel) label).setText(RandomChar());
		}
	}

	public JPanel getRandomLettersPanelFull() {
		return RandomLettersPanelFull;
	} //getter for randomletterspanelfull


	ModeLettres(Player pl1, Player pl2) {
		//we link each plauer to its name and score
			this.p1= pl1;
			this.p2 = pl2;
			//we start tour and get the name of the first player
			tour =1;
			p_name =p1.getName();

			//create the layout of mode letters game
			Font fontTitre1 = new Font("Times new roman", Font.BOLD, 48);
	        Font fontTitre2 = new Font("Times new roman", Font.BOLD, 18);
	        Font fontTitre3 = new Font("Times new roman", Font.BOLD, 20);
	        label1 = new JLabel("Chiffres Et Lettres");
	        label1.setFont(fontTitre1);
	        label2 = new JLabel("Mode Lettres");
	        WhosTour = new JLabel("¨Tour du joueur: "+p_name);
	        label2.setFont(fontTitre2);
	        label2.setForeground(new Color(128, 0, 120));

	        JLabel labelp1 = new JLabel(p1.Name);
			JLabel labelp2 = new JLabel(p2.Name);
			JLabel labelScore1 = new JLabel(Double.toString(p1.getScore()));
			JLabel labelScore2 = new JLabel(Double.toString(p2.getScore()));
			JLabel Jtour = new JLabel("Tour Number:"+floor(tour/2)); // print tour

			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
	        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 3));
			JPanel scoring = new JPanel( new GridLayout(3, 1));

			JPanel pan0 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

	        //add items to the panel
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
	        affichage = new JLabel("test");
	        affichage.setFont(fontTitre2);
	        affichage.setForeground(new Color(15, 5, 107));
	        pan0.add(WhosTour);


	        //generate random letters panel
	        JPanel RandomLettersPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		 	GenerateRandomLettersPanel(RandomLettersPanel);

		this.add(RandomLettersPanel);
		this.add(panel1);
		this.add(panel2);
		this.add(scoring);
		this.add(pan0);

		Validate = new JCheckBox("I swear this is a true word", true);
	    Validate.setBounds(100,150, 150,20);
	    JTextField field1 = new JTextField("enter word here");
	    pan1.add(field1);
		pan1.add(Validate);
		pan1.add(valider);
		pan1.add(reinitialiser);

		//add panels to the mother jpanel: mode lettres
		this.add(RandomLettersPanel);
		this.add(pan1);


		//on valider button click,
		valider.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (floor(tour/2) == 3){
					//we see if number of tours is over, if it is we end the game
					this.GameEnd();
				}

				else if(Validate.isSelected()){ // we check if its a true word
					if(tour % 2 == 1){// if its second player's tour we calculate his store and save it , increment the tour and update our jpanel elements
						p1.storeScore(p1.calculateScore(field1.getText().toUpperCase(),RandomLettersPanel));
						p_name=p2.Name;
						labelScore1.setText(Double.toString(p1.getScore()));
						scoring.revalidate();
						scoring.repaint();
						tour++;
						Jtour.setText("Tour Number:"+floor(tour/2));
						/// to do : update current player name
						UpdateRandomLettersPanel(RandomLettersPanel);

					}
					else{ // if its first player's tour we do the same as for player two
						p2.storeScore(p2.calculateScore(field1.getText().toUpperCase(),RandomLettersPanel));
						labelScore2.setText(Double.toString(p2.getScore()));

						p_name = p1.Name;
						scoring.revalidate();
						scoring.repaint();
						tour++;
						Jtour.setText("Tour Number:"+floor(tour/2));
						UpdateRandomLettersPanel(RandomLettersPanel);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "please enter a real word"); // if it's not a true word we pop a message to tell him to input a true word

				}
			}


				private void GameEnd() {
				//in ending the game we show a screen message that tell us who won
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
			// remise a zero of scores for both players as well as tour
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("RAZ");
			p1= p1.RAZscore();
		System.out.println("scoreee"+p1.getScore());
			p2=p2.RAZscore();
			tour =0;
			Jtour.setText("Tour Number:"+floor(tour/2));
			labelScore1.setText(Double.toString(p1.getScore()));
			labelScore2.setText(Double.toString(p2.getScore()));


			}
		});
	}

	}
