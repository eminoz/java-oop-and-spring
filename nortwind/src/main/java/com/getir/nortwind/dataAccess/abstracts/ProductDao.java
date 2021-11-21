package com.getir.nortwind.dataAccess.abstracts;

import com.getir.nortwind.entities.concretes.Product;
import com.getir.nortwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    //isimlendirme kurallarına uymak gerekiyor
    Product getByProductName(String productName);//burada getBy' bakarak ilgili alana göre bir where koşulu yapıştırıyor

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);//select*from products where product_name=abc or category_id=1 demektir

    List<Product> getByCategoryIn(List<Integer> categories);//select*from products where category_id in(1,2,3,4) demektir

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);


    @Query("Select new com.getir.nortwind.entities.dtos.ProductWithCategoryDto"
            + "(p.id, p.productName, c.categoryName) "
            + "From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails(
            //select p.productId,p.productName, c.categoryName  from Category c inner join Product p
            //on c.categoryId = p.categoryId
    );


}
