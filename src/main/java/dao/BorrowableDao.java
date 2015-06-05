package dao;

import entity.Borrowable;
import entity.PaperBook;

/**
 * Created by johnson on 6/3/15.
 */
public interface BorrowableDao {

    Borrowable getBorrowable(PaperBook paperBook);

    Borrowable addBorrowable(PaperBook paperBook, int num);
}
