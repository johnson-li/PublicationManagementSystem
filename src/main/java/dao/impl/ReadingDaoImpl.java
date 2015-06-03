package dao.impl;

import dao.ReadingDao;
import entity.AbstractBook;
import entity.Reading;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by johnson on 6/1/15.
 */
@Repository
public class ReadingDaoImpl implements ReadingDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Reading generatingReading(Date date, AbstractBook book) {
        Reading reading = new Reading();
        reading.setStartDate(date);
        reading.setBook(book);
        sessionFactory.getCurrentSession().save(reading);
        return reading;
    }

    @Override
    @Transactional
    public void updateReading(Reading reading) {
        sessionFactory.getCurrentSession().update(reading);
    }
}
