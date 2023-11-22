import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@https://www.oracle.com/ca-en/database/sqldeveloper/:1521:SQLD",
                    "userName", "Password");
            System.out.println("DB connected successfully");
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM EMP");

            while(rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString(2));
            }

        }
        catch(ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
}