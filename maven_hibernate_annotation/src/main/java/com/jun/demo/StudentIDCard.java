package com.jun.demo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STUDENTIDCARD", catalog = "SingleUserPerformanceTest")
public class StudentIDCard implements java.io.Serializable{

	private static final long serialVersionUID = 3240281547213597385L;
	private int Cardid;
	private String CardKinds;
	private Date DatePublished;
	private Set<Student> students = new HashSet<Student>(0);
	
	 public StudentIDCard() {
	    }

	    public StudentIDCard(String CardKinds, Date DatePublished) {
	        this.CardKinds = CardKinds;
	        this.DatePublished = DatePublished;
	    }

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false)
	
	public Integer getCardid() {
		return this.Cardid;
	}
	
	public void setCardid(Integer Cardid) {
        this.Cardid = Cardid;
    }
	
	public String getCardKinds() {
        return this.CardKinds;
    }

    public void setCardKinds(String CardKinds) {
        this.CardKinds = CardKinds;
    }
    
 
    public Date getDatePublished() {
        return this.DatePublished;
    }

    public void setDatePublished(Date DatePublished) {
        this.DatePublished = DatePublished;
    }
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "STUDENTIDCARD")
    public Set<Student> getStudent() {
    	return this.students;
    }

    public void setProducts(Set<Student> students) {
    	this.students = students;
    }
}
