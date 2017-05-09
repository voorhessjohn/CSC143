import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * class BookAnalyzer
 * 
 * contains methods to analyze book files
 * 
 * @author John Voorhess
 * 
 **/

public class BookAnalyzer{
	/**
	 * method BookAnalyzer
	 * 
	 * this constructor takes an ArrayList of book files and prints a sentiment report.
	 * 
	 * */
	public BookAnalyzer(ArrayList<String> bookList) throws FileNotFoundException{
		//system time is stored in a long variable
		long startTime = System.nanoTime();
		//a string variable used to store a sentiment report is instantiated
		String returnString = new String();
		//positive words are added to a hash set
		Set <String> posWords = addToHashSet("posWords.txt");
		//negative words are added to a hash set
		Set <String> negWords = addToHashSet("negWords.txt");
		//for each file in the list of files to analyze...
		for(String file: bookList){
			//the text file is added to an ArrayList
			ArrayList <String> list = addToArrayList(file);
			//a count of the words in the ArrayList is printed
			System.out.println(file + " has " + list.size() + " words.");
			//the filename, the ArrayList, and the hashsets are sent to comparator and the result is stored in a string variable
			returnString = comparator(file, list, posWords, negWords);
			//The results from comparator are printed
			System.out.println(returnString);
			//filenames, ArrayLists, and HashSets are sent to mostCommon()
			mostCommon(file, "posWords.txt", list, posWords);
			mostCommon(file, "negWords.txt", list, negWords);
			//The timer is stopped and the endtime is store in a long variable
			long elapsedTime = System.nanoTime() - startTime;
			//The total execution time is stored
			System.out.println("Total execution time: " + elapsedTime/1000000 + "ms.");
			System.out.println("");
		}
	}
	
	
	
	/**
	 * method mostCommon
	 * finds the most common words between an ArrayList and a HashSet.
	 * 
	 * @param title the name of the file in the ArrayList
	 * @param hash the name of the file in the HashSet
	 * @param compareList the ArrayList to be compared
	 * @param compareHash the HashSet to be compared
	 * 
	 * */
	void mostCommon(String title, String hash, ArrayList<String> compareList, Set<String> compareHash){
		//an integer variable to store the count of matches between sets is instantiated
		int count = 0;
		//a string variable used to store matching words is instantiated	
		String matchWord = "";	
		//an ArrayList of strings to store matching words is instantiated	
		ArrayList<String> matchWords = new ArrayList<String>();
		//for each word in the list of words to compare
		for (String word: compareList) {
			//if that word exists in the HashSet
		    if(compareHash.contains(word)){
		    	//the word is added to the ArrayList of matching words
		    	matchWords.add(word);
		    }   	
		}
		//for each word in the HashSet being compared
	    for (String word: compareHash){
	    	//an integer variable to store the count of matches is instantiated
		   	int count2 = 0;
		   	//for each word in the list of matching words
		   	for (String word2: matchWords){
		    	//if that word exists in the HashSet (at least one will exist)
		   		if(word.equals(word2)){
		   			//the count variable is incremented by one
		   			count2++;
	    		}		    			
	   		}
		   	//if the count of matching words for this word in the hash set is greater than the count of matches...
	   		if(count2 > count){
	   			//the value of count2 is stored in count
	   			count = count2;
	   			//the current string that is the most frequently found word is stored
	   			matchWord = word;
	   		}
	    }


	//a short report is printed	
	System.out.println("The most common word between " + title + " and " + hash + " is " + matchWord + ", occurring " + count + " times.");

	}
	
	/**
	 * method addToHashSet
	 * adds a text file to a HashSet
	 * 
	 * @param bookFile the filename of the text file to be added to a HashSet
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
	 * method addToArrayList
	 * adds a text file to an ArrayList
	 * 
	 * @param bookFile the filename of the text file to be added to an ArrayList
	 * */	
	ArrayList<String> addToArrayList(String bookFile) throws FileNotFoundException{
		//create new Set object to store file text
		ArrayList<String> bookList = new ArrayList<String>();
		//create new scanner instance to read File object
		Scanner in = new Scanner(new File(bookFile));
		/*while loop assigns each word in the file, makes it lowercase
		 * for comparison, and adds it to the new Set object*/
		while (in.hasNext()){
			String word = in.next();
			word = word.toLowerCase();
			bookList.add(word);	
		}
		//close Scanner
		in.close();
			
		return bookList;	
	}
	
	/**
	 * method comparator()
	 * compares an ArrayList to Set objects
	 * 
	 * @param title the name of the book file
	 * @param ArrayList<String> list the list containing the book file
	 * @param Set<String> compare1 The first Set to compare
	 * @param Set<String> compare2 The second Set to compare
	 * @return String a sentiment analysis report
	 * */
	String comparator(String title,ArrayList<String> list,Set<String> compare1, Set<String> compare2){
		//system time is stored in a long variable
		long startTime = System.nanoTime();
		//a string stores a line break object. Cool trick, right?
		String newLine = System.getProperty("line.separator");
		//a decimal format object is stored
		DecimalFormat df = new DecimalFormat("###.##");
		//counting variables are instantiated
		double posCount = 0;
		double negCount = 0;
		double count3 = 0;
		//here is the size of the list
		double size = list.size();
		
		String returnString = new String();
		String type = new String();
		
		//loop through all of the words in the list
		for(int i=0; i<list.size();i++){
			String word = list.get(i);
			//if the positive hashset contains the word from the list at this iteration...
			if(compare1.contains(word)){
				//increment the positive count by one
				posCount++;
			//if the negative hashset contains the word from the list at this iteration...
			}else if(compare2.contains(word)){
				//increment the negative count by one
				negCount++;
			//if it's not in either set...
			}else{
				//we still count it
				count3++;
			}
		}
		/*Here's the analysis part: I decided that a 5% difference in the count of negative and
		 * positive words was enough to classify the book as a comedy or a tragedy. Anything less than
		 * that, and it's considered "boring".*/
		if(posCount > 1.05*negCount){
			type = "comedy";
		}else if(negCount > 1.05*posCount){
			type = "tragedy";
		}else{
			type = "a boring book";
		}
		//now we stop the timer
		long elapsedTime = System.nanoTime() - startTime;
		//here, we print out a report
		returnString = "In " + elapsedTime/1000000 + "ms, " + title+" was determined to be a " + type + " with " + df.format(posCount/size*100)+"% positive words, " + newLine +df.format(negCount/size*100)+"% negative words, and "+df.format(count3/size*100)+"% neutral words."
		+ newLine +
		"("+(int)posCount+" positive words)" + newLine + "("+(int)negCount+" negative words)" + newLine + "("+(int)count3+" neutral words)";
		return returnString;

	}
	
}