package com.aura.training.dashboard.controller;


import com.aura.training.dashboard.entity.T_Age_Price_Dis;
import com.aura.training.dashboard.service.T_Age_Price_Dis_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
public class AgePriceDisController {
    @Autowired
    public T_Age_Price_Dis_Service agePriceDisservice;

    @RequestMapping("/age_Price_Dis")
    public List<T_Age_Price_Dis> getTAgePriceDis(){
        return agePriceDisservice.getTAgePriceDis("2016-08-03","2016-08-10");
    }
}
