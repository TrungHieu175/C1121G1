package service.impl;

import model.Product;
import repository.IProductRepo;
import repository.impl.ProductRepoImpl;
import service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepo iProductRepo = new ProductRepoImpl();

    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = iProductRepo.getAllProduct();
        if(productList.size() == 0) {
            return null;
        }
        return iProductRepo.getAllProduct();
    }

    @Override
    public void createProduct(Product product) {
        iProductRepo.createProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepo.updateProduct(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepo.findById(id);
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepo.deleteProduct(id);

    }

    @Override
    public List<Product> searchProduct(String name) {
        return null;
    }
}
