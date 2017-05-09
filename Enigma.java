import java.util.ArrayList;

/*
 * https://www.quora.com/How-do-you-split-a-word-in-Java
String s="abcd";
char[] a=s.toCharArray();
for(char c:a){
	System.out.println(c);
}
*/

public class Enigma {
	public char[] outerRotor = { '#', 'B', 'D', 'F', 'H', 'J', 'L', 'N', 'P', 'R', 'T', 'V', 'X', 'Z', 'A', 'C', 'E',
			'G', 'I', 'K', 'M', 'O', 'Q', 'S', 'U', 'W', 'Y' };
	public char[] middleRotor = { '#', 'E', 'J', 'O', 'T', 'Y', 'C', 'H', 'M', 'R', 'W', 'A', 'F', 'K', 'P', 'U', 'Z',
			'D', 'I', 'N', 'S', 'X', 'B', 'G', 'L', 'Q', 'V' };
	public char[] innerRotor = { '#', 'G', 'N', 'U', 'A', 'H', 'O', 'V', 'B', 'I', 'P', 'W', 'C', 'J', 'Q', 'X', 'D',
			'K', 'R', 'Y', 'E', 'L', 'S', 'Z', 'F', 'M', 'T' };
	public char[] rotatedRotor;
	

	public String encryptedOutput;
	public String decryptedOutput;

	public String enigmaEncrypt(String inputString) {
		String s = inputString;
		int i;
		int j;
		int k;
		char p;
		char encryptedOutputChar;

		char[] a = s.toCharArray();

		char[] encrypted = new char[a.length];
		System.out.println(java.util.Arrays.toString(a));
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < innerRotor.length; j++) {
				if (innerRotor[j] == a[i]) {
					char o = outerRotor[j];
					p = o;
					System.out.println("outerRotor match =" + o);
					for (k = 0; k < middleRotor.length; k++) {
						if (p == middleRotor[k]) {
							encryptedOutputChar = outerRotor[k];
							System.out.println(outerRotor[k] + " equals " + encryptedOutputChar);

							encrypted[i] = encryptedOutputChar;

						}
					}
					System.out.println(encrypted);

				}
			}
			rotateRotorClockWise(innerRotor);
			System.out.println(a[i]);
		}

		encryptedOutput = java.util.Arrays.toString(encrypted);

		return encryptedOutput;
	}

	public String enigmaDecrypt(String inputString) {
		String s = inputString;
		int i;
		int j;
		int k;
		int l;

		char[] a = s.toCharArray();
		char[] decrypted = new char[a.length];
		// for(l=0; l<a.length; l++){
		// rotateRotorClockWise(innerRotor);
		// }
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < outerRotor.length - 1; j++) {
				if (outerRotor[j] == a[i]) {
					char o = middleRotor[j];
					System.out.println("middleRotor match =" + o);
					for (k = 0; k < outerRotor.length; k++) {
						if (o == outerRotor[k]) {
							char decryptedOutputChar = innerRotor[k];
							System.out.println(innerRotor[k] + " equals " + decryptedOutputChar);
							decrypted[i] = decryptedOutputChar;

						}
					}
				}
			}
			rotateRotorClockWise(innerRotor);
			System.out.println(a[i]);
		}

		decryptedOutput = java.util.Arrays.toString(decrypted);
		System.out.println(decryptedOutput);
		return decryptedOutput;
	}

	public void rotateRotorCounterClockWise(char[] inputArray) {

		char[] temp = new char[27];
		int i;
		for (i = 0; i < inputArray.length - 1; i++) {
			temp[i] = inputArray[i + 1];
		}
		temp[26] = inputArray[0];

		rotatedRotor = temp;

		innerRotor = rotatedRotor;

	}

	public void rotateRotorClockWise(char[] inputArray) {

		char[] temp = new char[27];
		int i;
		for (i = 26; i > 0; i--) {
			temp[i] = inputArray[i - 1];
		}
		temp[0] = inputArray[26];

		rotatedRotor = temp;

		innerRotor = rotatedRotor;

	}
}