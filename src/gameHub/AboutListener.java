package gameHub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutListener implements ActionListener {
	
	int which;
	GameHub g;
	
	
	public AboutListener(int num, GameHub g) {
		which = num;
		this.g = g;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String get = "";
		if(which==4) { //video poker
			get = videoPokerHelp();
		}
		
		About a = new About(get);
		a.setVisible(true);
		
	}
	
	public String videoPokerHelp() {
		String help = "<html><pre>";
		
		help+="Video Poker - 10/21/15 -> 10/22/15<br />" +
				"Day 1:<br />" +
				" - Got working: pair, four of a kind, full house, straight, three of a kind, flush, straight flush, royal flush.<br />" +
				" - Finished all hand checkings<br />" +
				" -finished video poker<br />" +
				"Day 2:<br />" +
				" - fixed up code and made it more efficient<br />" +
				" - fixed some winnings<br />" +
				" - fixed the cards being able to be held before you draw<br />";
		
		return help+"</pre></html>";
	}
	
}
