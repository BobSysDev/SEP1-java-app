package model;

import java.io.Serializable;

public class Phone implements Serializable
{
    private String countryCode;
    private String phoneNumber;

    public Phone(String countryCode, String phoneNumber) {
        setCountryCode(countryCode);
        setPhoneNumber(phoneNumber);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullPhoneNumber() {
        return countryCode + phoneNumber;
    }
}
