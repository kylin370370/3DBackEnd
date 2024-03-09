package com.example.aaa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
class AaaApplicationTests {

    @Test
    void contextLoads() throws SQLException {


        Connection conn = null;
        // 加载驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        long start =System.currentTimeMillis();

        // 建立连接
        conn = DriverManager.getConnection("jdbc:mysql://rm-uf66v0c512w048jzp1o.mysql.rds.aliyuncs.com:3306/stone_wall?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false",
                "gaoyu", "gaoyu123!");
        long end = System.currentTimeMillis();
        System.out.println(conn);
        System.out.println("建立连接耗时： " + (end - start) + "ms 毫秒");
        System.out.println("查操作");
        // 创建Statement对象
        Statement stmt = conn.createStatement();

        // 执行SQL语句,查
        ResultSet rs = stmt.executeQuery("select * from result");
        System.out.println("幕墙块");
        while (rs.next()) {
            System.out.println(rs.getString("source_image_id"));
        }

        rs.close();
        stmt.close();
        conn.close();



    }

}
