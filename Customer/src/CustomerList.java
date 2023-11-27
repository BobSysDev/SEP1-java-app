import java.util.*;

public class CustomerList {
        private final List<Customer> customers;

        public CustomerList() {
            customers = new ArrayList<>();
        }

        public void addCustomer(Customer customer) {
            customers.add(customer);
        }

        public void removeCustomer(Customer customer) {
            customers.remove(customer);
        }

        public List<Customer> getCustomers() {
            return customers;
        }

}
