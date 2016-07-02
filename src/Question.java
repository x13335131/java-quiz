
public class Question {

	private int index;
	private String answer;
	private String question;
	private String questionType;
	
	public Question(int index, String answer, String question, String questionType){
		this.index = index;
		this.answer = answer;
		this.question = question;
		this.questionType = questionType;
	}


	public String getQuestionType() {
		return questionType;
	}


	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
}
