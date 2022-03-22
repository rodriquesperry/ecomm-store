package com.rodriquesperry.ecomm.controllers;

import com.rodriquesperry.ecomm.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final ProductRepository productDao;

    public IndexController(ProductRepository productDao) {
        this.productDao =productDao;
    }

    @GetMapping("/")
    public String showIndexPage(Model model) {
        model.addAttribute("products", productDao.findAll());
        return "index";
    }
}
