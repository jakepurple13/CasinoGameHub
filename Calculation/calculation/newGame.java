package calculation;
import gameHub.GameHub;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;


public class newGame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			newGame dialog = new newGame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public newGame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			JLabel lblWinner = new JLabel("Winner!!!");
			
			Font labelFont = lblWinner.getFont();
			String labelText = lblWinner.getText();

			int stringWidth = lblWinner.getFontMetrics(labelFont).stringWidth(labelText);
			int componentWidth = getWidth();

			// Find out how much the font can grow in width.
			double widthRatio = (double)componentWidth / (double)stringWidth;

			int newFontSize = (int)(labelFont.getSize() * widthRatio);
			int componentHeight = getHeight();

			// Pick a new font size so it will not be larger than the height of label.
			int fontSizeToUse = Math.min(newFontSize, componentHeight);

			// Set the label's font size to the newly determined size.
			lblWinner.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
			//lblWinner.setFont(new Font(labelFont.getName(), Font.PLAIN, 21));

			
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblWinner, 10, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblWinner, 203, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, lblWinner, -194, SpringLayout.EAST, contentPanel);
			contentPanel.add(lblWinner);
			setBounds(100, 100, 886, 229);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("New Game");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					
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
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Quit");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//System.exit(-1);
						double q = getMoney(GameHub.bet);
						GameHub.money+=q;
						GameHub.label.setText("Your money: $" + GameHub.money);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		
	}
	
	public double getMoney(double current) {
		current += (current*.15);
		return current;
	}
	
	public newGame(boolean won) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		SpringLayout sl_contentPanel = new SpringLayout();
		contentPanel.setLayout(sl_contentPanel);
		{
			JLabel lblWinner = new JLabel("Loser!!!");
			
			Font labelFont = lblWinner.getFont();
			String labelText = lblWinner.getText();

			int stringWidth = lblWinner.getFontMetrics(labelFont).stringWidth(labelText);
			int componentWidth = getWidth();

			// Find out how much the font can grow in width.
			double widthRatio = (double)componentWidth / (double)stringWidth;

			int newFontSize = (int)(labelFont.getSize() * widthRatio);
			int componentHeight = getHeight();

			// Pick a new font size so it will not be larger than the height of label.
			int fontSizeToUse = Math.min(newFontSize, componentHeight);

			// Set the label's font size to the newly determined size.
			lblWinner.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));
			//lblWinner.setFont(new Font(labelFont.getName(), Font.PLAIN, 21));

			
			sl_contentPanel.putConstraint(SpringLayout.NORTH, lblWinner, 10, SpringLayout.NORTH, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.WEST, lblWinner, 203, SpringLayout.WEST, contentPanel);
			sl_contentPanel.putConstraint(SpringLayout.EAST, lblWinner, -194, SpringLayout.EAST, contentPanel);
			contentPanel.add(lblWinner);
			setBounds(100, 100, 886, 229);
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("New Game");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
					
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
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Quit");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(-1);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		
	}

}
