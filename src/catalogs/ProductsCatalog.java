package catalogs;

import java.util.List;

import models.Product;
import persistance.PersistanceFacade;

public class ProductsCatalog {
    List<Product> l;

    public ProductsCatalog() {
        super();
        l = PersistanceFacade.getInstance().search(Product.class, "count", "[0-9]*[1-9][0-9]*");
    }

    public Product findByName(String name) {
        for (Product product : l) {
            if (product.getValue("name") == name) {
                return product;
            }
        }
        return null;
    }

    public Product findById(String id) {
        for (Product product : l) {
            if (product.getValue("id") == id) {
                return product;
            }
        }
        return null;
    }

}
