package service;

import exception.NoSessionFactoryException;
import javafx.util.Pair;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by johnson on 6/22/15.
 */
public class PersistenceService {
    public static PersistenceService instance = new PersistenceService();

    private SessionFactory sessionFactory;

    private PersistenceService() {
    }

    public static PersistenceService getInstance() {
        return instance;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        getInstance().sessionFactory = sessionFactory;
    }

    public void update(Object object) {
        if (sessionFactory == null)
            throw new NoSessionFactoryException();
        Session session = sessionFactory.openSession();
        session.update(object);
        session.flush();
        session.close();
    }

    public Serializable save(Object object) {
        if (sessionFactory == null)
            throw new NoSessionFactoryException();
        Session session = sessionFactory.openSession();
        Serializable serializable = session.save(object);
        session.flush();
        session.close();
        return serializable;
    }

    public void saveOrUpdate(Object object) {
        if (sessionFactory == null)
            throw new NoSessionFactoryException();
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(object);
        session.flush();
        session.close();
    }

    public List getObjects(String hql, Pair<String, Object>... pairs) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        for (Pair<String, Object> pair: pairs) {
            query.setParameter(pair.getKey(), pair.getValue());
        }
        List list = query.list();
        session.close();
        return list;
    }

    public Object getObject(String hql, Pair<String, Object>... pairs) {
        List list = getObjects(hql, pairs);
        if (list.size() <= 0) return null;
        return list.get(0);
    }
}
