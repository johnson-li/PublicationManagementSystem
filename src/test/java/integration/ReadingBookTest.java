package integration;

import entity.*;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import repository.HomeLibrary;
import service.PersistenceService;

import java.net.URL;
import java.util.Date;

/**
 * Created by johnson on 6/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class ReadingBookTest {
    static Logger logger = LoggerFactory.getLogger(ReadingBookTest.class);
    HomeLibrary homeLibrary;

    @Autowired
    SessionFactory sessionFactory;

    @Before
    public void init() {
        PersistenceService.setSessionFactory(this.sessionFactory);
        homeLibrary = HomeLibrary.getInstance();
    }

    @Test
    public void testAddBook() throws Exception {
        EBook eBook = new EBook();
        eBook.setUrl(new URL("http://baidu.com"));
        eBook.setAuthor("johnson");
        eBook.setBookName("johnson's book");
        eBook.setISBN(1234567890L);
        homeLibrary.addBook(eBook);

        PaperBook paperBook = new PaperBook();
        paperBook.setNum(10);
        paperBook.setBookName(eBook.getBookName());
        paperBook.setISBN(eBook.getISBN());
        paperBook.setAuthor(eBook.getAuthor());
        homeLibrary.addBook(paperBook);
    }

    @Test
    public void testReadBook() throws Exception {
        PaperBook paperBook = homeLibrary.getPaperBookByISBN(1234567890L);
        Reading reading = paperBook.startReading();
        logger.info("start reading at time " + reading.getStartDate());
        logger.info("reading for one second...");
        Thread.sleep(1000);
        reading = paperBook.stopReading();
        logger.info("stop reading at time " + reading.getEndDate());
    }

    /**
     * this is the integration test for reading book including taking notes
     */
    @Test
    public void testTakeNotes() throws Exception {
        PaperBook paperBook = homeLibrary.getPaperBookByISBN(1234567890L);
        Reading reading = paperBook.startReading();
        logger.info("start reading at time " + reading.getStartDate());

        //taking notes
        Note note1 = reading.takeNote("the first note line 1");
        reading.takeNote(note1, "the first note line 2");
        Note note2 = reading.takeNote("the second note");
        logger.info("note1: " + note1.getContent());
        logger.info("note2: " + note2.getContent());
        Thread.sleep(1000);
        reading = paperBook.stopReading();
        logger.info("stop reading at time " + reading.getEndDate());
    }

    /**
     * This is the integration test for collect comments
     */
    @Test
    public void testCollectComments() throws Exception {
        PaperBook paperBook = homeLibrary.getPaperBookByISBN(1234567890L);

        URLComment urlComment1 = new URLComment();
        urlComment1.setUrl(new URL("http://baidu.com"));
        urlComment1.setAuthor("johnson");
        urlComment1.setDate(new Date());
        URLComment urlComment2 = new URLComment();
        urlComment2.setUrl(new URL("http://google.com"));
        urlComment2.setAuthor("john");
        urlComment2.setDate(new Date());
        paperBook.recordComment(urlComment1, urlComment2);
    }
}
