package dao;

import entity.BorrowRecord;

/**
 * Created by johnson on 6/3/15.
 */
public interface BorrowRecordDao {

    BorrowRecord createRecord();

    BorrowRecord updateRecord(BorrowRecord borrowRecord);
}
