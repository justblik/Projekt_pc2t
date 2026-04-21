import java.util.List;

public class Datovi_analytici extends Zamestnanci
{

	public Datovi_analytici(int id,String jmeno, String prijmeni, int rok_narozeni/*,Uroven_spoluprace uroven_spoluprace,List<Zamestnanci> seznam_spolupracovniku*/) 
	{
		super(id, jmeno, prijmeni, rok_narozeni/*, uroven_spoluprace,seznam_spolupracovniku*/);
	}
	
	public void S_kym_mam_nejvic_spolecnych_spolupracovniku()
	{
		
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
	
	public Uroven_spoluprace getUroven_spoluprace() 
	{
		return uroven_spoluprace;
	}

	public void setUroven_spoluprace(Uroven_spoluprace uroven_spoluprace) 
	{
		this.uroven_spoluprace = uroven_spoluprace;
	}

	public List<Zamestnanci> getSeznam_spolupracovniku() 
	{
		return seznam_spolupracovniku;
	}

	public void setSeznam_spolupracovniku(List<Zamestnanci> seznam_spolupracovniku) 
	{
		this.seznam_spolupracovniku = seznam_spolupracovniku;
	}
	
	
	

}
