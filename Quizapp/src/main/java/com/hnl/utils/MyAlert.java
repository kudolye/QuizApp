/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hnl.utils;

import javafx.scene.control.Alert;

/**
 *
 * @author Luyen
 */
public class MyAlert {
    private static MyAlert instance;// mau singleton, cho MyAlert la mot object duy nhat khong tao them
    private final Alert alert;
    private MyAlert(){// de ben ngoai k new them cai moi
        alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Quiz App");
    }
    public static MyAlert getInstance(){
        if(instance==null){
            instance=new MyAlert();//neu chua co tao cai moi
        }
        return instance;
    }
    public void show(String mgs){
        this.alert.setContentText(mgs);
        this.alert.showAndWait();
    }
}
