
package Sanjeevani.dao;

import Sanjeevani.dbutil.DBConnection;
import Sanjeevani.pojo.ReceptionistPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ReceptionistsDao 
{
    public static void updateName(String currName,String newName)throws SQLException
    {
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Update receptionists set receptionist_name=? where receptionist_name=?");
     ps.setString(1, newName);
     ps.setString(2, currName);
     ps.executeUpdate();
    }
    
    //delete emp
    
    public static void deleteReceptionist(String name)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Delete From RECEPTIONISTS where RECEPTIONIST_NAME =?");
        ps.setString(1, name);
        ps.executeUpdate();
    }
    
    public static String getNewReceptionistId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select max(receptionist_id) from Receptionists");
        rs.next();
        int recId=101;
        String id=rs.getString(1);
        if(id!=null)
        {
            String num=id.substring(3);
            recId=Integer.parseInt(num)+1;
        }
        return "REC"+recId;       
    }
    public static boolean addReceptionist(ReceptionistPojo rec)throws SQLException
    {
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Insert into receptionists values(?,?,?)");
     ps.setString(1,rec.getReceptionistId());
     ps.setString(2,rec.getReceptionistName());
     ps.setString(3,rec.getGender());
     
     return ps.executeUpdate()==1;
    }
    
    public static List<ReceptionistPojo>getAllReceptionistDetails() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select * from receptionists order by receptionist_id");
    List<ReceptionistPojo>recList=new ArrayList<>();
    while(rs.next())
    {
    ReceptionistPojo recep=new ReceptionistPojo();
    recep.setReceptionistId(rs.getString(1));
    recep.setReceptionistName(rs.getString(2));
    recep.setGender(rs.getString(3));
    recList.add(recep);    
    }
    return recList;
    }
    
    public static List<String> getAllRecpId()throws SQLException
    {
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("Select receptionist_id from receptionists");
    List<String> RecpIdList=new ArrayList<>();
    while(rs.next())
    {
        RecpIdList.add(rs.getString(1));
    }
    return RecpIdList;
    } 
    
    
    
    public static ReceptionistPojo getReceptionistDetails(String ReceptionistId)throws SQLException
    {
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("Select * from receptionists where receptionist_id=?");
    ps.setString(1,ReceptionistId);
    ResultSet rs=ps.executeQuery();
    rs.next();
    ReceptionistPojo recp=new ReceptionistPojo();
    recp.setReceptionistId(rs.getString(1));
    recp.setReceptionistName(rs.getString(2));
    recp.setGender(rs.getString(3));
    
    return recp;
    
   } 
    
    public static boolean deleteReceptionistById(String recpId)throws SQLException{
     Connection conn=DBConnection.getConnection();
     PreparedStatement ps=conn.prepareStatement("Select RECEPTIONIST_NAME from  receptionists where receptionist_id=?");
     ps.setString(1, recpId);
     ResultSet rs=ps.executeQuery();
     rs.next();
     String recpName=rs.getString(1);
     UserDao.deleteUserByName(recpName);
     ps=conn.prepareStatement("Delete from receptionists where receptionist_id=?");
     ps.setString(1, recpId);
     return ps.executeUpdate()==1;
}
    public static boolean updateReceptionist(ReceptionistPojo recp)throws SQLException{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE RECEPTIONISTS SET RECEPTIONIST_NAME = ?, GENDER = ? WHERE RECEPTIONIST_ID = ?");
            ps.setString(1 , recp.getReceptionistName());           
            ps.setString(2 , recp.getGender());           
            ps.setString(3 , recp.getReceptionistId());           
            return ps.executeUpdate() == 1;
        }
    
    
}
