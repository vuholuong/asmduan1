/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author THANH VINH
 */
public class JdbcHelper {
    private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://localhost:1433;databaseName=QLTHUVIEN;encrypt=true;trustServerCertificate=true;";
    private static String username = "sa";
    private static String password = "vinh512005";
    static{
        try{
            Class.forName(driver);       
        }catch(ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException{
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement pstmt = null;
        if(sql.trim().startsWith("{")){
            pstmt = connection.prepareCall(sql);//PROC
        }else{
            pstmt = connection.prepareStatement(sql);//SQL
        }
        for(int i=0;i<args.length;i++){
            pstmt.setObject(i+1,args[i]);
        }
        return pstmt;
    }
    public static int update(String sql, Object...args){
        try{
            PreparedStatement pstmt = getStmt(sql, args);
            try{
                return pstmt.executeUpdate();
            }
            finally{
                pstmt.getConnection().close();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static ResultSet query(String sql, Object...args){
        try {
            PreparedStatement pstmt = getStmt(sql, args);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Object value(String sql, Object...args){
        try{
            ResultSet rs = query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }
    
}
