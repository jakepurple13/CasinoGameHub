package gui;

import gameHub.GameHub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import YahtzeeObjects.Scores;

public class ScoreListener implements ActionListener {
	
	int score;
	Scores s;
	JButton button;
	JLabel small;
	JLabel large;
	JLabel total;
	JButton roll;
	GUI g;
	
	public ScoreListener(int scored, Scores q, JButton but, JLabel small, JLabel large, JLabel total, JButton roll, GUI g) {
		score = scored;
		s = q;
		button = but;
		this.small = small;
		this.large = large;
		this.total = total;
		this.roll = roll;
		this.g = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(GUI.placed==false) {
			button.setEnabled(false);
			button.setText(button.getText() + s.updateScore(GUI.dice, score));
			small.setText("Small Total: " + s.getSmallTotal());
			large.setText("Large Total: " + s.getLargeTotal());
			total.setText("Total: " + s.getTotal());
			GUI.counter = 0;
			roll.setEnabled(true);
			GUI.btnDice.setBorderPainted(true);
			GUI.btnNewButton.setBorderPainted(true);
			GUI.btnNewButton_1.setBorderPainted(true);
			GUI.btnNewButton_2.setBorderPainted(true);
			GUI.btnNewButton_3.setBorderPainted(true);
			GUI.placed = true;
			GUI.btnDice.setEnabled(false);
			GUI.btnNewButton.setEnabled(false);
			GUI.btnNewButton_1.setEnabled(false);
			GUI.btnNewButton_2.setEnabled(false);
			GUI.btnNewButton_3.setEnabled(false);
			for(int i=0;i<GUI.dice.size();i++) {
				GUI.dice.get(i).unHold();
			}
		}
		ArrayList<Boolean> finalCheck = new ArrayList<Boolean>();
		for(JButton bunt : GUI.buttons) {
			if(bunt.isEnabled()) {
				System.out.println("Still playing");
			} else if(!bunt.isEnabled()) {
				System.out.println("Done playing");
			}
			finalCheck.add(bunt.isEnabled());
		}
			
		if(isDone(finalCheck)) {
			
			Object[] options = {"Quit", //0
        			"No",   //1
					"Yes"}; //2
			
			int choice = JOptionPane.showOptionDialog(g,
				    "Would you like to play again?",
				    "Score: " + s.getTotal(),
				    JOptionPane.YES_NO_CANCEL_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options,
				    options[2]);
			
			if(choice==0) { //quit
				if(s.getTotal()>150) {
					double q = getMoney(GameHub.bet);
					GameHub.money+=s.getTotal()+q;
					GameHub.label.setText("Your money: $" + GameHub.money);
				}
				g.dispose();
			} else if(choice==1) { //no
				//bring up the highscore window
			} else if(choice==2) { //yes
				s.reset();
				g.reset();
				GUI.placed = false;
				for(JButton bunt : GUI.buttons) {
					bunt.setEnabled(true);
				}
				double q = getMoney(GameHub.bet);
				GameHub.money+=s.getTotal()+q;
				GameHub.label.setText("Your money: $" + GameHub.money);
			}
		}
			
		roll.requestFocus();
		
	}
	
	public boolean isDone(ArrayList<Boolean> checker) {
		
		for(int i=0;i<checker.size();i++) {
			if(checker.get(i)==true) {
				return false;
			}
		}
		
		return true;
	}
	
	public double getMoney(double current) {
		current += (current*.15);
		return current;
	}
	
}
