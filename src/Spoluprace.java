
public class Spoluprace {
	
	private Zamestnanci kolega;
	private Uroven_spoluprace uroven;
	
	public Spoluprace(Zamestnanci kolega, Uroven_spoluprace uroven) {
		this.kolega = kolega;
		this.uroven = uroven;
	}

	public Zamestnanci getKolega() {
		return kolega;
	}

	public Uroven_spoluprace getUroven() {
		return uroven;
	}
	
	@Override
    public String toString() {
        return kolega.getJmeno() + " " + kolega.getPrijmeni() + " - " + uroven;
    }

}
