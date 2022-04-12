import java.util.ArrayList;

public class TrickTruck 
{
	private ArrayList<Payment>[] payments; //this is an array of Lists; each entry in the array is an ArrayList of Payment elements; i.e payments[3] contains all Payment elements for day 3 of the month.  
	private ArrayList<Integer> cars;
	private ArrayList<String> drivers;
	
	/*CONSTRUCTORS & COPIERS*/
	/**
	 * Constructor - creates a new element of type TrickTruck (a monthly overview).
	 * @param cars - list of license plate numbers belonging to the company during the desired time period
	 * @param drivers - list of driver names working for the company during the desired time period
	 */
	public TrickTruck(ArrayList<Integer> cars, ArrayList<String> drivers)
	{
		//create a new ArrayList of cars and add all existing license plates
		this.cars = new ArrayList<Integer>();
		for (int car : cars)
			this.cars.add(car);

		//create a new ArrayList of drivers and add all existing drivers
		this.drivers = new ArrayList<String>();
		for (String driver : drivers)
			this.drivers.add(driver);
		
		//create a new array of Payments; note that the list starts as empty; note that the first cell (payments[0]) should remain empty to match real-world day numbers
		this.payments = new ArrayList[31];
		for (int i=0; i<payments.length; i++)
			payments[i] = new ArrayList<Payment>();
	}//END PARTIAL CONSTRUCTOR
	
	/*METHODS*/
	/**
	 * Check if a specified driver exists in the company's drivers list.
	 * @param driverName - name of driver.
	 * @return true - if driver exists; false - otherwise.
	 * @implNote - Method is case-sensitive, allowing for names such as McLean and Mclean to identify different drivers
	 */
	public boolean existDriver(String driverName)
	{
		for (String temp : drivers) 
		{
			if (temp.equals(driverName))
				return true;
		}//end names check
		
		return false;
	}//END DRIVER CHECKER

	/**
	 * Check if a specified license plate is registered in the company's trucks list.
	 * @param plateNum - number of license plate.
	 * @return true - if plate exists; false - otherwise.
	 */
	public boolean existCar(int plateNum)
	{
		for (int temp : cars)
		{
			if (temp==plateNum)
				return true;
		}//end plate number check
		return false;
	}//END CAR CHECKER
	
	/**
	 * Check if specified driver has worked during the specified day
	 * @param driverName - name of driver.
	 * @param day - day of month.
	 * @return true - if driver has a bill signed in his name for that day; false - if no bills on record at the specified day contain the driver's name. 
	 */
	public boolean worked(String driverName, int day)
	{
		for (Payment temp : payments[day])
		{
			if (driverName.equals(temp.getName()))
				return true;
		}//end name checker for specified day
		return false; //only activates if no matches were found
	}//END WORKED CHECK

	/**
	 * Copy a payment bill and add it to the list of payments according to its recorded day.
	 * @param bill - payment bill to be copied and inserted
	 * @return true - if process completed successfully; false - if plate number or driver do not exist in the database.
	 * @implNote - plate number and driver name must match perfectly to those stored in the database.
	 */
	public boolean addPayment(Payment bill)
	{
		if (existCar(bill.getPlate()) && existDriver(bill.getName()))
		{
			int day = (bill.getDay()); //copy day from bill for better readability
			payments[day].add(new Payment(bill)); //add the new payment to the specified day's payments list, using the copy-constructor
			System.out.println("Bill successfully added!");
			return true;
		}//end bill addition
		else
		{
			System.out.println("Bill error! Driver name or license plate mismatch, bill could not be added.");
			return false;
		}
	}//END PAYMENT COPY-ADDITION
	
	/**
	 * Creates a new payment bill based on the specified parameters.
	 * @param day - day of bill, integer between 1 and 30.
	 * @param licensePlate - plate number of fuelled vehicle.
	 * @param name - name of vehicle driver at time of fuelling.
	 * @param amount - amount of gas filled, any real number greater than or equal to 0.
	 * @return true - if addition was successful; false - otherwise (see addPayment(Payment bill) for return mechanism).
	 */
	public boolean addPayment(int day, int licensePlate, String name, int amount)
	{
		Payment p=new Payment(day, licensePlate, amount, name);
		return addPayment(p);
	}//END PAYMENT ADDITION
	
	/**
	 * Calculates total fuel consumption per vehicle over the entire recorded period
	 * @param plate - plate number against which the registries are checked 
	 * @return the amount of fuel consumed by the vehicle(s) bearing the specified license plate 
	 */
	public double totalFuel(int plate)
	{
		double total=0;
		for (int i=0; i<payments.length; i++)
		{
			total+=totalFuel(plate, i);
		}//end summing loop
		return total;
	}//END MONTHLY FUEL CONSUMPTION CALCULATOR
	
	/**
	 * Calculates total fuel consumption per vehicle over the specified day
	 * @param plate - plate number against which to check the registries
	 * @param day - day number against which to check the registries
	 * @return the amount of fuel consumed by the vehicle(s) bearing the specified license plate over the specified day
	 */
	public double totalFuel(int plate, int day)
	{
		double total=0;
		for (Payment temp:payments[day])
		{
			if (plate==temp.getPlate())
				total=+temp.getAmount();
		}//end daily summing
		return total;
	}//END DAILY FUEL CONSUMPTION CALCULATOR
}//END CLASS
