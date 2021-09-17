package org.example.heima.orderservice.client;

import org.example.heima.orderservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Sep 17, 2021
// 远程调用用户服务的客户端
@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/user/get/{id}")
    User getById(@PathVariable("id") Long id);
}
