package com.aura.training.dashboard.service;

import com.aura.training.dashboard.entity.UserOrder;

import java.util.Date;
import java.util.List;

public interface UserOrderService {
    public List<UserOrder> getUserOrders(int uid, String start, String end);
}
