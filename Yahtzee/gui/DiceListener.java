package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import YahtzeeObjects.Dice;

public class DiceListener implements ActionListener {
	
	Dice q;
	JButton but;
	JButton roll;
	
	public DiceListener(Dice d, JButton front, JButton roller) {
		q = d;
		but = front;
		roll = roller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		q.hold();
		if(q.isHold()) {
			but.setBorderPainted(false);
		} else {
			but.setBorderPainted(true);
		}
		roll.requestFocus();
	}

}
