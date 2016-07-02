import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;


public class Quiz_GUI extends JFrame {

	private static JPanel contentPane;
	private static ImageIcon background;
	private static JPanel menuPanel;
	private static JButton playButton;
	private static JLabel bgLabel;

	
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				BufferedImage img = null;
				ImageIcon icon;
				try {
					img = ImageIO.read(new File("images/bg2.jpg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				icon = new ImageIcon(img);
				background = icon;
				
				try {
					Quiz_GUI frame = new Quiz_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Quiz_GUI() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuPanel = new JPanel();
		menuPanel.setBounds(10, 11, 604, 404);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyQuizController.startQuiz();
				
			}
		});
		playButton.setBounds(185, 154, 270, 35);
		playButton.setFont(new Font("Tahoma", Font.ITALIC, 24));
		menuPanel.add(playButton);
		
		bgLabel = new JLabel();
		bgLabel.setIcon(background);
		bgLabel.setText("Lou's Computer Quiz");
		bgLabel.setForeground(Color.BLACK);
		bgLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 30));
		bgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bgLabel.setVerticalAlignment(SwingConstants.TOP);
		bgLabel.setBounds(0, 0, 604, 404);
		menuPanel.add(bgLabel);
	}
	
	public static void updateGUI(Question q) {
		contentPane.removeAll();
		if(q.getQuestionType().equals("regQs")){
			contentPane.add(new QuestionPanel(q));
		}else if(q.getQuestionType().equals("multiQs")){
			contentPane.add(new Multichoice_QuestionPanel((Multichoice_Question)q));
		}else if(q.getQuestionType().equals("imgQs")){
			contentPane.add(new Image_QuestionPanel((Image_Question)q));
		}
		
		contentPane.revalidate();
		contentPane.repaint();
	}
	public static void loadMenu(){
		contentPane.removeAll();
		contentPane.add(menuPanel);
		contentPane.revalidate();
		contentPane.repaint();
	}
	public static void loadSummary(String s){
		contentPane.removeAll();
		contentPane.add(new Summary(s));
		contentPane.revalidate();
		contentPane.repaint();
	}
}
