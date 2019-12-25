package com.antiy.teleportboot.sqlite;

import com.antiy.teleportboot.teleport.pojo.dto.ACCInfoDto;

import java.sql.*;
import java.util.List;

/**
 * Author: Liuchong
 * Description:
 * date: 2019/12/17 10:54
 */
public class OpSqliteDB {
    private static final String Class_Name = "org.sqlite.JDBC";
//        private static final String DB_URL = "jdbc:sqlite:C:\\Users\\liuchong\\Desktop\\teleport.db";
    private static final String DB_URL = "jdbc:sqlite:/usr/local/teleport/data/db/teleport.db";

    public static void main(String args[]) throws SQLException {
        String sql = "select id ,password,pri_key AS priKey,state, host_id AS hostId, " +
                "protocol_type AS protocolType,protocol_port AS protocolPort, auth_type AS authType, username,username_prompt AS usernamePrompt," +
                "password_prompt AS passwordPrompt from tp_acc where id = ?";
        Connection connection = null;
        try {
            connection = OpSqliteDB.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "4");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<ACCInfoDto> reflectObject = ResultUtil.getReflectObject(resultSet, ACCInfoDto.class);
            System.out.println(reflectObject);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert connection != null;
            connection.close();
        }
    }

    // 创建Sqlite数据库连接
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName(Class_Name);
        return DriverManager.getConnection(DB_URL);
    }

    public static void func1(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        // 执行查询语句
        ResultSet rs = statement.executeQuery("select * from tp_host where id = 4");
        while (rs.next()) {
            String router = rs.getString("router_port");
            String username = rs.getString("router_ip");
            System.out.println("router = " + router + "  " + "router_ip = " + username);
        }
    }

}
