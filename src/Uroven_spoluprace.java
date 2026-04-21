
public enum Uroven_spoluprace {
	
	SPATNA("špatná"),
	PRUMERNA("průměrná"),
	DOBRA("dobrá");
	
	private final String typ;
		
	Uroven_spoluprace(String typ)
	{
		this.typ=typ;
	}
		
	public String getTyp(String typ)
	{
		return typ;
	}
		
		
	


}
