import java.util.Scanner;


public class TestMultipleChoice extends TestQuestion{
	public transient Scanner input = new Scanner(System.in);
	public String getQuestionType(){
		return "Multiple Choice";
	}
	
	public void setAnswer(){
		System.out.print("Please enter the choice number: ");
		String l = input.nextLine();
		int index = Integer.parseInt(l);
		while(choices.get(index) == null){
			System.out.print("Sorry, that choice number doesn't exist. Please reenter");
			l = input.nextLine();
			index = Integer.parseInt(l);
		}
		correctAnswer = choices.get(index).getPrompt();
	}
}
