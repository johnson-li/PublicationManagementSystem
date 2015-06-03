package service.impl;

import dao.BorrowableDao;
import entity.Borrowable;
import entity.PaperBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BorrowService;

/**
 * Created by johnson on 6/3/15.
 */
@Service
public class BorrowServiceImpl implements BorrowService{
    @Autowired
    BorrowableDao borrowableDao;

    @Override
    public Borrowable getBorrowable(PaperBook paperBook) {
        return borrowableDao.getBorrowable(paperBook);
    }

    @Override
    public Borrowable borrowBook(PaperBook paperBook) {
        return null;
    }
}
