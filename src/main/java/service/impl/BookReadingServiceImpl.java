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

    @Override
    public Reading stopReading(Reading reading) {
        reading.setEndDate(new Date());
        readingDao.updateReading(reading);
        return reading;
    }

    @Override
    public Reading startReading(AbstractBook book) {
        Reading reading = readingDao.generatingReading(new Date(), book);
        return reading;
    }
}
