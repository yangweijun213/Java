package com.jun.OneToMany;

import java.util.HashSet;
import java.util.Set;

/*
 * 学生类
 */
public class Student implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private int sid;
    
    private String sname;
    private String sex;

    // Constructors

    /** default constructor */
    public Student() {
    }

    /** minimal constructor */
    public Student(int sid) {
        this.sid = sid;
    }

    /** full constructor */
    public Student(int sid, String sname, String sex ) {
    
        this.sid = sid;

        this.sname = sname;
        this.sex = sex;
    }

    // Property accessors

    public int getSid() {
        return this.sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    

    public String getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}