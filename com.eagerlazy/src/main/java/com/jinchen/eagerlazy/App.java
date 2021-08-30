package com.jinchen.eagerlazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	Laptop l1 = new Laptop();
    	l1.setLid(101);
    	l1.setBrand("Apple");
    	l1.setPrice(10000);
    	
    	Laptop l2 = new Laptop();
    	l2.setLid(102);
    	l2.setBrand("IPad");
    	l2.setPrice(12000);
    	
    	Student student1 = new Student();
    	student1.setRollno(1);
    	student1.setName("Jinchen Duan");
    	student1.getLaps().add(l1);
    	student1.getLaps().add(l2);
    	l1.setStudent(student1);
    	l2.setStudent(student1);
    	
    	Laptop l3 = new Laptop();
    	l3.setLid(103);
    	l3.setBrand("HP");
    	l3.setPrice(9000);
    	
    	Laptop l4 = new Laptop();
    	l4.setLid(104);
    	l4.setBrand("DELL");
    	l4.setPrice(8000);
    	
    	Student student2 = new Student();
    	student2.setRollno(1);
    	student2.setName("Qiuying Jiang");
    	student2.getLaps().add(l3);
    	student2.getLaps().add(l4);
    	l3.setStudent(student2);
    	l4.setStudent(student2);
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	SessionFactory sf = config.buildSessionFactory(registry);
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	session.save(student1);
    	session.save(l1);
    	session.save(l2);
    	
    	session.save(student2);
    	session.save(l3);
    	session.save(l4);
    	
    	session.getTransaction().commit();
    }
}
