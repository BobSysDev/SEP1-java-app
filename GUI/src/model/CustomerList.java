package model;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerList implements Serializable
{
        private ArrayList<Customer> customers;

        public CustomerList() {
            customers = new ArrayList<>();
        }

        public void addCustomer(Customer customer) {
            customers.add(customer);
        }

        public void removeCustomer(Customer customer) {
            customers.remove(customer);
        }

        public Customer getCustomer(int index) {
            return customers.get(index);
        }

        public ArrayList<Customer> getCustomers(){
          return customers;
        }
}
