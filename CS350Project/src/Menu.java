import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Menu {
	public transient Scanner input = new Scanner(System.in);
	public Survey currentSurvey = null;
	public Test currentTest = null;
	
	// Display our opening menu
	public void displayOpeningMenu() throws IOException{
		System.out.println("Welcome to Survey Builder");
		System.out.println();
		System.out.println("1) Survey Menu");
		System.out.println("2) Test Menu");
		System.out.println("3) Quit");
		System.out.println();
		System.out.println("Please enter your choice: ");
		String l = input.nextLine();
		while(!l.equals("3")){
			if(l.equals("1")){
				displaySurveyMenu();
			}
			else if(l.equals("2")){
				displayTestMenu();
			}
			else if(l.equals("3")){
				System.exit(0);
			}
			else{
				System.out.println("Sorry, cannot recognize input. Please reenter.");
				System.out.println("Welcome to Survey Builder");
				System.out.println();
				System.out.println("1) Survey Menu");
				System.out.println("2) Test Menu");
				System.out.println("3) Quit");
				System.out.println();
				System.out.println("Please enter your choice: ");
				l = input.nextLine();
			}
		}
	}
	// Display the survey builder
	public void displaySurveyMenu() throws IOException{
		System.out.println("Survey Menu");
		System.out.println();
		System.out.println("1) Create a Survey");
		System.out.println("2) Display a Survey");
		System.out.println("3) Load a Survey");
		System.out.println("4) Save a Survey");
		System.out.println("5) Modify a Survey");
		System.out.println("6) Take a Survey");
		System.out.println("7) Tabulate a Survey");
		System.out.println("8) Quit");
		System.out.println();
		System.out.print("Please enter your choice: ");
		String l = input.nextLine();
		while(!l.equals("8")){
			if(l.equals("1")){
				currentSurvey = new Survey();
				currentSurvey.buildSurvey();
			}
			else if(l.equals("2")){
				currentSurvey.display();
			}
			else if(l.equals("3")){
				currentSurvey = surveyLoad();
			}
			else if(l.equals("4")){
				surveySave();
			}
			else if(l.equals("5")){
				modifySurvey();
			}
			else if(l.equals("6")){
				currentSurvey.takeSurvery();
			}
			else if(l.equals("7")){
				currentSurvey.tabulateSurvey();
			}
			else{
				System.out.println("Sorry, cannot recognize input. Please reenter.");
			}
			System.out.println("Fired");
			System.out.println();
			System.out.println("1) Create a Survey");
			System.out.println("2) Display a Survey");
			System.out.println("3) Load a Survey");
			System.out.println("4) Save a Survey");
			System.out.println("5) Modify a Survey");
			System.out.println("6) Take a Survey");
			System.out.println("7) Tabulate a Survey");
			System.out.println("8) Quit");
			System.out.println();
			System.out.print("Enter your choice:");
			l = input.nextLine();
		}
		System.exit(0);
	}
	
	// Load a survey
	public Survey surveyLoad(){
		  System.out.print("Please enter the filepath for the survey to load: ");
		  String l = input.nextLine();
		  Survey loadSurvey = null;
		  try
		  {
		     FileInputStream fileIn = new FileInputStream(l);
		     ObjectInputStream in = new ObjectInputStream(fileIn);
		     loadSurvey = (Survey) in.readObject();
		     in.close();
		     fileIn.close();
		  }
		  catch(IOException i)
		  { 
			 System.out.println("Sorry, could not load");
		     i.printStackTrace();
		     return null;
		  }
		  catch(ClassNotFoundException c)
		  {
		     System.out.println("Sorry, could not load");
		     c.printStackTrace();
		     return null;
		  }
		  return loadSurvey;
	}
	
	//Save a survey
	public void surveySave() throws IOException{
		try{
			String fileName = currentSurvey.getName() + ".ser";
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(currentSurvey);
			out.close();
			fileOut.close();
			System.out.println("Survey " + fileName + " has been saved!");
		}
		catch(IOException i){
			System.out.println("Sorry, could not save");
			i.printStackTrace();
		}
	}
	
	//Display the test builder
	public void displayTestMenu() throws IOException{
		System.out.println("Test Menu");
		System.out.println();
		System.out.println("1) Create a Test");
		System.out.println("2) Display a Test");
		System.out.println("3) Load a Test");
		System.out.println("4) Save a Test");
		System.out.println("5) Modify a Test");
		System.out.println("6) Take a Test");
		System.out.println("7) Tabulate a Test");
		System.out.println("8) Quit");
		System.out.println();
		System.out.print("Please enter your choice: ");
		String l = input.nextLine();
		while(!l.equals("8")){
			if(l.equals("1")){
				currentTest = new Test();
				currentTest.buildTest();
			}
			else if(l.equals("2")){
				currentTest.display();
			}
			else if(l.equals("3")){
				currentTest = testLoad();
			}
			else if(l.equals("4")){
				testSave();
			}
			else if(l.equals("5")){
				modifyTest();
			}
			else if(l.equals("6")){
				currentTest.takeTest();
			}
			else if(l.equals("7")){
				currentTest.tabulateTest();
			}
			else{
				System.out.println("Sorry, cannot recognize input. Please reenter.");
			}
			System.out.println();
			System.out.println("1) Create a Test");
			System.out.println("2) Display a Test");
			System.out.println("3) Load a Test");
			System.out.println("4) Save a Test");
			System.out.println("5) Modify a Test");
			System.out.println("6) Take a Test");
			System.out.println("7) Tabulate a Test");
			System.out.println("8) Quit");
			System.out.println();
			System.out.print("Enter your choice:");
			l = input.nextLine();
		}
		System.exit(0);
	}
	
	//Load a test
	public Test testLoad(){
		  System.out.print("Please enter the filepath for the test to load: ");
		  String l = input.nextLine();
		  Test loadTest = null;
		  try
		  {
		     FileInputStream fileIn = new FileInputStream(l);
		     ObjectInputStream in = new ObjectInputStream(fileIn);
		     loadTest = (Test) in.readObject();
		     in.close();
		     fileIn.close();
		  }
		  catch(IOException i)
		  { 
			 System.out.println("Sorry, could not load");
		     i.printStackTrace();
		     return null;
		  }
		  catch(ClassNotFoundException c)
		  {
		     System.out.println("Sorry, could not load");
		     c.printStackTrace();
		     return null;
		  }
		  return loadTest;
	}
	
	//Save a test
	public void testSave() throws IOException{
		try{
			String fileName = currentTest.getName() + ".ser";
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(currentTest);
			out.close();
			fileOut.close();
			System.out.println("Test " + fileName + " has been saved!");
		}
		catch(IOException i){
			System.out.println("Sorry, could not save");
			i.printStackTrace();
		}
	}
	
	//Set up the question on the survey to be modified.
	public void modifySurvey() throws IOException{
		System.out.println("You must enter the survey to modify.");
		currentSurvey = surveyLoad();
		System.out.println("Which question would you like to modify?");
		String l = input.nextLine();
		int quesNum = Integer.parseInt(l);
		quesNum -= 1;
		currentSurvey.modify(quesNum);
	}
	
	//Set up the question on the test to be modified
	public void modifyTest() throws IOException{
		System.out.println("You must enter the test to modify. This will load the test as well.");
		currentTest = testLoad();
		System.out.println("Which question would you like to modify?");
		String l = input.nextLine();
		int quesNum = Integer.parseInt(l);
		quesNum -= 1;
		currentTest.modify(quesNum);
	}
}
