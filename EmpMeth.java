package Mypack;


class InvalidNumberException extends Exception{
	public InvalidNumberException (String s)
	{
		super(s);
	} 
}
class InvalidGradeException extends Exception{
	public InvalidGradeException (String s)
	{
		super(s);
	}
}
class InvalidWorkingHoursException extends Exception{
	public InvalidWorkingHoursException (String s)
	{
		super(s);
	}
}
public interface EmpMeth
{
	public void Add();
	public void Mod();
	public void Del();
}