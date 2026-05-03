

public class Datovi_analytici extends Zamestnanci
{

	public Datovi_analytici(int id,String jmeno, String prijmeni, int rok_narozeni) 
	{
		super(id, jmeno, prijmeni, rok_narozeni);
	}
	
	@Override
	public void provedDovednost() {
		int pocetSpolecnych = -1;
		Zamestnanci kolegaSNejvyssimPoctem = null;
		
		for(Spoluprace s1 : seznam_spolupracovniku) {
			Zamestnanci kolega = s1.getKolega();
			int aktualniPocetSpolecnych = 0;
			
			for(Spoluprace s2 : seznam_spolupracovniku) {
				for(Spoluprace s3 : kolega.getSeznam_spolupracovniku()) {
					
					if(s2.getKolega() == s3.getKolega()) {
						if(s2.getKolega() != kolega && s2.getKolega() != this) {
							aktualniPocetSpolecnych++;
						}
					}
				}
			}
			if(aktualniPocetSpolecnych > pocetSpolecnych) {
	            pocetSpolecnych = aktualniPocetSpolecnych;
	            kolegaSNejvyssimPoctem = kolega;
	        }
		}
		if(kolegaSNejvyssimPoctem != null) {
	        System.out.println("Nejvice spolecnych spolupracovniku ma s: " + kolegaSNejvyssimPoctem.getJmeno() + " " + kolegaSNejvyssimPoctem.getPrijmeni() + " (" + pocetSpolecnych + ")");
	    } 
		else {
	        System.out.println("Nema zadne spolupracovniky");
	    }
	}
}
