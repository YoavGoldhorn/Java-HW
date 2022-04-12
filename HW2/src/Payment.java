
public class Payment 
{
	private int day;
	private int licensePlate;
	private double amount;
	private String name;
	
	/*CONSTRUCTORS AND COPIERS*/
	/**
	 * Create a new payment bill element with specified values for attributes.
	 * @param day - day of bill, integer between 1 and 30.
	 * @param plate - license plate of vehicle.
	 * @param amount - amount of gas filled, any real number greater than or equal to 0.
	 * @param name - name of vehicle driver at time of filling.
	 */
	public Payment (int day, int plate, double amount, String name)
	{
		this.setDay(day);
		this.licensePlate=plate;
		this.setAmount(amount);
		this.name=name;
	}//END CONSTRUCTOR
	
	/**
	 * Copy another payment bill's attributes to invoking payment element.
	 * @param other - other bill to be copied.
	 * @implNote this method generates a new bill identical to the specified bill, but does not remove the old one.
	 */
	public Payment (Payment other)
	{
		this.setDay(other.day);
		this.licensePlate=other.licensePlate;
		this.setAmount(other.amount);
		this.name=other.name;
	}//END COPIER
	
	/*SETERS AND GETTERS*/
	/**
	 * Set the DAY attribute of a payment bill to specified value.
	 * @param day - integer between 1 and 30.
	 */
	private void setDay(int day)
	{
		if (day>=1 && day<=30)
			this.day=day;		
		else
			System.out.println("ERROR: invalid day, please enter a value between 1 and 30.");
	}//END DAY SETTER
	
	/**
	 * Set the AMOUNT attribute of a payment bill to specified value.
	 * @param amount - integer equal to 0 or greater.
	 */
	private void setAmount(double amount)
	{
		if (amount>=0)
			this.amount=amount;
		else
			System.out.println("ERROR: invalid gas amount, please enter a value greater than or equal to 0.");
	}//END AMOUNT SETTER
	
	/**
	 * Return the day of the bill.
	 */
	public int getDay()
	{
		return day;
	}//END  GETTER
	
	/**
	 * Return the license plate of the vehicle filled.
	 */
	public int getPlate()
	{
		return licensePlate;
	}//END PLATE GETTER
	
	/**
	 * Return the name of the filling driver.
	 */
	public String getName()
	{
		return name;
	}//END NAME GETTER
	
	/**
	 * Return the amount of gas filled.
	 */
	public double getAmount()
	{
		return amount;
	}//END AMOUNT GETTER
	
	/*METHODS*/
	/**
	 * Prints all bill attributes.
	 */
	public void print()
	{
		System.out.println("Day: "+day);
		System.out.println("Plate: "+licensePlate);
		System.out.println("Amount: "+amount);
		System.out.println("Name: "+name);
		System.out.println();
	}//END PRINTER
	
}//END CLASS
