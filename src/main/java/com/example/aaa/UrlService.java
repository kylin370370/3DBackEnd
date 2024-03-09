package com.example.aaa;

import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UrlService {
    private Connection conn;

    public UrlService() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://rm-uf66v0c512w048jzp1o.mysql.rds.aliyuncs.com:3306/stone_wall?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false",
                    "gaoyu", "gaoyu123!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ImageInfo> getImageInfo(String sourceImageId) {
        List<ImageInfo> imageInfoList = new ArrayList<>();
        try {
            String query = "SELECT segment_block_image_path, segment_block_binary_image_path, has_crack, "
                    + "crack_area, crack_length, crack_average_width, crack_max_width "
                    + "FROM result WHERE source_image_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, sourceImageId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                boolean hasCrack = rs.getBoolean("has_crack");
                ImageInfo imageInfo = new ImageInfo(
                        rs.getString("segment_block_image_path"),
                        rs.getString("segment_block_binary_image_path"),
                        hasCrack,
                        hasCrack ? rs.getDouble("crack_area") : null,
                        hasCrack ? rs.getDouble("crack_length") : null,
                        hasCrack ? rs.getDouble("crack_average_width") : null,
                        hasCrack ? rs.getString("crack_max_width") : null
                );
                imageInfoList.add(imageInfo);
            }
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return imageInfoList;
    }
}
