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

public class StudentController {

	
	
	private Connection getConnection() throws SQLException {
		String driverClass = "oracle.jdbc.driver.OracleDriver";
		String jdbcurl = "jdbc:oracle:thin:@(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = 10.55.2.100)(PORT = 1521))  (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = ULERP) ) )";
		String user = "TABLEAU_USER";
		String pass = "9q-zYSv3aHmGThLoaHbq";
		
		try {
			Class.forName( driverClass );
		} catch (ClassNotFoundException e) {
			System.err.println("Error : couldn't find driver class "+driverClass);
			return null;
		}
        
        Connection connection = null;
        if ( user != null && pass != null )        
        	connection = DriverManager.getConnection(jdbcurl, user, pass);
        else
            connection = DriverManager.getConnection(jdbcurl);
                       
        return connection;		
	}
	
	
	
	
	
	
	public boolean storeStudent( Student pStudent ) throws SQLException {
		if ( pStudent == null )
			return false;
		
		Connection con = this.getConnection();
		
		if ( con == null )
			return false;
				
		String sql = "INSERT INTO SB_BAU.tj_student (matrikelnummer,name,strasse,hausnummer,plz,stadt) " +
                     "VALUES (?,?,?,?,?,?)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setString(1, pStudent.getMatrikelNummer());
		stmt.setString(2, pStudent.getName());
		stmt.setString(3, pStudent.getStrasse());
		stmt.setInt(4, pStudent.getHausnummer());
		stmt.setLong(5, pStudent.getPlz());
		stmt.setString(6, pStudent.getStadt());
		
		boolean ok = stmt.execute();		
		
		con.close();
		
		return ok;
	}
	
	
	public List<Student> getAllStudents( ) throws SQLException {
		
		ArrayList<Student> retList = new ArrayList<Student>();
				
		Connection con = this.getConnection();
		if ( con != null ) {
			
			String sql = "SELECT matrikelnummer,name,strasse,hausnummer,plz,stadt FROM sb_bau.tj_student";
			PreparedStatement stmt = con.prepareStatement( sql );
			
			ResultSet rs = stmt.executeQuery();
			
			Student stud = null;
			while( rs.next() ) {
				
				// new Student object requires only name, strasse and matrikelnummer in constructor 
				stud = new Student( rs.getString("name"),rs.getString("strasse"),rs.getString("matrikelnummer") );
				stud.setHausnummer( rs.getInt("hausnummer") );
				stud.setPlz( rs.getLong("plz") );
				stud.setStadt( rs.getString("stadt") );

				// now add this student object to our list to return later 
				retList.add( stud ); 
			}
						
			rs.close();
			stmt.close();
			
			con.close();	
		}
		
		
		return retList;
		
	}
	
}
