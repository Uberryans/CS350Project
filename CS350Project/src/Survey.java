import java.util.Scanner;
import java.util.Vector;


public class Survey implements java.io.Serializable{
	public Vector<Question> questions = new Vector<Question>();
	public transient Scanner input = new Scanner(System.in);
	public String name;
	
	//The survey builder
	public void buildSurvey(){
		System.out.println("Welcome to the survey builder.");
		System.out.println();
		System.out.println("Please enter a name for the survey: ");
		String l = input.nextLine();
		name = l;
		System.out.println("1) New T/F Question");
		System.out.println("2) New Multiple Choice Question");
		System.out.println("3) New Essay Question");
		System.out.println("4) New Short Answer Question");
		System.out.println("5) New Matching Question");
		System.out.println("6) New Ranking Question");
		System.out.println("7) Quit");
		System.out.println();
		System.out.print("Please enter your choice: ");
		l = input.nextLine();
		int index = 0;
		while(l.equals("7") == false){
			if(l.equals("1")){
				//System.out.println("We're in");
				TrueFalseQuestion ques = new TrueFalseQuestion();
				ques.buildPrompt();
				ques.buildChoices();
				questions.add(ques);
				index++;
			}
			else if(l.equals("2")){
				questions.add(new MultipleChoiceQuestion());
				questions.get(index).buildPrompt();
				questions.get(index).buildChoices();
				index++;
			}
			else if(l.equals("3")){
				questions.add(new EssayQuestion());
				questions.get(index).buildPrompt();
				index++;
			}
			else if(l.equals("4")){
				questions.add(new ShortAnswerQuestion());
				questions.get(index).buildPrompt();
				index++;
			}
			else if(l.equals("5")){
				questions.add(new MatchingQuestion());
				questions.get(index).buildPrompt();
				questions.get(index).buildChoices();
				index++;
			}
			else if(l.equals("6")){
				questions.add(new RankingQuestion());
				questions.get(index).buildPrompt();
				questions.get(index).buildChoices();
				index++;
			}
			else{
				System.out.print("Sorry, input not recognized. Please reenter.");
			}
			System.out.print("Enter your next question choice");
			l = input.nextLine();
		}
		System.out.println("Survey finished!");
	}
	
	public void display(){
		for(int i = 0; i < questions.size(); i++){
			questions.get(i).display();
		}
	}
	
	public String getName(){
		return name;
	}
	
	//A series of basic classes that manipulates the questions in the survey
	public void modify(int quesNum){
		questions.get(quesNum).modifyQuestion();
	}
	
	public void takeSurvery(){
		System.out.println("The survey is as follows: ");
		for(int i = 0; i < questions.size(); i++){
			questions.get(i).take();
		}
		System.out.println("Survey Finished!");
	}
	
	public void tabulateSurvey(){
		for(int i = 0; i < questions.size(); i++){
			questions.get(i).tabulate();
		}
	}
}
