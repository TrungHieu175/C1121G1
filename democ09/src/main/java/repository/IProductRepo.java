package repository;

import model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> getAllProduct();

    void createProduct(Product product);

    void updateProduct(Product product);

    Product findById(int id);

    void deleteProduct(int id);

    List<Product> searchProduct(String name);
}
