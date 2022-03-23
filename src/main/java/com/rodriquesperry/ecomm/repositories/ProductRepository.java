package com.rodriquesperry.ecomm.repositories;

import com.rodriquesperry.ecomm.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
}
