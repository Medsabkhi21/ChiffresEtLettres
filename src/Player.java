import java.util.ArrayList;

public class Player {
String Name;
ArrayList<Integer> scores =new ArrayList<Integer>(3);


int calculateScore(String essay) {
	 return essay.length();}

void storeScore (int Score) {
	scores.add(Score);
}

 double getScore() {
	 double sum = 0;
	 for(int i = 0; i < scores.size(); i++)
	     sum += scores.get(i);
	 return sum;
	 }
Player(){
	try{
	scores.add(0); }catch(Exception e ){
		e.printStackTrace();
	}
}

	public void setName(String name) {
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public int getLastScore(){
	return scores.get(scores.size() - 1);
	}
}

