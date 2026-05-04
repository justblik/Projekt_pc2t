import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class mainik {
	
	static int Osetreni_roku()
	{
		Scanner sc = new Scanner(System.in);
		for(;;)
		{
			System.out.print("Zadejte rok narozeni:");
			if (!sc.hasNextInt()) 
			{
			    System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
			    sc.next();
			}
			
			int rok_narozeni=sc.nextInt();
			if(rok_narozeni<=2026 && rok_narozeni>=1906)
			{
				return rok_narozeni;
			}
			else
			{
				System.out.println("Chyba, zkuste to znovu");
			}
		}
		
	}

	public static void main(String[] args) 
	{
		int menu_vyber;
		int did;

		Scanner sc = new Scanner(System.in);
		Map<Integer, Zamestnanci> mapa_zamestnanci = new HashMap<>();
		
		for(;;)
		{
			System.out.println("------------MENU----------------------------------------------");
			System.out.println("1\tPridani zamestnance");										//DONE
			System.out.println("2\tPridani spoluprace");										//DONE
			System.out.println("3\tOdebrani zamestnance");										//DONE
			System.out.println("4\tVyhledani zamestnance dle ID");								//DONE
			System.out.println("5\tSpusteni dovednosti zamestnance");							//DONE
			System.out.println("6\tAbecedni vypis zamestnancu podle prijmeni ve skupinach");	//DONE
			System.out.println("7\tStatistiky");												//DONE	
			System.out.println("8\tVypis poctu zamestnancu ve skupinach");						//DONE
			System.out.println("9\tUlozeni zamestnance do souboru");							//DONE	
			System.out.println("10\tNacteni zamestnancu ze souboru");							//DONE
			System.out.println("11\tUlozeni vsech dat do SQL databaze po skonceni programu");
			System.out.println("12\tNacteni vsech dat z SQL databaze po spusteni programu");
			System.out.println("13\tKONEC");													//DONE
			System.out.println("--------------------------------------------------------------");
			
			//System.out.println("\nVyberte cislo z nabidky: ");
			for(;;) {
				System.out.println("\nVyberte cislo z nabidky: ");

			    if (!sc.hasNextInt()) {
			        System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
			        sc.next();
			        continue;
			    }

			    menu_vyber = sc.nextInt();
			    break;
			}
			
			/*if (!sc.hasNextInt()) 
			{
			    System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
			    sc.next();
			}
			
			menu_vyber=sc.nextInt();*/
			
			if(menu_vyber<1 || menu_vyber>13)
			{
				System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
				continue;
			}
			
			switch(menu_vyber)
			{
			case 1:		
				int skupina_vyber;
				for(;;) {
					System.out.println("Vyberte skupinu: \n1 Datovi analytici\n2 bezpecnostni specialiste");

				    if (!sc.hasNextInt()) {
				        System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
				        sc.next();
				        continue;
				    }

				    skupina_vyber = sc.nextInt();
				    break;
				}
		
				if(skupina_vyber<1 || skupina_vyber>2){
					System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
					continue;
				}
				
				int maxId = 0;

				for (int id : mapa_zamestnanci.keySet()) {
				    if (id > maxId) {
				        maxId = id;
				    }
				}

				did = maxId + 1;
				
				if(skupina_vyber==1)
				{
					sc.nextLine();
					System.out.print("Zadejte jmeno:");
					String jmeno=sc.nextLine();
					System.out.println();
					System.out.print("Zadejte prijmeni:");
					String prijmeni=sc.nextLine();
					System.out.println();
					int rok_narozeni = Osetreni_roku();
					
					Datovi_analytici clovek = new Datovi_analytici(did,jmeno,prijmeni,rok_narozeni);
					mapa_zamestnanci.put(did, clovek);
					did++;
					
				}
				else
				{
					sc.nextLine();
					System.out.print("Zadejte jmeno:");
					String jmeno=sc.nextLine();
					System.out.println();
					System.out.print("Zadejte prijmeni:");
					String prijmeni=sc.nextLine();
					System.out.println();
					int rok_narozeni = Osetreni_roku();
					
					Bezpecnostni_specialiste clovek2 = new Bezpecnostni_specialiste(did,jmeno,prijmeni,rok_narozeni);
					mapa_zamestnanci.put(did, clovek2);
					did++;
					
				}
				break;
			case 2:
				int uroven_vyber;
				int idZamestnance;
				int idKolegy;
				
				for(;;) {
				    System.out.println("Zadejte ID zamestnance:");

				    if (!sc.hasNextInt()) {
				        System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
				        sc.next();
				        continue;
				    }

				    idZamestnance = sc.nextInt();

				    if (!mapa_zamestnanci.containsKey(idZamestnance)) {
				        System.out.println("ID zamestnance neexistuje");
				        continue;
				    }

				    break;
				}
				
				for(;;) {
				    System.out.println("Zadejte ID kolegy:");

				    if (!sc.hasNextInt()) {
				        System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
				        sc.next();
				        continue;
				    }

				    idKolegy = sc.nextInt();

				    if (!mapa_zamestnanci.containsKey(idKolegy)) {
				        System.out.println("ID kolegy neexistuje");
				        continue;
				    }

				    break;
				}
			
				if(idZamestnance == idKolegy) 
				{
					System.out.println("Zamestnanec nemuze spolupracovat sam se sebou");
					continue;
				}
				
				Zamestnanci zamestnanec = mapa_zamestnanci.get(idZamestnance);
				Zamestnanci kolega = mapa_zamestnanci.get(idKolegy);
				
				Uroven_spoluprace uroven = null;
				
				for(;;) {
					System.out.println("Vyberte uroven spoluprace: \n1 Spatna\n2 Prumerna\n3 Dobra");
					
					if (!sc.hasNextInt()) 
					{
					    System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
					    sc.next();
					    continue;
					}
					
					uroven_vyber = sc.nextInt();
					
					if(uroven_vyber<1 || uroven_vyber>3)
					{
						System.out.println("\nŠpatný vstup, zkuste to znovuX\n\n");
						continue;
					}
				
					switch(uroven_vyber) {
					case 1: uroven = Uroven_spoluprace.SPATNA; break;
					case 2: uroven = Uroven_spoluprace.PRUMERNA; break;
					case 3: uroven = Uroven_spoluprace.DOBRA; break;
					}
					break;					
				}
				
					
				Spoluprace spoluprace1 = new Spoluprace(kolega, uroven);
			    Spoluprace spoluprace2 = new Spoluprace(zamestnanec, uroven);

			    zamestnanec.getSeznam_spolupracovniku().add(spoluprace1);
			    kolega.getSeznam_spolupracovniku().add(spoluprace2);

			    System.out.println("Spoluprace byla pridana");
				break;
			case 3:
				int hledane_id;
				
				for(;;) {
					System.out.println("Zadejte ID zamestnance, ktereho chcete odebrat:");

				    if (!sc.hasNextInt()) {
				        System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
				        sc.next();
				        continue;
				    }

				    hledane_id = sc.nextInt();

				    if (!mapa_zamestnanci.containsKey(hledane_id)) {
				        System.out.println("ID zamestnance neexistuje");
				        continue;
				    }

				    break;
				}
				
				Zamestnanci z = mapa_zamestnanci.get(hledane_id);
				
				for(Zamestnanci ostatniZam : mapa_zamestnanci.values()) {
					for(int i = 0; i < ostatniZam.getSeznam_spolupracovniku().size();i++) {
						Spoluprace spoluprace = ostatniZam.getSeznam_spolupracovniku().get(i);
						
						if(spoluprace.getKolega().getId() == hledane_id) {
							ostatniZam.getSeznam_spolupracovniku().remove(i);
							i--;
						}
					}
				}
				mapa_zamestnanci.remove(hledane_id);
				System.out.println("Zamestnanec "+ z.getPrijmeni() +" odstraněn");
				break;
			case 4:
				
				int hledane_id1;
				for(;;) {
					System.out.println("Zadejte ID zamestnance, ktereho chcete vyhledat:");

				    if (!sc.hasNextInt()) {
				        System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
				        sc.next();
				        continue;
				    }

				    hledane_id1 = sc.nextInt();

				    if (!mapa_zamestnanci.containsKey(hledane_id1)) {
				        System.out.println("ID zamestnance neexistuje");
				        continue;
				    }

				    break;
				}
				
				Zamestnanci zam = mapa_zamestnanci.get(hledane_id1);
				
				if(zam != null)
				{
					System.out.println(zam.getJmeno()+ " " +zam.getPrijmeni());
				}
				else
				{
					System.out.println("Zamestnanec s tímto ID neexistuje");
				}
				
				break;
			case 5:
				int hledane_Id;
				
				for(;;) {
					System.out.println("Zadejte ID zamestnance, ktereho chcete spustit dovednost:");

				    if (!sc.hasNextInt()) {
				        System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
				        sc.next();
				        continue;
				    }

				    hledane_Id = sc.nextInt();

				    if (!mapa_zamestnanci.containsKey(hledane_Id)) {
				        System.out.println("ID zamestnance neexistuje");
				        continue;
				    }

				    break;
				}
				Zamestnanci z1 = mapa_zamestnanci.get(hledane_Id);
				z1.provedDovednost();
				break;
			case 6:
				List<Zamestnanci>seznam_zamestnancu = new ArrayList<>();
				
				System.out.println("Datovi analytici____________________");
				
				for (Map.Entry<Integer, Zamestnanci> entry : mapa_zamestnanci.entrySet()) 
				{
				    Zamestnanci za = entry.getValue();

				    if (za instanceof Datovi_analytici) 
				    {
				    	seznam_zamestnancu.add(za);				        
				    }
				}
				
				seznam_zamestnancu.sort(Comparator.comparing(Zamestnanci::getPrijmeni));
				
				for(Zamestnanci s : seznam_zamestnancu)
				{
					System.out.println("[" + s.getId() + "]" + ": " + s.getPrijmeni() + " " + s.getJmeno() + " " + s.getRok_narozeni());
				}
				
				seznam_zamestnancu.clear();
				
				System.out.println("\n\nBezpečnostní specialisté____________________");
					
				for (Map.Entry<Integer, Zamestnanci> entry : mapa_zamestnanci.entrySet()) 
				{
					Zamestnanci za = entry.getValue();
					if(za instanceof Bezpecnostni_specialiste)
					{
						seznam_zamestnancu.add(za);
					}
				}
				
				seznam_zamestnancu.sort(Comparator.comparing(Zamestnanci::getPrijmeni));
				
				for(Zamestnanci s : seznam_zamestnancu)
				{
					System.out.println("[" + s.getId() + "]" + ": " + s.getPrijmeni() + " " + s.getJmeno() + " " + s.getRok_narozeni());
				}
				seznam_zamestnancu.clear();
				
				break;
			case 7:
				int pocetSpatna = 0;
			    int pocetPrumerna = 0;
			    int pocetDobra = 0;

			    Zamestnanci zamestnanecSNejviceVazbami = null;
			    int nejviceVazeb = -1;
			    
			    for(Zamestnanci za : mapa_zamestnanci.values()) {
			    	int pocetVazeb = za.getSeznam_spolupracovniku().size();
			    	
			    	if(pocetVazeb > nejviceVazeb) {
			    		nejviceVazeb = pocetVazeb;
			    		zamestnanecSNejviceVazbami = za;
			    	}
			    	
			    	for(Spoluprace s : za.getSeznam_spolupracovniku()) {
			    		switch(s.getUroven()) {
			    		case SPATNA: pocetSpatna++; break;
			    		case PRUMERNA: pocetPrumerna++; break;
			    		case DOBRA: pocetDobra++; break;
			    		}
			    	}
			    }
			    
			    if (pocetSpatna == 0 && pocetPrumerna == 0 && pocetDobra == 0) {
			        System.out.println("Zadne spoluprace neexistuji");
			        return;
			    }
			    else {
			    	if (pocetSpatna >= pocetPrumerna && pocetSpatna >= pocetDobra) {
				        System.out.println("Prevazujici kvalita spoluprace je: SPATNA");
				    } else if (pocetPrumerna >= pocetSpatna && pocetPrumerna >= pocetDobra) {
				        System.out.println("Prevazujici kvalita spoluprace je: PRUMERNA");
				    } else {
				        System.out.println("Prevazujici kvalita spoluprace je: DOBRA");
				    }
			    	
			    }
			    
			    
			    if(zamestnanecSNejviceVazbami != null) {
			    	System.out.println("Zamestnanec s nejvice vazbami: " + zamestnanecSNejviceVazbami.getJmeno() + " " + zamestnanecSNejviceVazbami.getPrijmeni() + " - " + nejviceVazeb);
			    }
				break;
			case 8:
				int pocet_datovych_analytiku = 0;
				int pocet_bezpecnostnich_specialistu = 0;
				for (Map.Entry<Integer, Zamestnanci> entry : mapa_zamestnanci.entrySet()) 
				{
				    Zamestnanci za = entry.getValue();
				    if (za instanceof Datovi_analytici) 
				    {
				    	pocet_datovych_analytiku++;				        
				    }
				    if(za instanceof Bezpecnostni_specialiste)
				    {
				    	pocet_bezpecnostnich_specialistu++;
				    }
				    
				}
				
				System.out.println("Datovi analytici: "+pocet_datovych_analytiku);
				System.out.println("Bezpecnostni specialisti: "+pocet_bezpecnostnich_specialistu);
				break;
			case 9:
				int hledane_ID;
				
				for(;;) {
					System.out.println("Zadejte ID zamestnance, ktereho chcete ulozit do souboru:");

				    if (!sc.hasNextInt()) {
				        System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
				        sc.next();
				        continue;
				    }

				    hledane_ID = sc.nextInt();

				    if (!mapa_zamestnanci.containsKey(hledane_ID)) {
				        System.out.println("ID zamestnance neexistuje");
				        continue;
				    }

				    break;
				}
				Zamestnanci z3 = mapa_zamestnanci.get(hledane_ID);
				
				try {
					FileWriter fw = new FileWriter("zamestnanci.txt", true);
					String typ;
					
					if(z3 instanceof Datovi_analytici) {
						typ = "Datový analytik";
					}
					else {
						typ = "Bezpečnostní specialista";
					}
					
					fw.write(z3.getId() + ";" + z3.getJmeno() + ";" + z3.getPrijmeni() + ";" + z3.getRok_narozeni() + ";" + typ + "\n");
					fw.close();
					System.out.println("Zamestnanec byl ulozen do souboru");
				}
				catch(Exception e) {
					System.out.println("Chyba pri ukladani do souboru");
				}
				break;
			case 10:
				try {
					BufferedReader br = new BufferedReader(new FileReader("zamestnanci.txt"));
					String radek;
					
					while((radek = br.readLine()) != null) {
						String[] casti = radek.split(";");

			            int id = Integer.parseInt(casti[0]);
			            String jmeno = casti[1];
			            String prijmeni = casti[2];
			            int rokNarozeni = Integer.parseInt(casti[3]);
			            String typ = casti[4];

			            Zamestnanci zamestnan;
			            
			            if(typ.equals("Datový analytik")) {
			            	zamestnan = new Datovi_analytici(id, jmeno, prijmeni, rokNarozeni);
			            }
			            else {
			            	zamestnan = new Bezpecnostni_specialiste(id, jmeno, prijmeni, rokNarozeni);
			            }
			            mapa_zamestnanci.put(id, zamestnan);
					}
					br.close();
					System.out.println("Soubor byl nacten");
					
					
				}
				catch(Exception e){
					System.out.println("Chyba pri nacitani souboru");
				}
				break;
			case 11:
				Databaze db=new Databaze();
			    if (!db.connect("databaze.db"))
			    {
			    	System.out.println("K databázi se nebylo možné připojit");
			    	return;
			    }
			    
			    for (Zamestnanci zmst : mapa_zamestnanci.values()) {

			        String typ;

			        if (zmst instanceof Datovi_analytici) {
			            typ = "Datový analytik";
			        } else {
			            typ = "Bezpečnostní specialista";
			        }

			        db.ulozeniZamestnance(
			        	zmst.getId(),
			        	zmst.getJmeno(),
			        	zmst.getPrijmeni(),
			        	zmst.getRok_narozeni(),
			            typ
			        );
			    }
			    System.out.println("Ulozeni do databaze probehlo, varovani muzete ignorovat - omezeni kvuli novejsi verzi Java");
			    
			    
			    db.disconnect();
				break;
			case 12:
				Databaze db2=new Databaze();
			    if (!db2.connect("databaze.db"))
			    {
			    	System.out.println("K databázi se nebylo možné připojit");
			    	return;
			    }
			    
			    
			    db2.nacteniZamestnance(mapa_zamestnanci);
			    System.out.println("Nacteni z databaze probehlo, varovani muzete ignorovat - omezeni kvuli novejsi verzi Java");
			    
			    db2.disconnect();
				break;
			}
			
			if(menu_vyber == 13)
			{
				System.out.println("KONEC programu");
				break;
			}
				
			
			
		}
		
		

	}

}
