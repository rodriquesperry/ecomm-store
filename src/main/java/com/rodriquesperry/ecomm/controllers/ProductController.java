package com.rodriquesperry.ecomm.controllers;

import com.rodriquesperry.ecomm.models.CartItem;
import com.rodriquesperry.ecomm.models.Product;
import com.rodriquesperry.ecomm.repositories.CartItemRepository;
import com.rodriquesperry.ecomm.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final ProductRepository productDao;
    private final CartItemRepository cartItemDao;

    public ProductController(ProductRepository productDao, CartItemRepository cartItemDao) {
        this.productDao = productDao;
        this.cartItemDao = cartItemDao;
    }

    @GetMapping("/")
    public String showIndexPage(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "index";
    }

    @GetMapping("/product/{id}")
    public String ShowSingleProductPage(@PathVariable long id, Model model) {
        Product product = productDao.findProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("cartItem", new CartItem());
        return "product";
    }


}
