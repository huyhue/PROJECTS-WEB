package org.bildit.model.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session;

    public boolean createUser(Users users) {
        session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(users);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            System.out.println("Error create users");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    public Users readUser(String usersname) {
        Users users = null;
        session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("select u from Users as u where u.username=:username")
                    .setParameter("username", usersname);
            users = (Users) query.uniqueResult();
            session.getTransaction().commit();
            return users;
        } catch (HibernateException he) {
            System.out.println("Error read users");
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean updateUser(Users users) {
        session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Users loadedUsers = (Users) session.get(Users.class, users.getId());
            users = loadedUsers;
            session.update(users);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException he) {
            System.out.println("Error update users");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }
}
