package in.upcode.eShop.model;
import javax.persistence.*;
@Entity
@Table(name = "items")
public class Product {

    private Long id;
    private String name;
    private String quantity;

    public Product() {  //constructor
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
