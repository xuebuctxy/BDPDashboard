package com.aura.training.dashboard.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HBasePool {
    private static Configuration conf = null;
    // 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
    private static ExecutorService executor = null;
    private static Connection conn = null;

    static {
        try {
            conf = HBaseConfiguration.create();
            conf.set("hbase.zookeeper.quorum", "hadoopnode");
            conf.set("zookeeper.znode.parent", "/hbase");
            executor = Executors.newFixedThreadPool(10);
            conn = ConnectionFactory.createConnection(conf, executor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        return conn;
    }
}
