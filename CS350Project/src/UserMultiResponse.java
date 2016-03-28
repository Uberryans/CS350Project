import java.util.Scanner;
import java.util.Vector;

//Our user input class for matching and ranking questions; jumps off of UserResponse so it can be stored if need be
public class UserMultiResponse extends UserResponse{
	public transient Scanner input = new Scanner(System.in);
	public Vector<String> vals = new Vector<String>();
	
	public void addResponse(String resp){
		vals.add(resp);
	}
	
	public String getResponse(int i){
		return vals.get(i);
	}
	
	public int getSize(){
		return vals.size();
	}
}
