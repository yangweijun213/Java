package com.jun.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import java.util.Date;
import com.jun.demo.HibernateUtil;
import com.jun.demo.Student;
import com.jun.demo.StudentIDCard;

/**
 * @author http://www.cnblogs.com/hongten/archive/2011/07/20/java_hibernate_annotation.html
 *
 */
public class HibernateTest {   
	
	public static void main(String[] args) {
		
		HibernateTest test=new HibernateTest();
		test.add();
	}

	public void add(){
		Configuration config=new AnnotationConfiguration();
		config.configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		StudentIDCard stuCard = new StudentIDCard();
		stuCard.setCardKinds("stuentCard");
		stuCard.setDatePublished(new Date());
		session.save(stuCard);
		
		StudentIDCard c=(StudentIDCard)session.get(StudentIDCard.class, 5);
		Student p=new Student();
		p.setStuAge("100");
		p.setStuName("abc");
		p.setCardId(c);
		c.getStudent().add(p);
		
		session.save(p);
				
		session.getTransaction().commit();
	}
	
	

}