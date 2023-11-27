public class Name {

    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String lastName) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);

    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, lastName);
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = "";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
       this.lastName = lastName;
    }

    public String getFullName() {
        if (middleName.isEmpty()) {
            return firstName + " " + lastName;
        } else {
            return firstName + " " + middleName + " " + lastName;
        }
    }

}
