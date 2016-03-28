import java.util.Scanner;


public class TestTrueFalse extends TestMultipleChoice{
	public transient Scanner input = new Scanner(System.in);
	public String getQuestionType(){
		return "True False";
	}
	
	//Create true and false as choices for the question
	public void buildChoices(){
		choices.add(new StringPrompt());
		choices.get(0).setPrompt("True");
		choices.add(new StringPrompt());
		choices.get(1).setPrompt("False");
	}
	
	//Modifies only the prompt and the answer
	public void modifyQuestion(){
		input = new Scanner(System.in);
		System.out.println("This is the current question: ");
		this.display();
		System.out.println("Would you like to modify the prompt? (Y/N)");
		String k = input.nextLine();
		if(k.equals("Y")){
			System.out.println("Please enter the new prompt: ");
			k = input.nextLine();
			qPrompt.setPrompt(k);
		}
		System.out.println("Would you like to modify the answer? (Y/N)");
		k = input.nextLine();
		if(k.equals("Y")){
			this.setAnswer();
		}
		input.close();
	}
}
