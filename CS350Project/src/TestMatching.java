import java.util.Scanner;
import java.util.Vector;


public class TestMatching extends TestQuestion {
	public transient Scanner input = new Scanner(System.in);
	public Vector<StringPrompt> fullAnswer = new Vector<StringPrompt>();
	//Override the previous userAnswers to make tabulation easier
	public Vector<UserMultiResponse> userAnswers = new Vector<UserMultiResponse>();
	public UserMultiResponse temp = new UserMultiResponse();
	
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
	
	public void setAnswer(){
		for(int i = 0; i < choices.size(); i++){
			System.out.print("Please enter the matches one line at a time: ");
			String l = input.nextLine();
			StringPrompt answer = new StringPrompt();
			answer.setPrompt(l);
			fullAnswer.add(answer);
		}
	}
	
	
	public void displayAnswer(){
		System.out.println("The correct answer follows: ");
		for(int i = 0; i < fullAnswer.size(); i++){
			System.out.println(fullAnswer.get(i).getPrompt());
		}
	}
	
	//Take the question
	public void take(){
		input = new Scanner(System.in);
		currentlyTaking = true;
		this.display();
		temp = new UserMultiResponse();
		System.out.println("Please enter your answers one at a time, space between each word: ");
		for(int i = 0; i < choices.size(); i++){
			String l = input.nextLine();
			temp.addResponse(l);
		}
		userAnswers.add(temp);
		currentlyTaking = false;
	}
	
	//Grades the question
	public boolean gradeQues(){
		for(int i = 0; i < choices.size(); i++){
			if(fullAnswer.get(i).getPrompt().equals(temp.getResponse(i)) == false)
				return false;
		}
		return true;
	}
	
	//Tabulates all of the answers; can be finicky
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
