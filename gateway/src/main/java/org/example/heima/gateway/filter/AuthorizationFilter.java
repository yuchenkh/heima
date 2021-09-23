package org.example.heima.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Sep 18, 2021
 * 全局过滤器可以实现自定义过滤机制，对所有路由都生效。
 * 这里我们定义一个根据请求参数 user 来完成认证登录的过滤器。
 */
@Component
@Order(-1)
public class AuthorizationFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取请求的 query parameters
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        // 获取 user 参数
        String user = queryParams.getFirst("user");
        // 判断
        if ("admin".equals(user)) {
            return chain.filter(exchange);      // 放行，进入下一个 filter
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);      // 设定相应的状态码，提示未认证
            return exchange.getResponse().setComplete();        // 拦截
        }
    }
}
