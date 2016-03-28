import java.util.Scanner;
import java.util.Vector;


public class TestShortAnswer extends TestQuestion{
	public transient Scanner input = new Scanner(System.in);
	public String getQuestionType(){
		return "Short Answer";
	}
	
	//Modifies a short answer question
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
	}
	
	//Tabulates all given answers and enumerates them
	public void tabulate(){	
		Vector<String> uniqueChoices = new Vector<String>();
		boolean doAdd = true;
		for(int i = 0; i < userAnswers.size(); i++){
			for(int j = 0; j < uniqueChoices.size(); j++){
				if(userAnswers.get(i).getResponse().equals(uniqueChoices.get(j))){
					doAdd = false;
				}
			}
			if(doAdd){
				uniqueChoices.add(userAnswers.get(i).getResponse());
			}
		}
		
		int[] numCount = new int[uniqueChoices.size()];
		for(int i = 0; i < numCount.length; i++){
			numCount[i] = 0;
		}
		
		for(int i = 0; i < userAnswers.size(); i++){
			for(int j = 0; j < uniqueChoices.size(); j++){
				if(userAnswers.get(i).getResponse().equals(uniqueChoices.get(j))){
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
			System.out.println((i+1) + ". " + uniqueChoices.get(i) + " - " + numCount[i]);
		}
	}
}
