package com.app.threetier.service;

import com.app.threetier.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @Test
    public void insertProductTest() {
        ProductVO productVO = new ProductVO();
        productVO.setProductName("name");
        productVO.setProductPrice(10000);
        productVO.setProductStock(1000);
        productVO.setProductBrand("brand");
        productService.insertProduct(productVO);
    }
}
