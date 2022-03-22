package com.mydemo.demo.service.impl;

import com.mydemo.demo.entity.Order;
import com.mydemo.demo.mapper.OrderMapper;
import com.mydemo.demo.service.IOrderService;
import com.mydemo.demo.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer InsertOrder(Order order) {

        int row = orderMapper.insert(order);
        return row;
    }

    @Override
    public List<Order> selectOrderByUid(Integer uid) {
        return orderMapper.SelectByUid(uid);
    }

    @Override
    public List<Order> selectOrder() {
        return orderMapper.selectAllOrder();
    }

    @Override
    public Integer deleteOrderByPid(Integer pid) {
        return orderMapper.DeleteOrderByPid(pid);
    }


}
