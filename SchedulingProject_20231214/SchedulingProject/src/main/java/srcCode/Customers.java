package srcCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class Customers
{
    private ObservableList<Customer> allCustomers;
    private Integer customerID;

    public Customers()
    {
        customerID = 0;
        allCustomers = FXCollections.observableArrayList();
    }

    public void AddCustomer(Customer newCustomer)
    {
        customerID++;
        newCustomer.setCustomer_id(customerID);
        allCustomers.add(newCustomer);
    }
    public void UpdateCustomer(Customer originalCustomer, Customer updatedCustomer)
    {
        allCustomers.remove(originalCustomer);
        allCustomers.add(updatedCustomer);
    }
    public void RemoveCustomer(Customer removedCustomer)
    {
        allCustomers.remove(removedCustomer);
    }
    public ObservableList<Customer> getAllCustomers()
    {
        return allCustomers;
    }
    public Integer getNumCustomers()
    {
        return allCustomers.size();
    }
}
