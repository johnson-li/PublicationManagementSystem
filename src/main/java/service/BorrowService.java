package service;

import entity.Account;
import entity.BorrowRecord;
import entity.Borrowable;
import entity.PaperBook;

/**
 * Created by johnson on 6/3/15.
 */
public interface BorrowService {

    Borrowable getBorrowable(PaperBook paperBook);

    BorrowRecord borrowBook(Borrowable borrowable, Account account);

    Borrowable addBorrowable(PaperBook paperBook);

    BorrowRecord returnBook(BorrowRecord borrowRecord, Borrowable borrowable);
}
