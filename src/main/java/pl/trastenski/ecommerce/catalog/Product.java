package pl.trastenski.ecommerce.catalog;


import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    public Product(UUID id, String name, String description) {
        this.id=id.toString();
        this.name=name;
        this.description=description;
    }
    public String getId(){
        return id;
    }

    public BigDecimal getPrice(){
        return price;
    }
}
