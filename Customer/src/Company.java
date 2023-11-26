public class Company {

    private String name;
    private int CVR;

    public Company(String name, String CVR) {
        try {
            setCVR(CVR);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid CVR: " + e.getMessage());
        }
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void

    setName(String name) {
        if (name == null || name.isEmpty()) {
            throw
                    new IllegalArgumentException("Company name cannot be empty");
        }
        this.name = name;
    }

    public int getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        if (CVR.length() != 8) {
            throw new IllegalArgumentException("CVR must be 8 digits");
        }

        // Convert CVR string to integer
        try {
            this.CVR = Integer.parseInt(CVR);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid CVR format");
        }
    }

    @Override
    public String toString() {
        return "Company: " + name + " " + CVR;
    }
}
