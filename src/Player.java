import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Player {
String Name;
ArrayList<Double> scores =new ArrayList<Double>(3); //store score in an array of doubles


public double calculateScore(String essay, JPanel RandomCharPanel) {
	// calculate score: loop the panel components and see which one the player used, on each letter used, we increment the score
	int score = 0;
	for (Component label : RandomCharPanel.getComponents()) {
		String LabelText = ((JLabel) label).getText();
		char Labelchar = LabelText.charAt(0);
		if (essay.contains(LabelText)) {
			if (essay.indexOf(Labelchar) >= 0)
			{
				essay = essay.substring(0, essay.indexOf(Labelchar) ) + essay.substring(essay.indexOf(Labelchar) +1);
				score++;}
		}
	}	 return (double) score;
}

public void storeScore (double Score) {
	scores.add(Score);
}

 double getScore() {
	// we get the current score of the player by summing the scores ing the scores arraylist
	 double sum = 0;
	 for(int i = 0; i < scores.size(); i++){
	     sum += scores.get(i);
	 System.out.println("elements to sum:" +scores.get(i));}
	 return sum;
	 }


	Player RAZscore (){
	//remise a zero scores arraylist
		this.scores =new ArrayList<Double>(3);
		this.scores.add(0.0);
		System.out.println("done");
		return this;	}

		//getter and setter for player's name
	public void setName(String name) {
		Name = name;
	}
	public String getName() {
		return Name;
	}

	//calculate score for mode chiffres game
	public double calculateScoreN(double essay, double target){
		return 100-Math.abs(target-essay);}

	Player(String name){//constructor for player class
	try{
		this.Name = name;
	scores.add(0.0); }catch(Exception e ){
		e.printStackTrace();
	}
}}




