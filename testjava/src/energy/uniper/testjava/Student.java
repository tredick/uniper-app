package energy.uniper.testjava;

public class Student extends Person {

	private String myMatrikelNummer;
	
	
	

	/**
	 * Constructor to set all fields-
	 * @param pName Name of the Studen
	 * @param pStrasse Street of the location where Student lives
	 * @param pHausnummer Number in the street
	 * @param pPlz postal code
	 * @param pStadt City where Student lives
	 * @param pMatrikelnummer number of the student at the University
	 */
	public Student(String pName, String pStrasse,int pHausnummer,long pPlz,String pStadt, String pMatrikelnummer) {

		  // first use the parent constructor
		  super( pName, pStrasse, pHausnummer, pPlz, pStadt ); 
		  
		  // then add the additional field
		  myMatrikelNummer = pMatrikelnummer; 
	}

	
	
	
	public String getMatrikelNummer() {
		return myMatrikelNummer;
	}


	public void setMatrikelNummer(String matrikelNummer) {
		myMatrikelNummer = matrikelNummer;
	}
	
	
	public String toString() {
		
		return super.toString() + "matr.nr. :"+myMatrikelNummer+"\r\n";
		
	}
	
}


