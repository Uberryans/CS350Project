import java.util.Scanner;


public class TestRanking extends TestMatching{
	public transient Scanner input = new Scanner(System.in);
	public void buildChoices(){
		System.out.print("How many choices would you like to make: ");
		String l = input.nextLine();
		int num = Integer.parseInt(l);
		for(int i = 0; i < num; i++){
			System.out.print("Please enter a choice: ");
			l = input.nextLine();
			choices.add(new StringPrompt());
			choices.get(i).setPrompt(l);
		}
	}
	
	public void setAnswer(){
		System.out.print("Please enter the answers from highest ranking to lowest, one at a time. ");
		for(int i = 0; i < choices.size(); i++){
			String l = input.nextLine();
			StringPrompt answer = new StringPrompt();
			answer.setPrompt(l);
			fullAnswer.add(answer);
		}
	}
}
