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
		int id=0;
		Scanner sc = new Scanner(System.in);
		
		for(;;)
		{
			System.out.println("------------MENU----------------------------------------------");
			System.out.println("1\tPridani zamestnance");
			System.out.println("2\tPridani spoluprace");
			System.out.println("3\tOdebrani zamestnance");
			System.out.println("4\tVyhledani zamestnance dle ID");
			System.out.println("5\tSpusteni dovednosti zamestnance");
			System.out.println("6\tAbecedni vypis zamestnancu podle prijmeni ve skupinach");
			System.out.println("7\tStatistiky");
			System.out.println("8\tVypis poctu zamestnancu ve skupinach");
			System.out.println("9\tUlozeni zamestnance do souboru");
			System.out.println("10\tNacteni zamestnance ze souboru");
			System.out.println("11\tUlozeni vsech dat do SQL databaze po skonceni programu");
			System.out.println("12\tNacteni vsech dat z SQL databaze po spusteni programu");
			System.out.println("13\tKONEC");
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
			case 1:			//třeba dodělat ukládání?
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
						
					Datovi_analytici clovek = new Datovi_analytici(id,jmeno,prijmeni,rok_narozeni);
				}
				else
				{
					System.out.print("Zadejte jmeno:");
					String jmeno=sc.nextLine();
					System.out.println();
					System.out.print("Zadejte prijmeni:");
					String prijmeni=sc.nextLine();
					System.out.println();
					int rok_narozeni = Osetreni_roku();
						
					Bezpecnostni_specialiste clovek = new Bezpecnostni_specialiste(id,jmeno,prijmeni,rok_narozeni);
				}
				break;
			case 2:break;
			case 3:break;
			case 4:break;
			case 5:break;
			case 6:break;
			case 7:break;
			case 8:break;
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
