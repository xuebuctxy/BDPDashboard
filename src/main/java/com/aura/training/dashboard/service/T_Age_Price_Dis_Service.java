package com.aura.training.dashboard.service;

import com.aura.training.dashboard.entity.T_Age_Price_Dis;

import java.util.List;

public interface T_Age_Price_Dis_Service {
    public List<T_Age_Price_Dis> getTAgePriceDis(String start, String end);

}
