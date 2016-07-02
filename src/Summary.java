import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Summary extends JPanel {

	/**
	 * Create the panel.
	 */
	public Summary( String s) {
		setLayout(null);
		this.setBounds(0, 0, 604, 404);
		
		JLabel summaryLabel = new JLabel("Quiz Summary");
		summaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		summaryLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		summaryLabel.setBounds(193, 21, 200, 50);
		add(summaryLabel);
		
		JTextArea resultsTA = new JTextArea(s);
		resultsTA.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		resultsTA.setEditable(false);
		resultsTA.setBounds(27, 100, 550, 244);
		add(resultsTA);
		
		JButton retryBtn = new JButton("retry");
		retryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyQuizController.startQuiz();
			}
		});
		retryBtn.setBounds(488, 370, 89, 23);
		add(retryBtn);
		
		JButton quitBtn = new JButton("Quit");
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Quiz_GUI.loadMenu();
			}
		});
		quitBtn.setBounds(27, 370, 89, 23);
		add(quitBtn);

	}
}
