package com.aura.training.dashboard.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserOrder {
//    private String key;
    private int uid;
    private int age;
    private String sex;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date active_date;
    private int limits;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date buy_time;
    private double price;
    private int qty;
    private int cate_id;
    private double discount;
}
