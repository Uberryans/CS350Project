import java.util.Scanner;
import java.util.Vector;

// The abstract for our questions
public abstract class Question implements java.io.Serializable {
	public transient Scanner input = new Scanner(System.in);
	public StringPrompt qPrompt = new StringPrompt();
	// This will store our question's choices for multiple choice, tf, matching, and ranking questions
	public Vector<Prompt> choices = new Vector<Prompt>();
	//The user's responses for each question
	public Vector<UserResponse> userAnswers = new Vector<UserResponse>();
	
	public void display(){
		System.out.println(qPrompt.getPrompt());
		for(int i = 0; i < choices.size(); i++){
			int j = i+1;
			System.out.print(j + ". ");
			choices.get(i).display();
		}
	}
	
	//Create our question's prompt
	public void buildPrompt(){
		System.out.print("Please enter the prompt: ");
		String l = input.nextLine();
		qPrompt.setPrompt(l);
	}
	
	//Create the choices for our question; they are represented as prompts
	public void buildChoices(){
		System.out.print("Please enter the number of choices you want: ");
		String l = input.nextLine();
		boolean isInt = false;
		while(!isInt){
			if(!Character.isDigit(l.charAt(0))){
				System.out.println("Sorry, integer not found. Please reenter: ");
				l = input.nextLine();
			}
			else{
				isInt = true;
			}
		}
		
		int num = Integer.parseInt(l);
		
		for(int i = 0; i < num; i++){
			System.out.println("Please enter a choice: ");
			l = input.nextLine();
			choices.add(new StringPrompt());
			choices.get(i).setPrompt(l);
		}
	}
	
	//Modify a multiple choice question
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
		System.out.println("Would you like to modify the choices? (Y/N)");
		k = input.nextLine();
		if(k.equals("Y")){
			System.out.println("Please enter the choice number you wish to modify: ");
			k = input.nextLine();
			int modNum = Integer.parseInt(k);
			modNum -= 1;
			System.out.println("Please enter the new choice text: ");
			k = input.nextLine();
			choices.get(modNum).setPrompt(k);
		}
	}
	
	//Take a multiple choice question
	public void take(){
		input = new Scanner(System.in);
		this.display();
		UserResponse temp = new UserResponse();
		temp.setResponse();
		userAnswers.add(temp);
	}
	
	//Display the user's cumulative answers
	public void tabulate(){
		int[] numCount = new int[choices.size()];
		for(int i = 0; i < numCount.length; i++){
			numCount[i] = 0;
		}
		for(int i = 0; i < userAnswers.size(); i++){
			for(int j = 0; j < choices.size(); j++){
				if(choices.get(j).getPrompt().equals(userAnswers.get(i).getResponse())){
					numCount[j]++;
				}
			}
		}
		
		System.out.println("The question follows: ");
		this.display();
		
		System.out.println("The collected answers as follows: ");
		for(int i = 0; i < userAnswers.size(); i++){
			System.out.println(userAnswers.get(i).getResponse());
		}
		
		System.out.println("The collected answers tabulated: ");
		for(int i = 0; i < numCount.length; i++){
			System.out.println((i+1) + ". " + choices.get(i).getPrompt() + " - " + numCount[i]);
		}
	}
}
