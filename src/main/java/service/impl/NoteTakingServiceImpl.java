package service.impl;

import dao.NoteDao;
import entity.Note;
import entity.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.NoteTakingService;

/**
 * Created by johnson on 6/3/15.
 */
@Service
public class NoteTakingServiceImpl implements NoteTakingService{
    @Autowired
    NoteDao noteDao;

    @Override
    public Note takeNote(Reading reading, Note note, String content) {
        noteDao.record(note, content);
        return note;
    }

    @Override
    public Note takeNote(Reading reading, String content) {
        Note note = noteDao.createNote();
        noteDao.addNote(reading, note);
        noteDao.record(note, content);
        return note;
    }
}
