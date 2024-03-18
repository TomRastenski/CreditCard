package pl.trastenski.ecommerce.catalog;

import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class ProductCatalogTest {
    @Test
    void itListProduct(){
        ProductCatalog catalog = new ProductCatalog();

        List<Product>products= catalog.allProducts();

        assert products.isEmpty();
    }

    @Test
    void itAllowsToAddProduct(){
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct("Lego set 8083","Nice one");
        List<Product> products=catalog.allProducts();

        assertThat(products)
                .hasSize(1);
    }

    @Test
    void itAllowsToLoadProductDetails(){
        ProductCatalog catalog = new ProductCatalog();
        String id = catalog.addProduct("Lego set 8083","Nice one");

        Product loaded =catalog.getProducts(id);

        assertThat(id).isEqualTo(loaded.getId());

    }

    @Test
    void itAllowsToChangePriceForProduct(){
        ProductCatalog catalog = new ProductCatalog();
        string id =catalog.allProducts("Lego set 8083","Nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));

        Product loaded =catalog.getProducts(id);
        assertThat(BigDecimal.valueOf(10.10))
                .isEqualTo(loaded)
    }


}
