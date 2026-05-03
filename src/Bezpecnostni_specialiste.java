

public class Bezpecnostni_specialiste extends Zamestnanci
{

	public Bezpecnostni_specialiste(int id,String jmeno, String prijmeni, int rok_narozeni) 
	{
		super(id,jmeno, prijmeni, rok_narozeni);
		
	}
	
	@Override
	public void provedDovednost() {
		int pocetSpolupraci = seznam_spolupracovniku.size();
		double suma = 0;
		
		for(Spoluprace s : seznam_spolupracovniku) {
			switch(s.getUroven()) {
			case SPATNA: suma += 3; break;
			case PRUMERNA: suma += 2; break;
			case DOBRA: suma += 1; break;
			
			}
		}
		double prumer = pocetSpolupraci == 0 ? 0 : suma / pocetSpolupraci;
		double rizikoSpoluprace = pocetSpolupraci * prumer;
		
		
		if (rizikoSpoluprace < 5) {
	        System.out.println("[" + this.getJmeno() + " " + this.getPrijmeni() + "]:" + "Rizikove skore je: " + rizikoSpoluprace + " --> Nizke riziko");
	    } else if (rizikoSpoluprace < 15) {
	    	System.out.println("[" + this.getJmeno() + " " + this.getPrijmeni() + "]:" + "Rizikove skore je: " + rizikoSpoluprace + " --> Stredni riziko");
	    } else {
	    	System.out.println("[" + this.getJmeno() + " " + this.getPrijmeni() + "]:" + "Rizikove skore je: " + rizikoSpoluprace + " --> Vysoke riziko");
	    }
	}
	
	
	
	

}
