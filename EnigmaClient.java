import java.util.*;
import java.io.*;

public class EnigmaClient{
	public Enigma enigma = new Enigma();
	public String userMenuSelectionString;
	public String defaultMenuSelectionString;
	public String customRotorString;
	public String userInputString;
	public String userInputUpperString;
	public String whichRotorAnswer;
	public String userYesOrNoAnswer;
	public String yes = "yes";
	public String no = "no";
	public int userMenuSelectionInt;
	public int defaultMenuSelectionInt;
	public int whichRotorAnswerInt;
	public int firstOption = 1;
	public int secondOption = 2;
	public int thirdOption = 3;
	public boolean stop;
	public boolean stop2;
	public boolean stop3;
	public boolean stop4;
	public boolean stop5;
	public boolean stop6;
	public void welcome(){
		System.out.println("Welcome to the simple Enigma emulator.");
		

	}
	public void menuSelection(){
		System.out.println("Please select from the menu below:");
		System.out.println("1. Use default rotor settings");
		System.out.println("2. Input custom rotor settings");
		while(!stop){
			stop = false;
			Scanner console = new Scanner(System.in);
			System.out.print("Enter your choice:");
			userMenuSelectionString = console.next();
			//http://stackoverflow.com/questions/8187083/can-you-store-a-string-in-a-int-in-java
			userMenuSelectionInt = Integer.parseInt(userMenuSelectionString);
			if(userMenuSelectionInt == firstOption){
				stop = true;
				//call method for default rotor settings
				defaultMenu();
			}else if(userMenuSelectionInt == secondOption){
				stop = true;
				//call method for custom rotor settings
				customRotor();
			}else{
				System.out.println("Please enter a valid selection (1 or 2)");
			}
		}
	}
	public void defaultMenu(){
		System.out.println("The Enigma model will use the following settings:");
		System.out.println("    OUTER ring: #BDFHJLNPRTVXZACEGIKMOQSUWY");
		System.out.println("   MIDDLE ring: #EJOTYCHMRWAFKPUZDINSXBGLQV");
		System.out.println("    INNER ring: #GNUAHOVBIPWCJQXDKRYELSZFMT");
		System.out.println("");
		System.out.println("Would you like to:");
		System.out.println("	1. Encrypt");
		System.out.println("	2. Decrypt");
		System.out.println("	3. Run default example");
		while(!stop2){
			stop2 = false;
			Scanner console = new Scanner(System.in);
			System.out.print("Enter your choice(1, 2, or 3):");
			defaultMenuSelectionString = console.next();
			//http://stackoverflow.com/questions/8187083/can-you-store-a-string-in-a-int-in-java
			defaultMenuSelectionInt = Integer.parseInt(defaultMenuSelectionString);
			if(defaultMenuSelectionInt == firstOption){
				stop2 = true;
				//call method for encryption
				acceptUserInputForEncryption();
			}else if(defaultMenuSelectionInt == secondOption){
				
				stop2 = true;
				acceptUserInputForDecryption();
			}else if(defaultMenuSelectionInt == thirdOption){
				stop2 = true;
			}else{
				System.out.println("Please enter a valid selection (1, 2, or 3)");
			}
		}
	}
	public void customRotor(){
		System.out.println("Enter a string of characters, beginning with a #, for your rotor");
		System.out.println("The characters must all be unique and can only be the 26 letters of the alphabet.");
		while(!stop5){
			stop5 = false;
			Scanner console = new Scanner(System.in);
			System.out.print("Enter your inner rotor characters");
			customRotorString = console.nextLine();
			char[] customRotor = customRotorString.toCharArray();
			int dupe = 0;
//			for (int i = 0; i < customRotor.length; i++) {
//				for (int j = 0;j<enigma.innerRotor.length;j++){
//					if (enigma.innerRotor[i]==customRotor[j]) {
//			            dupe++;
//					}
//				}
//			}
			if(dupe==0){
				stop5 = true;
				//save custom rotor as a new rotor
				while(!stop6){
					Scanner console2 = new Scanner(System.in);
					System.out.print("Which rotor would you like to replace?(1,2,3, or quit)");
					whichRotorAnswer = console2.nextLine();
					whichRotorAnswerInt = Integer.parseInt(whichRotorAnswer);
					if(whichRotorAnswerInt==firstOption){
						enigma.innerRotor = customRotor;
					}else if(whichRotorAnswerInt==secondOption){
						enigma.middleRotor = customRotor;
					}else if(whichRotorAnswerInt==thirdOption){
						enigma.outerRotor = customRotor;
					}else if(whichRotorAnswer=="quit"){
						stop6=true;
						acceptUserInputForEncryption();
					}else{
						System.out.println(dupe);
						System.out.println("Please pick a valid option");
					}
				}
			}else{
				System.out.println(dupe);
				System.out.println(java.util.Arrays.toString(customRotor));
				System.out.println("Please enter a valid string of numbers");
			}
		}
	}
	public void acceptUserInputForEncryption(){
		
		while(!stop3){
			stop3 = false;
			Scanner console = new Scanner(System.in);
			System.out.print("Enter your string to encrypt:");
			userInputString = console.nextLine();
			System.out.println("You have entered: " + userInputString);
			System.out.print("Would you like to encrypt this message? (type yes or no)");
			userYesOrNoAnswer = console.next();
			if(userYesOrNoAnswer.equals(yes)){
				stop3 = true;
				//call method for encryption
				userInputUpperString = userInputString.toUpperCase();
				enigma.enigmaEncrypt(userInputUpperString);
			}else if(userYesOrNoAnswer.equals(no)){
				//keep looping
			}else{
				System.out.println("Please enter a valid selection (yes or no)");
			}
		}
	}
public void acceptUserInputForDecryption(){
		
		while(!stop4){
			stop4 = false;
			Scanner console = new Scanner(System.in);
			System.out.print("Enter your string to decrypt:");
			userInputString = console.nextLine();
			System.out.println("You have entered: " + userInputString);
			System.out.print("Would you like to decrypt this message? (type yes or no)");
			userYesOrNoAnswer = console.next();
			if(userYesOrNoAnswer.equals(yes)){
				stop4 = true;
				//call method for encryption
				userInputUpperString = userInputString.toUpperCase();
				enigma.enigmaDecrypt(userInputUpperString);
			}else if(userYesOrNoAnswer.equals(no)){
				//keep looping
			}else{
				System.out.println("Please enter a valid selection (yes or no)");
			}
		}
	}
	public static void main(String[] args) {
		// the welcome message runs when the main method is called.
		new EnigmaClient().welcome();
		new EnigmaClient().menuSelection();
	}
}