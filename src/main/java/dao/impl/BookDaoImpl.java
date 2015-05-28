package dao.impl;

import dao.BookDao;
import entity.AbstractBook;
import entity.EBook;
import entity.PaperBook;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by johnson on 5/28/15.
 */
@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Collection<AbstractBook> getBookByISBN(long isbn) {
        String hql = "from entity.AbstractBook";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    @Transactional
    public void addBook(AbstractBook book) {
        sessionFactory.getCurrentSession().save(book);
    }

    public void updateBook(AbstractBook book) {
        sessionFactory.getCurrentSession().update(book);
    }
}
