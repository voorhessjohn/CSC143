import java.util.*;

public class CoffeeShop {
	// create an instance of the print formatting object
	public PrintFormat pf = new PrintFormat();
	// instantiate a set of Strings to which user input will be compared
	public String coffeeDrink = "coffee";
	public String teaDrink = "tea";
	public String otherDrink = "other";
	public String checkOut = "checkout";
	public double compareOunces;
	public boolean quit;
	/*
	 * Three different ArrayLists are created to store drinks of like class. In
	 * an earlier version of this program, I used one ArrayList of type Drinks,
	 * but when I split the Drinks child classes into their own files, they were
	 * no longer recognized as drinks. Thus, because of deadline constraints,I
	 * was forced to use three ArrayLists, each of a different Drinks subtype.
	 */
	ArrayList<Coffee> orderCoffee = new ArrayList<Coffee>();
	ArrayList<Tea> orderTea = new ArrayList<Tea>();
	ArrayList<NonCaffeinatedDrink> orderNonCaffeinatedDrink = new ArrayList<NonCaffeinatedDrink>();

	// print a welcome message
	public void welcome() {
		System.out.println("Welcome to DRINKSHACK");
	}

	/*
	 * The takeOrder() method runs inside a while loop and prompts users to
	 * choose a type of drink. Within three different if statements, the method
	 * then calls the getSize() method to prompt the user to choose a size.
	 * Users then are prompted to choose a flavor or type or name, depending on
	 * the type of drink that was selected.
	 */
	public void takeOrder() {
		while (!quit) {
			// set boolean quit to false to allow the loop to run.
			quit = false;
			String customerInputDrink;
			Scanner console = new Scanner(System.in);
			System.out.print("What would you like to drink?:(enter coffee, tea, other, or checkout)");
			customerInputDrink = console.next();
			if (customerInputDrink.equals(teaDrink)) {
				double inputOunces;
				String inputFlavor;
				// call getSize() method to prompt user to choose a size
				inputOunces = getSize();

				// getFlavor() is a method unique to tea drinks.
				inputFlavor = getFlavor();
				System.out.print("What flavor):");
				// instantiate new Tea object
				Tea i = new Tea(inputOunces, inputFlavor);
				// print the drink info for review
				System.out.println(i.toString());
				// ask user if they would like to add the drink to their order
				addToOrder(i);

			} else if (customerInputDrink.equals(coffeeDrink)) {
				double inputOunces;
				String inputType;
				// call getSize() to get the drink size from the user
				inputOunces = getSize();
				// getType() is unique to the Coffee Drink option
				inputType = getType();
				// instantiate new Coffee object
				Coffee i = new Coffee(inputOunces, inputType);
				// print the drink info for review
				System.out.println(i.toString());
				// ask user if they would like to add the drink to their order
				addToOrder(i);
			} else if (customerInputDrink.equals(otherDrink)) {
				double inputOunces;
				String inputName;
				// call getSize() to get the drink size from the user
				inputOunces = getSize();
				
				// getName() is unique to the NonCaffeinatedDrink option
				inputName = getName();
				// instantiate new NonCaffeinatedDrink object
				NonCaffeinatedDrink i = new NonCaffeinatedDrink(inputOunces, inputName);
				// print the drink info for review
				System.out.println(i.toString());
				// ask the user if they would like to add the drink to their
				// order
				addToOrder(i);
			} else if (customerInputDrink.equals(checkOut)) {
				// set boolean variable to true to end the loop.
				quit = true;

			} else {
				// if user input does not match accepted values, prompt user to
				// try again
				System.out.println("Not a valid input; please try again");
			}
		}
		// When the checkout option is invoked, the loop ends and the checkOut()
		// method is called.
		checkOut();
	}

	public double getSize() {
		// three String objects representing sizes to which user input will be
		// compared
		// are instantiated
		final String smallSize = "small";
		final String mediumSize = "medium";
		final String largeSize = "large";
		double inputOunces = compareOunces;
		Scanner console = new Scanner(System.in);
		String customerInputSize;
		
		System.out.print("What size?(enter small, medium, or large):");
		customerInputSize = console.next();
		if (customerInputSize.equals(smallSize)) {
			inputOunces = 6;
		} else if (customerInputSize.equals(mediumSize)) {
			inputOunces = 12;
			System.out.println("drink size is medium");
		} else if (customerInputSize.equals(largeSize)) {
			inputOunces = 16;
		} else {
			// If the customer can't be bothered to enter a valid size, they get
			// a small
			System.out.println("That is not a valid size. You get a small");
			inputOunces = 6;
		}

		// getSize() returns the user-selected size as a double representing
		// ounces
		return inputOunces;
	}

