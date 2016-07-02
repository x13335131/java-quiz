import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class QuestionPanel extends JPanel {
	private JTextField answerTextField;

	/**
	 * Create the panel.
	 */
	public QuestionPanel(Question question) {
		setLayout(null);
		this.setBounds(10, 11, 604, 404);
		
		JLabel questionLabel = new JLabel("Error");
		questionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setBounds(10, 31, 584, 50);
		add(questionLabel);
		
		answerTextField = new JTextField();
		answerTextField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		answerTextField.setBounds(10, 265, 584, 40);
		add(answerTextField);
		answerTextField.setColumns(10);
		
		JButton nextBtn = new JButton("Next");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userAnswer= answerTextField.getText();
				userAnswer = userAnswer.trim();
				userAnswer = userAnswer.replace(" ", "");
				userAnswer = userAnswer.toLowerCase();
				MyQuizController.nextQuestion(userAnswer, question);
			}
		});
		nextBtn.setBounds(505, 370, 89, 23);
		add(nextBtn);
		
		JButton quitBtn = new JButton("Quit");
		quitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Quiz_GUI.loadMenu();
			}
		});
		quitBtn.setBounds(10, 370, 89, 23);
		add(quitBtn);

		
		questionLabel.setText(question.getQuestion());
		
	}
}
