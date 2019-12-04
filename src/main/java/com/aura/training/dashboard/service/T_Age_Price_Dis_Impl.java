package com.aura.training.dashboard.service;

import com.aura.training.dashboard.entity.T_Age_Price_Dis;
import com.aura.training.dashboard.utils.MysqlPool;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service("T_Age_Price_Dis_Service")
public class T_Age_Price_Dis_Impl implements T_Age_Price_Dis_Service{

    @Override
    public List<T_Age_Price_Dis> getTAgePriceDis(String start, String end) {
        Connection connection = null;
        List<T_Age_Price_Dis> list  = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try{
            connection= MysqlPool.getCon();
            PreparedStatement pstm =connection.prepareStatement("select * from t_age_price_dis where date_id between ? and ? order by age");
            if(start==null || "".equals(start)) {
                start="2016-08-03";
            }
            if(end==null || "".equals(end)) {
                end="2016-08-10";
            }
            pstm.setString(1, sdf.parse(start).toString());
            pstm.setString(2,sdf.parse(end).toString());

            ResultSet rs= pstm.executeQuery();
            while (rs.next()){
                T_Age_Price_Dis model=new T_Age_Price_Dis();
                model.setDate_id(rs.getDate(1));
                model.setAge(rs.getInt(2));
                model.setPrice(rs.getDouble(3));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
