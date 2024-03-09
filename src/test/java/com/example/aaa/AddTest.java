package com.example.aaa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
public class AddTest {
    @Test
    void adddd() throws SQLException {

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
        ResultSet rs = stmt.executeQuery("SELECT segment_block_image_path FROM result WHERE source_image_id = 'C_d_020'");
        while (rs.next()) {
            String segmentBlockImagePath = rs.getString("segment_block_image_path");
            System.out.println("对应的segment_block_image_path: " + segmentBlockImagePath);
        }

//        ResultSet rs = stmt.executeQuery("select * from result");
//        System.out.println("幕墙块");
//        while (rs.next()) {
//            System.out.println(rs.getString("source_image_id"));
//        }
//        // 执行SQL语句,查
//   stmt.execute("insert into user values('2','a','z')");
//        System.out.println("add successful");

//        rs.close();
        stmt.close();
        conn.close();
    }
    public boolean addUser(String nm,String tel){
return true;
    }
}
