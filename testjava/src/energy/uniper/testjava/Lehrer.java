package energy.uniper.testjava;

public class Lehrer extends Person {

	private String myFaecher = "";
	
	public Lehrer(String pName, String pStrasse, String pFaecher) {
		super(pName, pStrasse);
		
		myFaecher = pFaecher;
		
	}

	public String getFaecher() {
		return myFaecher;
	}

	public void setFaecher(String myFaecher) {
		this.myFaecher = myFaecher;
	}

	@Override
	public String toString() {
		return super.toString()+", myFaecher=" + myFaecher;
	}
	
	
}
