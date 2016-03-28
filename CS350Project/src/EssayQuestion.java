import java.util.Scanner;


public class EssayQuestion extends Question{
	public transient Scanner input = new Scanner(System.in);
	public String getQuestionType(){
		return "Essay";
	}
	
	public void display(){
		System.out.println(qPrompt.getPrompt());
	}
	
	// Change up the essay's prompt
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
	}
	
	//Simply dispaly the answers gathered
	public void tabulate(){
		System.out.println("The question follows: ");
		this.display();
		
		System.out.println("The collected answers as follows: ");
		for(int i = 0; i < userAnswers.size(); i++){
			System.out.println(userAnswers.get(i).getResponse());
		}
	}
}
