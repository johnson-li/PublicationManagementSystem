package integration;

import entity.*;
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
import service.BookReadingService;
import service.CommentService;
import service.NoteTakingService;

import java.net.URL;

/**
 * Created by johnson on 6/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReadingBookTest {
    static Logger logger = LoggerFactory.getLogger(ReadingBookTest.class);

    @Autowired
    BookManagementService bookManagementService;

    @Autowired
    BookReadingService bookReadingService;

    @Autowired
    NoteTakingService noteTakingService;

    @Autowired
    CommentService commentService;

    @Test @Ignore
    public void test1AddBook() throws Exception{
        EBook eBook = new EBook();
        eBook.setUrl(new URL("http://baidu.com"));
        eBook.setAuthor("johnson");
        eBook.setBookName("johnson's book");
        eBook.setISBN(1234567890L);
        bookManagementService.addEBook(eBook);

        PaperBook paperBook = new PaperBook();
        paperBook.setNum(10);
        paperBook.setBookName(eBook.getBookName());
        paperBook.setISBN(eBook.getISBN());
        paperBook.setAuthor(eBook.getAuthor());
        bookManagementService.addPaperBook(paperBook);
    }

    @Test @Ignore
    public void test2ReadBook() throws Exception {
        PaperBook paperBook = bookManagementService.getPaperBookByISBN(1234567890L);
        Reading reading = bookReadingService.startReading(paperBook);
        logger.info("start reading at time " + reading.getStartDate());
        logger.info("reading for one second...");
        Thread.sleep(1000);
        bookReadingService.stopReading(reading);
        logger.info("stop reading at time " + reading.getEndDate());
    }

    @Test @Ignore
    public void test3TakeNotes() throws Exception{
        PaperBook paperBook = bookManagementService.getPaperBookByISBN(1234567890L);
        Reading reading = bookReadingService.startReading(paperBook);
        logger.info("start reading at time " + reading.getStartDate());

        //taking notes
        Note note1 = noteTakingService.takeNote(reading, "the first note line 1");
        noteTakingService.takeNote(reading, note1, "the first note line 2");
        Note note2 = noteTakingService.takeNote(reading, "the second note");
        logger.info("note1: " + note1.getContent());
        logger.info("note2: " + note2.getContent());

        bookReadingService.stopReading(reading);
        logger.info("stop reading at time " + reading.getEndDate());
    }

    @Test
    public void test4CollectComments() throws Exception{

        //TODO failed to lazily initialize a collection of role: entity.AbstractBook.comments, could not initialize proxy - no Session
        PaperBook paperBook = bookManagementService.getPaperBookByISBN(1234567890L);

        //collect comments and show
        URLComment urlComment1 = commentService.getUrlComment(new URL("http://baidu.com"));
        URLComment urlComment2 = commentService.getUrlComment(new URL("http://google.com"));
        commentService.recordComment(paperBook, urlComment1, urlComment2);
        for (AbstractComment abstractComment: commentService.collectComment(paperBook)) {
            logger.info(abstractComment.getComment().toString());
        }

    }
}
