package blackjackGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BlackJack extends JFrame {

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
					BlackJack frame = new BlackJack();
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
	public BlackJack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new ContentPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
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

}
