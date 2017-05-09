import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * class Translator
 * 
 * contains the main method. Takes file input of an RNA string and returns a protein string
 * 
 * @author John Voorhess
 * 
 **/

public class Translator {
	//a new HashMap object is instantiated. This will be the reference object
	private Map<String,String> codon = new HashMap<String,String>();
	//a new ArrayList of characters is used to store the characters from the text file
	private List<Character> temp = new ArrayList<Character>();
	//compareList is used to hold the three-letter strings of RNA units
	private List<String> compareList = new ArrayList<String>();
	//proteinList will store the final string of proteins
	private ArrayList<String> proteinList = new ArrayList<String>();
	
	/**
	* method loadMap()
	*
	*loads a HashMap of RNA sequences and their respective protein values.
	*/
	void loadMap(){
		codon.put("UUU","F");
		codon.put("GGG","G");
		codon.put("GGA","G");
		codon.put("GGC","G");
		codon.put("GGU","G");
		codon.put("GAG","E");
		codon.put("GAA","E");
		codon.put("GAC","D");
		codon.put("GAU","D");
		codon.put("GCG","A");
		codon.put("GCA","A");
		codon.put("GCC","A");
		codon.put("AAG","K");
		codon.put("AGU","S");
		codon.put("AGC","S");
		codon.put("AGA","R");
		codon.put("AGG","R");
		codon.put("GUU","V");
		codon.put("GUC","V");
		codon.put("GUA","V");
		codon.put("GUG","V");
		codon.put("GCU","A");
		codon.put("AUC","I");
		codon.put("AUA","I");
		codon.put("AUG","M");
		codon.put("ACU","T");
		codon.put("ACC","T");
		codon.put("ACA","T");
		codon.put("ACG","T");
		codon.put("AAU","N");
		codon.put("AAC","N");
		codon.put("AAA","K");
		codon.put("CCG","P");
		codon.put("CAU","H");
		codon.put("CAC","H");
		codon.put("CAA","Q");
		codon.put("CAG","Q");
		codon.put("CGU","R");
		codon.put("CGC","R");
		codon.put("CGA","R");
		codon.put("CGG","R");
		codon.put("AUU","T");
		codon.put("UUC","F");
		codon.put("UUA","L");
		codon.put("UUG","L");
		codon.put("UCU","S");
		codon.put("UCC","S");
		codon.put("UCA","S");
		codon.put("UCG","S");
		codon.put("UAU","Y");
		codon.put("UAC","Y");
		codon.put("UAA","Stop");
		codon.put("UAG","Stop");
		codon.put("UGU","C");
		codon.put("UGC","C");
		codon.put("UGA","Stop");
		codon.put("UGG","W");
		codon.put("CUU","L");
		codon.put("CUC","L");
		codon.put("CUA","L");
		codon.put("CUG","L");
		codon.put("CCU","P");
		codon.put("CCC","P");
		codon.put("CCA","P");	
	}
	/**
	* method translator()
	*
	*loads a text file of an RNA string and prints a protein string translation.
	*/

	private void translator(){
		//a new GetString object is instantiated to allow for appending strings from ArrayLists
		GetString x = new GetString();
		
		try {
			//a new Scanner object is created and loaded with the txt file
			Scanner fileScanner = new Scanner(new File ("RNAString.txt"));
			//this Scanner instance uses an empty string as a delimiter to return one letter at a time.
			fileScanner.useDelimiter("");
			
			while(fileScanner.hasNext()){
				//Scanner.next().charAt(0) will return the next character in the file
				char c = fileScanner.next().charAt(0);
				//that character is added to the array
				temp.add(c);   
			}
			//Scanner object is closed
			fileScanner.close();		
		}catch(FileNotFoundException e){
			System.out.println("File not found, please check pathway and try again.");	
		}
		//a for loop that increments by three is used to load three letters at a time into the compareList ArrayList
		for(int i=0; i<temp.size();i+=3){
			//a second temporary ArrayList is created for every iteration. It will store only three letters
			ArrayList<Character> temp2 = new ArrayList<Character>();
			temp2.add(temp.get(i));
			temp2.add(temp.get(i+1));
			temp2.add(temp.get(i+2));
			//The StringBuilder object is used to convert the small 
			//ArrayList of characters to a string to be added to the comparison list
			compareList.add(x.getStringFromCharList(temp2));	
		}
		//for each element in the compareList of three-letter chains...
		for(int j=0; j<compareList.size();j++){
			//if the three-letter element is in the HashMap...
			if(codon.containsKey(compareList.get(j))){
				//the corresponding letter value is returned
				String a = codon.get(compareList.get(j));
				//the single-letter value is added to the proteinList ArrayList
				proteinList.add(a);
			}
		}
		//the complete protein string is printed to the console
		System.out.println(x.getStringFromStringList(proteinList));
	}
	


	//main method of the program
	public static void main(String[] args) {
		
		Translator x = new Translator();
		x.loadMap();
		x.translator();

	}
}