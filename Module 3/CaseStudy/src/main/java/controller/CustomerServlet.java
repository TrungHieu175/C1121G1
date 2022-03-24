package controller;

import DTO.CustomerDTO;
import model.Customer;
import model.CustomerType;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controller.UserServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "searchByName":
                searchByName(request, response);
                break;
            case "searchById":
                searchById(request, response);
                break;
            case "searchByAddress":
                searchByAddress(request,response);
                break;
            default:
                try {
                    listCustomer(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void searchByAddress(HttpServletRequest request, HttpServletResponse response) {
        String name1 = request.getParameter("searchValue");
        request.setAttribute("searchValue",name1);
        String address = request.getParameter("searchValue");
        List<Customer> customerList = iCustomerService.searchByAddress(address);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void searchById(HttpServletRequest request, HttpServletResponse response) {
        Integer name1 = Integer.valueOf(request.getParameter("searchValue"));
        request.setAttribute("searchValue",name1);
        Integer id = Integer.valueOf(request.getParameter("searchValue"));
        List<Customer> customerList = iCustomerService.searchById(id);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name1 = request.getParameter("searchValue");
        request.setAttribute("searchValue",name1);
        String name = request.getParameter("searchValue");
        List<Customer> customerList = iCustomerService.searchByName(name);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerService.customerTyper();
        request.setAttribute("customerTypeList", customerTypeList);
        Integer id = Integer.valueOf(request.getParameter("id"));
        Customer customer = iCustomerService.selectCustomer(id);
        request.setAttribute("customer", customer);
        try {
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertUser(request, response);
                break;
            case "update":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id1 = Integer.valueOf(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer typeId = Integer.valueOf(request.getParameter("typeId"));
        Customer customer = new Customer(id1, code, name, birthday, gender, idCard, phone, email, address, typeId);
        iCustomerService.updateCustomer(customer);
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Integer gender = Integer.valueOf(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Integer typeId = Integer.valueOf(request.getParameter("typeId"));
        Customer customer = new Customer(code, name,birthday, gender, idCard, phone, email, address,typeId);
        iCustomerService.insertCustomer(customer);
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        List<Customer> customerList = iCustomerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerService.customerTyper();
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("idDelete"));
        iCustomerService.deleteCustomer(id);
        try {
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

