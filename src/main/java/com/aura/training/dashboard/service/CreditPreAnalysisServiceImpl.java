package com.aura.training.dashboard.service;

import com.aura.training.dashboard.utils.JdbcUtil;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoopuser on 11/20/19.
 */
@Service(value = "creditPreAnalysisService")
public class CreditPreAnalysisServiceImpl implements CreditPreAnalysisService {

    @Override
    public List<String> getClickCountResult() {
        List<String> clickList=new ArrayList<String>();
        Connection connection= JdbcUtil.getConnection();
        ResultSet rs=null;
        try {
            rs=JdbcUtil.executeQuery(connection,"select result_key,result_value from streaming_result where result_key like 'click%';");
            while(rs.next()){
                clickList.add(rs.getString(1).substring(6)+"#"+rs.getString(2));
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.closeConnection(connection);

        return clickList;
    }

    @Override
    public List<String> getConsumeSumResult() {
        List<String> consumeList=new ArrayList<String>();
        Connection connection= JdbcUtil.getConnection();
        ResultSet rs=null;
        try {
            rs=JdbcUtil.executeQuery(connection,"select result_key,result_value from streaming_result where result_key like 'buy%';");
            while(rs.next()){
                consumeList.add(rs.getString(1).substring(4)+"#"+rs.getBigDecimal(2).setScale(2, RoundingMode.HALF_UP));
            }
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.closeConnection(connection);

        return consumeList;
    }
}
