import java.util.Scanner;


public class TrueFalseQuestion extends MultipleChoiceQuestion{
	public transient Scanner input = new Scanner(System.in);
	
	public String getQuestionType(){
		return "True False";
	}
	
	//Create true and false as choices for the question
	public void buildChoices(){
		choices.add(new Prompt());
		choices.get(0).setPrompt("True");
		choices.add(new Prompt());
		choices.get(1).setPrompt("False");
	}
	
	//Modifies only the prompt
	public void modifyQuestion(){
		input = new Scanner(System.in);
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
	}
}
