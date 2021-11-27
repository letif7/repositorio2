package py.una.bd;
//leticia ferreira
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bd {

    private static final String url = "jdbc:postgresql://localhost:5432/sd";
    private static final String user = "postgres";
    private static final String password = "12345";
 
    /**
     * @return objeto Connection 
     */
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    

}
