package com.aura.training.dashboard.controller;

import com.aura.training.dashboard.entity.T_Sex_Amount_Dis;
import com.aura.training.dashboard.service.T_Sex_Amount_Dis_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
@EnableAutoConfiguration
public class SexAmountDisController {
    @Autowired
    public T_Sex_Amount_Dis_Service sexAmountDisService;

    public List<T_Sex_Amount_Dis> getTSexAmountDis(){
        return sexAmountDisService.getTAgePriceDis(1,"2016-08-03","2016-08-10");
    }

    public List<T_Sex_Amount_Dis> getTSexAmountDis_w(){
        return sexAmountDisService.getTAgePriceDis(2,"31","48");
    }

    public List<T_Sex_Amount_Dis> getTSexAmountDis_m(){
        return sexAmountDisService.getTAgePriceDis(3,"2016-08","2016-11");
    }
}
