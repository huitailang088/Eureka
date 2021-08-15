package huitailiang.service.impl;

import huitailiang.pojo.Order;
import huitailiang.pojo.Product;
import huitailiang.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order getOrderById(String id) {
        Order order = new Order(1,"order", new Product(11, "order", 11));
        List<ServiceInstance> list = discoveryClient.getInstances("service-provider");

        ServiceInstance serviceInstance = list.get(0);

        String host  = serviceInstance.getHost();
        int port = serviceInstance.getPort();

        String url = "http://" + host + ":" + port + "/product/list";

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Product>>(){});

        List<Product> listProduct = responseEntity.getBody();

        for (Product p: listProduct
             ) {
            if (p.id == Integer.valueOf(id)) {
                order.setProduct(p);
            }
        }

        return order;
    }
}
