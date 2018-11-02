package entities;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {


        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

      //  List<User> users = session.createCriteria(User.class).add(Restrictions.like("username","%o%")).list();
        List<User> users = session.createQuery("FROM User ",User.class).list();
        for (User user : users) {
            System.out.println(user.getUsername());
        }

        session.getTransaction().commit();
        session.close();

    }
}
