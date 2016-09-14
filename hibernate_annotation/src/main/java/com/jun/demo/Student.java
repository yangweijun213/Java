package com.jun.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity 
public class Student {
	
	private int id; 
    private String name; 
    private String age; 
    private StudentIDCard cardId;
    
    @Id 
    @GeneratedValue//可以定单独的自增序列，这共用一个 
    public int getId() { 
        return id; 
    } 
    @OneToOne//一对一的关系 
    @JoinColumn(name="card_Id")//指定外键名称是card_Id 
    public StudentIDCard getCardId() { 
        return cardId; 
    } 

}
