package model;

import java.io.Serializable;

public class Email implements Serializable
{
    private String user;
    private String host;
    private String domain;

    public Email(String user, String host, String domain) {
        setUser(user);
        setHost(host);
        setDomain(domain);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user){
        this.user = user;
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host){
        this.host = host;
    }

    public String getDomain() {
        return domain;
    }
    public void setDomain(String domain){
        this.domain = domain;
    }

    public String getFullEmail(){
        return user + "@" + host + "." + domain;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Email)) {
            return false;
        }
        Email other = (Email) obj;
        return user.equals(other.user) && host.equals(other.host) && domain.equals(other.domain);
    }

}
