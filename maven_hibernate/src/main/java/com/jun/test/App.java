package com.jun.test;


import java.util.Date;
import org.hibernate.Session;
import com.jun.util.HibernateUtil;
import com.jun.demo.Dbuser;

/**
 * @author http://www.cnblogs.com/leiOOlei/p/3376155.html
 * 用Maven创建Hibernate项目
 *
 */
public class App {
	
	public static void main(String[] args) {
        System.out.println("Maven3 + Hibernate + Oracle11g");
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();
        Dbuser user = new Dbuser();
 
        user.setUserId(100);
        user.setUsername("leioolei");
        user.setCreatedBy("system");
        user.setCreatedDate(new Date());
 
        session.save(user);
        session.getTransaction().commit();
    }

}
