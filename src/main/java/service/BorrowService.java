package service;

import entity.Borrowable;
import entity.PaperBook;

/**
 * Created by johnson on 6/3/15.
 */
public interface BorrowService {

    Borrowable getBorrowable(PaperBook paperBook);

    Borrowable borrowBook(PaperBook paperBook);
}
