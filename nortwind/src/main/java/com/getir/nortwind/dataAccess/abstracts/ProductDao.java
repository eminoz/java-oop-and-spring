package com.getir.nortwind.dataAccess.abstracts;

import com.getir.nortwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {


}
