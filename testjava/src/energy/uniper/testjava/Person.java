package energy.uniper.testjava;




public class Person implements IMensch,ISerializable  {
		
	private String name;
	private String strasse;
	private int myHausnummer;
	private long plz;
	private String stadt;
	
	
	
	
	public Person() {
		name = "";
		strasse = "";
		stadt = "";
	}
	
	public  Person(String pName, String strasse ) {
		name = pName;
		this.strasse = strasse;			
	}
	public  Person(String pName, String pStrasse,int pHausnummer ) {
		name = pName;
		strasse = pStrasse;			
		myHausnummer = pHausnummer;
	}	
	
	
	public String toCsv() {
		return name+","+strasse+","+stadt;
	}
	
	
	public boolean fromCsv(String pLine) {
		
		// Zur Sicherheit
		if ( pLine == null || pLine.strip().length() == 0 ) {
			this.setName( null );
			this.setStrasse(null );
			this.setStadt(null );
			
			return false;
		}
		
		String[] parts = pLine.split(",");
		this.setName(parts[0]);
		this.setStrasse(parts[1]);
		this.setStadt(parts[2]);
		
		return true;
	}
		
	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		buf.append("name    : "+name+"\r\n" );
		buf.append("strasse : "+strasse+"\r\n" );
		
		return buf.toString();
	}
	
	public void store() { 
	
	}
	
	
	public void load() {
		
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String pName) {
		
		if ( pName != null ) {
		  name = pName;
		}
		
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public int getHausnummer() {
		return myHausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.myHausnummer = hausnummer;
	}
	
	public void setHausnummer(String hausnummer) {
		this.myHausnummer = Integer.parseInt( hausnummer );
	}

	public long getPlz() {
		return plz;
	}

	public void setPlz(long plz) {
		this.plz = plz;
	}

	public String getStadt() {
		return stadt;
	}

	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	@Override
	public String getNameAndStreet() {
		return "Person : "+name+" "+strasse;
	}


}
