package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    void createProduct(Product product);

    void updateProduct(Product product);

    Product findById(int id);

    void deleteProduct(int id);

    List<Product> searchProduct(String name);
}
