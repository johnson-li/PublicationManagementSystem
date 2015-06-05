package integration;

import entity.BorrowRecord;
import entity.Borrowable;
import entity.Friend;
import entity.PaperBook;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.BookManagementService;
import service.BorrowService;
import service.FriendManagementService;

/**
 * Created by johnson on 6/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BorrowBooks {
    static Logger logger = LoggerFactory.getLogger(BorrowBooks.class);

    @Autowired
    BorrowService borrowService;

    @Autowired
    BookManagementService bookManagementService;

    @Autowired
    FriendManagementService friendManagementService;

    @Test @Ignore
    public void testSetBorrowable() {
        PaperBook paperBook = bookManagementService.getPaperBookByISBN(1234567890L);
        borrowService.addBorrowable(paperBook);
    }

    @Test @Ignore
    public void testGetBorrowStatus() {
        PaperBook paperBook = bookManagementService.getPaperBookByISBN(1234567890L);
        Borrowable borrowable = borrowService.getBorrowable(paperBook);
        logger.info(borrowable.getPaperBook().getISBN() + "");
        logger.info(borrowable.getBorrowableStatus().name());
    }

    @Test @Ignore
    public void testAddFriend() {
        friendManagementService.addFriend("jj");
    }

    @Test @Ignore
    public void testGetFriend() {
        Friend friend = friendManagementService.getFriend("jj");
        System.out.println(friend);
    }

    @Test
    public void testBorrowBook() throws Exception{
        Friend friend = friendManagementService.getFriend("jj");
        PaperBook paperBook = bookManagementService.getPaperBookByISBN(1234567890L);
        Borrowable borrowable = borrowService.getBorrowable(paperBook);
        BorrowRecord borrowRecord = borrowService.borrowBook(borrowable, friend.getAccount());
        //Reading for a while
        Thread.sleep(500);
        borrowService.returnBook(borrowRecord, borrowable);
    }
}
