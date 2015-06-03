package dao;

import entity.AbstractBook;
import entity.Reading;

import java.util.Date;

/**
 * Created by johnson on 6/1/15.
 */
public interface ReadingDao {
    Reading generatingReading(Date date, AbstractBook book);

    void updateReading(Reading reading);
}
