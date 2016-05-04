package calculation;
import Cards.Card;
import Cards.Deck;




public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deck d = new Deck(true, 1);
		Deck q = new Deck(true, 1);
		
		for(int i=0;i<d.deckCount();i++) {
			System.out.println(d.draw() + "\t" + q.draw());
		}
		
		Deck j = new Deck();
		j.shuffle(1);
		for(int i=0;i<d.deckCount();i++) {
			System.out.println(j.draw());
		}
		
		Deck t = new Deck();
		//t.shuffle(1);
		for(int i=0;i<d.deckCount();i++) {
			Card c = t.draw();
			System.out.println(c + "\t" + c.getImage().toString());
		}
		
		
		//Hand h = new Hand();
		
		
		
	}

}
