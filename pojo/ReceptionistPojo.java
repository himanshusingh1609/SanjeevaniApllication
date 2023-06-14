
package Sanjeevani.pojo;

public class ReceptionistPojo 
{

    @Override
    public String toString() {
        return "ReceptionistPojo{" + "receptionistId=" + receptionistId + ", receptionistName=" + receptionistName + ", gender=" + gender + '}';
    }

    public String getReceptionistId() {
        return receptionistId;
    }

    public void setReceptionistId(String receptionistId) {
        this.receptionistId = receptionistId;
    }

    public String getReceptionistName() {
        return receptionistName;
    }

    public void setReceptionistName(String receptionistName) {
        this.receptionistName = receptionistName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    private String receptionistId;
    private String receptionistName;
    private String gender;
}
