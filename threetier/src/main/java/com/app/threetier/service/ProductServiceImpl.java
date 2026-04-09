package com.app.threetier.service;

import com.app.threetier.repository.ProductDAO;
import com.app.threetier.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    public void insertProduct(ProductVO productVO) {
        productDAO.save(productVO);
    }
}
