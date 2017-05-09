/**
 * CleanCorruptedData 
 * 
 * adds elements to an ArrayList, cleans the ArrayList,
 * and prints the new cleaned ArrayList
 * 
 * @author John Voorhess
 */

import java.util.*;

public class CleanCorruptData{
	public static ArrayList<Integer> userInput = new ArrayList<Integer>();
	
	/**
	 * populateList
	 * 
	 * adds elements to an ArrayList<Integer> for testing                  
	 */
	public void populateList(){
		int[] userInputList = {3, 7, 5, 5, 8, 5, 6, 3, 4, 7};
		
		for(int i=0;i<userInputList.length;i++){
			userInput.add(userInputList[i]);
		}
		cleanCorruptData(userInput);
		
	}
	/**
	 * cleanCorruptedData
	 * @param ArrayList<Integer> s  
	 * @return ArrayList<Integer> cleaned  
	 * @author John Voorhess                 
	 */

	public ArrayList<Integer> cleanCorruptData(ArrayList<Integer> s){
		//create ArrayList of type Integer to represent the cleaned ArrayList
		ArrayList<Integer> cleaned = null;
		//create ArrayList of type Integer to represent the dirty ArrayList
		ArrayList<Integer> toClean = null;
		// store the value of the ArrayList input in the ArrayList to be cleaned
		toClean = s;
		//check dirty ArrayList to see if it has an odd number of elements
		if(toClean.size()%2!=0){
			// if there are an odd number of elements, remove the last element
			toClean.remove(toClean.size()-1);
		}
		// for every element in the dirty ArrayList...
		for(int i=0;i<toClean.size();i++){
			//if the index is an odd number (the second integer in a pair of integers)...
			// AND the integer to the left of the second integer is less than the second integer...
			if(i%2>0 && toClean.get(i-1)<toClean.get(i)){
				//remove the second number in the pair
				toClean.remove(i);
				//remove the first number in the pair
				toClean.remove(i-1);		
			}

		}
		//assign value of dirty input to cleaned ArrayList
		cleaned = toClean;
		//print the cleaned ArrayList as verification
		System.out.println(cleaned.toString());
		//return the cleaned ArrayList
		return cleaned;
		
	}
	
	public static void main(String[] args) {
		new CleanCorruptData().populateList();	
	}
}