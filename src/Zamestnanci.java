import java.util.ArrayList;
import java.util.List;

abstract public class Zamestnanci 
{
	protected int id;
	protected String jmeno;
	protected String prijmeni;
	protected int rok_narozeni;
	protected Uroven_spoluprace uroven_spoluprace;
	protected List<Zamestnanci> seznam_spolupracovniku = new ArrayList<Zamestnanci>();
	
	public Zamestnanci(int id,String jmeno,String prijmeni,int rok_narozeni)
	{
		this.id = id;
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.rok_narozeni = rok_narozeni;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getJmeno() 
	{
		return jmeno;
	}

	public void setJmeno(String jmeno) 
	{
		this.jmeno = jmeno;
	}

	public String getPrijmeni() 
	{
		return prijmeni;
	}

	public void setPrijmeni(String prijmeni) 
	{
		this.prijmeni = prijmeni;
	}

	public int getRok_narozeni() 
	{
		return rok_narozeni;
	}

	public void setRok_narozeni(int rok_narozeni) 
	{
		this.rok_narozeni = rok_narozeni;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
