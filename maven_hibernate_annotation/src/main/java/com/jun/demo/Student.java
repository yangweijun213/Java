package com.jun.demo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity 
public class Student implements java.io.Serializable {
	
	private static final long serialVersionUID = -1546206493725028472L;
	private int StuId; 
    private StudentIDCard CardId;
    private String StuName; 
    private String StuAge; 

    
    public Student() {
    }


    public Student(String StuName, String StuAge,
    		StudentIDCard CardId) {
        this.StuName = StuName;
        this.StuAge = StuAge;
        this.CardId = CardId;
    }
    
    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false)
    
    public Integer getStuId() { 
        return this.StuId; 
    } 
    
    public void setStuId(Integer StuId) {
        this.StuId = StuId;
    }
    
   
    public String getStuName() {
        return this.StuName;
    }

    public void setStuName(String StuName) {
        this.StuName = StuName;
    }
    
    public String getStuAge() {
        return this.StuAge;
    }

    public void setStuAge(String StuAge) {
        this.StuAge = StuAge;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CARDID")
    
    public StudentIDCard getCardId() { 
        return this.CardId; 
    } 
    
    public void setCardId(StudentIDCard CardId) {
        this.CardId = CardId;
    }

}
