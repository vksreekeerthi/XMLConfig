package com.hib.demoProj;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjApplication.class, args);


//		SessionFactory sf;
//		Session s;
//
//		try{
//			sf = new Configuration().configure().buildSessionFactory();
//			s = sf.openSession();
//			s.beginTransaction();
//			System.out.println("Connected: " + s.isConnected());
//			s.getTransaction().commit();
//			sf.close();
//			s.close();
//		}catch (HibernateException e){
//			e.printStackTrace();
//		}

	}

}
