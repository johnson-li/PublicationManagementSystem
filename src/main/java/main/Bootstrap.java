package main;

import entity.PaperBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookManagementService;

/**
 * Created by johnson on 5/28/15.
 */
public class Bootstrap {
    static Logger logger = LoggerFactory.getLogger(Bootstrap.class);
    static String SPRING_CONFIG_FILE_PATH_ENV = "SPRING_CONFIG_FILE_PATH_ENV";

    public static void main(String[] args) throws Exception{
        logger.info("starting system");
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(System.getenv(SPRING_CONFIG_FILE_PATH_ENV));

        BookManagementService service = (BookManagementService)ac.getBean("service");
        PaperBook paperBook = service.getPaperBookByISBN(9787111075752L);
        System.out.println(paperBook);
    }
}
