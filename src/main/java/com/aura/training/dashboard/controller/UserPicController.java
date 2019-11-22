package com.aura.training.dashboard.controller;

import com.aura.training.dashboard.entity.UserOrder;
import com.aura.training.dashboard.entity.UserPic;
import com.aura.training.dashboard.service.UserOrderService;
import com.aura.training.dashboard.service.UserPicService;
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
public class UserPicController {
    @Autowired
    private UserPicService userpicService;

    @RequestMapping("/user-pic/search")
    public List<UserPic> search(@RequestParam("uid") int uid){

        return userpicService.getUserPic(uid);
    }
}
