/**
 * 
 */
package energy.uniper.testjava;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import energy.uniper.testjava.db.StudentController;

/**
 * @author T25551
 *
 */
public class HelloWorld {
	
	
	
	   public void storeStudents() {
         StudentController c = new StudentController();
         
         Student stud = new Student("Gunther","Hundegasse 12","9374563847");
         stud.setStadt("Entenhausen");
         stud.setPlz(41687);
		   
         try {
			c.storeStudent( stud );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	
	
	   public void loadStudents() {
		   
         StudentController c = new StudentController();
         
         Student stud = new Student("Daisy","Hundegasse 9","9374563846");
         stud.setStadt("Entenhausen");
         stud.setPlz(41687);
                  
         
         try {
			List<Student> list = c.getAllStudents();
			
			System.out.println( "Students:" );
			for ( Student s : list) {
				System.out.println( s );
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }

	   
	   
	   
	   
	   public static void main(String[] args){
		   
		   
		 HelloWorld app = new HelloWorld();
		 app.loadStudents();
		 
		 if ( true )
		   return;
		 
		 
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
	     
	    
	   }

	    private void helloWorld( String[] args ) {
	      System.out.println("Hello World :"+ args[0] );
	    }
}






