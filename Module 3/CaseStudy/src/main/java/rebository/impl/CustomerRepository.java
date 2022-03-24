package rebository.impl;

import DTO.CustomerDTO;
import model.Customer;
import model.CustomerType;
import rebository.ICustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer (customer_code, customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id =?";
    private static final String SELECT_ALL_USERS = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_code = ?,customer_name= ?, customer_birthday =? , customer_gender =? , customer_id_card =? , customer_phone =? , customer_email =? , customer_address =? , customer_type_id =? where customer_id = ?;";
    private static final String SEARCH_BY_ID = "select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_id = ?;";
    private static final String SEARCH_BY_NAME = "select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer.customer_name like ? ;";
    private static final String SEARCH_BY_ADDRESS = "select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer.customer_address like ? ;";
    private static final String ORDERBY_CUSTOMER_SQL = "SELECT * FROM customer join customer_type on customer.customer_type_id = customer_type.customer_type_id ORDER BY customer_id asc;";
    public BaseRepository baseRepository = new BaseRepository();

    @Override
    public void insertCustomer(Customer customer) {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getCode());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Customer selectCustomer(int id) {
        Connection connection = baseRepository.getConnection();
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id1 = resultSet.getInt("customer_id");
                String code = resultSet.getString("customer_code");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String email = resultSet.getString("customer_email");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                Integer typeId = Integer.valueOf(resultSet.getString("customer_type_id"));
                customer = new Customer(id1, code, name, birthday, gender, idCard, email, phone, address, typeId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(ORDERBY_CUSTOMER_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                Integer id1 = resultSet.getInt("customer_id");
                String code = resultSet.getString("customer_code");
                String name1 = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String email = resultSet.getString("customer_email");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                String typeName = resultSet.getString("customer_type_name");
                customer = new Customer(id1, code, name1, birthday, gender, idCard, email, phone, address, typeName);
                customerList.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return customerList;
        }
    }


    @Override
    public void deleteCustomer(int id) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getCode());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthday());
            preparedStatement.setInt(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getTypeId());
            preparedStatement.setInt(10, customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id1 = resultSet.getInt("customer_id");
                String code = resultSet.getString("customer_code");
                String name1 = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String email = resultSet.getString("customer_email");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                String typeName = resultSet.getString("customer_type_name");
                Customer customer = new Customer(id1, code, name1, birthday, gender, idCard, email, phone, address, typeName);
                customerList.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> searchById(Integer id) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id1 = resultSet.getInt("customer_id");
                String code = resultSet.getString("customer_code");
                String name1 = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String email = resultSet.getString("customer_email");
                String phone = resultSet.getString("customer_phone");
                String address1 = resultSet.getString("customer_address");
                String typeName = resultSet.getString("customer_type_name");
                Customer customer = new Customer(id1, code, name1, birthday, gender, idCard, email, phone, address1, typeName);
                customerList.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<CustomerType> customerTyper() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from customer_type;");
            ResultSet resultSet = preparedStatement.executeQuery();
            CustomerType customerType;
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id, name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return customerTypeList;
        }
    }

    @Override
    public List<Customer> searchByAddress(String address) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = baseRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_ADDRESS);
            preparedStatement.setString(1, "%" + address + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id1 = resultSet.getInt("customer_id");
                String code = resultSet.getString("customer_code");
                String name1 = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String email = resultSet.getString("customer_email");
                String phone = resultSet.getString("customer_phone");
                String address1 = resultSet.getString("customer_address");
                String typeName = resultSet.getString("customer_type_name");
                Customer customer = new Customer(id1, code, name1, birthday, gender, idCard, email, phone, address1, typeName);
                customerList.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

}
