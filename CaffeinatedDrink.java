/**
 * The CaffeinatedDrink Class extends the Drinks class
 * 
 * @author John Voorhess
 */

class CaffeinatedDrink{
	public class caffeinatedDrink extends Drinks{
		public PrintFormat pf = new PrintFormat();
		public double price_per_ounce = 3;
		public String name;
		/**
		 * CaffeinatedDrink constructor (without parameters) defaults to "default caffeinated drink; default size"
		 */
		public caffeinatedDrink(){
			name = "defult caffeinated drink";
			size = "default size";
		}
		/**
		 * CaffeinatedDrink constructor (with parameters)
		 * 
		 * @param String
		 *            inputSize
		 * @param String
		 *            inputName
		 */
		public caffeinatedDrink(String inputName, String inputSize){
			name = inputName;
			size = inputSize;
		}
		public String toString(){
			return "The " + size + " " + name + " costs $" + pf.printFormat(getPrice()) + ".";
		}
		public double getPrice(){
			double price = ounces * (this.price_per_ounce*basePrice);
			return price;
		}
	}
}
