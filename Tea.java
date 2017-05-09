/**
 * The Tea Class extends the CaffeinatedDrink class
 * 
 * @author John Voorhess
 */
class Tea extends CaffeinatedDrink {
	public PrintFormat pf = new PrintFormat();
	public double ounces;
	public double price_per_ounce = 1.5 * Drinks.basePrice;
	public String flavor;

	/**
	 * Tea constructor (without parameters) defaults to 6oz. English Breakfast
	 */
	public Tea() {
		flavor = "English Breakfast";
		ounces = 6;
	}

	/**
	 * Tea constructor (with parameters)
	 * 
	 * @param double
	 *            sendOunces
	 * @param String
	 *            sendFlavor
	 */
	public Tea(double sendOunces, String sendFlavor) {
		this.ounces = sendOunces;
		this.flavor = sendFlavor;
	}

	public String toString() {
		return "The " + ounces + "oz. " + flavor + " costs $" + pf.printFormat(getPrice()) + ".";
	}

	public String toString(double a) {
		return " " + a;
	}

	public double getPrice() {
		double price = this.ounces * this.price_per_ounce;
		return price;
	}

}