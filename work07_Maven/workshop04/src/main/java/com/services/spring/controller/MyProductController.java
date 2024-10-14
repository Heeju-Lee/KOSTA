package com.services.spring.controller;

import com.services.spring.domain.MyProduct;
import com.services.spring.service.MyProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyProductController {

    @Autowired
    private MyProductService myProductService;

    @RequestMapping("/addProduct.do")
    public ModelAndView addProduct(MyProduct myProduct) {
        myProductService.addProduct(myProduct);
        return new ModelAndView("result", "myProduct", myProduct);
    };

    @RequestMapping("/find.do")
    public ModelAndView find(String searchType, String value) {
        List<MyProduct> list = new ArrayList();

        if(searchType.equals("name")) {
            list = myProductService.findProductByName(value);
        }else if(searchType.equals("maker")) {
            list = myProductService.findProductByMaker(value);
        }else list =myProductService.findProducts();

        return new ModelAndView("result", "productList", list);
    };
}
