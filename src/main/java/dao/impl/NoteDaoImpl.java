package dao.impl;

import dao.NoteDao;
import entity.Note;
import entity.Reading;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by johnson on 6/3/15.
 */
@Repository
public class NoteDaoImpl implements NoteDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Note createNote() {
        Note note = new Note();
        note.setNoteDate(new Date());
        note.setContent(new StringBuffer());
        sessionFactory.getCurrentSession().save(note);
        return note;
    }

    @Override
    @Transactional
    public Note record(Note note, String content) {
        StringBuffer noteContent = note.getContent();
        if (noteContent == null) {
            noteContent = new StringBuffer();
        }
        noteContent.append(content).append('\n');
        sessionFactory.getCurrentSession().update(note);
        return note;
    }

    @Override
    @Transactional
    public Reading addNote(Reading reading, Note note) {
        Collection<Note> notes = reading.getNotes();
        if (notes == null) notes = new HashSet<>();
        if (!notes.contains(note)) notes.add(note);
        reading.setNotes(notes);
        sessionFactory.getCurrentSession().update(reading);
        return reading;
    }
}
