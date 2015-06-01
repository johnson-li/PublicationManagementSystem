package main;

import entity.EBook;
import entity.Reading;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookManagementService;
import service.BookReadingService;
import service.TakingNotesService;

import java.net.URL;

/**
 * Created by johnson on 5/28/15.
 */
public class Bootstrap {
    static Logger logger = LoggerFactory.getLogger(Bootstrap.class);
    static String SPRING_CONFIG_FILE_PATH_ENV = "SPRING_CONFIG_FILE_PATH_ENV";
    //test reading book
    static BookReadingService bookReadingService;
    static TakingNotesService takingNotesService;

    public static void main(String[] args) throws Exception {
        logger.info("starting system");
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(System.getenv(SPRING_CONFIG_FILE_PATH_ENV));

        BookManagementService bookManagementService = (BookManagementService) ac.getBean("bookManagementService");
//        PaperBook paperBook = service.getPaperBookByISBN(9787111075752L);
        EBook eBook = new EBook();
        eBook.setUrl(new URL("http://baidu.com"));
        eBook.setAuthor("johnson");
        eBook.setBookName("ebook");
        eBook.setISBN(123L);
        bookManagementService.addEBook(eBook);

        readingBook();
    }

    public static void readingBook() {
        long isbn = 123L;
        Reading reading = bookReadingService.startReading(isbn, Reading.ReadingBookType.PAPER_BOOK);
        StringBuffer note = new StringBuffer();
        takingNotesService.takeNote(reading, note);
        reading = bookReadingService.stopReading(reading);
        System.out.println("Reading finished, start time: " + reading.getStartDate()
                + ", end time: " + reading.getEndDate());
    }
}
