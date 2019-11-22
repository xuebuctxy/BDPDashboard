package com.aura.training.dashboard.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class UserPic {

    private int uid;
    private int age;
    private String sex;
    private int active_days;


    private int dayordercount;
    private int monthcount;
    private  int threemonthcount;

    private int dayloancount;
    private int monthloancount;
    private  int threemonthloancount;

}
