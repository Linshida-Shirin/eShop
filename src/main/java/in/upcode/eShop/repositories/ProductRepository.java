package in.upcode.eShop.repositories;

import in.upcode.eShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE CONCAT(p.name, ' ', p.id, ' ', p.quantity) LIKE %?1%")
    public List<Product> search(String keyword);
}
