
public class Prompt implements java.io.Serializable {
	
	private String prompt;
	
	public void display(){
		System.out.println(prompt);
	}
	
	public void setPrompt(String entered){
		prompt = entered;
	}
	
	public String getPrompt(){
		return prompt;
	}
}
