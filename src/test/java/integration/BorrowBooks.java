package integration;

import entity.Borrowable;
import entity.PaperBook;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.BookManagementService;
import service.BorrowService;

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

    public void testGetBorrowStatus() {
        PaperBook paperBook = bookManagementService.getPaperBookByISBN(1234567890L);
        Borrowable borrowable = borrowService.getBorrowable(paperBook);
        System.out.println(borrowable);
    }

}
