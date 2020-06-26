package energy.uniper.testjava;

public class Wasserwerk implements IMensch {
	private String name;
	private String strasse;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	@Override
	public String getNameAndStreet() {
		return "Wasserwerk : "+name+" "+strasse; 
	}
	
	
}