	/*
	 * The getFlavor() method allows the user to enter any value for the flavor
	 * of their tea
	 */
	public String getFlavor() {
		Scanner console = new Scanner(System.in);
		String customerInputFlavor;
		// prompt user
		System.out.print("What flavor?:");
		customerInputFlavor = console.next();
		return customerInputFlavor;
	}

	/*
	 * The getType() method allows the user to enter any value for the type of
	 * their coffee
	 */
	public String getType() {
		Scanner console = new Scanner(System.in);
		String customerInputType;
		// prompt user
		System.out.print("What type?:");
		customerInputType = console.next();
		return customerInputType;
	}

	/*
	 * The getName() method allows the user to enter any value for the name of
	 * their non-caffeinated drink
	 */
	public String getName() {
		Scanner console = new Scanner(System.in);
		String customerInputName;
		System.out.print("What drink?:");
		customerInputName = console.next();
		return customerInputName;
	}

	/*
	 * addToOrder() is an overloaded method that takes one of three different
	 * types of object and inserts them into an array of like types
	 */
	public void addToOrder(NonCaffeinatedDrink i) {
		NonCaffeinatedDrink currentDrink = i;
		// a string for comparison
		String yesAnswer = "yes";
		Scanner console = new Scanner(System.in);
		// instantiate answer string
		String answer;
		// prompt user
		System.out.print("Would you like to add this drink to your order?");
		answer = console.next();
		// if the customer answers yes, the currentDrink object is added to an
		// arraylist
		if (answer.equals(yesAnswer)) {
			orderNonCaffeinatedDrink.add(currentDrink);
		}
	}

	public void addToOrder(Coffee i) {
		Coffee currentDrink = i;
		String yesAnswer = "yes";
		Scanner console = new Scanner(System.in);
		String answer;
		System.out.print("Would you like to add this drink to your order?");
		answer = console.next();
		// if the customer answers yes, the currentDrink object is added to an
		// arraylist
		if (answer.equals(yesAnswer)) {
			orderCoffee.add(currentDrink);
		}
	}

	public void addToOrder(Tea i) {
		Tea currentDrink = i;
		String yesAnswer = "yes";
		Scanner console = new Scanner(System.in);
		String answer;
		System.out.print("Would you like to add this drink to your order?");
		answer = console.next();
		// if the customer answers yes, the currentDrink object is added to an
		// arraylist
		if (answer.equals(yesAnswer)) {
			orderTea.add(currentDrink);
		}
	}

	/*
	 * When the user selects checkOut(), each of the three arraylists of
	 * different drink types are looped through. The drink price is added to the
	 * order total using the individual getPrice() method of each drink type.
	 * Each set of drink info is printed with the unique toString() method for
	 * that drink type. When all loops have finished, the total, orderTotal, is
	 * printed on the screen
	 */
	public void checkOut() {
		double orderTotal = 0;
		for (int j = 0; j < orderTea.size(); j++) {
			System.out.println(orderTea.get(j).toString());
			orderTotal += orderTea.get(j).getPrice();
		}
		for (int j = 0; j < orderCoffee.size(); j++) {
			System.out.println(orderCoffee.get(j).toString());
			orderTotal += orderCoffee.get(j).getPrice();
		}
		for (int j = 0; j < orderNonCaffeinatedDrink.size(); j++) {
			System.out.println(orderNonCaffeinatedDrink.get(j).toString());
			orderTotal += orderNonCaffeinatedDrink.get(j).getPrice();
		}
		System.out.println("Your total is: $" + pf.printFormat(orderTotal));
	}

	public static void main(String[] args) {
		// the welcome message runs when the main method is called.
		new CoffeeShop().welcome();
		// customer interaction starts here
		new CoffeeShop().takeOrder();
	}
}
