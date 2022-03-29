package com.rodriquesperry.ecomm.repositories;

import com.rodriquesperry.ecomm.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
