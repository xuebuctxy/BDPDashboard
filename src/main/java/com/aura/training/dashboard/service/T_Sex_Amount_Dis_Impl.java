package com.aura.training.dashboard.service;
import com.aura.training.dashboard.entity.T_Sex_Amount_Dis;
import com.aura.training.dashboard.utils.MysqlPool;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service("T_Sex_Amount_Dis_Service")
public class T_Sex_Amount_Dis_Impl implements T_Sex_Amount_Dis_Service {
    @Override
    public List<T_Sex_Amount_Dis> getTAgePriceDis(int type, String start, String end) {
        Connection connection = null;
        List<T_Sex_Amount_Dis> list  = new ArrayList();
        try{
            connection= MysqlPool.getCon();
            PreparedStatement pstm =connection.prepareStatement("select * from t_sex_amount_dis where date_id between ? and ? and type=? order by sex ");
            if(start==null || "".equals(start)) {
                start="2016-08-03";
            }
            if(end==null || "".equals(end)) {
                end="2016-08-10";
            }
            pstm.setString(1, start);
            pstm.setString(2,end);
            pstm.setInt(3,1);
            ResultSet rs= pstm.executeQuery();
            while (rs.next()){
                T_Sex_Amount_Dis model=new T_Sex_Amount_Dis();
                model.setDate_id(rs.getDate(1));
                model.setSex(rs.getInt(2));
                model.setLoan_amount(rs.getDouble(3));
                model.setType(rs.getInt(4));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
