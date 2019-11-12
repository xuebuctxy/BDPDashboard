package com.aura.training.dashboard.service;

import com.aura.training.dashboard.entity.UserOrder;
import com.aura.training.dashboard.utils.HBasePool;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.PageFilter;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service("userOrderService")
public class UserOrderServiceImpl implements UserOrderService{
    public List<UserOrder> getUserOrders(int uid, String start, String end) {
//        Configuration conf = HBaseConfiguration.create();
//        conf.set("hbase.zookeeper.quorum", "hadoopnode");
//        conf.set("zookeeper.znode.parent", "/hbase");

        Connection connection = null;
        List<UserOrder> rtn  = new ArrayList();
        try {
//            connection = ConnectionFactory.createConnection(conf);
            connection = HBasePool.getConn();

            Table table = connection.getTable(TableName.valueOf("user_order"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Scan scan = new Scan();
            scan.setFilter(new PrefixFilter(Bytes.toBytes(uid+"-")));
            if(start!=null && !"".equals(start)) {
                scan.setStartRow(Bytes.toBytes(uid + "-" + start));
            }
            if(end!=null && !"".equals(end)){
                scan.setStopRow(Bytes.toBytes(uid+"-"+end));
            }

            scan.setCaching(100);
            ResultScanner results = table.getScanner(scan);

            for (Result result : results) {
                UserOrder vo = new UserOrder();
                String uidVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("uid")));
                String ageVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("age")));
                String sexVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("sex")));
                String active_dateVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("active_date")));
                String limitsVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("limits")));
                String buy_timeVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("buy_time")));
                String priceVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("price")));
                String qtyVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("qty")));
                String cate_idVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("cate_id")));
                String discountVal = new String(result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("discount")));

                try{
                    vo.setUid(Integer.parseInt(uidVal));
                    vo.setAge(Integer.parseInt(ageVal));
                    vo.setSex(sexVal);
                    vo.setActive_date(sdf.parse(active_dateVal));
                    vo.setLimits(Integer.parseInt(limitsVal));
                    vo.setBuy_time(sdf.parse(buy_timeVal));
                    vo.setPrice(Double.parseDouble(priceVal));
                    vo.setQty(Integer.parseInt(qtyVal));
                    vo.setCate_id(Integer.parseInt(cate_idVal));
                    vo.setDiscount(Double.parseDouble(discountVal));
                    rtn.add(vo);
                }catch (ParseException e){
                    //ignore
                }
            }
        }catch (IOException e){
            Logger.getLogger("").info(e.getMessage());
        }finally {
//            try {
//                if(connection!=null)
//                    connection.close();
//            }catch (IOException e){
//
//            }
        }
        return rtn;
    }
}
