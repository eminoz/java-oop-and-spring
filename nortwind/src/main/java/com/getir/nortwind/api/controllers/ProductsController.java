package com.getir.nortwind.api.controllers;

import com.getir.nortwind.business.abstracts.ProductService;
import com.getir.nortwind.core.utilities.results.DataResult;
import com.getir.nortwind.core.utilities.results.Result;
import com.getir.nortwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    //buradaki autowired ProductService productService ı implement edeni bulup new'liyor ve ona erişmemizi sağlıyor
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll() { //buradaki  DataResult<List<Product>> döndürülecek olan datanın fonksiyonu
        return this.productService.getAll();

    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }
}
