package pokerGUI;

import gameHub.GameHub;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;

import VideoPoker.Scores;
import Cards.Card;
import Cards.Deck;
import Cards.Hand;

import javax.swing.JLabel;

import rpgtester.WindowTest;

public class VideoPoker extends JFrame implements KeyListener {

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
					VideoPoker frame = new VideoPoker();
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
	
	Deck d;
	
	Scores s;
	
	Card c1;
	Card c2;
	Card c3;
	Card c4;
	Card c5;
	static boolean c1Hold = false;
	static boolean c2Hold = false;
	static boolean c3Hold = false;
	static boolean c4Hold = false;
	static boolean c5Hold = false;
	int lastDraw = 0;
	
	int amountBet = 1;
	
	JButton btnBet;
	JLabel lblBetting;
	JLabel lblYouWon;
	JLabel lblCurrentAmountOf;
	JButton button_1;
	JButton button;
	JButton btnCard;
	JButton btnCard_1;
	JButton btnCard_2;
	JButton btnCard_3;
	JButton btnCard_4;
	
	public VideoPoker() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 419, 406);
		contentPane = new ContentPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		addKeyListener(this);
		setFocusable(true);
        setFocusTraversalKeysEnabled(false);
		
		d = new Deck(true);
		s = new Scores();
		
		
		btnCard = new JButton("Hold");
		springLayout.putConstraint(SpringLayout.WEST, btnCard, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCard, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnCard);
		
		btnCard_1 = new JButton("Hold");
		springLayout.putConstraint(SpringLayout.WEST, btnCard_1, 6, SpringLayout.EAST, btnCard);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCard_1, 0, SpringLayout.SOUTH, btnCard);
		getContentPane().add(btnCard_1);
		
		btnCard_2 = new JButton("Hold");
		springLayout.putConstraint(SpringLayout.WEST, btnCard_2, 6, SpringLayout.EAST, btnCard_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCard_2, 0, SpringLayout.SOUTH, btnCard);
		getContentPane().add(btnCard_2);
		
		btnCard_3 = new JButton("Hold");
		springLayout.putConstraint(SpringLayout.WEST, btnCard_3, 6, SpringLayout.EAST, btnCard_2);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCard_3, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnCard_3);
		
		btnCard_4 = new JButton("Hold");
		springLayout.putConstraint(SpringLayout.NORTH, btnCard_4, 0, SpringLayout.NORTH, btnCard_3);
		springLayout.putConstraint(SpringLayout.WEST, btnCard_4, 6, SpringLayout.EAST, btnCard_3);
		getContentPane().add(btnCard_4);
		
		btnCard.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
		btnCard_1.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
		btnCard_2.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
		btnCard_3.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
		btnCard_4.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
		
		btnCard.setBorder(BorderFactory.createEmptyBorder());
		btnCard.setVerticalTextPosition(SwingConstants.TOP);
		btnCard.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCard_1.setBorder(BorderFactory.createEmptyBorder());
		btnCard_1.setVerticalTextPosition(SwingConstants.TOP);
		btnCard_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCard_2.setBorder(BorderFactory.createEmptyBorder());
		btnCard_2.setVerticalTextPosition(SwingConstants.TOP);
		btnCard_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCard_3.setBorder(BorderFactory.createEmptyBorder());
		btnCard_3.setVerticalTextPosition(SwingConstants.TOP);
		btnCard_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCard_4.setBorder(BorderFactory.createEmptyBorder());
		btnCard_4.setVerticalTextPosition(SwingConstants.TOP);
		btnCard_4.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnCard.addActionListener(new CardListener(btnCard, 1));
		btnCard_1.addActionListener(new CardListener(btnCard_1, 2));
		btnCard_2.addActionListener(new CardListener(btnCard_2, 3));
		btnCard_3.addActionListener(new CardListener(btnCard_3, 4));
		btnCard_4.addActionListener(new CardListener(btnCard_4, 5));
		
		JLabel lblWinnings = new JLabel(s.getHTMLValues());
		springLayout.putConstraint(SpringLayout.NORTH, lblWinnings, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblWinnings, 0, SpringLayout.WEST, btnCard);
		getContentPane().add(lblWinnings);
		
		JButton btnDraw = new JButton("Draw");
		springLayout.putConstraint(SpringLayout.WEST, btnDraw, 0, SpringLayout.WEST, btnCard);
		getContentPane().add(btnDraw);
		btnDraw.setEnabled(false);
		
		btnDraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(lastDraw!=2) {
					if(!c1Hold) {
						c1 = d.draw();
						btnCard.setIcon(c1.getImage());
					}
					if(!c2Hold) {
						c2 = d.draw();
						btnCard_1.setIcon(c2.getImage());
					}
					if(!c3Hold) {
						c3 = d.draw();
						btnCard_2.setIcon(c3.getImage());
					}
					if(!c4Hold) {
						c4 = d.draw();
						btnCard_3.setIcon(c4.getImage());
					}
					if(!c5Hold) {
						c5 = d.draw();
						btnCard_4.setIcon(c5.getImage());
					}
					
					if(d.deckCount()<5) {
						d = new Deck(true);
					}
					lastDraw++;
				} else {
					
				}
				
				if(lastDraw==2) {
					lastDraw = 0;
					
					Hand h = new Hand();
					h.add(c1);
					h.add(c2);
					h.add(c3);
					h.add(c4);
					h.add(c5);
					
					c1Hold = false;
					c2Hold = false;
					c3Hold = false;
					c4Hold = false;
					c5Hold = false;
					
					btnCard.setText("Hold");
					btnCard_1.setText("Hold");
					btnCard_2.setText("Hold");
					btnCard_3.setText("Hold");
					btnCard_4.setText("Hold");
					
					int winnings = s.winCheck(h, amountBet);
					//GameHub.money += winnings;
					WindowTest.money += winnings;
					//GameHub.label.setText("Your money: $" + GameHub.money);
					lblYouWon.setText("You won: $" + winnings);
					//lblCurrentAmountOf.setText("$" + GameHub.money);
					lblCurrentAmountOf.setText("$" + WindowTest.money);
					btnDraw.setEnabled(false);
					btnBet.setEnabled(true);
					button.setEnabled(true);
					button_1.setEnabled(true);
					btnBet.requestFocus();
					//amountBet = 1;
					lblBetting.setText("$" + amountBet);
				}
			}
		});
		
		button = new JButton("-1");
		springLayout.putConstraint(SpringLayout.NORTH, btnDraw, 6, SpringLayout.SOUTH, button);
		springLayout.putConstraint(SpringLayout.NORTH, button, 6, SpringLayout.SOUTH, lblWinnings);
		springLayout.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, btnCard);
		getContentPane().add(button);
		
		btnBet = new JButton("Bet");
		springLayout.putConstraint(SpringLayout.NORTH, btnBet, 6, SpringLayout.SOUTH, lblWinnings);
		springLayout.putConstraint(SpringLayout.WEST, btnBet, 6, SpringLayout.EAST, button);
		getContentPane().add(btnBet);
		
		button_1 = new JButton("+1");
		springLayout.putConstraint(SpringLayout.NORTH, button_1, 6, SpringLayout.SOUTH, lblWinnings);
		springLayout.putConstraint(SpringLayout.WEST, button_1, 6, SpringLayout.EAST, btnBet);
		getContentPane().add(button_1);
		
		JButton btnDeck = new JButton();
		springLayout.putConstraint(SpringLayout.NORTH, btnDeck, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnDeck, 0, SpringLayout.EAST, btnCard_4);
		getContentPane().add(btnDeck);
		btnDeck.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
		btnDeck.setBorder(BorderFactory.createEmptyBorder());
		
		//lblCurrentAmountOf = new JLabel("$" + GameHub.money);
		lblCurrentAmountOf = new JLabel("$" + WindowTest.money);
		springLayout.putConstraint(SpringLayout.NORTH, lblCurrentAmountOf, 5, SpringLayout.NORTH, btnDraw);
		springLayout.putConstraint(SpringLayout.WEST, lblCurrentAmountOf, 10, SpringLayout.WEST, button_1);
		getContentPane().add(lblCurrentAmountOf);
		
		lblBetting = new JLabel("Betting");
		springLayout.putConstraint(SpringLayout.NORTH, lblBetting, 5, SpringLayout.NORTH, btnDraw);
		springLayout.putConstraint(SpringLayout.WEST, lblBetting, 10, SpringLayout.WEST, btnBet);
		getContentPane().add(lblBetting);
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(amountBet>1) {
					amountBet--;
					lblBetting.setText("$" + amountBet);
				}
			}
		});
		
		btnBet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDraw.setEnabled(true);
				btnBet.setEnabled(false);
				button.setEnabled(false);
				button_1.setEnabled(false);
				btnCard.setEnabled(true);
				btnCard_1.setEnabled(true);
				btnCard_2.setEnabled(true);
				btnCard_3.setEnabled(true);
				btnCard_4.setEnabled(true);
				//GameHub.money-=amountBet;
				WindowTest.money-=amountBet;
				//lblCurrentAmountOf.setText("$" + GameHub.money);
				
				lblCurrentAmountOf.setText("$" + WindowTest.money);
				//GameHub.label.setText("Your money: $" + GameHub.money);
				btnCard.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
				btnCard_1.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
				btnCard_2.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
				btnCard_3.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
				btnCard_4.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
			}
		});
		
		lblBetting.setText("$" + amountBet);
		
		lblYouWon = new JLabel("You won: $");
		springLayout.putConstraint(SpringLayout.NORTH, lblYouWon, 6, SpringLayout.SOUTH, lblWinnings);
		springLayout.putConstraint(SpringLayout.WEST, lblYouWon, 6, SpringLayout.EAST, button_1);
		getContentPane().add(lblYouWon);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(amountBet<5) {
					amountBet++;
					lblBetting.setText("$" + amountBet);
				}
			}
		});
		
		btnDraw.addKeyListener(this);
		btnDeck.setFocusable(false);
		btnCard.setFocusable(false);
		btnCard_1.setFocusable(false);
		btnCard_2.setFocusable(false);
		btnCard_3.setFocusable(false);
		btnCard_4.setFocusable(false);
		button.setFocusable(false);
		button_1.setFocusable(false);
		
	}
	
	
	class ContentPanel extends JPanel {
		  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Image bgimage = null;

		  ContentPanel() {
		    MediaTracker mt = new MediaTracker(this);
		    //bgimage = Toolkit.getDefaultToolkit().getImage("1634959.jpg");
		    bgimage = (new ImageIcon(getClass().getResource("1634959.jpg"))).getImage();
		    System.out.println(Toolkit.getDefaultToolkit().getImage("1634959.jpg"));
		    
		    mt.addImage(bgimage, 0);
		    try {
		      mt.waitForAll();
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
		  }

		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		   // int imwidth = bgimage.getWidth(null);
		    //int imheight = bgimage.getHeight(null);
		    g.drawImage(bgimage, 1, 1, getWidth(), getHeight(), null);
		  }
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyChar());
		char c = e.getKeyChar();
		if(c=='1') {
			change(btnCard, c1Hold);
			c1Hold = !c1Hold;
		}
		if(c=='2') {
			change(btnCard_1, c2Hold);
			c2Hold = !c2Hold;
		}
		if(c=='3') {
			change(btnCard_2, c3Hold);
			c3Hold = !c3Hold;
		}
		if(c=='4') {
			change(btnCard_3, c4Hold);
			c4Hold = !c4Hold;
		}
		if(c=='5') {
			change(btnCard_4, c5Hold);
			c5Hold = !c5Hold;
		}
		
		
		
	}
	
	public void change(JButton but, boolean held) {
		if(but.getText().equalsIgnoreCase("Hold")) {
			but.setText("Holding");
		} else if(but.getText().equalsIgnoreCase("Holding")) {
			but.setText("Hold");
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
	}

}
