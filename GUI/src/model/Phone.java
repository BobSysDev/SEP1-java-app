package model;

import java.io.Serializable;
/**
 * Phone represents a customer's phone number with a country code.
 * It is associated to the Customer class.
 * @see Customer
 *
 *@author Karolina Anna Krysiak
 *@version 1.0 - December 2023
 */
public class Phone implements Serializable
{
    private String countryCode;
    private String phoneNumber;

    /**
     * Constructs a new phone number with the specified country code and phone number.
     *
     * @param countryCode The country code for the phone number.
     * @param phoneNumber The phone number.
     */
    public Phone(String countryCode, String phoneNumber) {
        setCountryCode(countryCode);
        setPhoneNumber(phoneNumber);
    }

    /**
     * Returns the country code associated with the phone number.
     *
     * @return The country code for the phone number.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code for the phone number.
     *
     * @param countryCode The new country code for the phone number.
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Returns the phone number.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber The new phone number.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the full phone number, including the country code and phone number.
     *
     * @return The full phone number, including the country code and phone number.
     */
    public String getFullPhoneNumber() {
        return countryCode + phoneNumber;
    }

    /**
     * Compares phones based on their country code and phone number.
     *
     * @param obj The object to compare to.
     * @return Whether the two objects are equal.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Phone other)) {
            return false;
        }

        if (!countryCode.equals(other.countryCode)) {
            return false;
        }

        return phoneNumber.equals(other.phoneNumber);
    }


}
