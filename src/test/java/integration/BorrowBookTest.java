package integration;

import entity.BorrowRecord;
import entity.Borrowable;
import entity.Friend;
import entity.PaperBook;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.FriendManager;
import repository.HomeLibrary;
import service.PersistenceService;

import java.util.Collection;

/**
 * Created by johnson on 6/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BorrowBookTest {
    static Logger logger = LoggerFactory.getLogger(BorrowBookTest.class);
    HomeLibrary homeLibrary;
    FriendManager friendManager;

    @Autowired
    SessionFactory sessionFactory;

    @Before
    public void init() {
        PersistenceService.setSessionFactory(this.sessionFactory);
        homeLibrary = HomeLibrary.getInstance();
        friendManager = FriendManager.getInstance();
    }

    @Test
    public void testSetBorrowable() {
        PaperBook paperBook = homeLibrary.getPaperBookByISBN(1234567890L);
        paperBook.addBorrowable();
    }

    @Test
    public void testGetBorrowStatus() {
        PaperBook paperBook = homeLibrary.getPaperBookByISBN(1234567890L);
        Borrowable borrowable = paperBook.getBorrowable();
        logger.info(borrowable.getPaperBook().getISBN() + "");
        logger.info(borrowable.getBorrowableStatus().name());
    }

    @Test
    public void testAddFriend() {
        friendManager.addFriend("pp");
    }

    @Test
    public void testGetFriend() {
        Friend friend = friendManager.getFriend("pp");
        System.out.println(friend.getName());
    }

    /**
     * This is the integration test for borrow book
     */
    @Test
    public void testBorrowBook() throws Exception {
        Friend friend = friendManager.getFriend("pp");
        PaperBook paperBook = homeLibrary.getPaperBookByISBN(1234567890L);
        Borrowable borrowable = paperBook.getBorrowable();
        friend.getAccount().addBorrowable(borrowable);
        BorrowRecord borrowRecord = friend.getAccount().borrowBook(borrowable);
        //Reading for a while
        Thread.sleep(500);
        friend.getAccount().returnBook(borrowRecord);
    }

    @Test
    public void testGetBorrowRecords() {
        Friend friend = friendManager.getFriend("pp");
        Collection collection = friend.getAccount().getBorrowRecords();
        System.out.println(collection);
    }
}
