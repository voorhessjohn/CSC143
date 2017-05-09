/**
 * The NonCaffeinatedDrink Class extends the Drinks class
 * 
 * @author John Voorhess
 */
class NonCaffeinatedDrink extends Drinks {
	public int ounces;
	public double price_per_ounce = 2 * basePrice;
	public String name;

	/**
	 * NonCaffeinatedDrink constructor (with parameters)
	 * 
	 * @param double
	 *            sendOunces
	 * @param String
	 *            sendName
	 */
	public NonCaffeinatedDrink(double sendOunces, String sendName) {
		this.name = sendName;
		this.ounces = (int) sendOunces;
	}

	/**
	 * NonCaffeinatedDrink constructor (without parameters) defaults to 6oz.
	 * water
	 */
	public NonCaffeinatedDrink() {
		this.name = "water";
		this.ounces = 6;
	}

	public String toString() {
		return "The " + ounces + "oz. " + name + " costs $" + pf.printFormat(getPrice()) + ".";
	}

	public double getPrice() {
		double price = (double) ounces * (this.price_per_ounce * basePrice);
		return price;
	}
}