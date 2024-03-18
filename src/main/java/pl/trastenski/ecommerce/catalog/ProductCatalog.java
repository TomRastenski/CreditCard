package pl.trastenski.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    ArrayList<Product>products;

    public ProductCatalog(){
        products=new ArrayList<>();
    }
    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(String name, String description) {
        UUID id =UUID.randomUUID();
        Product newProduct = new Product(id,name, description);


        products.add(newProduct);

        return newProduct.getId();
    }

    public Product getProductBY(String id){
        return products.stream()
                .filter(product->product.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    public void changePrice(String id, BigDecimal newPrice){
        var loadedProduct = getProductBy(id);
        loadedProduct.changePrice(newPrice);

    }
}
