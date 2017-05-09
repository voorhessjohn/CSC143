import java.io.FileNotFoundException;
import java.util.*;

/**
 * class BookComparison
 * 
 * <p> BookComparison() contains the main method that instantiates new 
 * Adder and Comparator objects and calls object methods to add text
 * files to HashSets and TreeSets and compare those Set objects</p>
 * 
 * @author John Voorhess
 * */
public class BookComparison{
	//main method
	public static void main(String[] args) {
		
		//a new instance of an Adder object is instantiated
		Adder adder = new Adder();
		
		//a new instance of a Comparator object is instantiated
		Comparator comparator = new Comparator();
		
		/*new Set objects of type String are instantiated. These objects will hold
		 * the words from two text files. They are created as Set<String> objects because
		 * the Set class provides methods of the Collection interface, allowing methods
		 * like "add", "contains", and "remove" to be used*/
		Set<String> secondVarietyHash = new HashSet<String>();
		Set<String> variableManHash = new HashSet<String>();
		Set<String> secondVarietyTree = new TreeSet<String>();
		Set<String> variableManTree = new TreeSet<String>();
		
		/*The addToHashSet() and addToTreeSet() methods of the Adder class throw
		 * a FileNotFoundException, so a try/catch statement is used to call these methods.*/
		try {
			variableManHash = adder.addToHashSet("TheVariableMan.txt");
			secondVarietyHash = adder.addToHashSet("SecondVariety.txt");
			
			variableManTree = adder.addToTreeSet("TheVariableMan.txt");
			secondVarietyTree = adder.addToTreeSet("SecondVariety.txt");
			
			
		} catch (FileNotFoundException e) {
			
			//if the file is not found, the printStackTrace() method of FileNotFoundException is called.
			e.printStackTrace();
		}

		/*I have added the following four lines to confirm that the Set objects
		 * store information and that the Set objects representing different files
		 * store a different number of words*/
		System.out.println("variablemanhash " + variableManHash.size());
		System.out.println("secondvarietyhash " + secondVarietyHash.size());
		System.out.println("variablemantree " + variableManTree.size());
		System.out.println("secondvarietytree " + secondVarietyTree.size());
		
		/*Eight separate calls to the comparator() method of the Comparator
		 * object are called. Each of these returns a report on the number of
		 * iterations through the first Set object, the number of matches found
		 * in the second Set object, and the elapsed time for comparison*/
		comparator.comparator(variableManHash,secondVarietyHash);
		comparator.comparator(variableManHash,secondVarietyTree);
		comparator.comparator(variableManTree,secondVarietyHash);
		comparator.comparator(variableManTree,secondVarietyTree);
		comparator.comparator(secondVarietyHash,variableManHash);
		comparator.comparator(secondVarietyHash,variableManTree);
		comparator.comparator(secondVarietyTree,variableManHash);
		comparator.comparator(secondVarietyTree,variableManTree);	
	}
}

