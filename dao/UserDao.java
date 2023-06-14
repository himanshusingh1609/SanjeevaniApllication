
package Sanjeevani.dao;

import Sanjeevani.dbutil.DBConnection;
import Sanjeevani.pojo.UserPojo;
import Sanjeevani.pojo.UsersPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao 
{
    public static String validateUser(UserPojo user) throws SQLException{
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("Select user_name from users where login_id=? and password=? and user_type=?");
         ps.setString(1, user.getLoginId());
         ps.setString(2,user.getPassword());
         ps.setString(3, user.getUserType());//toLowerCase()
         ResultSet rs=ps.executeQuery();
         String name=null;
         if(rs.next())
         {
             name=rs.getString("user_name");
         }
         return name;
    }
    public static void updateName(String currName,String newName)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update users set user_name=? where user_name=?");
     ps.setString(1, newName);
     ps.setString(2, currName);
     ps.executeUpdate();
}
    
    //delete emp
    public static void deleteUser(String name)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Delete From USERS where user_name =?");
        ps.setString(1, name);
        ps.executeUpdate();
    }
    
    
    public static boolean addUser (UsersPojo doc) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into users values(?,?,?,?) ");
        ps.setString(1,doc.getLoginId());
        ps.setString(2,doc.getUserName() );
        ps.setString(3,doc.getPassword() );
        ps.setString(4,doc.getUserType());
        return ps.executeUpdate()==1;
    
    }
    
    public static void deleteUserByName(String name)throws SQLException
    {
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("delete from users where user_name=?");
     ps.setString(1, name);
     ps.executeUpdate();
    }
    
    public static boolean updateUser(UsersPojo user , String prevName)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE USERS SET USER_NAME = ? , LOGIN_ID = ? , PASSWORD = ? WHERE USER_NAME = ?");
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getLoginId());
        ps.setString(3, user.getPassword());
        ps.setString(4, prevName);
        return ps.executeUpdate() == 1;
    }
    
    public static UsersPojo getUserDetailsByName(String name)throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT LOGIN_ID, USER_NAME, PASSWORD FROM USERS WHERE USER_NAME= ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        UsersPojo user = new UsersPojo();
        if(rs.next()){
            user.setLoginId(rs.getString(1));
            user.setUserName(rs.getString(2));
            user.setPassword(rs.getString(3)); 
        }
        return user;
    }
    
}
