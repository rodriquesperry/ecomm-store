package com.rodriquesperry.ecomm.repositories;

import com.rodriquesperry.ecomm.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    CartItem findById(long id);
}
