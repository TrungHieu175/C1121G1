package controller;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Hieu", "1/1/1995", "Da Nang City", "image/Gawr Gura_ (5).jpg"));
        customerList.add(new Customer("Hieu", "1/1/1995", "Da Nang City", "image/Gawr Gura_ (6).jpg"));
        customerList.add(new Customer("Hieu", "1/1/1995", "Da Nang City", "image/Gawr Gura_ (7).jpg"));
        customerList.add(new Customer("Hieu", "1/1/1995", "Da Nang City", "image/Gawr Gura_ (8).jpg"));
        customerList.add(new Customer("Hieu", "1/1/1995", "Da Nang City", "image/Gawr Gura_ (9).jpg"));
        customerList.add(new Customer("Hieu", "1/1/1995", "Da Nang City", "image/Gawr Gura_ (10).jpg"));
        request.setAttribute("customer",customerList);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
