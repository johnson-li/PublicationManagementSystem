package service.impl;

import dao.BorrowRecordDao;
import dao.BorrowableDao;
import entity.Account;
import entity.BorrowRecord;
import entity.Borrowable;
import entity.PaperBook;
import exception.BookUnavailbleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BorrowService;

import java.util.Date;

/**
 * Created by johnson on 6/3/15.
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BorrowableDao borrowableDao;

    @Autowired
    BorrowRecordDao borrowRecordDao;

    @Override
    public Borrowable getBorrowable(PaperBook paperBook) {
        return borrowableDao.getBorrowable(paperBook);
    }

    @Override
    public Borrowable addBorrowable(PaperBook paperBook) {
        Borrowable borrowable = getBorrowable(paperBook);
        if (borrowable != null) return borrowable;
        return borrowableDao.addBorrowable(paperBook, paperBook.getNum());
    }

    @Override
    public BorrowRecord returnBook(BorrowRecord borrowRecord, Borrowable borrowable) {
        borrowRecord.setReturnDate(new Date());
        borrowRecordDao.updateRecord(borrowRecord);
        return borrowRecord;
    }

    @Override
    public BorrowRecord borrowBook(Borrowable borrowable, Account account) {
        if (!checkBorrowable(borrowable))
            throw new BookUnavailbleException("attempt to borrow an unavailable book");

        BorrowRecord borrowRecord = borrowRecordDao.createRecord();
        borrowRecord.setAccount(account);
        borrowRecord.setBorrowable(borrowable);
        borrowRecord = borrowRecordDao.updateRecord(borrowRecord);
        return borrowRecord;
    }

    boolean checkBorrowable(Borrowable borrowable) {
        return borrowable.getBorrowableNumber() > 0 &&
                borrowable.getBorrowableStatus().equals(Borrowable.BorrowableStatus.AVAILABLE);
    }
}
