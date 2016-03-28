import java.util.Scanner;

//Our class for basic user response; used in tf, multiple choice, essay, and short answer
public class UserResponse implements java.io.Serializable{
	public transient Scanner input = new Scanner(System.in);
	public String val;
	
	public void setResponse(){
		System.out.println("Please enter the answer: ");
		String l = input.nextLine();
		val = l;
	}
	
	public String getResponse(){
		return val;
	}
	
}
