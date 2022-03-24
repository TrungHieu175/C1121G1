package repository.impl;

import model.Product;
import repository.BaseRepository;
import repository.IProductRepo;
import service.impl.ProductServiceImpl;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements IProductRepo {



    @Override
    public List<Product> getAllProduct() {
        Connection connection = BaseRepository.getConnection();
        List<Product> productList = new ArrayList<>();
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("select * from product join category on product.category_id = category.category_id;");
                resultSet = preparedStatement.executeQuery();
                Product product;
                while (resultSet.next()) {
                    product = new Product();
                    product.setProductId(resultSet.getInt("product_id"));
                    product.setProductName(resultSet.getString("product_name"));
                    product.setProductPrice(resultSet.getDouble("product_price"));
                    product.setProductQuantity(resultSet.getInt("product_quantity"));
                    product.setProductColor(resultSet.getString("product_color"));
                    product.setCategoryName(resultSet.getString("category_name"));
                    productList.add(product);
                }
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

        return productList;
    }

    @Override
    public void createProduct(Product product) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("insert into product(product_name, product_price, product_quantity, product_color, category_id) value (?,?,?,?,?)");
                preparedStatement.setString(1, product.getProductName());
                preparedStatement.setDouble(2, product.getProductPrice());
                preparedStatement.setInt(3, product.getProductQuantity());
                preparedStatement.setString(4, product.getProductColor());
                preparedStatement.setInt(5, product.getCategoryId());

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
    }

    @Override
    public void updateProduct(Product product) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement
                    ("update product set  product_name = ?,product_price = ?,product_quantity = ?," +
                            "product_color = ?,category_id= ? where product_id = ?");
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getProductPrice());
            preparedStatement.setInt(3, product.getProductQuantity());
            preparedStatement.setString(4, product.getProductColor());
            preparedStatement.setInt(5, product.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().
                    prepareStatement("select * from customer where product_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setProductId(id);
                product.setProductName(resultSet.getString("product_name"));
                product.setProductPrice(resultSet.getDouble("product_price"));
                product.setProductQuantity(resultSet.getInt("product_quantity"));
                product.setProductColor(resultSet.getString("product_color"));
                product.setCategoryId(resultSet.getInt("category_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void deleteProduct(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("delete from product where product_id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> searchProduct(String name) {
        return null;
    }
}
