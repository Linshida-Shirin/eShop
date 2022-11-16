package in.upcode.eShop.services;

import in.upcode.eShop.model.Product;
import in.upcode.eShop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> GetAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> listAll(String keyword) {
        if(keyword!=null) {
            return productRepository.search(keyword);
        }
        return productRepository.findAll();
    }
    public void save(Product product) {
        productRepository.save(product);
    }
    public void delete(long id) {
        productRepository.deleteById(id);
    }
    public Product get(long id) {
        return productRepository.findById(id).get();
    }

}
