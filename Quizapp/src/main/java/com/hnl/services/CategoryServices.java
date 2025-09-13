/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hnl.services;

import com.hnl.pojo.Category;
import com.hnl.utils.JdbcConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luyen
 */
public class CategoryServices {

    public List<Category> GetCates() throws SQLException {
        //mo ket noi
        Connection conn = JdbcConnector.GetInstance().connect();

        //truy van du lieu
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM category");
        List<Category> Cates = new ArrayList<>();
        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            Category c = new Category(id, name);
            Cates.add(c);
        }
        return Cates;

    }

}
