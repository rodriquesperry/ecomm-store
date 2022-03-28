package com.rodriquesperry.ecomm.controllers;

import com.rodriquesperry.ecomm.models.Cart;
import com.rodriquesperry.ecomm.models.CartItem;
import com.rodriquesperry.ecomm.models.Product;
import com.rodriquesperry.ecomm.models.User;
import com.rodriquesperry.ecomm.repositories.CartItemRepository;
import com.rodriquesperry.ecomm.repositories.ProductRepository;
import com.rodriquesperry.ecomm.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {

    private final UserRepository userDao;
    private final ProductRepository productDao;
    private final CartItemRepository cartItemDao;

    public CartController(UserRepository userDao, CartItemRepository cartItemDao, ProductRepository productDao) {

        this.userDao = userDao;
        this.cartItemDao = cartItemDao;
        this.productDao = productDao;
    }

    @GetMapping("/cart")
    public String showShoppingCart(Model model) {
        model.addAttribute("cartItem", new CartItem());
        return "cart";
    }

    @PostMapping("/cart")
    public String createCartItem(@RequestParam(name = "productId") long productId, Model model) {
        System.out.println("productId = " + productId);


        CartItem cartItem = new CartItem();
        Cart cart = new Cart();


        cartItem.setProduct(productDao.findProductById(productId));



        model.addAttribute("cartItem", cartItem);

        return "cart";
    }

}
