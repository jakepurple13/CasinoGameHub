package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;

import YahtzeeObjects.Dice;
import YahtzeeObjects.Scores;

import javax.swing.JLabel;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	static int counter = 0;
	static ArrayList<Dice> dice = new ArrayList<Dice>();
	static boolean placed = false;
	static JButton btnDice;
	static JButton btnNewButton;
	static JButton btnNewButton_1;
	static JButton btnNewButton_2;
	static JButton btnNewButton_3;
	static ArrayList<JButton> buttons;
	JButton btnOnes;
	JButton btnTwos;
	JButton btnThrees;
	JButton btnFours;
	JButton btnFives;
	JButton btnSixes;
	JButton btnThreeOfA;
	JButton btnFourOfA;
	JButton btnFullHouse;
	JButton btnSmallStraight;
	JButton btnLargeStraight;
	JButton btnYahtzee;
	JButton btnChance;
	JLabel lblSmallTotal;
	JLabel lblLargeTotal;
	JLabel lblTotal;
	Scores s;
	
	public GUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		buttons = new ArrayList<JButton>();
		
		s = new Scores();
		
		Dice d = new Dice(1);
		Dice d1 = new Dice(1);
		Dice d2 = new Dice(1);
		Dice d3 = new Dice(1);
		Dice d4 = new Dice(1);
		
		dice.add(d);
		dice.add(d1);
		dice.add(d2);
		dice.add(d3);
		dice.add(d4);
		
		btnDice = new JButton(d.getImage());
		sl_contentPane.putConstraint(SpringLayout.WEST, btnDice, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnDice, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnDice);
		
		btnNewButton = new JButton(d1.getImage());
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnDice);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, btnDice);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton(d2.getImage());
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnDice);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, btnNewButton);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton(d3.getImage());
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 6, SpringLayout.EAST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 0, SpringLayout.SOUTH, btnDice);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton(d4.getImage());
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_3, 6, SpringLayout.EAST, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_3, 0, SpringLayout.SOUTH, btnDice);
		contentPane.add(btnNewButton_3);
		
		JButton btnRoll = new JButton("Roll");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRoll, 6, SpringLayout.EAST, btnNewButton_3);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnRoll, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnRoll);
		
		btnDice.addActionListener(new DiceListener(d, btnDice, btnRoll));
		btnNewButton.addActionListener(new DiceListener(d1, btnNewButton, btnRoll));
		btnNewButton_1.addActionListener(new DiceListener(d2, btnNewButton_1, btnRoll));
		btnNewButton_2.addActionListener(new DiceListener(d3, btnNewButton_2, btnRoll));
		btnNewButton_3.addActionListener(new DiceListener(d4, btnNewButton_3, btnRoll));
		
		btnOnes = new JButton("Ones: ");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnOnes, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnOnes, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnOnes);
		
		btnTwos = new JButton("Twos:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTwos, 6, SpringLayout.SOUTH, btnOnes);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTwos, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnTwos);
		
		btnThrees = new JButton("Threes:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnThrees, 6, SpringLayout.SOUTH, btnTwos);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnThrees, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnThrees);
		
		btnFours = new JButton("Fours:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFours, 6, SpringLayout.SOUTH, btnThrees);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFours, 0, SpringLayout.WEST, btnOnes);
		contentPane.add(btnFours);
		
		btnFives = new JButton("Fives:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFives, 6, SpringLayout.SOUTH, btnFours);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFives, 0, SpringLayout.WEST, btnOnes);
		contentPane.add(btnFives);
		
		btnSixes = new JButton("Sixes:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSixes, 6, SpringLayout.SOUTH, btnFives);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSixes, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnSixes);
		
		JLabel lblIfTheTotal = new JLabel("If the total is over 63, +35");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIfTheTotal, 7, SpringLayout.SOUTH, btnSixes);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblIfTheTotal, 0, SpringLayout.WEST, btnOnes);
		contentPane.add(lblIfTheTotal);
		
		lblSmallTotal = new JLabel("Small Total:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblSmallTotal, 6, SpringLayout.SOUTH, lblIfTheTotal);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblSmallTotal, 0, SpringLayout.WEST, btnOnes);
		contentPane.add(lblSmallTotal);
		
		btnThreeOfA = new JButton("Three of a Kind:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnThreeOfA, 0, SpringLayout.NORTH, btnOnes);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnThreeOfA, 0, SpringLayout.WEST, btnNewButton_2);
		contentPane.add(btnThreeOfA);
		
		btnFourOfA = new JButton("Four of a Kind:");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFourOfA, 0, SpringLayout.WEST, btnNewButton_2);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnFourOfA, 0, SpringLayout.SOUTH, btnTwos);
		contentPane.add(btnFourOfA);
		
		btnFullHouse = new JButton("Full House:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFullHouse, 0, SpringLayout.NORTH, btnThrees);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFullHouse, 0, SpringLayout.WEST, btnNewButton_2);
		contentPane.add(btnFullHouse);
		
		btnSmallStraight = new JButton("Small Straight:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSmallStraight, 0, SpringLayout.NORTH, btnFours);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSmallStraight, 0, SpringLayout.WEST, btnNewButton_2);
		contentPane.add(btnSmallStraight);
		
		btnLargeStraight = new JButton("Large Straight:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLargeStraight, 0, SpringLayout.NORTH, btnFives);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLargeStraight, 0, SpringLayout.WEST, btnNewButton_2);
		contentPane.add(btnLargeStraight);
		
		btnYahtzee = new JButton("Yahtzee:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnYahtzee, 0, SpringLayout.NORTH, btnSixes);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnYahtzee, 0, SpringLayout.WEST, btnNewButton_2);
		contentPane.add(btnYahtzee);
		
		btnChance = new JButton("Chance:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnChance, 0, SpringLayout.NORTH, lblIfTheTotal);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnChance, 0, SpringLayout.WEST, btnNewButton_2);
		contentPane.add(btnChance);
		
		lblLargeTotal = new JLabel("Large Total:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLargeTotal, 6, SpringLayout.SOUTH, btnChance);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblLargeTotal, -10, SpringLayout.EAST, btnChance);
		contentPane.add(lblLargeTotal);
		
		lblTotal = new JLabel("Total:");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTotal, 0, SpringLayout.WEST, btnNewButton_1);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTotal, -6, SpringLayout.NORTH, btnNewButton_1);
		contentPane.add(lblTotal, btnRoll);
		
		btnOnes.addActionListener(new ScoreListener(1, s, btnOnes, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnTwos.addActionListener(new ScoreListener(2, s, btnTwos, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnThrees.addActionListener(new ScoreListener(3, s, btnThrees, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnFours.addActionListener(new ScoreListener(4, s, btnFours, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnFives.addActionListener(new ScoreListener(5, s, btnFives, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnSixes.addActionListener(new ScoreListener(6, s, btnSixes, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnThreeOfA.addActionListener(new ScoreListener(7, s, btnThreeOfA, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnFourOfA.addActionListener(new ScoreListener(8, s, btnFourOfA, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnFullHouse.addActionListener(new ScoreListener(9, s, btnFullHouse, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnSmallStraight.addActionListener(new ScoreListener(10, s, btnSmallStraight, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnLargeStraight.addActionListener(new ScoreListener(11, s, btnLargeStraight, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnYahtzee.addActionListener(new ScoreListener(12, s, btnYahtzee, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		btnChance.addActionListener(new ScoreListener(13, s, btnChance, lblSmallTotal, lblLargeTotal, lblTotal, btnRoll, this));
		
		buttons.add(btnOnes);
		buttons.add(btnTwos);
		buttons.add(btnThrees);
		buttons.add(btnFours);
		buttons.add(btnFives);
		buttons.add(btnSixes);
		buttons.add(btnThreeOfA);
		buttons.add(btnFourOfA);
		buttons.add(btnFullHouse);
		buttons.add(btnSmallStraight);
		buttons.add(btnLargeStraight);
		buttons.add(btnYahtzee);
		buttons.add(btnChance);
		
		btnRoll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(counter<3) {
					d.changeDice();
					d1.changeDice();
					d2.changeDice();
					d3.changeDice();
					d4.changeDice();
					btnDice.setIcon(d.getImage());
					btnNewButton.setIcon(d1.getImage());
					btnNewButton_1.setIcon(d2.getImage());
					btnNewButton_2.setIcon(d3.getImage());
					btnNewButton_3.setIcon(d4.getImage());
					placed = false;
					GUI.btnDice.setEnabled(true);
					GUI.btnNewButton.setEnabled(true);
					GUI.btnNewButton_1.setEnabled(true);
					GUI.btnNewButton_2.setEnabled(true);
					GUI.btnNewButton_3.setEnabled(true);
				}
				if(counter>=2) {
					btnRoll.setEnabled(false);
					btnDice.setBorderPainted(true);
					btnNewButton.setBorderPainted(true);
					btnNewButton_1.setBorderPainted(true);
					btnNewButton_2.setBorderPainted(true);
					btnNewButton_3.setBorderPainted(true);
				}
				counter++;
			}
		});
		
	}
	
	
	public void reset() {
		btnOnes.setText("Ones: ");
		btnTwos.setText("Twos: ");
		btnThrees.setText("Threes: ");
		btnFours.setText("Fours: ");
		btnFives.setText("Fives: ");
		btnSixes.setText("Sixes: ");
		btnThreeOfA.setText("Three of a Kind: ");
		btnFourOfA.setText("Four of a Kind: ");
		btnFullHouse.setText("Full House: ");
		btnSmallStraight.setText("Small Straight: ");
		btnLargeStraight.setText("Large Straight: ");
		btnYahtzee.setText("Yahtzee: ");
		btnChance.setText("Chance: ");
		lblSmallTotal.setText("Small Total: ");
		lblLargeTotal.setText("Large Total: ");
		lblTotal.setText("Total: ");
	}
}
