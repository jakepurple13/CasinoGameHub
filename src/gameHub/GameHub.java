package gameHub;



import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import pokerGUI.VideoPoker;
import wordsperminute.wordsGUI;


public class GameHub extends JFrame implements ActionListener {

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
					GameHub frame = new GameHub(args);
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
	
	public static double money = 0;
	public static double bet = 0;
	public static JLabel label;
	public static int chessUnlocked = 0;
	public static int yahtzeeUnlocked = 0;
	public static int calculationUnlocked = 0;
	public static int videoPokerUnlocked = 0;
	public static int wordsPerMinuteUnlocked = 0;
	
	public GameHub(String[] args) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		try {
			getText();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Something went wrong looking for the file.");
			money = 1000;
			chessUnlocked = 0;
			yahtzeeUnlocked = 0;
			calculationUnlocked = 0;
			videoPokerUnlocked = 0;
			wordsPerMinuteUnlocked = 0;
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			money = 1000;
			chessUnlocked = 0;
			yahtzeeUnlocked = 0;
			calculationUnlocked = 0;
			videoPokerUnlocked = 0;
			wordsPerMinuteUnlocked = 0;
			e1.printStackTrace();
		}
		
		JButton btnChess = new JButton("Chess");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnChess, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnChess, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnChess);
		
		
		JButton btnYahtzee = new JButton("Yahtzee");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnYahtzee, 6, SpringLayout.SOUTH, btnChess);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnYahtzee, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnYahtzee);
		
		JButton btnCalculation = new JButton("Calculation");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnCalculation, 6, SpringLayout.SOUTH, btnYahtzee);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnCalculation, 10, SpringLayout.WEST, contentPane);
		contentPane.add(btnCalculation);
		
		label = new JLabel("Your money: $" + money);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, label, 0, SpringLayout.SOUTH, contentPane);
		contentPane.add(label);
		
		JButton btnUnlockChess = new JButton("Unlock Chess $5000");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnUnlockChess, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnUnlockChess, 0, SpringLayout.EAST, contentPane);
		contentPane.add(btnUnlockChess);
		
		JButton btnUnlockYahtzee = new JButton("Unlock Yahtzee $1000");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnUnlockYahtzee, 0, SpringLayout.NORTH, btnYahtzee);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnUnlockYahtzee, 0, SpringLayout.EAST, btnUnlockChess);
		contentPane.add(btnUnlockYahtzee);
		
		JButton btnUnlockCalculation = new JButton("Unlock Calculation $1500");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnUnlockCalculation, 0, SpringLayout.NORTH, btnCalculation);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnUnlockCalculation, 0, SpringLayout.EAST, btnUnlockChess);
		contentPane.add(btnUnlockCalculation);
		
		JLabel lblBet = new JLabel("<html>Bet: $50<br />Win: +250%</html>");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBet, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBet, 6, SpringLayout.EAST, btnChess);
		contentPane.add(lblBet);
		
		JLabel lblBetWin = new JLabel("<html>Bet: $5<br />Win: +15%</html>");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblBetWin, 0, SpringLayout.NORTH, btnYahtzee);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblBetWin, 6, SpringLayout.EAST, btnYahtzee);
		contentPane.add(lblBetWin);
		
		JButton btnNewButton = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnChess);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 6, SpringLayout.EAST, lblBet);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -70, SpringLayout.SOUTH, btnCalculation);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 81, SpringLayout.EAST, btnCalculation);
		contentPane.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("help.png")));
		
		JButton btnNewButton_1 = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnYahtzee);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 6, SpringLayout.EAST, lblBetWin);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -35, SpringLayout.SOUTH, btnCalculation);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_1, -231, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("help.png")));
		
		JButton btnVideoPoker = new JButton("Video Poker");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnVideoPoker, 6, SpringLayout.SOUTH, btnCalculation);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVideoPoker, 0, SpringLayout.WEST, btnChess);
		contentPane.add(btnVideoPoker);
		
		JButton btnUnlockVideoPoker = new JButton("Unlock Video Poker $2500");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnUnlockVideoPoker, 6, SpringLayout.SOUTH, btnUnlockCalculation);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnUnlockVideoPoker, 0, SpringLayout.EAST, btnUnlockChess);
		contentPane.add(btnUnlockVideoPoker);
		
		JButton btnNewButton_2 = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnVideoPoker);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_2, 50, SpringLayout.EAST, btnVideoPoker);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton_2, 0, SpringLayout.SOUTH, btnVideoPoker);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, btnNewButton);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setBorder(BorderFactory.createEmptyBorder());
		btnNewButton_2.setIcon(new ImageIcon(getClass().getResource("help.png")));
		
		JButton btnWordsPerMinute = new JButton("Words Per Minute");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnWordsPerMinute, 6, SpringLayout.SOUTH, btnVideoPoker);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnWordsPerMinute, 0, SpringLayout.WEST, btnChess);
		contentPane.add(btnWordsPerMinute);
		
		JButton btnUnlockWpm = new JButton("Unlock WPM $1000");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnUnlockWpm, 6, SpringLayout.SOUTH, btnUnlockVideoPoker);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnUnlockWpm, 0, SpringLayout.EAST, btnUnlockChess);
		contentPane.add(btnUnlockWpm);
		
		
		btnNewButton.addActionListener(this);
		
		btnNewButton_1.addActionListener(this);
		
		btnNewButton_2.addActionListener(new AboutListener(4, this));
		
		btnUnlockChess.addActionListener(new UnlockListener(btnChess, 5000, btnUnlockChess, label, chessUnlocked));
		btnUnlockYahtzee.addActionListener(new UnlockListener(btnYahtzee, 1000, btnUnlockYahtzee, label, yahtzeeUnlocked));
		btnUnlockCalculation.addActionListener(new UnlockListener(btnCalculation, 1500, btnUnlockCalculation, label, calculationUnlocked));
		btnUnlockVideoPoker.addActionListener(new UnlockListener(btnVideoPoker, 2500, btnUnlockVideoPoker, label, videoPokerUnlocked));
		btnUnlockWpm.addActionListener(new UnlockListener(btnWordsPerMinute, 1000, btnUnlockWpm, label, wordsPerMinuteUnlocked));
		
		isUnlocked(btnChess, btnUnlockChess, chessUnlocked);
		isUnlocked(btnYahtzee, btnUnlockYahtzee, yahtzeeUnlocked);
		isUnlocked(btnCalculation, btnUnlockCalculation, calculationUnlocked);
		isUnlocked(btnVideoPoker, btnUnlockVideoPoker, videoPokerUnlocked);
		isUnlocked(btnWordsPerMinute, btnUnlockWpm, wordsPerMinuteUnlocked);
		
		btnChess.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chessUnlocked++;
				money-=50;
				bet = 50;
				label.setText("Your money: $" + money);
				try {
					ChessGUI.GUI.main(args);
				} catch (Exception q) {
					q.printStackTrace();
				}
			}
		});
		
		btnVideoPoker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				videoPokerUnlocked++;
				label.setText("Your money: $" + money);
				try {
					VideoPoker.main(args);
				} catch (Exception q) {
					q.printStackTrace();
				}
			}
		});
		
		
		btnYahtzee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				yahtzeeUnlocked++;
				money-=5;
				bet = 5;
				label.setText("Your money: $" + money);
				try {
					gui.GUI.main(args);
				} catch (Exception q) {
					q.printStackTrace();
				}
			}
		});
		
		
		btnCalculation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calculationUnlocked++;
				money-=10;
				bet = 10;
				label.setText("Your money: $" + money);
				try {
					calculation.Mainer.main(args);
				} catch (Exception q) {
					q.printStackTrace();
				}
			}
		});
		
		btnWordsPerMinute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				wordsPerMinuteUnlocked++;
				label.setText("Your money: $" + money);
				try {
					wordsGUI.main(args);
				} catch (Exception q) {
					q.printStackTrace();
				}
			}
		});
		
		
		GameHub.this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				try {
					saveToFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	
	public void isUnlocked(JButton game, JButton locked, int checked) {
		
		if(checked>=1) {
			game.setEnabled(true);
			locked.setEnabled(false);
		} else if(checked!=1) {
			game.setEnabled(false);
			locked.setEnabled(true);
		}
		
	}
	
	public static void getText() throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/gamehub.txt"))) {
		    String line;
		    // process the line.
	    	line = br.readLine();
	    	money = Double.valueOf(line.trim());
	    	line = br.readLine();
	    	chessUnlocked = Integer.valueOf(line.trim());
	    	line = br.readLine();
	    	yahtzeeUnlocked = Integer.valueOf(line.trim());
	    	line = br.readLine();
	    	calculationUnlocked = Integer.valueOf(line.trim());
	    	line = br.readLine();
	    	videoPokerUnlocked = Integer.valueOf(line.trim());
	    	line = br.readLine();
	    	wordsPerMinuteUnlocked = Integer.valueOf(line.trim());;

		   
		}
		
	}
	
	public static void saveToFile() throws IOException {

		File fout = new File(System.getProperty("user.home") + "/gamehub.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		bw.write(money + "\n");
		bw.write(chessUnlocked + "\n");
		bw.write(yahtzeeUnlocked + "\n");
		bw.write(calculationUnlocked + "\n");
		bw.write(videoPokerUnlocked  + "\n");
		bw.write(wordsPerMinuteUnlocked  + "\n");
	 
		bw.close();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
