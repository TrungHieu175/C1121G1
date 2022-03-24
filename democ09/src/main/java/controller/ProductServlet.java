package controller;

import model.Category;
import model.Product;
import repository.ICategoryRepo;
import service.ICategoryService;
import service.IProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProdutchServlet", value = {"","/product"})
public class ProductServlet extends HttpServlet {

    private IProductService iProductService = new ProductServiceImpl();
    private ICategoryService iCategoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateProductForm(request, response);
                break;
            case "update":
                showUpdateProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        request.setAttribute("product",product);
        List<Category> categoryList = iCategoryService.getAllCategory();
        request.setAttribute("categoryList",categoryList);
        try {
            request.getRequestDispatcher("/update.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateProductForm(HttpServletRequest request, HttpServletResponse response) {
        List<Category> categoryList = iCategoryService.getAllCategory();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = iProductService.getAllProduct();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("/list.jsp").forward(request, response);
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
                createProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "update":
                UpdateProduct(request, response);
                break;
        }

    }

    private void UpdateProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("product_name");
        double productPrice = Double.parseDouble(request.getParameter("product_price"));
        int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
        String productColor = request.getParameter("product_color");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Product product = new Product(productName, productPrice, productQuantity, productColor, categoryId);
        iProductService.updateProduct(product);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.deleteProduct(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("product_name");
        double productPrice = Double.parseDouble(request.getParameter("product_price"));
        int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
        String productColor = request.getParameter("product_color");
        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        Product product = new Product(productName, productPrice, productQuantity, productColor, categoryId);
        iProductService.createProduct(product);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}