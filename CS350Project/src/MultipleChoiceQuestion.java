import java.util.Scanner;


public class MultipleChoiceQuestion extends Question {
	public transient Scanner input = new Scanner(System.in);
	public String getQuestionType(){
		return "Multiple Choice";
	}
	
}
