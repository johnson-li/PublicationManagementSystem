package dao.impl;

import dao.ReadingDao;
import entity.Reading;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by johnson on 6/1/15.
 */
@Repository
public class ReadingDaoImpl implements ReadingDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Reading generatingReading() {
        Reading reading = new Reading();
        reading = (Reading) sessionFactory.getCurrentSession().save(reading);
        return reading;
    }

    @Override
    public void updateReading(Reading reading) {
        sessionFactory.getCurrentSession().update(reading);
    }
}
