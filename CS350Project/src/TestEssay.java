import java.util.Scanner;


public class TestEssay extends TestQuestion{
	public transient Scanner input = new Scanner(System.in);
	public String getQuestionType(){
		return "Essay";
	}
	
	public void display(){
		System.out.println(qPrompt.getPrompt());
	}
	
	//Simply modifies the prompt
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
	
	//Unique question grading makes it always correct
	public boolean gradeQues(){
		System.out.println("This quesion auto grades as true. Your professor will grade it at a later point.");
		return true;
	}
	
	//Collects the various answers and displayes them
	public void tabulate(){
		System.out.println("The question follows: ");
		this.display();
		
		System.out.println("The collected answers as follows: ");
		for(int i = 0; i < userAnswers.size(); i++){
			System.out.println(userAnswers.get(i).getResponse());
		}
	}
}
