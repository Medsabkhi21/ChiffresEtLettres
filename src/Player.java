import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Player {
String Name;
ArrayList<Double> scores =new ArrayList<Double>(3);


public double calculateScore(String essay, JPanel RandomCharPanel) {
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
	 double sum = 0;
	 for(int i = 0; i < scores.size(); i++){
	     sum += scores.get(i);
	 System.out.println("elements to sum:" +scores.get(i));}
	 return sum;
	 }


	Player RAZscore (){
		this.scores =new ArrayList<Double>(3);
		this.scores.add(0.0);
		System.out.println("done");
		return this;	}

	public void setName(String name) {
		Name = name;
	}
	public String getName() {
		return Name;
	}

	public double calculateScoreN(double essay, double target){
		return 100-Math.abs(target-essay);}

	Player(String name){
	try{
		this.Name = name;
	scores.add(0.0); }catch(Exception e ){
		e.printStackTrace();
	}
}}




