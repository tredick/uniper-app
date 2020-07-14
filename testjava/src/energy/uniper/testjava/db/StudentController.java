package energy.uniper.testjava.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import energy.uniper.testjava.Student;

public class StudentController extends BasicDbController 
{

	public StudentController() {
		super(null);
	}

	
	public StudentController(Connection pConnection) {
		super(pConnection);
	}

	
	/**
	 * This version of storeStudent allows to reuse a connection being opened somewhere else 
	 * @param pConnection
	 * @param pStudent
	 * @return true in case of success
	 * @throws SQLException
	 */
	public boolean storeStudent( Connection pConnection, Student pStudent )  {
		
		boolean ok = false;
		
		try { 
			if ( pStudent == null )
				return false;
					
			if ( pConnection == null )
				return false;
					
			String sql = "INSERT INTO SB_BAU.tj_student (matrikelnummer,name,strasse,hausnummer,plz,stadt) " +
	                     "VALUES (?,?,?,?,?,?)";
			
			PreparedStatement stmt = pConnection.prepareStatement(sql);
			
			stmt.setString(1, pStudent.getMatrikelNummer());
			stmt.setString(2, pStudent.getName());
			stmt.setString(3, pStudent.getStrasse());
			stmt.setInt(4, pStudent.getHausnummer());
			stmt.setLong(5, pStudent.getPlz());
			stmt.setString(6, pStudent.getStadt());
			
			stmt.execute();
			
			ok = true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
				
		return ok;
	}
	

	/**
	 * StoreStudent using the member connection variable
	 * @param pStudent
	 * @return
	 * @throws SQLException
	 */
	public boolean storeStudent( Student pStudent )  {
		
		return storeStudent( myConnection, pStudent);
		
	}
	
	
	
	/**
	 * This version uses the connection stored in the member variable myConnection
	 * @return
	 * @throws SQLException
	 */
	public List<Student> getAllStudents() throws SQLException {
		return getAllStudents( myConnection );
	}
		
	
	/**
	 * Get all students in the DB
	 * @return
	 * @throws SQLException
	 */
	public List<Student> getAllStudents( Connection pConnection ) throws SQLException {
		
		ArrayList<Student> retList = new ArrayList<Student>();
		
		// no connection ? Then return an empty list
		if ( pConnection == null )
			return retList;
				
		if ( pConnection != null ) {
			
			String sql = "SELECT matrikelnummer,name,strasse,hausnummer,plz,stadt FROM sb_bau.tj_student";
			PreparedStatement stmt = pConnection.prepareStatement( sql );
			
			ResultSet rs = stmt.executeQuery();
			
			Student stud = null;
			while( rs.next() ) {
				
				// new Student object requires only name, strasse and matrikelnummer in constructor 
				stud = new Student( rs.getString("name"),
						           rs.getString("strasse"),
						           rs.getInt("hausnummer"),
						           rs.getLong("plz"),
						           rs.getString("stadt"),
						           rs.getString("matrikelnummer") );

				// now add this student object to our list to return later 
				retList.add( stud ); 
			}
						
			rs.close();
			stmt.close();
			
		}
				
		return retList;
		
	}
	
}
