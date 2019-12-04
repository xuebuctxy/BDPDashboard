package com.aura.training.dashboard.service;

import com.aura.training.dashboard.entity.T_Sex_Amount_Dis;

import java.util.List;

public interface T_Sex_Amount_Dis_Service {
    public List<T_Sex_Amount_Dis> getTAgePriceDis(int type,String start, String end);

}
