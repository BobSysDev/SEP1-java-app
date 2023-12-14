package model;

import java.io.Serializable;

/**
 * CustomerCompany represents a customer's company information.
 * It is associated to Customer class.
 * @see Customer
 *
 *@author Karolina Anna Krysiak
 *@version 1.0 - December 2023
 */
public class CustomerCompany implements Serializable {
    private String name;
    private String CVR;

    /**
     * Constructs a new customer company with the specified name and CVR.
     *
     * @param name The name of the customer's company.
     * @param CVR The CVR number of the customer's company.
     */
    public CustomerCompany(String name, String CVR) {
        setCVR(CVR);
        setName(name);
    }

    /**
     * Returns the name of the customer's company.
     *
     * @return The name of the customer's company.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer's company.
     *
     * @param name The new name of the customer's company.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the CVR number of the customer's company.
     *
     * @return The CVR number of the customer's company.
     */
    public String getCVR() {
        return CVR;
    }

    /**
     * Sets the CVR number of the customer's company.
     *
     * @param CVR The new CVR number of the customer's company.
     */
    public void setCVR(String CVR) {
        this.CVR = CVR;
    }

    /**
     * Gets the full company name, including the name and CVR.
     *
     * @return The full company name.
     */
    public String getFullCompanyName() {
        return name + "\n" + CVR;
    }

    /**
     * Compares companies based on their name and CVR.
     *
     * @param obj The object to compare to.
     * @return Whether the two objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CustomerCompany)) {
            return false;
        }
        CustomerCompany other = (CustomerCompany) obj;
        return name.equals(other.name) && CVR.equals(other.CVR);
    }
}
