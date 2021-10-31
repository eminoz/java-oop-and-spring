package nLayeredDemo.business.abstacts;

import nLayeredDemo.entities.concretes.Product;

import java.util.List;

public interface ProductService { //service varsa bu interfacedir
    void add(Product product);

    List<Product> getAll();

}
