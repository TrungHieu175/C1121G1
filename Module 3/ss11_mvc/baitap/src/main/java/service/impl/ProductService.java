package service.impl;

import model.Product;
import service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static Map<Integer, Product> product;

    static {
        product = new HashMap<>();
        product.put(1, new Product(1, "Cục cớt bình thường",3000,"Thơm", "Nhà Tui"));
        product.put(2, new Product(2, "Cục cớt kiêu kì",2000,"Thơm", "Nhà Bạn"));
        product.put(3, new Product(3, "Cục cớt thần thánh",1000,"Thơm", "Nhà Hàng Xốm"));
        product.put(4, new Product(4, "Cục cớt vô địch",4000,"Thơm", "Nhà Trắng"));
        product.put(5, new Product(5, "Cục cớt tàng hình",6000,"Thơm", "Nhà Xí"));
        product.put(6, new Product(6, "Cục cớt xinh đẹp",5000,"Thơm", "Ngôi Nhà Hoa Hồng"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(product.values());
    }

    @Override
        public void save(Product product) {
        ProductService.product.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return product.get(id);
    }

    @Override
    public void update(int id, Product product) {
        ProductService.product.put(id, product);
    }

    @Override
    public void remove(int id) {
        product.remove(id);
    }
}
