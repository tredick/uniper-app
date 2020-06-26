package energy.uniper.testjava;

public class Student extends Person {

	private String matrikelNummer;
	
	public String getMatrikelNummer() {
		return matrikelNummer;
	}


	public void setMatrikelNummer(String matrikelNummer) {
		this.matrikelNummer = matrikelNummer;
	}


	public Student(String pName,String pStrasse, String pMatrikelnummer) {
	  super( pName, pStrasse );
	  
	  
	  setStrasse( "S:"+getStrasse() );
	  
	  matrikelNummer = pMatrikelnummer;
	}
	
	
	public String toString() {
		
		return super.toString() + "matr.nr. :"+matrikelNummer+"\r\n";
		
	}
	
}


