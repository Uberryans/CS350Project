import java.util.Vector;


public class ShortAnswerQuestion extends EssayQuestion{
	
	public String getQuestionType(){
		return "Short Answer";
	}
	
	//This tabulates the questions and prints them out, then divides them into similar answers
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
