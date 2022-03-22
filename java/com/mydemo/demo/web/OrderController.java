package com.mydemo.demo.web;


import com.mydemo.demo.entity.Order;
import com.mydemo.demo.entity.Users;
import com.mydemo.demo.service.IOrderService;
import com.mydemo.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("addorder")
    public JsonResult<Order> addOrder(Order order, HttpSession session){
        order.setUsername(getUsernameFromSession(session));
        order.setUid(getIdFromSession(session));
        orderService.InsertOrder(order);
        return new JsonResult<Order>(OK);
    }

    @RequestMapping("show_order")
    public JsonResult<List<Order>> showOrder(HttpSession session){
        List<Order> data = orderService.selectOrderByUid(getIdFromSession(session));
        return new JsonResult<List<Order>>(OK, data);
    }

    @RequestMapping("{pid}/delete")
    public JsonResult<Void> delete(@PathVariable("pid") Integer pid, HttpSession session){
        orderService.deleteOrderByPid(pid);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("show_allOrder")
    public JsonResult<List<Order>> selectAllUsers(){
        List<Order> data = orderService.selectOrder();
        return new JsonResult<List<Order>>(OK, data);
    }

}
