package com.rodriquesperry.ecomm.repositories;

import com.rodriquesperry.ecomm.models.Cart;
import com.rodriquesperry.ecomm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    User findCartByCustomerId(long id);
}
