package com.jinchen.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	Mobile mobile = new Mobile();
    	mobile.setMid(1);
    	mobile.setMname("REALME");
    	
    	Student student = new Student();
    	student.setRollno(53);
    	student.setName("Jinchen Duan");
    	student.setMarks(100);
    	// student.setMobile(mobile); // One to one
    	student.getMobile().add(mobile); // One to many
    	mobile.getStudent().add(student); // Many to many
    	
    	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Mobile.class);
    	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
    	SessionFactory sf = config.buildSessionFactory(registry);
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	session.save(mobile);
    	session.save(student);
    	
    	session.getTransaction().commit();
    }
}
