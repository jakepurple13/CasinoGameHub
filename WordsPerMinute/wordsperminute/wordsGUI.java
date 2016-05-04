package wordsperminute;

import gameHub.GameHub;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;


public class wordsGUI extends JFrame {

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
					wordsGUI frame = new wordsGUI();
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
	Timer t;
	int wordCount = 0;
	String g;
	ArrayList<String> misspelled = new ArrayList<String>();
	ArrayList<String> spelled = new ArrayList<String>();
	ArrayList<String> allWords;
	JScrollPane scrollPane_1;
	
	
	public wordsGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		allWords = new ArrayList<String>();
		allWords.clear();
		
		JButton btnStart = new JButton("Start");
		contentPane.add(btnStart);
		btnStart.setFocusable(false);
		
		JLabel lblWordsPerMinute = new JLabel("Words per minute:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblWordsPerMinute, 6, SpringLayout.SOUTH, btnStart);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWordsPerMinute, 0, SpringLayout.WEST, btnStart);
		contentPane.add(lblWordsPerMinute);
		
		JLabel lblTimer = new JLabel("Timer");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnStart, 0, SpringLayout.WEST, lblTimer);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTimer, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblTimer, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblTimer);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 83, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -88, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnStart, 6, SpringLayout.SOUTH, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, lblTimer);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 430, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEnabled(false);
		scrollPane.setViewportView(textArea);
		
		scrollPane.getViewport().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int newValue = scrollPane_1.getVerticalScrollBar().getValue()+10;
				scrollPane_1.getVerticalScrollBar().setValue(newValue);
			}
		});
		
		
		scrollPane_1 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_1, 5, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_1, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_1, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_1, -6, SpringLayout.NORTH, scrollPane);
		contentPane.add(scrollPane_1);
		
		JTextPane lblWordsToType = new JTextPane();
		scrollPane_1.setViewportView(lblWordsToType);
		
		JLabel lblWordsTyped = new JLabel("Words typed");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblWordsTyped, 0, SpringLayout.NORTH, lblWordsPerMinute);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblWordsTyped, 0, SpringLayout.EAST, scrollPane);
		contentPane.add(lblWordsTyped);
		
		lblWordsToType.setText("Words to type");
		lblWordsToType.setEditable(false);
		
		JLabel lblCorrect = new JLabel("Correct");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCorrect, 0, SpringLayout.NORTH, lblTimer);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblCorrect, 0, SpringLayout.EAST, scrollPane);
		contentPane.add(lblCorrect);
		
		JButton btnAccuracy = new JButton("Accuracy");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAccuracy, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAccuracy, -6, SpringLayout.WEST, lblCorrect);
		contentPane.add(btnAccuracy);
		btnAccuracy.setEnabled(false);
		
		
		btnAccuracy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object[] options = {"OK"}; //0
				String mispelled = "";
				
				for(int i=0;i<misspelled.size();i++) {
					mispelled+=misspelled.get(i) + "=" + spelled.get(i) + "\n";
				}
				
				int choice = -1;
				choice = JOptionPane.showOptionDialog(wordsGUI.this,
			    mispelled,
			    "Words that were misspelled",
			    JOptionPane.YES_NO_CANCEL_OPTION,
			    JOptionPane.QUESTION_MESSAGE,
			    null,
			    options,
			    options[0]);
				
				System.out.println(choice);
				
			}
		});
		
		
		t = new Timer();
		
		g = "";
		try {
			getWords(g);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnStart.setEnabled(false);
				textArea.setEnabled(true);
				textArea.setEditable(true);
				btnAccuracy.setEnabled(false);
				lblWordsToType.setText(getWords1(g));
				lblWordsToType.setCaretPosition(0);
				textArea.requestFocus();
				textArea.setText("");
				lblWordsPerMinute.setText("Words per minute: " + 0);
				lblCorrect.setText(0 + " words correct");
				btnAccuracy.setText("Accuracy: " + 0 + "%");
				lblWordsTyped.setText(0 + " words");
				counter = 0;
				t.scheduleAtFixedRate(new TimerTask() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						 System.out.println("TimerTask executing counter is: " + counter);
			             counter++;//increments the counter
			             lblTimer.setText((60-counter) + " seconds left");
			             if(counter==60) {
			            	 textArea.setEditable(false);
			            	 btnStart.setEnabled(true);
			            	 misspelled.clear();
			            	 spelled.clear();
			            	 int list = wordCount(textArea.getText());
			            	 lblWordsPerMinute.setText("Words per minute: " + list);
			            	 t.cancel();
			            	 t = new Timer();
			            	 int correctness = check(textArea, lblWordsToType);
			            	 lblCorrect.setText(correctness + " words correct");
			            	 GameHub.money+=(correctness*50);
			            	 GameHub.label.setText("Your money: $" + GameHub.money);
			            	 btnAccuracy.setEnabled(true);
			            	 double q = (double) ((correctness + 0.0)/textArea.getText().split(" ").length);
			            	 double j = q*100;
			            	 int a = (int) j;
			            	 //double z = a/100.0;
			            	 
			            	 btnAccuracy.setText("Accuracy: " + a + "%");
			            	 
			            	 g = "";
			             }
					}
				}, 0, 1000);
			}
		});
		
		
		textArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar() == KeyEvent.VK_SPACE) {
					wordCount++;
					lblWordsTyped.setText(textArea.getText().split(" ").length + " words");
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	
	
	public int wordCount(String words) {
		
		String[] worded;
		worded = words.split(" "); //use this and set it into an array
		int count = 0;
		
		for(int i=0;i<worded.length;i++) {
			try {
				if(getText(worded[i])) {
					count++;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count;
	}
	
	public boolean getText(String word) throws FileNotFoundException, IOException {
		InputStream is = getClass().getResourceAsStream("english.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		try {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	// process the line.
		    	line = line.substring(0, line.indexOf(" "));
		    	if(line.equalsIgnoreCase(word)) { 
		    		br.close();
		    		//System.out.println(line + "|" + i);
		    		return true;
		    	}
		    }   
		} catch(IOException e) {
			System.out.print(e);
		}
		br.close();
		return false;
	}
	
	
	public void getWords(String word) throws IOException {
	
		InputStream is = getClass().getResourceAsStream("english.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		int i = 0;
			try {
			    String line;
			    while ((line = br.readLine()) != null) {
			    	// process the line.
			    	line = line.substring(0, line.indexOf(" "));
			    	allWords.add(line);
			    	System.out.println(line + "|" + i);
			    	i++;
			    }
			    
			    
		} catch(IOException e) {
			System.out.print(e);
		}
		br.close();
		//puts 500 random words into word
		
	}
	
	public String getWords1(String word) {
		word = "";
		Random gen = new Random();
		
		for(int j=0;j<500;j++) {
			word+=allWords.remove(gen.nextInt(allWords.size()-1)) + "   ";
		}
		return word;
	}
	
	
	public int check(JTextArea typing, JTextPane toType) {
		//add all the mispelled words to an arraylist or maybe even a map or tree
		//to display in another window
		String[] typed = typing.getText().split(" ");
		String[] toTyped = toType.getText().split("   ");
		int count = 0;
		for(int i=0;i<typed.length;i++) {
			if(typed[i].equalsIgnoreCase(toTyped[i])) {
				count++;
			} else {
				misspelled.add(typed[i]);
				spelled.add(toTyped[i]);
			}
		}
		return count;
	}
	
	
}
