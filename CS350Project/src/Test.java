import java.util.Scanner;
import java.util.Vector;


public class Test implements java.io.Serializable{
	public Vector<TestQuestion> questions = new Vector<TestQuestion>();
	public transient Scanner input = new Scanner(System.in);
	public String name;
	
	//The test builder
	public void buildTest(){
		System.out.println("Welcome to the test builder.");
		System.out.println();
		System.out.println("Please enter a name for the test: ");
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
				questions.add(new TestTrueFalse());
				questions.get(index).buildPrompt();
				questions.get(index).buildChoices();
				questions.get(index).setAnswer();
				index++;
			}
			else if(l.equals("2")){
				questions.add(new TestMultipleChoice());
				questions.get(index).buildPrompt();
				questions.get(index).buildChoices();
				questions.get(index).setAnswer();
				index++;
			}
			else if(l.equals("3")){
				questions.add(new TestEssay());
				questions.get(index).buildPrompt();
				//questions.get(index).setAnswer();
				index++;
			}
			else if(l.equals("4")){
				questions.add(new TestShortAnswer());
				questions.get(index).buildPrompt();
				questions.get(index).setAnswer();
				index++;
			}
			else if(l.equals("5")){
				questions.add(new TestMatching());
				questions.get(index).buildPrompt();
				questions.get(index).buildChoices();
				questions.get(index).setAnswer();
				index++;
			}
			else if(l.equals("6")){
				questions.add(new TestRanking());
				questions.get(index).buildPrompt();
				questions.get(index).buildChoices();
				questions.get(index).setAnswer();
				index++;
			}
			else{
				System.out.print("Sorry, input not recognized. Please reenter.");
			}
			System.out.print("Enter your next question choice");
			l = input.nextLine();
		}
		System.out.println("Test finished!");
	}
	
	public void display(){
		for(int i = 0; i < questions.size(); i++){
			questions.get(i).display();
		}
	}
	
	public String getName(){
		return name;
	}
	
	// A series of functions that manipulate the test questions
	public void modify(int quesNum){
		questions.get(quesNum).modifyQuestion();
	}
	
	public void takeTest(){
		System.out.println("The test is as follows: ");
		for(int i = 0; i < questions.size(); i++){
			questions.get(i).take();
		}
		System.out.println("Test Finished! Your grade is below: ");
		this.grade();
	}
	
	public void grade(){
		int right = 0;
		int wrong = 0;
		for(int i = 0; i < questions.size(); i++){
			if(questions.get(i).gradeQues())
				right++;
			else
				wrong++;
		}
		
		System.out.println("Total right: " + right);
		System.out.println("Total wrong: " + wrong);
	}
	public void tabulateTest(){
		for(int i = 0; i < questions.size(); i++){
			questions.get(i).tabulate();
		}
	}
}
