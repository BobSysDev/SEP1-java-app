public class Company {
    private String name;
    private int CVR;

    public Company(String name, String CVR) {
        setCVR(CVR);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void

    setName(String name) {
        this.name = name;
    }

    public int getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = Integer.parseInt(CVR);
    }
}
