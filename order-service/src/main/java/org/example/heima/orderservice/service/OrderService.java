package org.example.heima.orderservice.service;

import lombok.RequiredArgsConstructor;
import org.example.heima.feignapi.client.UserClient;
import org.example.heima.feignapi.entity.User;
import org.example.heima.orderservice.entity.Order;
import org.example.heima.orderservice.mapper.OrderMapper;
import org.springframework.stereotype.Service;

// Sep 9, 2021
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper mapper;

    // 使用 Feign client 远程调用
    private final UserClient client;

    // 使用 RestTemplate 调用 User 服务的 RESTful 接口获得相应的用户信息，未启用服务注册与发现
    public Order getById(Long id) {
        Order result = mapper.getById(id);          // 数据库表中查得，只有用户 ID，不含用户数据
        User user = client.getById(result.getUserId());
        result.setUser(user);

        return result;
    }
}
