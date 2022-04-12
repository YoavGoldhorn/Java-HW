import java.util.ArrayList;

public class Store 
{
	private ArrayList<Tablet> tablets;
	private int countW, countA, countI;
	
	/*BUILDERS AND COPIERS*/	
	/**
	 * Construct an "empty" store with 0 devices
	 */
	public Store()
	{
		countW=countA=countI=0;
		tablets=new ArrayList<>();
	}//end default store builder
	
	/**
	 * Copy specified store's parameters to invoking store element
	 * @param other - store to be copied
	 * @implNote specified store remains unchanged
	 */
	public Store(Store other)
	{
		this.countA=other.countA;
		this.countI=other.countI;
		this.countW=other.countW;
		for (Tablet t : other.tablets)
		{
			this.tablets.add(t);
		}//end tablets ArrayList copy
	}//end store copy constructor
	
	/*SETTERS AND GETTERS*/
	/**
	 * @return count of Android devices in store
	 */
	public int getA()
	{
		return countA;
	}//end Android getter
	/**
	 * @return count of iOS devices in store
	 */
	public int getI()
	{
		return countI;
	}//end iOS getter
	/**
	 * @return count of Windows devices in store
	 */
	public int GetW()
	{
		return countW;
	}//end Windows getter

	/*OTHER METHODS*/
	/**
	 * Check if specified tablet has identical parameters to any of the tablets in the invoking store element
	 * @param t1 - tablet to search within invoking store element
	 * @return True - if an identical tablet has been found; False - otherwise
	 */
	public boolean tabletExistInStore(Tablet t1)
	{
		for (Tablet t2 : tablets)
		{
			if (t2.isSame(t2, t1))
				return true;
		}//end ArrayList check
		return false;
	}//end same-tablet inventory checker
	
	/**
	 * Auxiliary method to addTablet method
	 * @param t1 - Tablet to be found
	 * @return address of tablet, if an identical tablet element has been found within invoking store element; NULL if no such tablet has been found
	 */
	private Tablet findSame(Tablet t1)
	{
		for (Tablet t2 : tablets)
		{
			if (t1.isSame(t1, t2))
				return t2;
		}//end locator loop
		return null;
	}//end tablet locator
	
	/**
	 * Auxiliary method to addTablet method
	 * @param sys - operating system to define counter
	 */
	private void updateCount(char sys)
	{
		if (sys=='W')
			this.countW++;
		if (sys=='A')
			this.countA++;
		if (sys=='I')
			this.countI++;
	}//end OS updater
	
	/**
	 * Add new tablet element to a store's Tablets ArrayList, and updates store inventory.
	 * If new tablet already exists but has a lower price - method replaces old tablet price with new price.
	 * @param newTablet - tablet element to be added
	 * @see updateCount(char sys)
	 */
	public void addTablet(Tablet newTablet)
	{
		if (tabletExistInStore(newTablet))
		{
			Tablet oldTablet=findSame(newTablet); //connects existing tablet's address to 'oldTablet', for clarity
			//if price of old tablet is lower than the new, replace old price; if not, drop new tablet, basically deleting it
			if (oldTablet.getPrice()<newTablet.getPrice())
				oldTablet.setPrice(newTablet.getPrice());
		}//end existing tablet re-pricing
		else
		{
			tablets.add(newTablet);
			updateCount(newTablet.getSystem());
		}//end tablet addition
	}//end tablet adder

	/**
	 * Prints the full details for all tablet element, and afterwards prints a summary of the store's inventory.
	 */
	public void print()
	{
		for (Tablet t : tablets)
		{
			System.out.println("Item #"+(tablets.indexOf(t)+1));
			t.print();
			System.out.println("\n------------------");
		}//end printing loop
		System.out.println("-Store Inventory-");
		System.out.println("Android Devices: "+countA+"\niOS Devices: "+countI+"\nWindows Devices: "+countW);
		System.out.println("\n~~~~~~~~~~~~~~~~~~\n");			
	}//end store printer
	
	/**
	 * Re-organises tablets in a store by their OS type:
	 * first are Windows tablets,
	 * second are Androids,
	 * and last are iOS tablets.
	 * The method scans through the inventory 3 times (one for each OS type), and after compiling a new inventory list, replaces the unsorted list with the new one.
	 * The method also prints the entire inventory after sorting.
	 * @see print(), addTablet(Tablet newTablet)
	 */
	public void sortStore()
	{
		ArrayList<Tablet> temp_list = new ArrayList<>();
		
		/*add all devices in order*/
		for (Tablet t : tablets)
		{
			if (t.getSystem()=='W')
				temp_list.add(new Tablet(t));
		}//end Windows adding
		
		for (Tablet t : tablets)
		{
			if (t.getSystem()=='A')
				temp_list.add(new Tablet(t));
		}//end Android adding
		
		for (Tablet t : tablets)
		{
			if (t.getSystem()=='I')
				temp_list.add(new Tablet(t));
		}//end iOS adding
		
		/*replace old unsorted list with sorted list and print store inventory*/
		this.tablets=temp_list;
		this.print();
	}//end store sorter	
}//END CLASS
