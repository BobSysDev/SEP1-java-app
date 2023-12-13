package model;

import java.io.Serializable;

public class CustomerCompany implements Serializable {
    private String name;
    private String CVR;

    public CustomerCompany(String name, String CVR) {
        setCVR(CVR);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = CVR;
    }

    public String getFullCompanyName() {
        return name + "\n" + CVR;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CustomerCompany)) {
            return false;
        }
        CustomerCompany other = (CustomerCompany) obj;
        return name.equals(other.name) && CVR.equals(other.CVR);
    }
}
