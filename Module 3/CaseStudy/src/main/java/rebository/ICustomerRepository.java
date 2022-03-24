package rebository;

import DTO.CustomerDTO;
import model.Customer;
import model.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    public void insertCustomer(Customer customer);

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomer();

    public void deleteCustomer(int id);

    public void updateCustomer(Customer customer);

    public List<Customer> searchByName(String name);

    public List<Customer> searchById(Integer id);

    List<CustomerType> customerTyper();

    List<Customer> searchByAddress(String address);
}
