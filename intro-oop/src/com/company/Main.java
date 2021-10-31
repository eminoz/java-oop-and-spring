package com.company;

import oooIntro.Category;
import oooIntro.Product;
import oooIntro.ProductManager;

public class Main {

    public static void main(String[] args) {

        Product product2 = new Product();
        product2.setName("macbook");
        product2.setDetail("perfect");
        product2.setId(2);
        product2.setUnitPrice(1000);
        product2.setDiscount(10);
        Category category=new Category();
        category.setId(1);
        System.out.println(category.getId());
        ProductManager productManager=new ProductManager();
        productManager.addToCart(product2);
    }
}
