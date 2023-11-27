public class Email {
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

}
