
public class MyQuizController {

	private static int totalNumQs = 5;
	private static int visibleNumQs = 5; 
	private static Question[] questionList = new Question[totalNumQs];
	private static int[] randomQs = new int[visibleNumQs]; //picking two integers
	private static int counter = 0;
	
	private static int[][] summary = new int[visibleNumQs][2];
	
	private static void setOfQuestions(){
		questionList[0]= new Image_Question(1, "psu", "What component is this?", "psu.png", (new String[]{"ram", "heatSink", "psu","hard drive"}), "imgQs");
		questionList[1]= new Multichoice_Question(2, "HTML", "Which of the following is not a programming language?", (new String[]{"java", "C#", "C++","HTML"}),"multiQs");
		questionList[2]= new Question(3, "worldwideweb", "What does WWW stand for?", "regQs");
		questionList[3]= new Multichoice_Question(4, "hadoop", "Which of these is NOT an operating system?", (new String[]{"linux", "windows", "unix","hadoop"}), "multiQs");
		questionList[4]= new Multichoice_Question(5, "cascade style sheets", "What does CSS stand for?", (new String[]{"carude state sheet", "cascade style sheets", "cascade styling system","complex styling system"}), "multiQs");	    
		
	}
	
	private static void chooseRandom(){
		boolean alreadyChosen = false;
		
		for(int i=0; i < randomQs.length; i++)
		{
			
			if (i==0) {
				randomQs[i] = (int) (Math.random()*totalNumQs)+1;
			}else {
				int temp = (int) (Math.random()*totalNumQs)+1;
				
				for (int j=0; j<i; j++) 
				{
					
					if(randomQs[j]==temp){
						alreadyChosen = true;
					}
					
				}
				
				if (alreadyChosen) {
					i--;
					alreadyChosen = false;
				}else {
					randomQs[i] = temp;
				}	
			}
			
		}
		
		for (int i=0; i < randomQs.length; i++){
			System.out.println(randomQs[i]);
		}
		System.out.println("\n");
		
		
		
	}
	public static void startQuiz(){
		setOfQuestions();
		chooseRandom();
		counter = 0;
		for(int i=0; i<visibleNumQs; i++){
			for(int j =0; j<2; j++){
				summary[i][j] = 0;
			}
		}
		firstQuestion();
	}
	public static void firstQuestion(){
		if(counter < randomQs.length){
			Quiz_GUI.updateGUI(questionList[randomQs[counter]-1]);
			counter++;
		 }else{
			// Quiz_GUI.loadSummary();
			 System.out.println("error controller first question");
		 }
	}
	public static void nextQuestion(String userAnswer, Question q){
		if(userAnswer.equals(q.getAnswer())){
			System.out.println("true");
			fillSummary(q, 1);
		}else{
			System.out.println("false");
			fillSummary(q, 0);
		}
		
		
		if(counter < randomQs.length){
			Quiz_GUI.updateGUI(questionList[randomQs[counter]-1]);
			counter++;
		 }else{
			 String toDisplay = "";
			 String temp;
			 for(int i=0; i<visibleNumQs; i++){
				 temp = questionList[summary[i][0]-1].getQuestion()+ " : ";
				 if(summary[i][1] == 1){
					 temp += "Correct\n";
				 }else{
					 temp += "Incorrect\n";
				 }
				 toDisplay += temp;
			 }
			 int correct = 0;
			 for(int i=0; i<visibleNumQs; i++){
				if (summary[i][1]==1){
					correct++;		
				}
			 }
			 int percent = (correct * 100 / visibleNumQs);
			 toDisplay += "\n\t you got: " + percent+ "%";
			 if(percent > 79){
				 toDisplay += "\n\t Congratulations!";
			 }else if(percent < 40){
				 toDisplay += "\n\t hard luck. Try again? ";
			 }
			 Quiz_GUI.loadSummary(toDisplay);
		 }
	}
	private static void fillSummary (Question q, int b){
		summary[counter-1][0]= q.getIndex();
		summary[counter-1][1]= b;
	}
	
	
	
}
