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
		int did=0;
		int i=0;
		Scanner sc = new Scanner(System.in);
		Map<Integer, Zamestnanci> mapa_zamestnanci = new HashMap<>();
		
		for(;;)
		{
			System.out.println("------------MENU----------------------------------------------");
			System.out.println("1\tPridani zamestnance");										//DONE
			System.out.println("2\tPridani spoluprace");
			System.out.println("3\tOdebrani zamestnance");										//DONE
			System.out.println("4\tVyhledani zamestnance dle ID");								//DONE
			System.out.println("5\tSpusteni dovednosti zamestnance");
			System.out.println("6\tAbecedni vypis zamestnancu podle prijmeni ve skupinach");	//DONE
			System.out.println("7\tStatistiky");
			System.out.println("8\tVypis poctu zamestnancu ve skupinach");						//DONE
			System.out.println("9\tUlozeni zamestnance do souboru");
			System.out.println("10\tNacteni zamestnance ze souboru");
			System.out.println("11\tUlozeni vsech dat do SQL databaze po skonceni programu");
			System.out.println("12\tNacteni vsech dat z SQL databaze po spusteni programu");
			System.out.println("13\tKONEC");													//DONE
			System.out.println("--------------------------------------------------------------");
			
			System.out.println("\nVyberte cislo z nabidky: ");
			
			if (!sc.hasNextInt()) 
			{
			    System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
			    sc.next();
			}
			
			menu_vyber=sc.nextInt();
			
			if(menu_vyber<1 || menu_vyber>13)
			{
				System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
				continue;
			}
			
			switch(menu_vyber)
			{
			case 1:		
				int skupina_vyber;
				for(;;)
				{
					System.out.println("Vyberte skupinu: \n1 Datovi analytici\n2 bezpecnostni specialiste");
					if (!sc.hasNextInt()) 
					{
					    System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
					    sc.next();
					}
					skupina_vyber=sc.nextInt();
					
					if(skupina_vyber<1 || skupina_vyber>2)
					{
						System.out.println("\nŠpatný vstup, zkuste to znovu\n\n");
						continue;
					}
					else
					{
						break;
					}
				}
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
			case 2:break;
			case 3:
				System.out.println("Zadejte ID zamestnance, ktereho chcete odebrat:");
				int hledane_id = sc.nextInt();
				Zamestnanci z = mapa_zamestnanci.get(hledane_id);
				if(mapa_zamestnanci.containsKey(hledane_id))
				{
					mapa_zamestnanci.remove(hledane_id);
					System.out.println("Zamestnanec "+ z.getPrijmeni() +" odstraněn");
				}
				else
				{
					System.out.println("Zamestnanec s id: "+ hledane_id + " neexistuje");
				}
				
				
				
				break;
			case 4:
				System.out.println("Zadejte ID zamestnance, ktereho chcete vyhledat:");
				hledane_id = sc.nextInt();
				
				Zamestnanci zam = mapa_zamestnanci.get(hledane_id);
				
				if(zam != null)
				{
					System.out.println(zam.getJmeno()+ " " +zam.getPrijmeni());
				}
				else
				{
					System.out.println("Zamestnanec s tímto ID neexistuje");
				}
				
				break;
			case 5:break;
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
					System.out.println(s.getId() + ": " + s.getPrijmeni() + " " + s.getJmeno() + " " + s.getRok_narozeni());
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
					System.out.println(s.getId() + ": " + s.getPrijmeni() + " " + s.getJmeno() + " " + s.getRok_narozeni());
				}
				seznam_zamestnancu.clear();
				
				break;
			case 7:break;
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
			case 9:break;
			case 10:break;
			case 11:break;
			case 12:break;
			}
			
			if(menu_vyber == 13)
			{
				System.out.println("KONEC programu");
				break;
			}
				
			
			
		}
		
		

	}

}
