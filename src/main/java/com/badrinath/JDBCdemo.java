package com.badrinath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCdemo {
    public static void main(String[] args){

        try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:;INIT=RUNSCRIPT FROM 'classpath:users.sql';")){
            System.out.println("connection.isValid(0) =" + connection.isValid(0));
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
