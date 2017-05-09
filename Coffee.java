/**
 * The Coffee Class extends the CaffeinatedDrink class
 * 
 * @author John Voorhess
 */

class Coffee extends CaffeinatedDrink {
	public PrintFormat pf = new PrintFormat();
	public int ounces;
	public double price_per_ounce = 1.5 * Drinks.basePrice;
	public double priceSurcharge = 0;
	public String type;
	public String name;

	/**
	 * Coffee constructor (without parameters) defaults to 6oz. drip
	 */
	public Coffee() {
		this.type = "drip";
		this.ounces = 6;
	}

	/**
	 * Coffee constructor (with parameters)
	 * @param double sendOunces          
	 * @param String sendType           
	 */
	public Coffee(double sendOunces, String sendType) {

		this.ounces = (int) sendOunces;
		this.type = sendType;
		if (sendOunces == 12) {
			this.priceSurcharge = .50;
		} else if (sendOunces == 16) {
			this.priceSurcharge = 1.0;
		} else {
			this.priceSurcharge = 0;
		}
	}

	public String toString() {
		return "The " + ounces + "oz. " + type + " costs $" + pf.printFormat(getPrice()) + ".";
	}

	public double getPrice() {
		double price = (double) ounces * (this.price_per_ounce) + priceSurcharge;
		return price;
	}
}