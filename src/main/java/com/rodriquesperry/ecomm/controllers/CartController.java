package com.rodriquesperry.ecomm.controllers;

import com.rodriquesperry.ecomm.models.CartItem;
import com.rodriquesperry.ecomm.repositories.CartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    private final CartRepository cartDao;

    public CartController(CartRepository cartDao) {
        this.cartDao =cartDao;
    }

    @GetMapping("/cart")
    public String showShoppingCart(@PathVariable long id, Model model) {
        CartItem cartItem = cartDao.findById(id);
        model.addAttribute("cartItem", cartItem);
        return "cart";
    }

}
