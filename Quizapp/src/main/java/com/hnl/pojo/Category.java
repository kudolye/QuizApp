/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hnl.pojo;


import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Luyen
 */
@Getter
@Setter

public class Category {
    private int id;
    private String name;

    public Category(int id,String s) {
        this.id=id;
        this.name=s;
    }

    @Override
    public String toString() {
        return this.name; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
        
    
    
}
