package energy.uniper.testjava;




public class Person implements IMensch,ISerializable  {
		
	private String myName;
	private String myStrasse;
	private int myHausnummer;
	private long myPlz;
	private String myStadt;
	
	
	
	
	public Person() {
		myName = "";
		myStrasse = "";
		myStadt = "";
	}
	
	public  Person(String pName, String strasse ) {
		myName = pName;
		myStrasse = strasse;			
	}

	public  Person(String pName, String pStrasse,int pHausnummer,long pPlz,String pStadt ) {
		myName = pName;
		myStrasse = pStrasse;			
		myHausnummer = pHausnummer;
		myPlz = pPlz;
		
	}	
	
	
	
	public String toCsv() {
		return myName+","+myStrasse+","+myStadt;
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
		
		buf.append("name    : "+myName+"\r\n" );
		buf.append("strasse : "+myStrasse+"\r\n" );
		
		return buf.toString();
	}
	
	public void store() { 
	
	}
	
	
	public void load() {
		
	}
	
	
	
	public String getName() {
		return myName;
	}
	public void setName(String pName) {
		
		if ( pName != null ) {
		  myName = pName;
		}
		
	}

	public String getStrasse() {
		return myStrasse;
	}

	public void setStrasse(String strasse) {
		myStrasse = strasse;
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
		return myPlz;
	}

	public void setPlz(long plz) {
		myPlz = plz;
	}

	public String getStadt() {
		return myStadt;
	}

	public void setStadt(String stadt) {
		myStadt = stadt;
	}

	@Override
	public String getNameAndStreet() {
		return "Person : "+myName+" "+myStrasse;
	}


}
