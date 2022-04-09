
public class Tablet 
{
	private String name;
	private String kind;
	private char system;
	private double size;
	private double price;
	
	
	/*BUILDERS AND COPIERS*/
	
	/**
	 * Create new tablet with default parameters
	 */
	public Tablet()
	{
		this.name="default tablet";
		this.kind="001";
		this.system='W';
		this.size=100;
		this.price=1000;
	}//end default tablet constructor
	
	/**
	 * Create a new tablet with specified parameters
	 * @param name - tablet model name
	 * @param kind - tablet model kind (e.g screen size)
	 * @param system - char representing tablet's operating system
	 * @param size - tablet memory size
	 * @param price - tablet price
	 */
	public Tablet(String name, String kind, char system, double size, double price)
	{
		this.name=name;
		this.kind=kind;
		this.setSystem(system);
		this.size=size;
		this.price=price;
	}//end tablet builder
	
	/**
	 * Copy a specified tablet's parameters to invoking element
	 * @param other - tablet to be "copied"
	 * @implNote specified tablet remains unchanged
	 */
	public Tablet(Tablet other)
	{
		name=other.name;
		kind=other.kind;
		system=other.system;
		size=other.size;
		price=other.price;
	}//end tablet copy constructor
	
	/*SETTERS AND GETTERS*/
	
	/**
	 * Set operating system type for invoking tablet element
	 * @param os - char representing an operating system, either 'W', 'I', or 'A'
	 */
	private void setSystem(char os)
	{
		if (os=='W' || os=='A' || os=='I')
			this.system=os;
		else
			System.out.println("OS ERROR");
	}//end system setter
	
	/**
	 * Set price for invoking tablet element 
	 * @param p - new price to be set
	 */
	public void setPrice(double p)
	{
		this.price=p;
	}//end price setter
	
	/**
	 * Set name for invoking tablet element
	 * @param n - new name to be set
	 */
	public void setName(String n)
	{
		this.name=name.replace(name, n);
	}//end name setter
	
	/**
	 * Get tablet name
	 * @return String containing name of invoking tablet element
	 */
	public String getName()
	{
		return name;
	}//end name getter
	
	/**
	 * Get tablet "kind"
	 * @return String containing "kind" of invoking tablet element
	 */
	public String getKind()
	{
		return kind;
	}//end kind getter
	
	/**
	 * Get tablet's operating system
	 * @return Char representing operating system of invoking tablet element
	 */
	public char getSystem()
	{
		return system;
	}//end system getter
	
	/**
	 * Get tablet's memory size
	 * @return Double containing size of invoking tablet element
	 */
	public double getSize()
	{
		return size;
	}//end size getter
	
	/**
	 * Get tablet's price
	 * @return Double containing price of invoking tablet element
	 */
	public double getPrice()
	{
		return price;
	}//end price getter

	/*OTHER METHODS*/
	
	/**
	 * Check if the given tablet has identical parameters to those specified
	 * @param t1 - tablet element to compare
	 * @param n - specific name String
	 * @param k - specific kind String
	 * @param s - specific size
	 * @return True - if given tablet has identical parameters to those specified
	 * @return False - if at least one parameter is different from that of given tablet
	 */
	public boolean isSame(Tablet t1, String n, String k, double s)
	{
		if (t1.name.equals(n))
			if (t1.kind.equals(k))
				if (t1.size==s)
					return true;
		return false; //only activates if all 3 conditions have not been met
	}//end same-tablet check
	
	/**
	 * Check if two given tablets have identical Name, Kind and Size parameters
	 * @param t1 - first tablet to compare
	 * @param t2 - second tablet to compare
	 * @return True - if tablets have identical specified parameters
 	 * @return False - if at least one parameter is different between the tablets
	 */
	public boolean isSame(Tablet t1, Tablet t2)
	{
		if (isSame(t1, t2.getName(), t2.getKind(), t2.getSize()))
			return true;
		return false;
	}//end same-tablet comparison
	
	/**
	 * Print a full description of invoking tablet element
	 */
	public void print()
	{
		System.out.println("Name: "+name+"\nKind: "+kind+"\nOS: "+system+"\nSize: "+size+"\nPrice: "+price);
	}//end tablet printer
	
}//END CLASS
