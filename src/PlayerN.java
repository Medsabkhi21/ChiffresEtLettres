import javax.swing.*;
import java.util.ArrayList;

public class PlayerN extends Player{


        PlayerN(String name) {
        super(name);
    }
    String Name;
    ArrayList<Integer> scores =new ArrayList<Integer>(3);


    public int calculateScore(int essay, int target){
        return 100-Math.abs(target-essay);}

    public void storeScore (int Score) {
        scores.add(Score);
    }

}
