package org.example.heima.orderservice.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.heima.orderservice.entity.Order;

// Sep 9, 2021
public interface OrderMapper {

    @Select("select * from tb_order where id = #{id}")
    Order getById(@Param("id") Long id);
}
