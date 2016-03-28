import java.util.Scanner;
import java.util.Vector;


public class MatchingQuestion extends Question {
	public transient Scanner input = new Scanner(System.in);
	//A vector built purely for matching and ranking questions; it makes checking and tabulating possible
	public Vector<UserMultiResponse> userAnswers = new Vector<UserMultiResponse>();
	
	//Build matching choices
	public void buildChoices(){
		System.out.print("How many choices would you like to make: ");
		String l = input.nextLine();
		int num = Integer.parseInt(l);
		for(int i = 0; i < num; i++){
			System.out.print("Please enter a choice from each column (space between, please): ");
			l = input.nextLine();
			choices.add(new StringPrompt());
			choices.get(i).setPrompt(l);
		}
	}
	
	//Builds a series of responses and stores them in a single variable
	public void take(){
		input = new Scanner(System.in);
		this.display();
		UserMultiResponse temp = new UserMultiResponse();
		System.out.println("Please enter your answers one at a time, space between each word: ");
		for(int i = 0; i < choices.size(); i++){
			String l = input.nextLine();
			temp.addResponse(l);
		}
		userAnswers.add(temp);
	}
	
	//Tabulates the responses; can be occasionally finicky
	public void tabulate(){
		Vector<UserMultiResponse> answers = new Vector<UserMultiResponse>();
		int checkCount = 1;
		boolean doAdd = true;
		for(int i = 0; i < userAnswers.size(); i++){
			for(int j = 0; j < answers.size(); j++){
				for(int k = 0; k < userAnswers.get(i).getSize(); k++){
					if(userAnswers.get(i).getResponse(k).equals(answers.get(j).getResponse(k))){
						checkCount++; 
					}
				}
				if(checkCount != choices.size() - 1){
					doAdd = false;
				}
				checkCount = 1;
			}
			if(doAdd){
				answers.add(userAnswers.get(i));
			}
		}
		
		checkCount = 1;
		int[] numCount = new int[answers.size()];
		for(int i = 0; i < numCount.length; i++){	
			numCount[i] = 0;
		}
		
		for(int i = 0; i < userAnswers.size(); i++){
			for(int j = 0; j < answers.size(); j++){
				for(int k = 0; k < userAnswers.get(i).getSize(); k++){
					if(userAnswers.get(i).getResponse(k).equals(answers.get(j).getResponse(k))){
						checkCount++; 
					}
				}
				if(checkCount == choices.size() - 1){
					numCount[j]++;
				}
				checkCount = 1;
			}
		}
		
		System.out.println("The question follows: ");
		this.display();
		
		System.out.println("The collected answers are as follows: ");
		for(int i = 0; i < userAnswers.size(); i++){
			for(int j = 0; j < userAnswers.get(i).getSize(); j++){
				System.out.println(userAnswers.get(i).getResponse(j));
			}
		}
		
		System.out.println("The collected answers tabulated: ");
		for(int i = 0; i < numCount.length; i++){
			System.out.println(numCount[i] + ": ");
			for(int j = 0; j < answers.get(i).getSize(); j++){
				System.out.println(answers.get(i).getResponse(j));
			}
			System.out.println();
		}
		
	}
}
