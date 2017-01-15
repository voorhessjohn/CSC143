import java.util.*;

/**
 * CSC 143 Weekly Problem 2 <br>
 * Checking validity of EAN
 * 
 * @author <John Voorhess>
 */

public class CheckSum {
	//store user input as String
	public String userEAN;
	public String userEANSTR;
	//instantiate Input class to receive user input
	//public Input input = new Input();
	//instantiate 1D array of weights
	int [] weights = {1,3,1,3,1,3,1,3,1,3,1,3};
	//boolean to allow user to quit by typing "q"
	public boolean quit;
	//comparison String value to determine whether the user has typed "q"
	public String quitStr = "q";
	
	
	
	public void acceptAndCheckEAN() {
		
		while (!quit){
			Scanner console = new Scanner(System.in);
			
			//find length of input string to determine validity
			System.out.print("Please enter your EAN or type q to quit:");
			
			this.userEAN = console.next();
			
			
			int inputLength = this.userEAN.length();
			//quit boolean defaults to false
			quit = false;
			//if block allows loop to break if user has typed "q"
			
			if (this.userEAN.equals(quitStr)){
				quit = true;
				break;
			//test for EAN length (over-length test is below)				
			}else if(inputLength<13){
				System.out.println("That is not a valid EAN");	
			//if requirements are met, the program will run
			}else{
				quit = false;
				
			}
			//create int array to store each character of user string input as individual int
			int[] ean = new int[userEAN.length()];
			//create int array to store values of ean[] multiplied by values of weights[]
			int[] eanByWeight = new int[ean.length-1];
			//int variable to store sum of weighted values
			int sumOfWeightedValues = 0;
			//for loop to load the numeric value of the characters from userEAN[] into an array of integers
			//uses a method from the Character class that I found at the following address:
			//http://stackoverflow.com/questions/28008730/how-to-split-string-of-numbers-in-to-int-array
			for (int i = 0; i < userEAN.length(); i++) {
				ean[i] = Character.getNumericValue(userEAN.charAt(i));
			}
			/*since the EAN will be one digit longer than the list of weights,
			*the length minus the checksum digit is stored to determine the length of the loop
			*when multiplying values in the two arrays. This value should be 12, but I wanted to keep it flexible*/
		    int eanArrayLength = ean.length-1;	    
		    /*the if statement that catches user inputs of lengths greater than 13 is in this section
		     * because an out of bounds exception is thrown when a list of values that is too
		     * long is allowed to get to this point.
		     */
		    if(inputLength>13){
		    	System.out.println("That is not a valid EAN");
		    }else{
		    	//for loop multiplies user values by weights and stores them in an array
		    	for (int j = 0; j < eanArrayLength; j++){
		    		eanByWeight[j] = ean[j] * weights[j];			    	
		    	}
		    }
		    //a for loop sums the values of the weighted user input
		    for (int k = 0; k < eanByWeight.length; k++){
		    	sumOfWeightedValues += eanByWeight[k];
		    }
		    /*to determine the nearest multiple of ten to use for the setup of
		     * the comparison operation, I found a technique that uses the round method 
		     * of the Math class. The sum is added to 5 to force it to round only up, divided by ten,
		     * and stored as a double. Then it is multiplied by ten and cast back into an integer to 
		     * chop off any extra digits from the double conversion. 
		     * This technique was found at the following address:
		     *http://stackoverflow.com/questions/9303604/rounding-up-a-number-to-nearest-multiple-of-5
		    */
		    double roundedUp = Math.round((sumOfWeightedValues+5)/10);
		    int checkValue = (int)(roundedUp*10);
		    //the sum of the weighted values is subtracted from the rounded-up sum to determine
		    //what value of the last digit of the EAN SHOULD be.
		    int checkLastDigit = checkValue-sumOfWeightedValues;
		    //The last digit of the user input EAN is checked against the proposed proper value
		    if(checkLastDigit == ean[ean.length-1]){
		    	System.out.println("Your EAN is valid");
		    	
		    }else{
		    	System.out.println("Your EAN is invalid");
		    	
		    }
		    
		}
	}
	
	public static void main(String[] args) {
	
		new CheckSum().acceptAndCheckEAN();
	}

}

