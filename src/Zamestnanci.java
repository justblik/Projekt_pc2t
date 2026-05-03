import java.util.ArrayList;
import java.util.List;

abstract public class Zamestnanci 
{
	protected int id;
	protected String jmeno;
	protected String prijmeni;
	protected int rok_narozeni;
	protected List<Spoluprace> seznam_spolupracovniku = new ArrayList<>();
	
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
	

	public List<Spoluprace> getSeznam_spolupracovniku() 
	{
		return seznam_spolupracovniku;
	}

	public void setSeznam_spolupracovniku(List<Spoluprace> seznam_spolupracovniku) 
	{
		this.seznam_spolupracovniku = seznam_spolupracovniku;
	}
	
	public abstract void provedDovednost();

	
	
	
	
	
	
	
	
	
	
	
	
}
