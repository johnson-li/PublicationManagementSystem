package dao.impl;

import dao.BorrowableDao;
import entity.Borrowable;
import entity.PaperBook;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by johnson on 6/3/15.
 */
@Repository
public class BorrowableDaoImpl implements BorrowableDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Borrowable getBorrowable(PaperBook paperBook) {
        String hql = "from entity.Borrowable where paperBook = :paperBook";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("paperBook", paperBook);
        List list = query.list();
        return list.size() > 0 ? (Borrowable)list.get(0) : null;
    }

    @Override
    @Transactional
    public Borrowable addBorrowable(PaperBook paperBook, int num) {
        Borrowable borrowable = new Borrowable();
        borrowable.setPaperBook(paperBook);
        if (num > 0)
            borrowable.setBorrowableStatus(Borrowable.BorrowableStatus.AVAILABLE);
        else
            borrowable.setBorrowableStatus(Borrowable.BorrowableStatus.UNAVAILABLE);
        borrowable.setBorrowableNumber(num);
        sessionFactory.getCurrentSession().save(borrowable);
        return borrowable;
    }
}
