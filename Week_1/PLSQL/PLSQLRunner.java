import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;

public class PLSQLRunner {
    public static void main(String[] args) {
        
        // Oracle connection strings usually look like this:
        String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
        String user = "system";
        String password = "7012675718";

        // Your PL/SQL Block wrapped in standard formatting
        String plsqlBlock = 
            "DECLARE " +
            "   a INTEGER := 10; " +
            "   b INTEGER := 20; " +
            "   c INTEGER; " +
            "BEGIN " +
            "   c := a + b; " +
            "   DBMS_OUTPUT.PUT_LINE('Sum is: ' || c); " +
            "END;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             CallableStatement stmt = conn.prepareCall(plsqlBlock)) {

            // Execute the PL/SQL block
            stmt.execute();
            System.out.println("PL/SQL Block executed successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}