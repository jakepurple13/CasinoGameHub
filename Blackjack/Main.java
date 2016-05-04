import java.util.Scanner;

import Cards.Deck;
import Player.Dealer;
import Player.Player;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		Player p = new Player("Jacob");
		Deck d = new Deck(true);
		Dealer deal = new Dealer(d);
		String q = "";
		p.addAmount(d.draw());
		p.addAmount(d.draw());
		deal.start();
		while(!q.equalsIgnoreCase("Quit")) {
			System.out.println(deal);
			System.out.println(p + "\nType in 'hit' to hit, or 'stay' to stay or 'quit' to stop playing.");
			q = s.nextLine();
			
			if(q.equalsIgnoreCase("hit")) {
				p.addAmount(d.draw());
				if(p.isBusted()) {
					System.out.println(p);
					System.out.println("You lose!");
					p.reset();
					deal.start();
					p.addAmount(d.draw());
					p.addAmount(d.draw());
				}
			} else if(q.equalsIgnoreCase("stay")) {
				deal.addAmount();
				System.out.println(deal);
				p.reset();
				deal.start();
				p.addAmount(d.draw());
				p.addAmount(d.draw());
			}
			
			if(d.deckCount()<5) {
				d = new Deck(true);
			}
			
			
		}
		
		s.close();
		
	}

}
