package energy.uniper.testjava;




public class Person implements IMensch,ISerializable  {
		
	private String myName;
	private String myStrasse;
	private int myHausnummer;
	private long myPlz;
	private String myStadt;
	
	
	
	
	@Override
	public String toString() {
		return "myName=" + myName + ", myStrasse=" + myStrasse + ", myHausnummer=" + myHausnummer + ", myPlz="
				+ myPlz + ", myStadt=" + myStadt;
	}

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
		myStadt = pStadt;
		
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

	@Override
	public boolean fromCsv(String pLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toCsv() {
		// TODO Auto-generated method stub
		return null;
	}


}
