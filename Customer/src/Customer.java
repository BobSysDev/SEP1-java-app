import java.io.Serializable;

public class Customer implements Serializable
{
    private boolean isPrivate;
    private Name name;
    private Phone phone;
    private Email email;
    private CustomerCompany company;

    public Customer(Name name, Phone phone, Email email, CustomerCompany company) {
        setPrivate(false);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setCompany(company);
    }

    public Customer(Name name, Phone phone, Email email) {
        setPrivate(true);
        setName(name);
        setPhone(phone);
        setEmail(email);
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
        if (isPrivate) {
            this.company = null;
        }
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public CustomerCompany getCompany() {
        return company;
    }

    public void setCompany(CustomerCompany company) {
        if (!isPrivate) {
            this.company = company;
        }
    }
}
