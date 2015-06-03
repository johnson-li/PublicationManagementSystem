package service;

import entity.Note;
import entity.Reading;

/**
 * Created by johnson on 6/1/15.
 */

public interface NoteTakingService {

    Note takeNote(Reading reading, String content);

    Note takeNote(Reading reading, Note note, String content);
}
