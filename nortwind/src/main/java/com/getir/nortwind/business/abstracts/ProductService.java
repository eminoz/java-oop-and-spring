package com.getir.nortwind.business.abstracts;

import com.getir.nortwind.core.utilities.results.DataResult;
import com.getir.nortwind.core.utilities.results.Result;
import com.getir.nortwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();

    Result add(Product product);
}
