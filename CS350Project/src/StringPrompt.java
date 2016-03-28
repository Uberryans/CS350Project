
public class StringPrompt extends Prompt {
	private String qPrompt;
	
	public void display(){
		System.out.println(qPrompt);
	}
	
	public void setPrompt(String entered){
		qPrompt = entered;
	}
	
	public String getPrompt(){
		return qPrompt;
	}
}
