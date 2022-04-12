
public class OpenQuestion extends Question
{
	public boolean singleLine;
	
	
	/*BUILDER & COPIER*/
	public OpenQuestion(int id, String title, boolean mandatory, boolean singleLine)
	{
		super(id, title, mandatory);
		this.singleLine=singleLine;
	}//END OPEN QUESTION BUILDER
	
	public OpenQuestion(OpenQuestion other)
	{
		super(other);
		this.singleLine=other.singleLine;
	}//END OPEN QUESTION COPIER
	
	@Override
	public void print()
	{
		System.out.println("Open question:");
		super.print();
		System.out.println("is single line? "+singleLine);
	}//END PRINT
	
}//END OPEN QUESTION CLASS
