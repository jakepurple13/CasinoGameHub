package YahtzeeObjects;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scores s = new Scores();
		ArrayList<Dice> d = new ArrayList<Dice>();
		d.add(new Dice(5));
		d.add(new Dice(1));
		d.add(new Dice(3));
		d.add(new Dice(4));
		d.add(new Dice(6));
		
		System.out.println(d.get(1).getImage());
		
		for(int i=0;i<13;i++) {
			//s.updateScore(d, i);
		}
		
		System.out.println(s);
		
		
		
		
	}

}
