
package Sanjeevani.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection
{
    private static Connection conn=null;
    static
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.out.println("driver loaded successfully");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        try
        {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//LAPTOP-18I8UDE4:1521/XE","appproject","java");
            System.out.println("connection open successfully");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }

    public static void closeConnection()
    {
        if (conn!=null)
        {
            try
            {
                conn.close();
                System.out.println("conn close successfully");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
