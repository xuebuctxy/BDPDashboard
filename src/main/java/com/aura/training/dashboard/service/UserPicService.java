package com.aura.training.dashboard.service;

import com.aura.training.dashboard.entity.UserOrder;
import com.aura.training.dashboard.entity.UserPic;
import com.aura.training.dashboard.utils.HBasePool;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.CellScanner;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.*;
@Service("userPicService")
public class UserPicService implements UserPicServiceInfo {

    @Override
    public List<UserPic> getUserPic(int uid) {
        Connection connection = null;
        List<UserPic> rtn  = new ArrayList();
        String temp =String.valueOf(uid) ;
        int t=temp.length();
        if(temp.length()<5)
        {
            for(int i=0;i<5-t;i++)
            {
                temp="0"+temp;

            }

        }
        try {

            connection = HBasePool.getConn();
//            HBaseAdmin  hBaseAdmin = (HBaseAdmin)connection.getAdmin();
//            Get get = new Get(Bytes.toBytes(temp));
//
//            Result wresults = table.get(get);
//            CellScanner cellScanner = wresults.cellScanner();
//            boolean flag = hBaseAdmin.tableExists("user");
            Table table = connection.getTable(TableName.valueOf("user"));
            Scan scan = new Scan();
            scan.setStartRow(Bytes.toBytes(temp ));
            scan.setFilter(new PrefixFilter(Bytes.toBytes(temp)));
            scan.setCaching(100);
            ResultScanner results = table.getScanner(scan);

            for (Result result : results) {
                UserPic vo = new UserPic();
                String uidVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("uid")));
                String ageVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("age")));
                String sexVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("sex")))=="1"?"女":"男";
                String active_daysVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("active_days")));
                String dayordercountVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("dayordercount")));
                String monthcountVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("monthcount")));
                String threemonthcountVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("threemonthcount")));
                String dayloancountVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("dayloancount")));
                String monthloancountVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("monthloancount")));
                String threemonthloancountVal = new String(result.getValue(Bytes.toBytes("userinfo"), Bytes.toBytes("threemonthloancount")));

                vo.setUid(Integer.parseInt(uidVal));
                vo.setAge(Integer.parseInt(ageVal));
                vo.setSex(sexVal);
                vo.setActive_days(Integer.parseInt(active_daysVal));
                vo.setDayordercount(Integer.parseInt(dayordercountVal));
                vo.setMonthcount(Integer.parseInt(monthcountVal));
                vo.setThreemonthcount(Integer.parseInt(threemonthcountVal));
                vo.setDayloancount(Integer.parseInt(dayloancountVal));
                vo.setMonthloancount(Integer.parseInt(monthloancountVal));
                vo.setThreemonthloancount(Integer.parseInt(threemonthloancountVal));
                rtn.add(vo);
            }
            results.close();
            table.close();
        }catch (IOException e){
            Logger.getLogger("").info(e.getMessage());
        }finally {

        }
        return rtn;
    }
}
