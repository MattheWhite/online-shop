package com.codecool.shop.controller;


import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.dto.ProductId;
import com.codecool.shop.service.CartService;
import com.google.gson.Gson;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartDao cart = CartDaoMem.getInstance();
        CartService cartService = new CartService();
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("products", cartService.getAllProducts());
        engine.process("product/cart.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader in = req.getReader();
        ProductId productId = new Gson().fromJson(in.readLine(), ProductId.class);
        CartService cartService = new CartService();
        cartService.addProductToCart(productId.getId());

        // get JSON - then to service
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader in = req.getReader();
        ProductId productId = new Gson().fromJson(in.readLine(), ProductId.class);
        CartService cartService = new CartService();
        cartService.removeProductFromCart(productId.getId());
    }
}
