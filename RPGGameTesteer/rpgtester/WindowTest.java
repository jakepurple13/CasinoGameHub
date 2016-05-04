package rpgtester;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pokerGUI.VideoPoker;
import wordsperminute.wordsGUI;

import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import java.util.Timer;
import java.util.TimerTask;


public class WindowTest extends JFrame implements KeyListener {

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
					WindowTest frame = new WindowTest(args);
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
	
	int size = 7; //default is 10
	int x = size/2;
	int y = size/2;
	int width = 0;
	int height = 0;
	JButton[][] grid;
	String[] arg;
	String last = "N";
	String imagePath = "Spr_GS_Red.png";
	public static double money = 0;
	public static double bet = 0;
	public static JLabel label;
	public static int chessUnlocked = 0;
	public static int yahtzeeUnlocked = 0;
	public static int calculationUnlocked = 0;
	public static int videoPokerUnlocked = 0;
	public static int wordsPerMinuteUnlocked = 0;
	
	int counter = 0;
	
	
	public WindowTest(String[] args) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(size, size, 0, 0));
		grid = new JButton[size][size];
		
		
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
		
		setTitle("$" + money);
		
		arg = args;
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				grid[i][j] = new JButton("N");
				grid[i][j].addKeyListener(this);
				/*grid[i][j].setOpaque(true);
				grid[i][j].setBorderPainted(false);*/
				add(grid[i][j]);
				
			}
		}

		
		
		Timer t = new Timer();
		
		t.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				 System.out.println("TimerTask executing counter is: " + counter);
	             counter++;//increments the counter
	             grid[1][1].setText(counter + "");
	             if(counter==60) {
	            	
	            	 t.cancel();
	            	
	             }
			}
		}, 0, 1000);
		
		grid[x][y].setText("");
		grid[x][y].setIcon(new ImageIcon(getClass().getResource(imagePath)));

		
		grid[x][y].addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				width = grid[x][y].getWidth();
				height = grid[x][y].getHeight();
				Image img = new ImageIcon(getClass().getResource(imagePath)).getImage() ;
				Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;  
				Icon icon = new ImageIcon( newimg );
				grid[x][y].setIcon(icon);
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		
		
		grid[0][0].setText("Yahtzee");
		grid[0][size-1].setText("Chess");
		grid[size-1][0].setText("Calculation");
		grid[size-1][size-1].setText("Video Poker");
		grid[size/2][0].setText("WPM");
		grid[size/2][size-1].setText("Tetris");
		grid[size-1][size/2].setText("Quit");
		
		printGrid();
		
		this.addWindowListener(new WindowListener() {
			
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		try {
			grid[x][y].setText(last);
			grid[x][y].setIcon(null);
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				x--;
				last = grid[x][y].getText();
			} else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				y--;
				last = grid[x][y].getText();
			} else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				y++;
			} else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				x++;
			}
			last = grid[x][y].getText();
			grid[x][y].setText("");
			Image img = new ImageIcon(getClass().getResource(imagePath)).getImage() ;
			Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;  
			Icon icon = new ImageIcon( newimg );
			grid[x][y].setIcon(icon);
			
		} catch(IndexOutOfBoundsException r) {
			if(x>size-1) {
				x=size-1;
			} else if(x<0) {
				x = 0;
			}
			
			if(y>size-1) {
				y=size-1;
			} else if(y<0) {
				y=0;
			}
			grid[x][y].setText("Y");
		}
		
		grid[x][y].addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
				width = grid[x][y].getWidth();
				height = grid[x][y].getHeight();
				Image img = new ImageIcon(getClass().getResource(imagePath)).getImage() ;  
				Image newimg = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH ) ;  
				Icon icon = new ImageIcon( newimg );
				grid[x][y].setIcon(icon);
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		location(x, y);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void location(int x, int y) {
		
		if(x==0 && y==0) { //yahtzee
			gui.GUI.main(arg);
		} else if(x==size-1 && y==size-1) { //video poker
			VideoPoker.main(arg);
		} else if(x==size/2 && y==0) { //wpm
			wordsGUI.main(arg);
		} else if(x==0 && y==size-1) { //chess
			ChessGUI.GUI.main(arg);
		} else if(x==size-1 && y==0) { //calculation
			calculation.Mainer.main(arg);
		} else if(x == size/2 && y==size-1) { //tetris
			//Tetris.main(arg);
		} else if(x == size-1 && y == size/2) { //quit
			System.exit(-1);
		}
		
	}
	
	
	public void printGrid() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(grid[i][j].getText() + "|");
			}
			System.out.print("\n");
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
	
	

}
