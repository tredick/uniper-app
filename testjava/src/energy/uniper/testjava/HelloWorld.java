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
	
	
	
	   /**
	    * Example how to store data
	    */
	   public void storeStudents() {
         StudentController c = new StudentController();
         
         Student stud = new Student("Gunther","Hundegasse",12,12674,"Entenhausen","9374563847");
         stud.setStadt("Entenhausen");
         stud.setPlz(41687);
		   
		 c.storeStudent( stud );
	   }
	
	
	   
	   /**
	    * Example of how to query data
	    */
	   public void loadStudents() {
		   
         StudentController c = new StudentController( StudentController.getConnection( "config") );         
         
         try {
        	 
        	// get all students
			List<Student> list = c.getAllStudents();
			
			// simply print them
			System.out.println( "Students:" );
			for ( Student s : list) {
				System.out.println( s );
			}
			
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
         
          // close the connection stored inside the StudentController
          c.close();
	   }

	   
	   
	   
	   
	   /**
	    * Main method to start our application
	    * 
	    * @param args
	    */
	   public static void main(String[] args){
		   
		   
		 HelloWorld app = new HelloWorld();
		 app.loadStudents();
		 
		 Student stud = new Student("Alfred Nobel","Nobel Allee",56,43636,"Woauchimmerhausen","9374563850");
		 StudentController c = new StudentController( StudentController.getConnection( "config") );
		 
		 if ( c.storeStudent( stud ) ) 
			 System.out.println("Student hinzugefügt !");			 
		 else
			 System.out.println("Student NICHT hinzugefügt !");
		 
		 c.close();
		 
		 app.loadStudents();
		 
	    
	   }

}






