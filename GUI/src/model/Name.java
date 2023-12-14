package model;

import java.io.Serializable;

/**
 * Email represents a customer's full name.
 * It is associated to the Customer class.
 * @see Customer
 *
 *@author Karolina Anna Krysiak
 *@version 1.0 - December 2023
 */
public class Name implements Serializable
{

    private String firstName;
    private String middleName;
    private String lastName;

    /**
     * Constructs a new customer's name with the specified first and last names but no middle name.
     *
     * @param firstName The customer's first name.
     * @param lastName The customer's last name.
     */
    public Name(String firstName, String lastName) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);

    }

    /**
     * Constructs a new customer's name with the specified first, middle, and last names.
     *
     * @param firstName The customer's first name.
     * @param middleName The customer's middle name.
     * @param lastName The customer's last name.
     */
    public Name(String firstName, String middleName, String lastName) {
        this(firstName, lastName);
        this.middleName = middleName;
    }

    /**
     * Returns the customer's first name.
     *
     * @return The customer's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the customer's first name.
     *
     * @param firstName The new first name of the customer.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the customer's middle name.
     *
     * @return The customer's middle name.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the customer's middle name.
     *
     * @param middleName The new middle name of the customer.
     */
    public void setMiddleName(String middleName) {
        this.middleName = "";
    }

    /**
     * Returns the customer's last name.
     *
     * @return The customer's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the customer's last name.
     *
     * @param lastName The new last name of the customer.
     */
    public void setLastName(String lastName) {
       this.lastName = lastName;
    }

    /**
     * Returns the customer's full name, in the format "firstName middleName lastName".
     *
     * @return The customer's full name.
     */
    public String getFullName() {
        if (middleName.isEmpty()) {
            return firstName + " " + lastName;
        } else {
            return firstName + " " + middleName + " " + lastName;
        }
    }

    /**
     * Compare customer's names based on their first name, middle name, and last name.
     *
     * @param obj The object to compare to.
     * @return Whether the two objects are equal.
     */
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Name other)) {
            return false;
        }
        return firstName.equals(other.firstName) &&
                middleName.equals(other.middleName) &&
                lastName.equals(other.lastName);
    }
}
