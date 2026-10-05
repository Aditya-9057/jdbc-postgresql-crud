import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBconnection {
private static final String JDBC_HOST = "localhost";
private static final String JDBC_PORT = "5433";
private static final String JDBC_DB = "postgres";
private static final String JDBC_USERNAME = "postgres";
private static final String JDBC_PASSWORD = "root@123";

    private static final String JDBC_URL = "jdbc:postgresql://" + JDBC_HOST + ":" + JDBC_PORT + "/" + JDBC_DB;
    
    
    static{
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC driver registered successfully!");

            
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Driver not found. Set classpath of Driver. "+cnfe.getMessage());
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        
    }
}
