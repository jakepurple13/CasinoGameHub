package calculation;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.undo.UndoManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import Cards.Card;
import Cards.Deck;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;





import javax.swing.JLabel;
import javax.swing.JButton;


public class Mainer extends JFrame implements MouseListener, KeyListener {

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
					Mainer frame = new Mainer();
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
	
	Stockpile s;
	Holding h;
	ArrayList<Card> holder;
	UndoManager um;
	
	public Mainer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 619, 480);
		//setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH );
		//Color col = new Color();
		//setBackground(col);
		
		contentPane = new ContentPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(new JLabel(new ImageIcon(getClass().getResource("1634959.jpg"))));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		
		Card one = d.getFirstCardByValue(1);
		Card two = d.getFirstCardByValue(2);
		Card three = d.getFirstCardByValue(3);
		Card four = d.getFirstCardByValue(4);
		
		s = new Stockpile(one, two, three, four);
		h = new Holding();
		holder = new ArrayList<Card>();
		
		um = new UndoManager();
		
		
		 lblOne = new JLabel("One");
		contentPane.add(lblOne, "2, 2");
		lblOne.setIcon(one.getImage());
		
		 lblTwo = new JLabel("Two");
		contentPane.add(lblTwo, "4, 2");
		lblTwo.setIcon(two.getImage());
		
		 lblThree = new JLabel("Three");
		contentPane.add(lblThree, "6, 2");
		lblThree.setIcon(three.getImage());
		
		 lblFour = new JLabel("Four");
		contentPane.add(lblFour, "8, 2");
		lblFour.setIcon(four.getImage());
		
		lblNextNumber = new JLabel("Next Number");
		contentPane.add(lblNextNumber, "2, 4");
		
		lblNextNumber_1 = new JLabel("Next Number");
		contentPane.add(lblNextNumber_1, "4, 4");
		
		lblNextNumber_2 = new JLabel("Next Number");
		contentPane.add(lblNextNumber_2, "6, 4");
		
		lblNextNumber_3 = new JLabel("Next Number");
		contentPane.add(lblNextNumber_3, "8, 4");
		
		lblNextNumber.setForeground(Color.white);
		lblNextNumber_1.setForeground(Color.white);
		lblNextNumber_2.setForeground(Color.white);
		lblNextNumber_3.setForeground(Color.white);
		
		
		lblCardsLeft = new JLabel("48 cards left");
		contentPane.add(lblCardsLeft, "2, 10");
		lblCardsLeft.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
		
		lblCardsLeft.setForeground(Color.white);
		
		
		lblDrawn = new JLabel("Drawn");
		contentPane.add(lblDrawn, "4, 10");
		lblDrawn.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
		
		lblCardToMove = new JLabel("Card to Move");
		contentPane.add(lblCardToMove, "8, 10");
		
		btnDraw = new JButton("Draw");
		contentPane.add(btnDraw, "2, 12");
		
		//addKeyListener(this);
		
		btnDraw.addKeyListener(this);
		
		btnDraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*Card one = d.getFirstCardByValue(1);
				Card two = d.getFirstCardByValue(2);
				Card three = d.getFirstCardByValue(3);
				Card four = d.getFirstCardByValue(4);
				
				
				
				
				
				lblOne.setIcon(one.getImage());
				lblTwo.setIcon(two.getImage());
				lblThree.setIcon(three.getImage());
				lblFour.setIcon(four.getImage());*/
				
				/*Card five = d.draw();
				Card six = d.draw();
				Card seven = d.draw();
				Card eight = d.draw();
				
				
				
				lblFive.setIcon(five.getImage());
				lblSix.setIcon(six.getImage());
				lblSeven.setIcon(seven.getImage());
				lblEight.setIcon(eight.getImage());
				
				
				
				h.adda(five);
				h.addb(six);
				h.addc(seven);
				h.addd(eight);*/
				if(pass) {
					if(toMove!=null) {
						d.addCard(toMove);
						//holder.remove(toMove);
					}
				}
				
				
				
				
				
				
				Card f = d.draw();
				toMove = f;
				lblDrawn.setIcon(f.getImage());
				moved = lblDrawn;
				holder.add(f);
				lblCardsLeft.setText(d.deckCount() + " cards left");
				System.out.println();
				System.err.println(holder);
				System.out.println(d);
				System.out.println();
				System.out.println(one + "\t" + two + "\t" + three + "\t" + four);
				System.out.println("------------------------");
				System.out.println();
				System.out.println(s);
				System.out.println();
				System.out.println(h);
				
				ArrayList<Card> fiveli = h.getOne();
				ArrayList<Card> sixli = h.getTwo();
				ArrayList<Card> sevenli = h.getThree();
				ArrayList<Card> eightli = h.getFour();
				
				String fi = "<html>";
				for(int i=0;i<fiveli.size();i++) {
					fi+=fiveli.get(i)+"<br>";
				}
				fi+="</html>";
				lblFiveList.setText(fi);
				
				String si = "<html>";
				for(int i=0;i<sixli.size();i++) {
					si+=sixli.get(i)+"<br>";
				}
				si+="</html>";
				lblSixList.setText(si);
				
				String sei = "<html>";
				for(int i=0;i<sevenli.size();i++) {
					sei+=sevenli.get(i)+"<br>";
				}
				sei+="</html>";
				lblSevenList.setText(sei);
				
				String ei = "<html>";
				for(int i=0;i<eightli.size();i++) {
					ei+=eightli.get(i)+"<br>";
				}
				ei+="</html>";
				lblEightList.setText(ei);
				
				lblNextNumber.setText(s.nextOne());
				lblNextNumber_1.setText(s.nextTwo());
				lblNextNumber_2.setText(s.nextThree());
				lblNextNumber_3.setText(s.nextFour());
				
				
				//lblNewLabel.setText(h.toString());
				if(!pass) {
					btnDraw.setEnabled(false);
				}
				
				
					
				if(d.deckCount()<=3) {
					//System.out.println("------------------------" + );
					for(int i=0;i<holder.size();i++) {
						//d.addCard(holder.get(i));
					}
					if(d.deckCount()==0) {
						btnDraw.setEnabled(false);
					}
					//holder.clear();
					//d = new Deck(true);
					System.out.println("------------------------" + d.deckCount());
				}
				
			}
		});
		
		lblFive = new JLabel("Five");
		contentPane.add(lblFive, "2, 16");
		
		lblSix = new JLabel("Six");
		contentPane.add(lblSix, "4, 16");
		
		lblSeven = new JLabel("Seven");
		contentPane.add(lblSeven, "6, 16");
		
		lblEight = new JLabel("Eight");
		contentPane.add(lblEight, "8, 16");
		
		lblFiveList = new JLabel("Five List");
		contentPane.add(lblFiveList, "2, 20");
		
		lblSixList = new JLabel("Six List");
		contentPane.add(lblSixList, "4, 20");
		
		lblSevenList = new JLabel("Seven List");
		contentPane.add(lblSevenList, "6, 20");
		
		lblEightList = new JLabel("Eight List");
		contentPane.add(lblEightList, "8, 20");
		
		lblFive.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
		lblSix.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
		lblSeven.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
		lblEight.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
		
		lblFiveList.setForeground(Color.white);
		lblSixList.setForeground(Color.white);
		lblSevenList.setForeground(Color.white);
		lblEightList.setForeground(Color.white);
		
		
		lblOne.addMouseListener(this);
		lblTwo.addMouseListener(this);
		lblThree.addMouseListener(this);
		lblFour.addMouseListener(this);
		
		lblFive.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(toMove==null) {
					Card asdf = h.get1();
					toMove = asdf;
					lblCardToMove.setIcon(asdf.getImage());
					Card qwe;
					moved = lblFive;
					try {
						qwe = h.get1();
						h.adda(qwe);
						lblFive.setIcon(null);
						lblFive.validate();
						lblFive.setIcon(qwe.getImage());
					} catch(NullPointerException g) {
						lblFive.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblFive.validate();
					} catch(ArrayIndexOutOfBoundsException g) {
						lblFive.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblFive.validate();
					}
				} else {
					lblDrawn.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
					lblDrawn.validate();
					btnDraw.setEnabled(true);
					lblFive.setIcon(toMove.getImage());
					h.adda(toMove);
					toMove = null;
				}
				showNumbers();
			}
		});
		
		lblSix.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(toMove==null) {
					Card asdf = h.get2();
					toMove = asdf;
					lblCardToMove.setIcon(asdf.getImage());
					moved = lblSix;
					Card qwe;
					try {
						qwe = h.get2();
						h.addb(qwe);
						lblSix.setIcon(null);
						lblSix.validate();
						lblSix.setIcon(qwe.getImage());
					} catch(NullPointerException g) {
						lblSix.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblSix.validate();
					} catch(ArrayIndexOutOfBoundsException g) {
						lblSix.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblSix.validate();
					}
					} else {
						lblDrawn.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblDrawn.validate();
						lblSix.setIcon(toMove.getImage());
						btnDraw.setEnabled(true);
						h.addb(toMove);
						toMove = null;
					}
				showNumbers();
			}
		});
		
		lblSeven.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(toMove==null) {
					Card asdf = h.get3();
					toMove = asdf;
					lblCardToMove.setIcon(asdf.getImage());
					moved = lblSeven;
					Card qwe;
					try {
						qwe = h.get3();
						h.addc(qwe);
						lblSeven.setIcon(null);
						lblSeven.validate();
						lblSeven.setIcon(qwe.getImage());
					} catch(NullPointerException g) {
						lblSeven.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblSeven.validate();
					} catch(ArrayIndexOutOfBoundsException g) {
						lblSeven.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblSeven.validate();
					}
					} else {
						lblDrawn.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblDrawn.validate();
						lblSeven.setIcon(toMove.getImage());
						btnDraw.setEnabled(true);
						h.addc(toMove);
						toMove = null;
					}
				showNumbers();
			}
		});

		lblEight.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(toMove==null) {
					Card asdf = h.get4();
					toMove = asdf;
					lblCardToMove.setIcon(asdf.getImage());
					moved = lblEight;
					Card qwe;
					try {
						qwe = h.get4();
						h.addd(qwe);
						lblEight.setIcon(null);
						lblEight.validate();
						lblEight.setIcon(qwe.getImage());
					} catch(NullPointerException g) {
						lblEight.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblEight.validate();
					} catch(ArrayIndexOutOfBoundsException g) {
						lblEight.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblEight.validate();
					}
					} else {
						lblDrawn.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
						lblDrawn.validate();
						lblEight.setIcon(toMove.getImage());
						btnDraw.setEnabled(true);
						h.addd(toMove);
						toMove = null;
						moved = lblEight;
					}
				showNumbers();
			}
		});
		
		//pack();
		/*ImageIcon iii = new ImageIcon("/Users/Jacob/Downloads/1634959.jpg");
		contentPane.setsetIconImage(iii.getImage());*/
		
		//contentPane.paintComponent(paintComponent(getGraphics()));
		/*JLabel back = new JLabel(new ImageIcon("/Users/Jacob/Downloads/1634959.jpg"));
		add(back);
		back.setLayout(new FlowLayout());*/
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Options");
		
		JMenuItem menuItem = new JMenuItem("New Game");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Mainer frame = new Mainer();
					frame.setVisible(true);
				} catch (Exception q) {
					q.printStackTrace();
				}
				
				dispose();
			}
		});
		
		JMenuItem menuItem2 = new JMenuItem("Developer Password");
		menuItem2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JPasswordField pf = new JPasswordField();
				int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				if (okCxl == JOptionPane.OK_OPTION) {
				  String password = new String(pf.getPassword());
				  System.err.println("You entered: " + password);
				  if(password.equalsIgnoreCase("bjAlert")) {
					  
					  pass = true;
					  btnDraw.setEnabled(true);
					  
				  }
				  
				  
				}
			}
		});
		
		
		
		
		/*JMenuItem menuItem1 = new JMenuItem("Undo");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				um.undo();
				
				
				dispose();
			}
		});*/
		
		menu.add(menuItem);
		//menu.add(menuItem1);
		menu.add(menuItem2);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		lblOne.setText("");
		lblTwo.setText("");
		lblThree.setText("");
		lblFour.setText("");
		lblFive.setText("");
		lblSix.setText("");
		lblSeven.setText("");
		lblEight.setText("");
		
		showNumbers();
		
		
	}
	
	
	boolean pass = false;
	
	   /* public void paintComponent(Graphics g) {
	       // super.paintComponent(g);
	        Graphics2D g2d = (Graphics2D) g;
	        Color color1 = getBackground();
	        Color color2 = color1.darker();
	        int w = getWidth();
	        int h = getHeight();
	        GradientPaint gp = new GradientPaint(
	            0, 0, color1, 0, h, color2);
	        g2d.setPaint(gp);
	        g2d.fillRect(0, 0, w, h);
	    }*/
	
	Card toMove;
	
	JLabel moved;
	
	Deck d = new Deck(true);
	JLabel lblFour;
	JLabel lblThree;
	JLabel lblTwo;
	JLabel lblOne;
	private JButton btnDraw;
	private JLabel lblFive;
	private JLabel lblSix;
	private JLabel lblSeven;
	private JLabel lblEight;
	private JLabel lblDrawn;
	private JLabel lblCardToMove;
	private JLabel lblCardsLeft;
	private JLabel lblFiveList;
	private JLabel lblSixList;
	private JLabel lblSevenList;
	private JLabel lblEightList;
	private JLabel lblNextNumber;
	private JLabel lblNextNumber_1;
	private JLabel lblNextNumber_2;
	private JLabel lblNextNumber_3;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel q = (JLabel) e.getSource();
		
		
		if(q.equals(lblOne)) {
			if(s.add1(toMove)) {
				q.setIcon(toMove.getImage());
				lblCardToMove.setIcon(null);
				lblCardToMove.validate();
			} else {
				moved.setIcon(toMove.getImage());
				lblCardToMove.setIcon(null);
				lblCardToMove.validate();
				if(moved.equals(lblFive)) {
					h.adda(toMove);
				} else if(moved.equals(lblSix)) {
					h.addb(toMove);
				} else if(moved.equals(lblSeven)) {
					h.addc(toMove);
				} else if(moved.equals(lblEight)) {
					h.addd(toMove);
				} else if(moved.equals(lblDrawn)) {
					moved.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
					moved.validate();
					d.addCard(toMove);
				}
			}
			
			if(moved.equals(lblDrawn)) {
				lblDrawn.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
				lblDrawn.validate();
				btnDraw.setEnabled(true);
			}
			
			
			toMove = null;
			moved = null;
			System.out.println("HIASDJLAKHSLDJH");
		} else if(q.equals(lblTwo)) {
			if(s.add2(toMove)) {
				q.setIcon(toMove.getImage());
				lblCardToMove.setIcon(null);
				lblCardToMove.validate();
			} else {
				moved.setIcon(toMove.getImage());
				lblCardToMove.setIcon(null);
				lblCardToMove.validate();
				if(moved.equals(lblFive)) {
					h.adda(toMove);
				} else if(moved.equals(lblSix)) {
					h.addb(toMove);
				} else if(moved.equals(lblSeven)) {
					h.addc(toMove);
				} else if(moved.equals(lblEight)) {
					h.addd(toMove);
				} else if(moved.equals(lblDrawn)) {
					moved.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
					moved.validate();
					d.addCard(toMove);
				}
			}
			
			if(moved.equals(lblDrawn)) {
				lblDrawn.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
				lblDrawn.validate();
				btnDraw.setEnabled(true);
			}
			
			toMove = null;
			moved = null;
			System.out.println("HIASDJLAKHSLDJH");
		} else if(q.equals(lblThree)) {
			if(s.add3(toMove)) {
				q.setIcon(toMove.getImage());
				lblCardToMove.setIcon(null);
				lblCardToMove.validate();
			} else {
				moved.setIcon(toMove.getImage());
				lblCardToMove.setIcon(null);
				lblCardToMove.validate();
				if(moved.equals(lblFive)) {
					h.adda(toMove);
				} else if(moved.equals(lblSix)) {
					h.addb(toMove);
				} else if(moved.equals(lblSeven)) {
					h.addc(toMove);
				} else if(moved.equals(lblEight)) {
					h.addd(toMove);
				} else if(moved.equals(lblDrawn)) {
					moved.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
					moved.validate();
					d.addCard(toMove);
				}
			}
			
			if(moved.equals(lblDrawn)) {
				lblDrawn.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
				lblDrawn.validate();
				//if(toMove==null) {
					btnDraw.setEnabled(true);
				//}
			}
			
			toMove = null;
			moved = null;
			System.out.println("HIASDJLAKHSLDJH");
		} else if(q.equals(lblFour)) {
			if(s.add4(toMove)) {
				q.setIcon(toMove.getImage());
				lblCardToMove.setIcon(null);
				lblCardToMove.validate();
			} else {
				moved.setIcon(toMove.getImage());
				lblCardToMove.setIcon(null);
				lblCardToMove.validate();
				if(moved.equals(lblFive)) {
					h.adda(toMove);
				} else if(moved.equals(lblSix)) {
					h.addb(toMove);
				} else if(moved.equals(lblSeven)) {
					h.addc(toMove);
				} else if(moved.equals(lblEight)) {
					h.addd(toMove);
				} else if(moved.equals(lblDrawn)) {
					moved.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
					moved.validate();
					d.addCard(toMove);
				}
				/*if(moved.equals(lblDrawn)) {
					moved.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
					moved.validate();
				}*/
			}
			
			
			if(moved.equals(lblDrawn)) {
				lblDrawn.setIcon(new ImageIcon(getClass().getResource("b1fvtrans.png")));
				lblDrawn.validate();
				btnDraw.setEnabled(true);
			}
			moved.validate();
			toMove = null;
			moved = null;
			System.out.println("HIASDJLAKHSLDJH");
		} 
		
		
		/*moved.setIcon(new ImageIcon(getClass().getResource("b1fv.png")));
		moved.validate();*/
		showNumbers();
		
		//bf1v
		
		
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		if(e.getKeyChar()=='h') {
			if(lblNextNumber.isVisible()) {
				lblNextNumber.setVisible(false);
				lblNextNumber_1.setVisible(false);
				lblNextNumber_2.setVisible(false);
				lblNextNumber_3.setVisible(false);
				validate();
			} else if(!lblNextNumber.isVisible()) {
				lblNextNumber.setVisible(true);
				lblNextNumber_1.setVisible(true);
				lblNextNumber_2.setVisible(true);
				lblNextNumber_3.setVisible(true);
				validate();
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		/*if(e.getKeyCode()==KeyEvent.VK_H) {
			if(lblNextNumber.isVisible()) {
				lblNextNumber.setVisible(false);
				lblNextNumber_1.setVisible(false);
				lblNextNumber_2.setVisible(false);
				lblNextNumber_3.setVisible(false);
			} else if(!lblNextNumber.isVisible()) {
				lblNextNumber.setVisible(true);
				lblNextNumber_1.setVisible(true);
				lblNextNumber_2.setVisible(true);
				lblNextNumber_3.setVisible(true);
			}
		}*/
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void showNumbers() {
		ArrayList<Card> fiveli = h.getOne();
		ArrayList<Card> sixli = h.getTwo();
		ArrayList<Card> sevenli = h.getThree();
		ArrayList<Card> eightli = h.getFour();
		
		String fi = "<html>";
		for(int i=0;i<fiveli.size();i++) {
			fi+=fiveli.get(i)+"<br>";
		}
		fi+="</html>";
		lblFiveList.setText(fi);
		
		String si = "<html>";
		for(int i=0;i<sixli.size();i++) {
			si+=sixli.get(i)+"<br>";
		}
		si+="</html>";
		lblSixList.setText(si);
		
		String sei = "<html>";
		for(int i=0;i<sevenli.size();i++) {
			sei+=sevenli.get(i)+"<br>";
		}
		sei+="</html>";
		lblSevenList.setText(sei);
		
		String ei = "<html>";
		for(int i=0;i<eightli.size();i++) {
			ei+=eightli.get(i)+"<br>";
		}
		ei+="</html>";
		lblEightList.setText(ei);
		
		lblNextNumber.setText(s.nextOne());
		lblNextNumber_1.setText(s.nextTwo());
		lblNextNumber_2.setText(s.nextThree());
		lblNextNumber_3.setText(s.nextFour());
		
		if(d.deckCount()==0) {
			if(h.isEmpty()) {
				System.err.println("Holding is EMPTY!!!");
				if(lblNextNumber.getText().equalsIgnoreCase("Done")) {
					if(lblNextNumber_1.getText().equalsIgnoreCase("Done")) {
						if(lblNextNumber_2.getText().equalsIgnoreCase("Done")) {
							if(lblNextNumber_3.getText().equalsIgnoreCase("Done")) {
								try {
									newGame dialog = new newGame();
									dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									dialog.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
								dispose();
							}
						}
					}
				}
			} else if(!h.isEmpty()) {
				/*Card one;
				Card two;
				Card three;
				Card four;
				try {
					one = h.get1();
				} catch(ArrayIndexOutOfBoundsException q) {
					one = new Card(null, 13);;
				}
				try {
					two = h.get2();
				} catch(ArrayIndexOutOfBoundsException q) {
					two = new Card(null, 13);;
				}
				try {
					three = h.get3();
				} catch(ArrayIndexOutOfBoundsException q) {
					three = new Card(null, 13);;
				}
				try {
					four = h.get4();
				} catch(ArrayIndexOutOfBoundsException q) {
					four = new Card(null, 13);
				}
				
				
				ArrayList<String> carded = new ArrayList<String>();
				
				carded.add(num(one.getValue()));
				carded.add(num(two.getValue()));
				carded.add(num(three.getValue()));
				carded.add(num(four.getValue()));
				
				
				ArrayList<String> stock = new ArrayList<String>();
				
				String s1 = s.nextOne();
				String s2 = s.nextTwo();
				String s3 = s.nextThree();
				String s4 = s.nextFour();
				
				stock.add(s1);
				stock.add(s2);
				stock.add(s3);
				stock.add(s4);
				
				
				Collections.sort(carded);
				Collections.sort(stock);
				boolean w = true;
				for(int i=0;i<4;i++) {
					if(!carded.get(i).equalsIgnoreCase(stock.get(i))) {
						w = false;
					} else if(!stock.contains(carded.get(i))) {
						w = false;
					}
				}
				
				if(w) {
					try {
						newGame dialog = new newGame(true);
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
					dispose();
				} else {
					if(one.getSuits()!=null)
						h.adda(one);
					if(two.getSuits()!=null)
						h.addb(two);
					if(three.getSuits()!=null)
						h.addc(three);
					if(four.getSuits()!=null)
						h.addd(four);
				}*/
			}
		}
		
	}
	
	public String num(int numb) {
		String g = "";
		
		if(numb==11) {
			g="J";
		} else if(numb==12) {
			g="Q";
		} else if(numb==13) {
			g="K";
		} else if(numb==14) {
			g="Ace";
		} else {
			g=numb+"";
		}
		
		
		return g;
	}
	

}
