
public class Question 
{
	private int id;
	private String title;
	private boolean mandatory;
	
	/*BUILDER & COPIER*/
	public Question (int id, String title, boolean mandatory)
	{
		this.mandatory=mandatory;
		this.title=title;
		setID(id);
	}//END QUESTION BUILDER
	
	public Question (Question other)
	{
		mandatory=other.mandatory;
		title=other.title;
		id=other.id;
	}//END QUESTION COPIER
	
	
	/*SETTERS*/
	private void setID (int id)
	{
		if (id>0)
			this.id=id;
		else
			System.out.println("invalid ID, must be positive integer");
	}//END ID SETTER
	
	/*GETTERS*/
	public int getID (Question q)
	{
		return q.id;
	}
	public String getTitle (Question q)
	{
		return q.title;
	}
	
	/*OTHER*/
	public void print ()
	{
		System.out.println("id. "+id+"\ntitle: "+title+"\nmandatory: "+mandatory);
	}//END PRINT
	
}//END QUESTION CLASS
