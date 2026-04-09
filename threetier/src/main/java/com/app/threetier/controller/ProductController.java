package com.app.threetier.controller;

import com.app.threetier.service.ProductService;
import com.app.threetier.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/products/*")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product")
    public void goToProduct(ProductVO productVO) {;}

    @PostMapping("/insert")
    public RedirectView insertProduct(ProductVO productVO) {
        //log.info("productVO: {}", productVO);
        productService.insertProduct(productVO);
        return new RedirectView("/products/product");
    }
}
