package com.app.threetier.repository;

import com.app.threetier.mapper.ProductMapper;
import com.app.threetier.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDAO {

    private final ProductMapper productMapper;

    public void save(ProductVO productVO) {
        productMapper.insert(productVO);
    }
}
