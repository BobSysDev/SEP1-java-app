package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * CustomerList represents a list of customers from Customer class.
 *
 * @author Karolina Anna Krysiak
 * @version 1.0 - December 2023
 * @see Customer
 */
public class CustomerList implements Serializable {
    private ArrayList<Customer> customers;

    /**
     * Constructs a new customer list.
     */
    public CustomerList() {
        customers = new ArrayList<>();
    }

    /**
     * Adds a customer to the list.
     *
     * @param customer The customer to add.
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Removes a customer from the list.
     *
     * @param customer The customer to remove.
     */

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    /**
     * Retrieves a customer from the list at the specified index.
     *
     * @param index The index of the customer to retrieve.
     * @return The customer at the specified index.
     */
    public Customer getCustomer(int index) {
        return customers.get(index);
    }

    /**
     * Returns a list of all customers in the list.
     *
     * @return An ArrayList containing all customers in the list.
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
