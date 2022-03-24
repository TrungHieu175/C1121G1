package service.impl;

import DTO.CustomerDTO;
import model.Customer;

import model.CustomerType;
import rebository.ICustomerRepository;
import rebository.impl.CustomerRepository;

import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
ICustomerRepository iCustomerRepository = new CustomerRepository();


    @Override
    public void insertCustomer(Customer customer) {
        iCustomerRepository.insertCustomer(customer);
    }

    @Override
    public Customer selectCustomer(Integer id) {
        return iCustomerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return iCustomerRepository.selectAllCustomer();
    }

    @Override
    public void deleteCustomer(int id) {
        iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        iCustomerRepository.updateCustomer(customer);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return iCustomerRepository.searchByName(name);
    }

    @Override
    public List<Customer> searchById(Integer id) {
        return iCustomerRepository.searchById(id);
    }

    @Override
    public List<CustomerType> customerTyper() {
        return iCustomerRepository.customerTyper();
    }

    @Override
    public List<Customer> searchByAddress(String address) {
        return iCustomerRepository.searchByAddress(address);
    }
}
