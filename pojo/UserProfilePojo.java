
package Sanjeevani.pojo;


public class UserProfilePojo 
{

    

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserProfilePojo.userName = userName;
    }

    public static String getUserType() {
        return userType;
    }

    public static void setUserType(String userType) {
        UserProfilePojo.userType = userType;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        UserProfilePojo.userId = userId;
    }
    private static  String userName;
    private static String userType;
    private static String userId;
  
    
}
