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
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        return null;
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("urun eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        //business codes in here
        return new SuccessDataResult<Product>
                (this.productDao.getByProductName(productName), "Data listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        //business codes in here
        return new SuccessDataResult<Product>
                (this.productDao.getByProductNameAndCategoryId(productName, categoryId), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameOrCategoryId(productName, categoryId), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByCategoryIdIn(categories), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameContains(productName), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName), "Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByNameAndCategory(productName,categoryId), "Data listelendi");

    }


}
