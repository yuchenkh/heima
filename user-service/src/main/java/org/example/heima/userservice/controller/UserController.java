package org.example.heima.userservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.heima.userservice.config.PatternProperties;
import org.example.heima.userservice.entity.User;
import org.example.heima.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Sep 8, 2021
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    private final PatternProperties properties;

    @GetMapping("/prop")
    public PatternProperties getProp(){
        return properties;
    }

    @GetMapping("/now")
    public String time(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateFormat()));
    }

    /**
     * 路径： /user/2
     *
     * @param id 用户 ID
     * @param truth 该参数与 Request header {@code truth} 绑定
     * @return 用户实体
     */
    @GetMapping("/get/{id}")
    public User getById(@PathVariable("id") Long id,
                        @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println("Truth: " + truth);
        return userService.getById(id);
    }
}
