package energy.uniper.testjava.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BasicDbController {

	Connection myConnection = null;
	
	
	public BasicDbController( Connection pConnection ) {
		myConnection = pConnection;
	}
	
	public void close()  {
		try {
			if ( myConnection != null && !myConnection.isClosed() ) {
				myConnection.close();
				myConnection = null;
			}
		}
		catch ( SQLException  e) {
			System.err.println("SQLError: "+e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	

	/**
	 * Reads the Db connectivity details from a property file in "./"+pConfigFile+".properties"
	 * @param pConfigFile The name of the property files in the start directory of the application
	 * @return an open connection or null if an error occured
	 */
	public static Connection getConnection(String pConfigFile)   {
		
		String driverClass = null;
		String jdbcurl = null;
		String user = null;
		String pass = null;			
		
		try (InputStream input = new FileInputStream( pConfigFile+".properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
    		driverClass = prop.getProperty("db.driverClass");
    		jdbcurl = prop.getProperty("db.jdbcurl");
    		user = prop.getProperty("db.user");
    		pass = prop.getProperty("db.pass");
    		
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
		
		
        // now let's open the connection
        Connection connection = null;

		try {
			// check if the driver class can be loaded
			Class.forName( driverClass );
			
			// now open the connection
	        if ( user != null && pass != null )        
	        	connection = DriverManager.getConnection(jdbcurl, user, pass);
	        else
	            connection = DriverManager.getConnection(jdbcurl);

	        
		} catch (ClassNotFoundException e) {
			System.err.println("Error : couldn't find driver class "+driverClass);
			return null;
		}
		catch ( SQLException  e) {
			System.err.println("SQLError during login : "+e.getMessage());
			e.printStackTrace();
			return null;			
		}
        
                       
        return connection;		
	}

	
	
	
}
