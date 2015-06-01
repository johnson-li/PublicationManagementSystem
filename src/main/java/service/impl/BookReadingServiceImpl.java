package service.impl;

import dao.ReadingDao;
import entity.AbstractBook;
import entity.Reading;
import exception.UnsupportedReadingBookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookManagementService;
import service.BookReadingService;

import java.util.Date;

/**
 * Created by johnson on 6/1/15.
 */
@Service
public class BookReadingServiceImpl implements BookReadingService {

    @Autowired
    private ReadingDao readingDao;

    @Autowired
    private BookManagementService bookManagementService;

    @Override
    public Reading stopReading(Reading reading) {
        return null;
    }

    @Override
    public Reading startReading(long isbn, Reading.ReadingBookType readingBookType) {
        Reading reading = readingDao.generatingReading();
        AbstractBook abstractBook;
        switch (readingBookType) {
            case E_BOOK:
                throw new UnsupportedReadingBookType(readingBookType);
//                break;
            case PAPER_BOOK:
                abstractBook = bookManagementService.getPaperBookByISBN(isbn);
                break;
            default:
                throw new UnsupportedReadingBookType(readingBookType);
        }
        reading.setBook(abstractBook);
        reading.setStartDate(new Date());
        readingDao.updateReading(reading);
        return reading;
    }
}
