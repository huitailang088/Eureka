package huitailiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EurekaConsumer {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumer.class);
    }

    @Bean
    @LoadBalanced //负载均衡器 根据这个自动找服务发请求
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
