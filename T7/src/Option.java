import java.util.Scanner;
public class Option 
{
	public String text;
	public boolean correct;
	Scanner input = new Scanner(System.in);
	
	public Option (String text, boolean correct)
	{
		this.text=text;
		this.correct=correct;
	}//END BUILDER
	
	public Option (Option other)
	{
		this.text=other.text;
		this.correct=other.correct;
	}//END COPIER
	
	public String getText(Option p)
	{
		return p.text;
	}
	
	public boolean getCorrect(Option p)
	{
		return p.correct;
	}
	
	public void setText(Option p)
	{
		p.text=input.nextLine();
	}
	
	public void setText(Option p, String s)
	{
		p.text=s;
	}
	
	public void setCorrect(Option p, boolean c)
	{
		p.correct=c;
	}
	
}//END OPTION CLASS
