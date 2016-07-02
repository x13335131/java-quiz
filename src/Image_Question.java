import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Image_Question extends Question {

	private String choices[] = new String[4];
	private ImageIcon image;
	public Image_Question(int index, String answer, String question, String image, String[] choices, String questionType) {
		super(index, answer, question, questionType);
	
		BufferedImage img = null;
		ImageIcon icon;
		try {
			img = ImageIO.read(new File("images/questions/"+image));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedImage resizedImg = new BufferedImage(400, 131, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(img, 0, 0, 400, 131, null);
	    g2.dispose();
		icon = new ImageIcon(resizedImg);
		this.setImage(icon);
		this.setChoices(choices);
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
	}
	public String[] getChoices() {
		return choices;
	}
	public void setChoices(String choices[]) {
		this.choices = choices;
	}

}
