import java.util.Scanner;


public class RankingQuestion extends MatchingQuestion{
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
	
	
}
