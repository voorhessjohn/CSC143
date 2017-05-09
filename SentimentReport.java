import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * class SentimentReport
 * 
 * contains the main method. Takes filename input from the user 
 * @author John Voorhess
 * 
 **/


public class SentimentReport {
	public static boolean TEST_MODE = false;
	static ArrayList<String> fileList = new ArrayList<String>();
	/**
	 * method buildFileList()
	 * adds a filename to a list of filenames.
	 * 
	 * @param fileName a file name of a text file contained in the project directory
	 * 
	 * */
	static void buildFileList(String fileName){
		if(!TEST_MODE){
			fileList.add(fileName);
			System.out.println("Added.");
		}else{
			fileList.add("Macbeth.txt");
			fileList.add("MuchAdoAboutNothing.txt");
			fileList.add("OliverTwist.txt");
		}
	}

	/**
	 * method intro()
	 * gives an explanation of the program and prompts user for filenames
	 * 
	 * @return ArrayList<String> fileNames
	 * 
	 * */
	static ArrayList<String> intro(){
		//an error message will be returned if the file is not found
		String errorMessageText = "Not found";
		boolean exists = false;
		boolean errorMessage = false;
		boolean done = false;
		String demoString = "demo";

		System.out.println("Welcome to the book analyzer.");
		System.out.println("You may analyze your own files or type \"demo\" after the prompt to see a demonstration.");
		
		while(!done && !TEST_MODE){
				
				Scanner console = new Scanner(System.in);
				/*while exists boolean value is set to false, the user is prompted to enter a filename.
				 * a File object is created with the name that the user has specified.*/
				if(errorMessage){
					System.out.println(errorMessageText);
				}
				System.out.println("Please enter the filename and extension of the book (\"example.txt\"):");
				System.out.println("Type \"done\" when you're finished adding files.");
				
				String file = console.next();
				File tempFile = new File(file);
				
				//http://alvinalexander.com/java/java-file-exists-directory-exists
				//if the tempFile is actually a file, exists value is set to be true if tempFile exists
				if(tempFile.isFile()){
					exists = tempFile.exists();
					buildFileList(file);

				}else if(file.equals(demoString)){
					console.close();
					exists = true;
					TEST_MODE = true;
					buildFileList("demo");
					return fileList;
				}else if(file.equals("done")){

					done = true;
					console.close();
					return fileList;
				}else{
					errorMessage = true;
				}
			
		}
		return fileList;
		
	}
	/**
	 * method getReport()
	 * takes an ArrayList of file names and sends it to BookAnalyzer
	 * @param ArrayList<String> files
	 * */
	static void getReport(ArrayList<String> files) throws FileNotFoundException{
		BookAnalyzer bookAnalyzer = new BookAnalyzer(files);
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> files = intro();
		System.out.println(files);
		getReport(files);
		

	}
}