
package Sanjeevani.pojo;

public class UserPojo 
{

    public UserPojo(String loginId, String password, String userType) 
    {
        this.loginId = loginId;
        this.password = password;
        this.UserType = userType;
    }
    public UserPojo(){
        
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }
    private String loginId;
    private String password;
    private String UserType;
}
