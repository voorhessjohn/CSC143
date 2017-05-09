import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * class Adder
 * 
 * Adder contains methods to add text files to HashSet and TreeSet objects
 * 
 * @author John Voorhess
 * 
 **/


public class Adder{
	/**
	 * method addToHashSet()
	 * adds text file to a HashSet object
	 * @param <String> The filename of the book file to be added to HashSet
	 * @return Set<String> the HashSet containing the words from the text file
	 * @throws FileNotFoundException 
	 * */
	Set<String> addToHashSet(String bookFile) throws FileNotFoundException{
		//create new Set object to store file text
		Set<String> wordsHash = new HashSet<String>();
		//create new scanner instance to read File object
		Scanner in = new Scanner(new File(bookFile));
		/*while loop assigns each word in the file, makes it lowercase
		 * for comparison, and adds it to the new Set object*/
		while (in.hasNext()){
			String word = in.next();
			word = word.toLowerCase();
			wordsHash.add(word);	
		}
		//close Scanner
		in.close();
		
		return wordsHash;	
	}
	
	/**
	 * method addToTreeSet()
	 * adds text file to a TreeSet object
	 * @param <String> The filename of the book file to be added to TreeSet
	 * @return Set<String> the TreeSet containing the words from the text file
	 * @throws FileNotFoundException
	 * */
	Set<String> addToTreeSet(String bookFile) throws FileNotFoundException{
		//create new Set object to store file text
		Set<String> wordsTree = new TreeSet<String>();
		//create new scanner instance to read File object
		Scanner in = new Scanner(new File(bookFile));
		/*while loop assigns each word in the file, makes it lowercase
		 * for comparison, and adds it to the new Set object*/
		while (in.hasNext()){
			String word = in.next();
			word = word.toLowerCase();
			wordsTree.add(word);	
		}
		//close Scanner
		in.close();
		
		return wordsTree;	
	}
}