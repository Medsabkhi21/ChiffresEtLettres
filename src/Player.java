import java.util.ArrayList;

public class Player {
String Name;
ArrayList<Integer> scores;

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

}

