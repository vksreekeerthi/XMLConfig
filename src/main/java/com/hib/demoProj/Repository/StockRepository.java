package com.hib.demoProj.Repository;

import com.hib.demoProj.Entities.Stock;
import com.hib.demoProj.Entities.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class StockRepository {

        public List<Stock> getStocks()
        {
            SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
            //configuration.configure("hibernate.cfg.xml");
            //sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            List<Stock> stocks=new ArrayList<Stock>();
            if (session != null) {
                try {
                    Query query = session.createQuery("from Stock");

                    stocks = query.getResultList();
                }
                catch (Exception exception) {
                    System.out.println("Exception occred while reading stock data: "
                            + exception.getMessage());
                }
            }
            return stocks;
        }
        public List<User> getallUsers()
        {
            SessionFactory sessionFactory;
            Configuration configuration = new Configuration();
            //configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //Query query=session.createQuery("SELECT s.stockid,s.stockname from stock s, user_stock us where s.stockid=us.stockid and us.userid=1");
            String queryString = "SELECT u FROM User u";
            org.hibernate.query.Query consulta = session.createQuery(queryString);
            List<User> users = consulta.list();
            // Query query=session.createQuery("from user_stock");
            transaction.commit();
            return users;
        }


        public void saveorUpdateStock(Stock stock)
        {
            SessionFactory sessionFactory;
            Configuration configuration = new Configuration();
            //configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.saveOrUpdate(stock);
            transaction.commit();

        }
    public void deleteStock(Stock stock)
    {
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
       // sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.delete(stock);
        transaction.commit();

    }


}
