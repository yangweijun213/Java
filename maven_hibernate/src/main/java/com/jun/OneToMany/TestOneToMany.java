package com.jun.OneToMany;

/*
 * 这是一个hibernate one to manay 例子
 * reference http://www.cnblogs.com/liunanjava/p/4336126.html
 */

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jun.OneToMany.*;
import com.jun.OneToMany.Student;

/**
 * @author jeff yang
 *
 */
public class TestOneToMany {
	
	/**
     * 测试类
     */
    public static void main(String[] args) {
        save();
         find();
        update();

    }
    
    public static void save() {
        // 声明班级对象，并赋值
        Grade grade = new Grade();
        grade.setGid(201504);
        grade.setGname("Java一班");
        grade.setGdesc("刚开始学习JAVA");
        // 声明2个学生对象
        Student stu1 = new Student();
        stu1.setSid(201504012);
        stu1.setSname("张三");
        stu1.setSex("男");

        Student stu2 = new Student();
        stu2.setSid(201504013);
        stu2.setSname("李四");
        stu2.setSex("女");

        // 将学生添加到班级
        grade.getStudents().add(stu1);
        grade.getStudents().add(stu2);
        // 建立session
        Session session = new Configuration().configure().buildSessionFactory()
                .openSession();
        // 开始事务
        Transaction transaction = session.beginTransaction();
        // 保存班级
        session.save(grade);
        // 保存学生
        session.save(stu1);
        session.save(stu2);
        // 提交事务
        transaction.commit();
        // 关闭session
        session.close();
    }

    /*
     * 将基中一个学生更改为别一个班级
     */
    public static void update() {
        // 声明班级对象，并赋值
        Grade grade = new Grade();
        grade.setGid(201506);
        grade.setGname("Java二班");
        grade.setGdesc("学习JAVA二年级");
        // 获取一个学生的信息
        // 建立session
        Session session = new Configuration().configure().buildSessionFactory()
                .openSession();
        // 开始事务
        Transaction transaction = session.beginTransaction();
        Student stu1=(Student) session.get(Student.class, 201504013);
        //将学生添加到这个新的班级
        grade.getStudents().add(stu1);
        // 保存班级
        session.save(grade);
        // 保存学生
        session.save(stu1);
        // 提交事务
        transaction.commit();
        // 关闭session
        session.close();
    }

    // 查询班级
    public static void find() {

        // 建立session
        Session session = new Configuration().configure().buildSessionFactory()
                .openSession();
        Grade g = (Grade) session.get(Grade.class, 201504);
        System.out.println("班级信息：" + g.getGid() + "\t" + g.getGname()
                + g.getGdesc());
        // 通过班级获取这个班级的学生信息
        System.out.println("201504班的学生信息如下:");
        Set<Student> set = g.getStudents();
        for (Student stu : set) {
            System.out.println(stu.getSid() + "\t" + stu.getSname() + "\t"
                    + stu.getSex());
        }
    }

}
