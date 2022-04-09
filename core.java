
public class core 
{
	public static void main(String[] args) 
	{
		Store gsp = new Store();
		Tablet t1= new Tablet("iPad Max 2023", "10.2", 'I', 256, 1000);
		Tablet t2= new Tablet("Galaxy Tab 7", "10.2", 'A', 512, 2000);
		Tablet t3= new Tablet("Surface Pro", "11.3", 'W', 2048, 5000);
		Tablet t4= new Tablet("Google Pixel", "7.8", 'A', 1024, 2500);
	
		gsp.addTablet(t1);
		gsp.addTablet(t2);
		gsp.addTablet(t3);
		gsp.addTablet(t4);
		gsp.sortStore();
	}//END MAIN

}//END CORE CLASS
