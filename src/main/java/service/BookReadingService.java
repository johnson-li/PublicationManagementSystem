package service;

import entity.AbstractBook;
import entity.Reading;

/**
 * Created by johnson on 6/1/15.
 */
public interface BookReadingService {

    Reading startReading(AbstractBook book);

    Reading stopReading(Reading reading);
}
