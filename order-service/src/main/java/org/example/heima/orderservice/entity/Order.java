package org.example.heima.orderservice.entity;

import lombok.Data;
import org.example.heima.feignapi.entity.User;

// Sep 9, 2021
@Data
public class Order {

    private Long id;

    private String name;

    private Long price;

    private Integer num;

    private Long userId;            // Entity 的驼峰命名和数据库表中的下划线命名是匹配不上的，得在配置文件中配置

    private User user;
}
