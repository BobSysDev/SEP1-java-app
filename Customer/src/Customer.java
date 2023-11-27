public class Customer {
    private boolean isPrivate;

    public Customer(boolean isPrivate) {
        setPrivate(isPrivate);
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }
}
