package com.rodriquesperry.ecomm.controllers;

import com.rodriquesperry.ecomm.models.Cart;
import com.rodriquesperry.ecomm.models.CartItem;
import com.rodriquesperry.ecomm.models.Product;
import com.rodriquesperry.ecomm.models.User;
import com.rodriquesperry.ecomm.repositories.CartItemRepository;
import com.rodriquesperry.ecomm.repositories.CartRepository;
import com.rodriquesperry.ecomm.repositories.ProductRepository;
import com.rodriquesperry.ecomm.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    private final UserRepository userDao;
    private final ProductRepository productDao;
    private final CartItemRepository cartItemDao;
    private final CartRepository cartDao;

    public CartController(UserRepository userDao,
                          CartItemRepository cartItemDao,
                          ProductRepository productDao,
                          CartRepository cartDao) {

        this.userDao = userDao;
        this.cartItemDao = cartItemDao;
        this.productDao = productDao;
        this.cartDao = cartDao;
    }

    @GetMapping("/cart")
    public String showShoppingCart(Model model) {

        User user = userDao.findUserById(1);


//        model.addAttribute("cartItems", );

//        System.out.println("cartDao.findCartByCustomerId(user.getId()) = " + cartDao.findCartByCustomerId(user.getId()));

        return "cart";
    }

    @PostMapping("/addToCart")
    public String saveCartItem(@ModelAttribute CartItem cartItem,
                               @RequestParam(name = "productId") long productId,
                               @RequestParam(name = "productQuantity") long quantity,
                               Model model) {

        User customer = new User();
        Cart cart = new Cart();
        ArrayList<CartItem> cartItems = new ArrayList<>();

        cart.setCustomer(userDao.findUserById(1));
        cart.setCartItems(cartItems);
        cartDao.save(cart);

        cartItem.setProduct(productDao.findProductById(productId));
        cartItem.setCart(cart);

        cartItem.setProductQuantity(quantity);

        cartItemDao.save(cartItem);
        cartItems.add(cartItem);

        cart.setCartItems(cartItems);



//        model.addAttribute("cartItem", );

        return "redirect:/cart";
    }

//    @PostMapping("/addToCart")
//    public String createCartItem(@RequestParam(name = "productId") long productId,
//                                 @RequestParam(name = "cartItemQuantity") long quantity,
//                                 Model model) {
//
//        Cart cart = new Cart();
//        CartItem cartItem = new CartItem();
//        cartItem.setProduct(productDao.findProductById(productId));
//        cartItem.setQuantity(cartItem.getQuantity(quantity));
//        cartItemDao.save(cartItem);
//
//        cart.setCartItem(cartItem);
//        cartDao.save(cart);
//
//
////        cartItem.setCarts();
////        Product product = productDao.findProductById(productId);
////        User customer = userDao.findUserById(1);
////
////
////        cart.setCustomer(cartDao.findCartByCustomerId(customer.getId()));
////        cartItem.setProduct(product);
////
////        cart.setCartItems();
////
//////        List<CartItem> cartItems = cartItemDao.findAllCartItemsByCartId();
////
////
//
//
//
//        return "cart";
//    }

}
