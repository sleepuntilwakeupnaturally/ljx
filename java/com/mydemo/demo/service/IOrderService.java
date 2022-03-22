package com.mydemo.demo.service;

import com.mydemo.demo.entity.Order;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IOrderService {

    /**
     * 添加订单
     * @param order
     * @return
     */
    Integer InsertOrder(Order order);

    List<Order> selectOrderByUid(Integer uid);

    List<Order> selectOrder();

    Integer deleteOrderByPid(Integer pid);

}
