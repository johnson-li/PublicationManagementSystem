package main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by johnson on 5/28/15.
 */
public class Bootstrap {
    static Logger logger = LoggerFactory.getLogger(Bootstrap.class);
    static String SPRING_CONFIG_FILE_PATH_ENV = "SPRING_CONFIG_FILE_PATH_ENV";

    public static void main(String[] args) throws Exception {
        logger.info("starting system");
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(System.getenv(SPRING_CONFIG_FILE_PATH_ENV));
        logger.info("system initiated");
    }
}
