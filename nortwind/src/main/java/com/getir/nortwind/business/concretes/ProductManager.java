package com.getir.nortwind.business.concretes;

import com.getir.nortwind.business.abstracts.ProductService;
import com.getir.nortwind.core.utilities.results.DataResult;
import com.getir.nortwind.core.utilities.results.Result;
import com.getir.nortwind.core.utilities.results.SuccessDataResult;
import com.getir.nortwind.core.utilities.results.SuccessResult;
import com.getir.nortwind.dataAccess.abstracts.ProductDao;
import com.getir.nortwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data listelendi");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("urun eklendi");
    }
}
