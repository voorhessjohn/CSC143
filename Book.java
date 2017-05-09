/**
 * class Book
 * 
 * contains methods related to the book object
 * 
 * @author John Voorhess
 * 
 **/

public class Book{
	private String isbn;
	private String lastName;
	private String firstName;
	private String title;
	private int year;
	private double price;
	private Book next;
	/*Book constructor - each Book object has a node at the end that can store the next book*/
	public Book(String bookIsbn, String last, String first, String bookTitle, int year, double price, Book next){
		this.isbn = bookIsbn;
		this.lastName = last;
		this.firstName = first;
		this.title = bookTitle;
		this.year = year;
		this.price = price;		
		this.next = next;
	}
	/**
	 * method toString
	 * returns a String representation of the book object.
	 * 
	 * overrides Object.toString()
	 * @return String representation of the book object
	 * 
	 * */
	public String toString(){
		return " " + this.isbn +" "+ this.lastName +" "+ this.firstName +" "+ this.title +" "+ this.year + " " + this.price + " ";
		
	}
	//getters for instance fields
	public int getYear(){
		return this.year;
	}
	
	public String getIsbn(){
		return this.isbn;
	}
	public String getLastName(){
		return this.lastName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public String getTitle(){
		return this.title;
	}
	public double getPrice(){
		return this.price;
	}
	public Book getNext(){
		return this.next;
	}
	
	public void setNext(Book next) {
		this.next = next;
	}
	/**
	 * method searchBool
	 * returns boolean regarding search
	 * checks to see if the searchTerm equals the isbn, firstName, or lastName of the Book object
	 * 
	 * @return boolean
	 * 
	 * */
	public boolean searchBool(String searchTerm){
		if(searchTerm.equalsIgnoreCase(isbn)){
			return true;
		}else if(searchTerm.equalsIgnoreCase(firstName)){
			return true;
		}else if(searchTerm.equalsIgnoreCase(lastName)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * method isbnSearchBool()
	 * only checks the isbn for removing books.
	 * 
	 * @return boolean
	 * 
	 * */
	public boolean isbnSearchBool(String searchIsbn){
		if(searchIsbn.equalsIgnoreCase(isbn)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * method titleValidator
	 * checks if titles meet parameters
	 * 
	 * @return boolean
	 * 
	 * */
	public boolean titleValidator(String title){
		//title can't be empty
		if(title == null){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * method nameValidator
	 * checks if names meet parameters
	 * 
	 * @return boolean
	 * 
	 * */
	public boolean nameValidator(String name){
		//name cannot be empty
		if(name == null){
			return false;
		//name cannot begin with a number
		//check character value of first letter of string
		}else if(name.charAt(0)<64 || name.charAt(0)>123){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * method yearValidator
	 * checks if years meet parameters
	 * 
	 * @return boolean
	 * 
	 * */
	public boolean yearValidator(int year){
		//year cannot be greater than 2013
		if(year < 2013){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * method priceValidator
	 * checks if prices meet parameters
	 * 
	 * @return boolean
	 * 
	 * */
	public boolean priceValidator(double price){
		//price cannot be less than zero
		if(price>0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * method isbnValidator
	 * checks if isbns meet parameters
	 * 
	 * @return boolean
	 * 
	 * */
	public boolean isbnValidator(String isbn){
		//if the String isbn has no value, the isbn is invalid
		if(isbn == null){
			return false;
		}
		//test for leading, trailing, sequential, or too many hyphens before removing them
		if(isbn.startsWith("-")||isbn.endsWith("-")){
			System.out.println("Leading or trailing hyphens are not allowed in ISBN");
			return false;
		}else{
			//declare int variable to count hyphens
			int hyphen = 0;
			//loop through all characters to check hyphens
			for(int i = 0;i<isbn.length();i++){
				//char variable represents 
				char c = isbn.charAt(i);
				if(c=='-'&& isbn.charAt(i+1)=='-'){
					System.out.println("No sequential dashes allowed in ISBN");
					return false;
				}else{
					if(c == '-'){
						hyphen++;}
				}
			}
			//check for more or less than three hyphens
			if(hyphen>3||hyphen<3){
				System.out.println("Either 3 hyphens or NO hyphens.");
				return false;
			}
		}
		//since hyphens are not required, they are removed for validation
		isbn = isbn.replaceAll( "-", "" );
		
		//isbn length must be 10
		if(isbn.length() != 10){
			System.out.println("ISBN length must be ten digits.");
			return false;
		}
		
		//testing the checksum:
		try{
			//declare variable to hold sum of multiplied digits
			int total = 0;
			//loop through the first nine digits of the ISBN
			for(int i=0; i<isbn.length()-1; i++){
				/*total is the sum of each digit of the isbn multiplied by its 
				 * position in the string of numbers, as determined by the iteration in the loop*/
				total = total + (Integer.valueOf(isbn.substring(i, i+1))*(i+1));
				
			}
			//proposed checksum equals last digit of the isbn string
			String checkSum = isbn.substring(isbn.length()-1, isbn.length());
			//convert checkSum to X if needed
			if ("10".equals(checkSum)){
              checkSum = "X";
			}
			
			//our theoretical checksum should be the total%11
			int checkSumCheck = total%11;
			
			//convert checkSumCheckString to X if needed
			String checkSumCheckString = String.valueOf(checkSumCheck);
			if ("10".equals(checkSumCheckString)){
	              checkSumCheckString = "X";
				}
            //if the checksum equals the last digit, the method returns true
            return checkSum.equals(checkSumCheckString);
        }catch (NumberFormatException numberFormatException){
            //catch bad ISBN with non-numeric characters
            return false;
        }
    }
	
}