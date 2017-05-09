import java.util.Iterator;
import java.util.Set;

/**
 * class Comparator
 * 
 * Adder contains methods to add text files to HashSet and TreeSet objects
 * 
 * @author John Voorhess
 * 
 **/

public class Comparator{
	
	/**
	 * method comparator()
	 * compares two Set objects, prints elapsed comparison time,
	 * number of iterations through the first Set object,
	 * and number of matches found in the second Set object.
	 * @param Set<String> The first Set to compare
	 * @param Set<String> The second Set to compare
	 * */
	void comparator(Set<String> compare1, Set<String> compare2){
		//new Iterator object is created to iterate through the first Set object
		Iterator<String> itr = compare1.iterator();
		//two counter variables are instantiated
		int count = 0;
		int count2 = 0;
		
		//process start time is set
		long startTime = System.nanoTime();
		while (itr.hasNext()){
			String word = itr.next();
			//this counter tallies the number of words that are searched in the first Set
			count2++;
			/*the contains() method of the Collection interface is used to check
			 * whether each word in the first Set is contained within the second Set*/
			if (compare2.contains(word)){
				//for each matching word, the counter variable is incremented by one
				count++;				
			}
		}
		//elapsed time is stored
		long elapsedTime = System.nanoTime() - startTime;
		//a report is printed
		System.out.println("INSIDE COMPARATOR Total execution time: " + elapsedTime/1000000 + "ms");
		System.out.println("INSIDE COMPARATOR iterations through first Set object:" + count2);
		System.out.println("INSIDE COMPARATOR number of matches in second Set object: " + count);
	}
	
}