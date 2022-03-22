package com.mydemo.demo.web;


import com.mydemo.demo.entity.Product;
import com.mydemo.demo.entity.Users;
import com.mydemo.demo.service.IProductService;
import com.mydemo.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("product")
@RestController
public class ProductController extends BaseController {

    @Autowired
    private IProductService productService;

    @RequestMapping("show_product")
    public JsonResult<List<Product>> showProduct(){
        List<Product> data = productService.showProduct();

        return new JsonResult<List<Product>>(OK, data);

    }

}
