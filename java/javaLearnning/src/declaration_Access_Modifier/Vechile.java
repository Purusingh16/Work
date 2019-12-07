package declaration_Access_Modifier;

abstract class Vechile 
{
	abstract public int get_No_Of_Wheels();
}
class bus extends Vechile
{
	public int get_No_Of_Wheels()
	{
		return 7;
	}
}
