package com.badrinath;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCdemo {
    public static void main(String[] args) {

        DataSource dataSource = createDataSource();

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("connection.isValid(0) =" + connection.isValid(0));

            //select
            PreparedStatement ps = connection
                    .prepareStatement("SELECT * FROM users where name = ?");
            ps.setString(1, "Badri");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                System.out.println(result.getInt("id") + "-" + result.getString("name"));
            }


            //insert
            PreparedStatement insertPs = connection
                    .prepareStatement("INSERT INTO users (name) values (?)");
            insertPs.setString(1, "bablu");
            int insertCount = insertPs.executeUpdate();
            System.out.println("insertCount: " + insertCount);


            //update
            PreparedStatement updatePs = connection
                    .prepareStatement("update users set name = ? where name = ?");
            updatePs.setString(1, "badri");
            updatePs.setString(2, "bablu");
            int updateCount = updatePs.getUpdateCount();
            System.out.println("updateCount: " + updateCount);


            //delete
            PreparedStatement deletePs = connection
                    .prepareStatement("delete from users where name = ?");
            deletePs.setString(1, "badri");
            int deleteCount = deletePs.getUpdateCount();
            System.out.println("deleteCount: " + deleteCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        private static DataSource createDataSource(){
            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:users.sql'");
            ds.setUsername("sa");
            ds.setPassword("");
            return ds;
        }

    }

