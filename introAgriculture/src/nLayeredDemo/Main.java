package nLayeredDemo;

import nLayeredDemo.business.abstacts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.JLoggerManagerAdapter;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;

public class Main {
    public static void main(String[] args) {
        //bir projede entitiler haric newleniyorsa ilerde mokoko olacak
        ProductService productService = new ProductManager(new HibernateProductDao(), new JLoggerManagerAdapter());
        Product product = new Product(1, 2, "elma", 12, 50);
        productService.add(product);
    }
}
