import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.floor;
import static java.lang.Math.random;

class ModeLettres extends JPanel {


    private JButton valider;
    private JButton reinitialiser;
    private JLabel affichage, label1, label2;
    private Barre barre;
    private JCheckBox Validate ;
    private JLabel WhosTour;
	private JLabel Jtour;
	String p_name="Ali";
    String[] lettresAlea = new String[10];
    Player p1,p2;
    int tour;
	JLabel lab;
	JPanel   RandomLettersPanelFull ;
	JLabel labelScore2,labelScore1;

    String RandomChar (){//random character generator
	    Random random = new Random();
	    int i =random.nextInt(26)+65;
		String convertedChar = Character.toString((char)i);
	    return convertedChar;}

	    JPanel GenerateRandomLettersPanel(JPanel randomcharspanel){
		for(int i = 0; i<11; i++)
			randomcharspanel.add(new JLabel(RandomChar()));
	return randomcharspanel;
    }

	void UpdateRandomLettersPanel(JPanel RandomLettersPanel){
		for(Component label : RandomLettersPanel.getComponents()){
			((JLabel) label).setText(RandomChar());
		}}


	 void GameEnd() {
	System.out.println(Integer.parseInt(labelScore1.getText()));
		String winner;
//
//		int s1=Integer.parseInt(labelScore1.getText());
//		int s2=Integer.parseInt(labelScore2.getText());
//		if(s1>s2){
//			winner = p1.getName();
//		}
//		else if (s1<s2){
//			winner =p2.getName();
//		}
//		else
//			winner ="players! it's a draw";
//
//		JOptionPane.showMessageDialog(null, "Game Finished!\n Congrats"+winner);

	}

	ModeLettres(){
		//BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
	       // frame.setLayout();
			Player p1 = new Player();
			Player p2 = new Player();
			p1.setName("ALi");
			p2.setName("mohamed");
			tour =1;
			Font fontTitre1 = new Font("Times new roman", Font.BOLD, 48);
	        Font fontTitre2 = new Font("Times new roman", Font.BOLD, 18);
	        Font fontTitre3 = new Font("Times new roman", Font.BOLD, 20);
	        label1 = new JLabel("Chiffres Et Lettres");
	        label1.setFont(fontTitre1);
	        label2 = new JLabel("Mode Lettres");
	        WhosTour = new JLabel("¨Tour du joueur:"+p_name);
	        label2.setFont(fontTitre2);
	        label2.setForeground(new Color(128, 0, 128));
			JLabel labelp1 = new JLabel(p1.Name);
			JLabel labelp2 = new JLabel(p2.Name);
			JLabel labelScore1 = new JLabel(Double.toString(p1.getScore()));
			JLabel labelScore2 = new JLabel(Double.toString(p2.getScore()));
			JLabel Jtour = new JLabel("Tour Number:"+floor(tour/2));



			JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
	        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 3));
			JPanel scoring = new JPanel(new FlowLayout(FlowLayout.LEADING, 50, 3));

			JPanel pan0 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JPanel RandomLettersPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
	        JPanel pan2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
	        JPanel pan3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 0));
	        JPanel pan4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        JPanel pan5 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
	        barre = new Barre();
	        panel1.add(label1);
	        panel2.add(label2);
	        scoring.add(Jtour);
	        scoring.add(labelp2);
	        scoring.add(labelp2);
	        scoring.add(labelScore1);
			scoring.add(labelScore2);

	        valider = new JButton("valider");
	        reinitialiser = new JButton("Reinitialiser");
	        affichage = new JLabel("test");
	        affichage.setFont(fontTitre2);
	        affichage.setForeground(new Color(15, 5, 107));
	        pan0.add(valider);
	        pan0.add(reinitialiser);
	        pan0.add(WhosTour);
			JPanel RandomLettersPanelFull = GenerateRandomLettersPanel(RandomLettersPanel);


			this.add(RandomLettersPanelFull);
	        this.add(panel1);
	        this.add(panel2);
	        this.add(pan0);
	        this.add(scoring);
	        Validate = new JCheckBox("I swear this is a true word", true);  
	        Validate.setBounds(100,150, 150,20);




			JTextField field1 = new JTextField("enter word here");
			pan1.add(field1);
			this.add(RandomLettersPanel);
			this.add(pan1);
	        this.add(Validate);


		valider.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (floor(tour/2) == 7){
				GameEnd();
				}

				else if(Validate.isSelected()){
					if(tour % 2 == 1){
						p1.storeScore(p1.calculateScore(field1.getText()));
						p_name=p2.Name;
						labelScore1.setText(Double.toString(p1.getScore()));
						scoring.revalidate();
						scoring.repaint();
						tour++;
						Jtour.setText("Tour Number:"+floor(tour/2));

						UpdateRandomLettersPanel(RandomLettersPanel);


					}
					else{
						p2.storeScore(p2.calculateScore(field1.getText()));
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
					JOptionPane.showMessageDialog(null, "please enter a real word");

				}
		}});

	}


}