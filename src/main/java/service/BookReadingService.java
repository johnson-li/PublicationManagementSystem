package service;

import entity.Reading;

/**
 * Created by johnson on 6/1/15.
 */
public interface BookReadingService {

    Reading startReading(long isbn, Reading.ReadingBookType readingBookType);

    Reading stopReading(Reading reading);
}
