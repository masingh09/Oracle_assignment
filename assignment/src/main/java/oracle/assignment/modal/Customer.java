package oracle.assignment.modal;
public class Customer {
    private String customerID;
    private String contractId;
    private String zone;
    private String teamCode;
    private String projectCode;
    private String buildDuration;

    public Customer(String customerID, String contractId, String zone, String teamCode, String projectCode, String buildDuration) {
        this.customerID = customerID;
        this.contractId = contractId;
        this.zone = zone;
        this.teamCode = teamCode;
        this.projectCode = projectCode;
        this.buildDuration = buildDuration;
    }


    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getBuildDuration() {
        return buildDuration.substring(0, this.buildDuration.length()-1);
    }

    public void setBuildDuration(String buildDuration) {
        this.buildDuration = buildDuration;
    }
}
