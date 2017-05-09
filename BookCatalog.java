
/**
 * class Book
 * 
 * contains methods related to BookCatalog object
 * stores Book objects in a linked list
 * 
 * @author John Voorhess
 * 
 **/
public class BookCatalog {
	private Book firstBook;

	/**
	 * method toBookArray()
	 * returns an array of Book objects for use in writing to a file
	 * @param int size
	 * @return Book[]
	 * 
	 * */
	public Book[] toBookArray(int size){
			//catalog.size() is meant to be used to find appropriate size for the array
			Book[] bookArray = new Book[size];
			Book newBook = firstBook;
			int i = 0;
			while(newBook!=null){
				bookArray[i] = newBook;

				i++;
				newBook = newBook.getNext();
			}
			return bookArray;
		
	}
	/**
	 * method toString()
	 * returns String representation of each book in the catalog
	 * @return String
	 * 
	 * */
	public String toString(){
		if(firstBook!=null){
			Book newBook = firstBook;
			while(newBook!=null){
				System.out.println("\n"+newBook.toString());
				newBook = newBook.getNext();
			}
		}
		else
			System.out.println("No books to print.");
		return null;
	}
	
	
	/**
	 * method add()
	 * finds the right spot and links a new book object into the catalog
	 * @param String isbn
	 * @param String last name
	 * @param String first name
	 * @param String title
	 * @param int year
	 * @param double price
	 * 
	 * */
	public void add(String isbn, String lastName, String firstName, String title, int year, double price){
		//make a new book object
		Book newNode = new Book(isbn, lastName, firstName, title, year, price, null);
		if(firstBook==null)
			firstBook = newNode;
		else{
			Book newBook = firstBook;
			//find the first null nextNode
			while(newBook.getNext()!=null)
				newBook = newBook.getNext();
			//set the new book as the last nextNode
			newBook.setNext(newNode);
		}
	}
	/**
	 * method deleteBook()
	 * removes books from the catalog
	 * 
	 * @param String isbn
	 * 
	 * */ 
	public void deleteBook(String isbn){
		Book bookToDelete = firstBook;
		Book tempBook = null;
		//move through the list of books until the isbn matches
		while(bookToDelete.isbnSearchBool(isbn)!=true){
			//move like an inchworm connecting books
			tempBook = bookToDelete;
			bookToDelete = bookToDelete.getNext();
		}
		bookToDelete = bookToDelete.getNext();
		tempBook.setNext(bookToDelete);
		System.out.printf("Deleted.");
	}
	/**
	 * method contains()
	 * uses Book.searchBool to match searchTerms. 
	 * If the terms match, Book.toString() is returned. 
	 * Otherwise, a message tells user that the book was not found.
	 * 
	 * @param String searchTerm
	 * 
	 * */ 
	public String contains(String searchTerm){
		Book searchBook = firstBook;
		while(searchBook!=null){
			if(searchBook.searchBool(searchTerm)== true)
				return searchBook.toString();
			searchBook = searchBook.getNext();
		}
		return ("Sorry. Didn't find it.");
	}
	
	/**
	 * method size()
	 * gives user the number of books in the catalog
	 * 
	 * @return int count
	 * 
	 * */ 
	public int size(){
		int count = 0;
		
		for(Book book = firstBook; book != null; book = book.getNext())
			++count;
		return count;
	}
}