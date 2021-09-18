package org.example.heima.feignapi.client;

import org.example.heima.feignapi.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Sep 18, 2021
// 远程调用用户服务的客户端
@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/user/get/{id}")
    User getById(@PathVariable("id") Long id);
}
