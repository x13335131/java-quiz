
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Image_QuestionPanel extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton ans1;
	private JRadioButton ans2;
	private JRadioButton ans3;
	private JRadioButton ans4;
	/**
	 * Create the panel.
	*/
	public Image_QuestionPanel(Image_Question imcq) {
		setBorder(null);
		setLayout(null);
		this.setBounds(10, 11, 604, 404);
		
		JLabel questionLabel = new JLabel("Error");
		questionLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setBounds(10, 31, 584, 50);
		add(questionLabel);
			
		JButton nextBtn = new JButton("Next");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userAnswer="N/A";
				if(ans1.isSelected()){
					userAnswer = ans1.getText();
				}else if(ans2.isSelected()){
					userAnswer = ans2.getText();
				}else if(ans3.isSelected()){
					userAnswer = ans3.getText();
				}else if(ans4.isSelected()){
					userAnswer = ans4.getText();
				}
				MyQuizController.nextQuestion(userAnswer, imcq);
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
		
		ans4 = new JRadioButton("placeholder");
		ans4.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		buttonGroup.add(ans4);
		ans4.setBounds(106, 322, 448, 23);
		add(ans4);
		
		ans3 = new JRadioButton("placeholder");
		ans3.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		buttonGroup.add(ans3);
		ans3.setBounds(106, 290, 448, 23);
		add(ans3);
		
		ans2 = new JRadioButton("placeholder");
		ans2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		buttonGroup.add(ans2);
		ans2.setBounds(106, 258, 448, 23);
		add(ans2);
		
	    ans1 = new JRadioButton("placeholder");
		ans1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		buttonGroup.add(ans1);
		ans1.setBounds(106, 226, 448, 23);
		add(ans1);
		
		JLabel imageLabel = new JLabel("image error");
		imageLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLabel.setBounds(92, 88, 400, 131);
		add(imageLabel);

		questionLabel.setText(imcq.getQuestion());
		ans1.setText(imcq.getChoices()[0]);
		ans2.setText(imcq.getChoices()[1]);
		ans3.setText(imcq.getChoices()[2]);
		ans4.setText(imcq.getChoices()[3]);
		
		imageLabel.setText("");
		imageLabel.setIcon(imcq.getImage());
	}
}
