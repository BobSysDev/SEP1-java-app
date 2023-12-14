package model;

import java.io.Serializable;

/**
 * Email represents a customer's email address.
 * It is associated to the Customer class.
 * @see Customer
 *
 *@author Karolina Anna Krysiak
 *@version 1.0 - December 2023
 */
public class Email implements Serializable
{
    private String user;
    private String host;
    private String domain;

    /**
     * Constructs a new email address with the specified user, host, and domain.
     *
     * @param user The username of the email address.
     * @param host The host of the email address.
     * @param domain The domain of the email address.
     */
    public Email(String user, String host, String domain) {
        setUser(user);
        setHost(host);
        setDomain(domain);
    }

    /**
     * Returns the username of the email address.
     *
     * @return The username of the email address.
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the username of the email address.
     *
     * @param user The new username of the email address.
     */
    public void setUser(String user){
        this.user = user;
    }

    /**
     * Returns the host of the email address.
     *
     * @return The host of the email address.
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the host of the email address.
     *
     * @param host The new host of the email address.
     */
    public void setHost(String host){
        this.host = host;
    }

    /**
     * Returns the domain of the email address.
     *
     * @return The domain of the email address.
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the domain of the email address.
     *
     * @param domain The new domain of the email address.
     */
    public void setDomain(String domain){
        this.domain = domain;
    }

    /**
     * Gets the full email address, including the user, host, and domain with necessary characters in between.
     *
     * @return The full email address.
     */
    public String getFullEmail(){
        return user + "@" + host + "." + domain;
    }

    /**
     * Compares emails based on their username, host name, and domain name.
     *
     * @param obj The object to compare to.
     * @return Whether the two objects are equal.
     */
    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Email)) {
            return false;
        }
        Email other = (Email) obj;
        return user.equals(other.user) && host.equals(other.host) && domain.equals(other.domain);
    }

}
