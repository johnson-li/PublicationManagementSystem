package dao;

import entity.Reading;

/**
 * Created by johnson on 6/1/15.
 */
public interface ReadingDao {
    Reading generatingReading();

    void updateReading(Reading reading);
}
