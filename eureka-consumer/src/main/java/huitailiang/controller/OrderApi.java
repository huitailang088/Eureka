package huitailiang.controller;

import huitailiang.pojo.Order;
import huitailiang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderApi {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Order getOrder(@PathVariable String id){
        return orderService.getOrderById(id);
    }
}
