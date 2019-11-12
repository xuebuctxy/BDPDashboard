package com.aura.training.dashboard.controller;

import com.aura.training.dashboard.entity.UserOrder;
import com.aura.training.dashboard.service.UserOrderService;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Logger;

@CrossOrigin
@RestController
@EnableAutoConfiguration
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping("/user-order/search")
    public List<UserOrder> search(@RequestParam("uid") int uid,
                                  @RequestParam(value = "start",required = false) String start,
                                  @RequestParam(value = "end",required = false) String end){

        return userOrderService.getUserOrders(uid,start, end);
    }
}
