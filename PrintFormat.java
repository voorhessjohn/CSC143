import java.text.DecimalFormat;

/**
 * The PrintFormat Class uses java.text.DecimalFormat and an if block to set
 * multiple formatting options for listing prices and change.
 * The idea came from:
 * http://stackoverflow.com/questions/34063620/java-print-double-println-or-printf
 * I've created a class for this mechanism to reduce redundant code
 * @author John Voorhess
 */

/**
 * PrintFormat employs an if block to apply appropriate formatting to doubles
 * used as prices and change
 * 
 * @param double
 *            unFormatted
 * @author John Voorhess
 */
class PrintFormat {
	public String printFormat(double unFormatted) {
		String formatted = null;
		if (unFormatted < 1) {
			DecimalFormat df = new DecimalFormat(".00");
			formatted = df.format(unFormatted);
		} else if (unFormatted < 10) {
			DecimalFormat df = new DecimalFormat("0.00");
			formatted = df.format(unFormatted);
		} else if (unFormatted < 100) {
			DecimalFormat df = new DecimalFormat("00.00");
			formatted = df.format(unFormatted);
		} else if (unFormatted < 1000) {
			DecimalFormat df = new DecimalFormat("000.00");
			formatted = df.format(unFormatted);
		} else {
			/*
			 * Rather than continue to format possible output, I have used the
			 * valueOf() method in String to return the value of the double as a
			 * string in the unlikely event that a dollar value over $1000 is
			 * generated. I learned of the valueOf() method from:
			 * http://stackoverflow.com/questions/5766318/converting-double-to-
			 * string
			 */
			formatted = String.valueOf(unFormatted);
		}
		return formatted;
	}

	public static void main(String[] args) {

	}
}
