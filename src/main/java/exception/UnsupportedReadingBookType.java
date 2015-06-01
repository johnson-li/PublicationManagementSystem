package exception;

import entity.Reading;

/**
 * Created by johnson on 6/1/15.
 */
public class UnsupportedReadingBookType extends RuntimeException {
    public UnsupportedReadingBookType() {
        super();
    }

    public UnsupportedReadingBookType(Reading.ReadingBookType readingBookType) {
        super(readingBookType.name());
    }
}
