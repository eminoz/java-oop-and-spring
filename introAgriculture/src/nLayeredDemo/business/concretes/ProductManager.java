package nLayeredDemo.business.concretes;

import nLayeredDemo.business.abstacts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;

import java.util.List;

public class ProductManager implements ProductService {
    /*
    burada hibernate direk bağlanmadan onu refaranslarını tutan bir interfacese böyle bağlanmalıyız
    böylelikle this.productDao diye metodlara erişebiliriz
    yine böylelikle hibernete hiçbir şekilde bağımlılık  yok
     */
    private ProductDao productDao;
    private LoggerService loggerService;

    public ProductManager(ProductDao productDao, LoggerService loggerService) {
        this.productDao = productDao;
        this.loggerService = loggerService;
    }

    @Override
    public void add(Product product) {
        if (product.getCategoryId() == 1) {
            System.out.println("bu kategoride ürün kabul edilemez");
            return;
        }
        this.productDao.add(product);
        this.loggerService.logtosystem("urun ekledi" + product.getName());

    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
