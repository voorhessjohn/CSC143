/*The Drinks Class will contain fields for the base price/oz. and the drink
size (small = 6 oz., medium = 12 oz., large = 16 oz.). In essence, this
covers the minimal costs (labor, cup, etc.). It will include also methods
to print the drink information and to change the base drink prices
(ideally all the prices should be changed simultaneously).*/
/**
 * The Drinks class is the parent class for all drink items.
 * 
 * @author John Voorhess
 */
class Drinks {
	public PrintFormat pf = new PrintFormat();
	public String name = "Drink";
	public static double basePrice = 0.1;
	public String size = "regular";
	public double ounces = 0;
	public String inputName;
	public String inputSize;

	public Drinks(String inputName, String inputSize) {
		name = inputName;
		size = inputSize;
		getPrice();
	}

	public Drinks() {

	}

	public String toString() {
		return "The " + size + " " + name + " costs $" + pf.printFormat(getPrice()) + ".";
	}

	/**
	 * Allows for a price change method to be implemented later. Changes the
	 * basePrice double by which all Drink prices are derived
	 * 
	 * @param double
	 *            costMultiplier
	 */
	public void changeDrinkCost(double costMultiplier) {
		basePrice = basePrice * costMultiplier;
	}

	public double getPrice() {
		double price = ounces * basePrice;
		return price;
	}

	public static void main(String[] args) {

	}
}
