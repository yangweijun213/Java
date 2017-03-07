package com.jun.OneToMany;

import java.util.HashSet;
import java.util.Set;

public class Grade implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private int gid;
    private String gname;
    private String gdesc;
    private Set<Student> students = new HashSet<Student> ();

    // Constructors

    /** default constructor */
    public Grade() {
    }

    /** minimal constructor */
    public Grade(int gid) {
        this.gid = gid;
    }

    /** full constructor */
    public Grade(int gid, String gname, String gdesc, Set<Student> students) {
        this.gid = gid;
        this.gname = gname;
        this.gdesc = gdesc;
        this.students = students;
    }

    // Property accessors

    public int getGid() {
        return this.gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return this.gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGdesc() {
        return this.gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}
