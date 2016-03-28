import java.util.Scanner;


public class TestQuestion extends Question{
	public String correctAnswer;
	public transient Scanner input = new Scanner(System.in);
	public boolean currentlyTaking = false;
	public void setAnswer(){
		System.out.print("Please enter the correct answer: ");
		String l = input.nextLine();
		correctAnswer = l;
	}
	
	public void displayAnswer(){
		System.out.print("The correct answer for this quiz is: ");
		System.out.println(correctAnswer);
	}
	
	public void display(){
		System.out.println(qPrompt.getPrompt());
		for(int i = 0; i < choices.size(); i++){
			int j = i+1;
			System.out.print(j + ". ");
			choices.get(i).display();
			
		}
		if(!currentlyTaking)
			this.displayAnswer();
	}
	
	//Modifies all parts of the test question
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
		System.out.println("Would you like to modify the answer? (Y/N)");
		k = input.nextLine();
		if(k.equals("Y")){
			this.setAnswer();
		}
	}
	
	// Takes a test question
	public void take(){
		currentlyTaking = true;
		input = new Scanner(System.in);
		this.display();
		UserResponse temp = new UserResponse();
		temp.setResponse();
		userAnswers.add(temp);
		currentlyTaking = false;
	}
	
	//Grades a test question
	public boolean gradeQues(){
		if(userAnswers.lastElement().getResponse().equals(correctAnswer)){
			return true;
		}
		return false;
	}
}
