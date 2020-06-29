/**
 * 
 */
package energy.uniper.testjava;

import java.util.ArrayList;

/**
 * @author T25551
 *
 */
public class HelloWorld {

	   public static void main(String[] args){
		   
         // HelloWorld app = new HelloWorld ();
	     // app.helloWorld( args );
		   		 
		 ArrayList<IMensch> arr2 = new ArrayList<IMensch>(); 
	     
	     Person a = new Person("Donald Duck","Entenweg 5");	     	    
	     Person b = new Person("Mickey Mouse","Mäuseallee 28");	     
	     Student c = new Student("Goofy","Hundegasse 9","9374563845");
	     Lehrer  d = new Lehrer("Daisy Duck","Entenweg 7","Deutsch, Mathe");
	     
	     Wasserwerk e = new Wasserwerk();
	     e.setName("Wasserwerk Neuss");
	     e.setStrasse("Am Bach 5");
	     
	     
	     arr2.add( a );
	     arr2.add( b );
	     arr2.add( c );
	     arr2.add( d );
	     arr2.add( e );
	    	     

	     /*
	     System.out.println("a : "+a.toString());
	     System.out.println("b : "+b.toString());
	     System.out.println("c : "+c.toString());
	     System.out.println("d : "+d.toString());
		 
	     Person x = a;
	     System.out.println("x : "+x.toString());
	     x.setName( "Gustav Ganz");
	     
	     System.out.println("x : "+x.toString());
	     System.out.println("a : "+a.toString());
	     */
	     
	     System.out.println("------------");
	     
	     System.out.println("Length :"+arr2.size() );
	     System.out.println("");
	     
	     for ( IMensch elem : arr2 ) {
	    	 System.out.println( elem.getNameAndStreet() );	    	 
	     }
	     
	     /*
	     for ( int i=0; i<arr.length ; i++ ) { 
	       System.out.println( arr[ i ] );
	     }
	     */
	    
	   }

	    private void helloWorld( String[] args ) {
	      System.out.println("Hello World :"+ args[0] );
	    }
}






