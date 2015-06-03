package dao;

import entity.Note;
import entity.Reading;

/**
 * Created by johnson on 6/3/15.
 */
public interface NoteDao {

    Note createNote();

    Reading addNote(Reading reading, Note note);

    Note record(Note note, String content);
}
