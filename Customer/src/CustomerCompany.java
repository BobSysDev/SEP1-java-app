public class CustomerCompany {
    private String name;
    private int CVR;

    public CustomerCompany(String name, int CVR) {
        setCVR(CVR);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCVR() {
        return CVR;
    }

    public void setCVR(int CVR) {
        this.CVR = CVR;
    }

    public String getFullCompanyName() {
        return name + "\n" + CVR;
    }
}
