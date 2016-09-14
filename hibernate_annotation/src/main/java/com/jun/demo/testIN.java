package com.jun.demo;

import org.hibernate.Session;
import java.util.Date;
import com.jun.demo.HibernateUtil;
import com.jun.demo.Student;
import com.jun.demo.StudentIDCard;

public class testIN {   
	
	public static void main(String[] args) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
       session.beginTransaction(); 
 
       StudentIDCard sic = new StudentIDCard(); 
/*       sic.setKinds("primarySchool"); 
       sic.setDatePublished(new Date()); */
       session.save(sic); 
        
    Student s = new Student(); 
/*    s.setName("李四"); 
    s.setAge(0); 
    s.setCardId(sic); */
       session.save(s); 
 
       session.getTransaction().commit(); 
       HibernateUtil.getSessionFactory().close();     
       
	}
} 
