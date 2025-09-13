/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hnl.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luyen
 */
public class JdbcConnector {
    private static JdbcConnector instance;
    private final Connection conn;
    static 
    {
        try {
            //nap drive
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public JdbcConnector() throws SQLException {
        this.conn=DriverManager.getConnection("jdbc:mysql://localhost/quizapp", "root","Admin@123");
    }
    public static JdbcConnector GetInstance() throws SQLException{
        if(instance==null){
            instance=new JdbcConnector();
        }
        return instance;
    }
    public Connection connect(){
        return this.conn;
    }
    public void close() throws SQLException{
        this.conn.close();
    }
}
