import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import java.util.Random;

class FenetreL extends JFrame{

	Player player1 = new Player();
	Player player2 = new Player();
	JPanel pan = new JPanel();
	JLabel welcome = new JLabel("Welcome to the game");
	JLabel Player1 = new JLabel("Player 1 , Your Turn!");
	JLabel Player2 = new JLabel("Player 2 , Your Turn!");
	JTextField inputP1 = new JTextField(20);


	JButton ValidateBtn = new JButton("validate");
	JButton nextPlayerBtn = new JButton("Next Player");

	int Tour = 4;

	char RandomChar (){//random character generator
	    Random random = new Random();
	    char randomizedCharacter = (char) (random.nextInt(26) + 'a');
	    return randomizedCharacter;}
	 

	String RandomizedString() {//random string generator
		 Random random = new Random();
		 String randomString="";
		 int randomRange= random.nextInt(26) +4;
		 for(int i =0; i<= randomRange; i++)
			 randomString+=RandomChar();
		 return  randomString;}
 
	void fctp1() {
		String essay = inputP1.getText();
		
		int score1 =player1.calculateScore(essay);
		System.out.println(" score :"+ String.valueOf(score1));
		player1.storeScore(score1);
		JLabel scoreLabel = new JLabel("hehe");
		pan.add(scoreLabel);
		}
	void fctp2() {

		Player1.setVisible(false);
		inputP1.setVisible(false);
		pan.add(Player2);
		String Letters = RandomizedString();
		JLabel LettersLabel = new JLabel(Letters);
		pan.add(LettersLabel);
		JTextField inputP1 = new JTextField(20);
		pan.add(inputP1);
		String essay2 = inputP1.getText();
		int score2 =player2.calculateScore(essay2);
		player2.storeScore(score2);
		JLabel scoreLabel = new JLabel(String.valueOf(score2));
		pan.add(scoreLabel);
	}
	public FenetreL() {

		this.setSize(1080,720);
		this.setLocationRelativeTo(null);
	

		pan.setLayout(new FlowLayout());
		pan.add(welcome);
		
		this.setContentPane(pan);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
		//random String generating for player one and keeping score
		int i =0;
			while(i<Tour){
			if (i % 2 == 0) {
				String Letters = RandomizedString();
				JLabel LettersLabel = new JLabel(Letters);
				
				pan.add(Player1);
				pan.add(LettersLabel);
				pan.add(inputP1);
				pan.add(ValidateBtn);
				
				ValidateBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						fctp1();
						pan.add(nextPlayerBtn);
					}});
				}
			
			nextPlayerBtn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
		fctp2();
				}
			});
	}
	}}


/*
class Validate implements ActionListener{
	public void actionPerformed(ActionEvent e) {

		String essay = inputP1.getText();
		
		int score1 =player1.calculateScore(essay);
		
		player1.storeScore(score1);
		JLabel scoreLabel = new JLabel(String.valueOf(score1));
	pan.add(scoreLabel);
	}	
}*/
