package dao.impl;

import dao.BorrowRecordDao;
import entity.BorrowRecord;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by johnson on 6/5/15.
 */
@Repository
public class BorrowRecordDaoImpl implements BorrowRecordDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public BorrowRecord updateRecord(BorrowRecord borrowRecord) {
        sessionFactory.getCurrentSession().update(borrowRecord);
        return borrowRecord;
    }

    @Override
    @Transactional
    public BorrowRecord createRecord() {
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setBorrowDate(new Date());
        sessionFactory.getCurrentSession().save(borrowRecord);
        return borrowRecord;
    }
}
