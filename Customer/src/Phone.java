public class Phone {
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
        if (phoneNumber.length() < 4 || phoneNumber.length() > 13) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getFullPhoneNumber() {
        return countryCode + phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone: " + getFullPhoneNumber();
    }
}
