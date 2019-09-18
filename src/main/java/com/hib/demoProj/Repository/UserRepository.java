package com.hib.demoProj.Repository;

import com.hib.demoProj.Entities.Stock;
import com.hib.demoProj.Entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepository {

    public void createstock()
    {
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        //configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Set<Stock> stocks=new HashSet<>();
        stocks.add(new Stock("Apple",200));
        stocks.add(new Stock("Apple1",201));
        User user=new User(1,stocks);
    session.save(user);
        transaction.commit();
    }

    public List<Stock> getS()
    {
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        //configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        //Query query=session.createQuery("SELECT s.stockid,s.stockname from stock s, user_stock us where s.stockid=us.stockid and us.userid=1");
        String queryString = "SELECT u FROM Stock u";
        Query consulta = session.createQuery(queryString);
       List<Stock> stock = consulta.list();
      // Query query=session.createQuery("from user_stock");
        transaction.commit();

        return stock;
    }

}
