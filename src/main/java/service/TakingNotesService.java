package service;

import entity.Note;
import entity.Reading;

/**
 * Created by johnson on 6/1/15.
 */
public interface TakingNotesService {

    Note takeNote(Reading reading, StringBuffer note);
}
