package huitailiang.controller;

import huitailiang.pojo.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class Api {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Product> getProduct(){
        List<Product> list = new ArrayList<>();
        list.add(new Product(1, "test01", 12));
        list.add(new Product(2, "test02", 13));
        list.add(new Product(3, "test03", 14));
        return list;
    }
}
