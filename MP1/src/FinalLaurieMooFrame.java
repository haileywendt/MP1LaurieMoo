/**
 * ECCS 1621 - Spring 2022 MP1 - LaurieMOO
 * 
 * Creates a 4-digit secret value (0000 through 9999) for a player to guess. Feedback is returned in the form of big and little moos. Each
 * "MOO!" indicates a digit correctly guessed in both value and position. Each "moo." indicates a digit correctly guessed in terms of
 * value, but not position. If no digits are correctly guessed, then all the user hears are cowbells... Please note that the number generated
 * by the program can be any four-digit number: it can have leading zeros, it can have multiple instances of the same digit, and so on.
 * For example, the following values are all possible: 0000, 0123, 3455, 7870. When generating big (MOO!) and little (moo.) moos, each
 * guessed digit can only match at most one digit in the secret value. For example, if the secret value is 0055 and the user's guess is
 * 5550, our favorite cow should be uttering "MOO! moo. moo." as there is an exact match in digit position 3, plus two inexact matches.
 * 
 * @author Hailey Wendt
 * @version 1.0 - 22 February 2022
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinalLaurieMooFrame {

	private JFrame frame;
	private JTextField guessField;
	private int i;
	
	FinalRandomMooValue temp = new FinalRandomMooValue();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalLaurieMooFrame window = new FinalLaurieMooFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinalLaurieMooFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel guessLabel = new JLabel("Guess # 1");
		guessLabel.setHorizontalAlignment(SwingConstants.CENTER);
		guessLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		guessLabel.setBounds(10, 38, 416, 25);
		frame.getContentPane().add(guessLabel);
		
		JLabel mooLabel = new JLabel("no moos");
		mooLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		mooLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mooLabel.setBounds(10, 154, 416, 62);
		frame.getContentPane().add(mooLabel);
		
		guessField = new JTextField();
		guessField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Gets userInput from text field of GUI
				int userInput = Integer.parseInt(guessField.getText());
				
				// Increases i
				i++;
				
				// Sets text of guess label
				guessLabel.setText("Guess #" + i + ":");
				
				// Sets text of moo and guess labels
				if (i == 11 || i > 11) {
					mooLabel.setText("Boo hoo -- no LaurieMoo. (" + temp.getSecretValue() + ")");
					guessLabel.setText("No more guesses :(");
				}
				
				// All of these statements set moo label to certain text depending on number of Big Moos and Little Moos
				else if(temp.getBigMooCount(userInput) == 4) {
					mooLabel.setText("LaurieMOO!");
				}
				else if(temp.getBigMooCount(userInput) == 0 && temp.getLittleMooCount(userInput) == 0) {
					mooLabel.setText("no moos/MOOS");
				}
				else if(temp.getBigMooCount(userInput) == 3 && temp.getLittleMooCount(userInput) == 0) {
					mooLabel.setText("MOO! MOO! MOO!");
				}
				else if(temp.getBigMooCount(userInput) == 2 && temp.getLittleMooCount(userInput) == 0) {
					mooLabel.setText("MOO! MOO!");
				}
				else if(temp.getBigMooCount(userInput) == 1 && temp.getLittleMooCount(userInput) == 0) {
					mooLabel.setText("MOO!");
				}
				else if(temp.getBigMooCount(userInput) == 0 && temp.getLittleMooCount(userInput) == 4) {
					mooLabel.setText("moo. moo. moo. moo.");
				}
				else if(temp.getBigMooCount(userInput) == 0 && temp.getLittleMooCount(userInput) == 3) {
					mooLabel.setText("moo. moo. moo.");
				}
				else if(temp.getBigMooCount(userInput) == 0 && temp.getLittleMooCount(userInput) == 2) {
					mooLabel.setText("moo. moo.");
				}
				else if(temp.getBigMooCount(userInput) == 0 && temp.getLittleMooCount(userInput) == 1) {
					mooLabel.setText("moo. ");
				}
				else if(temp.getBigMooCount(userInput) == 1 && temp.getLittleMooCount(userInput) == 3) {
					mooLabel.setText("MOO! moo. moo. moo.");
				}
				else if(temp.getBigMooCount(userInput) == 2 && temp.getLittleMooCount(userInput) == 2) {
					mooLabel.setText("MOO! MOO! moo. moo.");
				}
				else if(temp.getBigMooCount(userInput) == 3 && temp.getLittleMooCount(userInput) == 1) {
					mooLabel.setText("MOO! MOO! MOO! moo.");
				}
			}
		});
		guessField.setFont(new Font("Arial Black", Font.PLAIN, 16));
		guessField.setBounds(137, 89, 166, 25);
		frame.getContentPane().add(guessField);
		guessField.setColumns(10);
	}
}
