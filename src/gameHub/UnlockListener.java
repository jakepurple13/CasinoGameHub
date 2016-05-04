package gameHub;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;


public class UnlockListener implements ActionListener {
	
	JButton button;
	double amount;
	JButton thisOne;
	JLabel money;
	int unlocked;
	
	public UnlockListener(JButton buttonToUnlock, double amount, JButton thisOne, JLabel label, int unlocker) {
		button = buttonToUnlock;
		this.amount = amount;
		this.thisOne = thisOne;
		money = label;
		unlocked = unlocker;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(GameHub.money-amount>=0) {
			button.setEnabled(true);
			thisOne.setEnabled(false);
			GameHub.money-=amount;
			money.setText("Your money: $" + GameHub.money);
			unlocked++;
			System.out.println(GameHub.yahtzeeUnlocked);
		}
		
	}

}
