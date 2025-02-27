package org.youcode.product_service;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class TestController {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    public TestController(DiscoveryClient discoveryClient , RestClient.Builder restClientBuilder){
        this.discoveryClient = discoveryClient;
        this.restClient = restClientBuilder.build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        ServiceInstance serviceInstance = discoveryClient.getInstances("user-service").get(0);
        String res = restClient.get()
                .uri(serviceInstance.getUri() + "/la7ya" )
                .retrieve()
                .body(String.class);
        return new ResponseEntity<>(res , HttpStatus.OK);
    }
}
