package com.mydemo.demo.service.impl;

import com.mydemo.demo.entity.Product;
import com.mydemo.demo.mapper.ProductMapper;
import com.mydemo.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class ProductImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> showProduct() {
        return productMapper.selectProduct();
    }
}
