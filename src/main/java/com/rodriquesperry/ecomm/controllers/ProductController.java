package com.rodriquesperry.ecomm.controllers;

import com.rodriquesperry.ecomm.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductRepository productDao;

    public ProductController(ProductRepository productDao) {
        this.productDao =productDao;
    }

    @GetMapping("/")
    public String showIndexPage(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "index";
    }

    @GetMapping("/product/{id}")
    public String ShowSingleProductPage(@PathVariable long id, Model model) {
        model.addAttribute()
        return "product";
    }

}
