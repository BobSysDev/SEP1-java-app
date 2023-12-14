package model;

import java.io.Serializable;

/**
 * Customer class represents a customer in the system. A customer can either be a private individual or a company
 *
 * @author Karolina Anna Krysiak
 * @version 1.0 - December 2023
 */

public class Customer implements Serializable {
    private boolean isPrivate;
    private Name name;
    private Phone phone;
    private Email email;
    private CustomerCompany company;

    /**
     * Initializes all instance variables for a new customer with the specified name, phone number, email address and company.
     *
     * @param name    The name of the customer
     * @param phone   The phone number of the customer
     * @param email   The email address of the customer
     * @param company The company associated with the customer
     */
    public Customer(Name name, Phone phone, Email email, CustomerCompany company) {
        setPrivate(false);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setCompany(company);
    }

    /**
     * Initializes all instance variables for a new customer with the specified name, phone number, and email
     * address. The customer is not associated with a company.
     *
     * @param name    The name of the customer
     * @param phone   The phone number of the customer
     * @param email   The email address of the customer
     */
    public Customer(Name name, Phone phone, Email email) {
        setPrivate(true);
        setName(name);
        setPhone(phone);
        setEmail(email);
    }

    /**
     * Returns whether the customer is a private individual or not.
     *
     * @return true if the customer is private, false if the customer is a company
     */
    public boolean isPrivate() {
        return isPrivate;
    }

    /**
     * Sets private type for the customer. This method also sets the company to null if the customer becomes private.
     *
     * @param isPrivate The new value of the isPrivate
     */
    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
        if (isPrivate) {
            this.company = null;
        }
    }

    /**
     * Returns the name of the customer.
     *
     * @return The name of the customer
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The new name of the customer
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Returns the phone number of the customer.
     *
     * @return The phone number of the customer
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the customer.
     *
     * @param phone The new phone number of the customer
     */
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    /**
     * Returns the email address of the customer.
     *
     * @return The email address of the customer
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Sets the email address of the customer.
     *
     * @param email The new email address of the customer
     */
    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * Returns the company associated with the customer.
     *
     * @return The company associated with the customer or null if the customer is private.
     */
    public CustomerCompany getCompany() {
        return company;
    }

    /**
     * Sets the company for the customer. This method only sets the company if the customer
     * is not private.
     *
     * @param company The new company associated with the customer.
     */
    public void setCompany(CustomerCompany company) {
        if (!isPrivate) {
            this.company = company;
        }
    }

    /**
     * Compares customers based on their private status and (if not private) name, phone number, email address, and company.
     *
     * @param obj The object to compare to.
     * @return Whether the two objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Customer other)) {
            return false;
        }

        if (isPrivate != other.isPrivate) {
            return false;
        }
        if (isPrivate) {
            if (company != null && other.company != null) {
                return company.equals(other.company);
            } else {
                return company == other.company;
            }
        } else {
            if (name == null) {
                return null == other.name && phone.equals(other.phone) && email.equals(other.email) && company == other.company;
            } else if (name.equals(other.name)) {
                return phone.equals(other.phone) && email.equals(other.email) && company == other.company;
            } else {
                return false;
            }
        }
    }

}
