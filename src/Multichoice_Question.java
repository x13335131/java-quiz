
public class Multichoice_Question extends Question{
	
	private String[] choices = new String[4];
	public Multichoice_Question(int index, String answer, String question, String[] choices, String questionType) {
		super(index, answer, question, questionType);
		this.setChoices(choices);
	}
	public String[] getChoices() {
		return choices;
	}
	public void setChoices(String[] choices) {
		this.choices = choices;
	}

}
