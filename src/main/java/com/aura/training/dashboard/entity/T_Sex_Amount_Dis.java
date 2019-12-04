package com.aura.training.dashboard.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data

public class T_Sex_Amount_Dis {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date_id;
    private int sex;
    private double loan_amount;
    private int type;
    public Date getDate_id() {
        return date_id;
    }

    public int getSex() {
        return sex;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public int getType() {
        return type;
    }

    public void setDate_id(Date date_id) {
        this.date_id = date_id;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public void setType(int type) {
        this.type = type;
    }


}
