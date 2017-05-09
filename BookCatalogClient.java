import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * class BookCatalogClient
 * 
 * contains methods to manipulate a BookCatalog object
 * 
 * @author John Voorhess
 * 
 **/
public class BookCatalogClient{
	public static BookCatalog catalog;
	public static Scanner fileScanner;
	public static Scanner consoleScanner;
	
	/**
	 * method Welcome()
	 * 
	 * greets user and loads a catalog file
	 * 
	 * @author John Voorhess
	 * 
	 **/
	public static void welcome() throws FileNotFoundException{
		System.out.println("Welcome to the book catalog program.");
		//booklist.txt is hard-coded in
		String catalogFile = "booklist.txt";
		//create new BookCatalog instance
		catalog = new BookCatalog();
		try{
			//open the fileScanner and load the text file in
			fileScanner = new Scanner(new File(catalogFile));
			//iterate through each line in the list of books
			while(fileScanner.hasNext()==true){
				
				//store next line in the file as a String object
				String book = fileScanner.nextLine();
				//split the string object at each tab and store each segment in a list of book fields
				String[] bookArray = book.split("\t");
				//at the list of parameters to the catalog as a book
				
				catalog.add(bookArray[0],bookArray[1],bookArray[2],bookArray[3],Integer.valueOf(bookArray[4]),Double.valueOf(bookArray[5]));
			}
			//print a message so the user knows something happened
			System.out.print("Catalog created successfully.");
			
			
			
			
			
		}catch(FileNotFoundException fileNotFoundException){
			System.out.println("File not found.");
		}
	}
	/**
	 * method Menu()
	 * 
	 * presents options for manipulating BookCatalog object
	 * 
	 * @author John Voorhess
	 * 
	 **/
	public static void menu(){
		consoleScanner = new Scanner(System.in);
		boolean validChoice = false;
		String menuChoice = new String();
		int menuChoiceInt = 0;
		while(!validChoice){
			System.out.println("Please enter the corresponding number from this list of options:");
			System.out.println("1. Add a book to the catalog.\n");
			System.out.println("2. View the catalog.\n");
			System.out.println("3. Search for a book to the catalog.\n");
			System.out.println("4. Delete a book from the catalog.\n");
			System.out.println("5. Exit the program.\n");

			
			menuChoice = consoleScanner.next();
			//this preemptively sanitizes user input. Only allows strings that can be parsed to integer values.
			try{
				menuChoiceInt = Integer.parseInt(menuChoice);
			}catch(NumberFormatException numberFormatException){
				System.out.println("Please enter a valid number from the menu.");
				menu();
			}
			
			
			if(menuChoiceInt == 1){
				//a fake book to access Book methods
				Book b = new Book("1-57231-866-X","Hart","Kevin","I'm A Big Boy Now", 2011,22.90,null);
				validChoice = true;
				String[] inputBook = new String[6];
				String isbnInput = new String();
				String lastNameInput = new String();
				String firstNameInput = new String();
				String titleInput = new String();
				String yearInputString = new String();
				String priceInputString = new String();
				String year = new String();
				
				double price = 0.00;
				//validator booleans
				boolean validIsbn = false;
				boolean validLastName = false;
				boolean validFirstName = false;
				boolean validTitle = false;
				boolean validYear = false;
				boolean validPrice = false;
				
				//take isbn
				while(!validIsbn){
					System.out.println("Please enter the ISBN number for the new book.");
					consoleScanner = new Scanner(System.in);
					isbnInput = consoleScanner.nextLine();
					//if the isbn passes the test, the boolean is set to true
					validIsbn = b.isbnValidator(isbnInput);
					
				}
				inputBook[0] = isbnInput;
				//take last name
				while(!validLastName){
					System.out.println("Please enter the last name of the author.");
					consoleScanner = new Scanner(System.in);
					lastNameInput = consoleScanner.nextLine();
					//if the last name passes the test, the boolean is set to true
					validLastName = b.nameValidator(lastNameInput);
					
				}
				inputBook[1] = lastNameInput;
				//take first name
				while(!validFirstName){
					System.out.println("Please enter the first name of the author.");
					consoleScanner = new Scanner(System.in);
					firstNameInput = consoleScanner.nextLine();
					//if the first name passes the test, the boolean is set to true
					validFirstName = b.nameValidator(firstNameInput);
					
				}
				inputBook[2] = firstNameInput;
				//take title
				while(!validTitle){
					System.out.println("Please enter the title.");
					consoleScanner = new Scanner(System.in);
					titleInput = consoleScanner.nextLine();
					//if the title passes the test, the boolean is set to true
					validTitle = b.titleValidator(titleInput);
					System.out.println(b.titleValidator(titleInput));
				}
				inputBook[3] = titleInput;
				//take year
				while(!validYear){
					System.out.println("Please enter the year of publication.");
					consoleScanner = new Scanner(System.in);
					yearInputString = consoleScanner.nextLine();
					int yearInt = Integer.valueOf(yearInputString);
					//if the year passes the test, the boolean is set to true
					validYear = b.yearValidator(yearInt);
					year = String.valueOf(yearInt);
				}
				inputBook[4] = year;
				//take price
				while(!validPrice){
					System.out.println("Please enter the price.");
					consoleScanner = new Scanner(System.in);
					priceInputString = consoleScanner.nextLine();
					price = Double.valueOf(priceInputString);
					validPrice = b.priceValidator(price);
					System.out.println(b.priceValidator(price));
				}
				inputBook[5] = priceInputString;
				//ADD THAT BOOK!!!!
				catalog.add(inputBook[0],inputBook[1],inputBook[2],inputBook[3],Integer.valueOf(inputBook[4]),Double.valueOf(inputBook[5]));
				//show the menu again
				menu();
			}else if(menuChoiceInt == 2){

				//print the catalog
				catalog.toString();
			}else if(menuChoiceInt == 3){

				//search
				System.out.println("Please enter a search term.");
				consoleScanner = new Scanner(System.in);
				String searchInputString = consoleScanner.nextLine();
				//print results from catalog search method
				System.out.println(catalog.contains(searchInputString));
			}else if(menuChoiceInt == 4){

				System.out.println("Please enter a the ISBN for the book you would like to delete.");
				consoleScanner = new Scanner(System.in);
				String deleteInputString = consoleScanner.nextLine();
				//use BookCatalog method for deleting book
				catalog.deleteBook(deleteInputString);
			}else if(menuChoiceInt == 5){
				//prompt user to save upon exit
				System.out.println("Would you like to save the changes that you've made to the book catalog?");
				System.out.println("Type y or n");
				consoleScanner = new Scanner(System.in);
				String exitMenuChoice = consoleScanner.nextLine();
				//make it lowercase to reduce confusion
				exitMenuChoice = exitMenuChoice.toLowerCase();
				if(exitMenuChoice.equals("y")){
					System.out.println("You have chosen to save the file.");
					try{
						//create new PrintStream object - writing to a different file for testing purposes (helps when I was failing and ruining the booklist file)
						
						PrintStream fileOutput = new PrintStream(new File("books.txt"));
						//a book array from which to print
						Book[] bookArray = new Book[catalog.size()];
						//store output from toBookArray method in new array
						bookArray = catalog.toBookArray(catalog.size());
						//output the book object at each book in the array
						for(int i = 0; i < bookArray.length; i++){
							fileOutput.println(bookArray[i].getIsbn()+"\t"+bookArray[i].getLastName()+"\t"+bookArray[i].getFirstName()+"\t"+bookArray[i].getTitle()+"\t"+bookArray[i].getYear()+"\t"+bookArray[i].getPrice());
						}
						
						
						fileOutput.close();
						System.out.println("File saved. Goodbye.");
					}catch(FileNotFoundException fileNotFoundException) {
						System.out.println("File not found. Sorry.");
					}
					validChoice = true;
				}else if(exitMenuChoice.equals("n")){
					//see you later
					System.out.println("Nothing saved. Goodbye.");
					validChoice = true;
				}else{
					//give user more chances
					System.out.println("Please type y or n next time.");
					menu();
				}
			
			}else{
				System.out.println("Please enter a valid menu selection.");
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		//fake book for testing add method
//		Book b = new Book("1-57231-866-X","Hart","Kevin","I'm A Big Boy Now", 2011,22.90,null);		
		welcome();
		menu();
		
		
		
	}
}