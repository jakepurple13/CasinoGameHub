package pokerGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CardListener implements ActionListener {
	
	JButton cards;
	int number;
	
	public CardListener(JButton button, int num) {
		cards = button;
		number = num;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String textCheck = cards.getText();
		if(textCheck.equalsIgnoreCase("Hold")) {
			cards.setText("Holding");
			changeHold();
		} else if(textCheck.equalsIgnoreCase("Holding")) {
			cards.setText("Hold");
			changeHold();
		}
		
	}
	
	public void changeHold() {
		if(number==1) {
			VideoPoker.c1Hold = !VideoPoker.c1Hold;
		} else if(number==2) {
			VideoPoker.c2Hold = !VideoPoker.c2Hold;
		} else if(number==3) {
			VideoPoker.c3Hold = !VideoPoker.c3Hold;
		} else if(number==4) {
			VideoPoker.c4Hold = !VideoPoker.c4Hold;
		} else if(number==5) {
			VideoPoker.c5Hold = !VideoPoker.c5Hold;
		} 
	}

}
