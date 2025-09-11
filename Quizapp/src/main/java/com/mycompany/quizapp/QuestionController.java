/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.quizapp;

import com.hnl.pojo.Category;
import com.hnl.utils.JdbcConnector;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Luyen
 */
public class QuestionController implements Initializable {
    @FXML private ComboBox<Category> cbCat; 
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //nap Drive
            
            try ( //mo ket noi
                    Connection conn=JdbcConnector.GetInstance().connect()) {
                //truy van du lieu
                Statement stm = conn.createStatement();
                ResultSet rs=stm.executeQuery("SELECT * FROM category");
                List<Category> Cates=new ArrayList<>();
                while(rs.next()){
                    
                    int id=rs.getInt("id");
                    String name=rs.getString("name");
                    Category c=new Category(id,name);
                    Cates.add(c );
                }
                //dong
                conn.close();
                this.cbCat.setItems(FXCollections.observableArrayList(Cates));
            }
        } catch ( SQLException ex) {
            Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
