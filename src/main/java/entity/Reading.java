package entity;

import exception.UnsupportedReadingBookType;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by johnson on 6/1/15.
 */
@Entity
@Table(name = "READING")
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date startDate;

    private Date endDate;

    @ManyToOne
    private EBook eBook;
    @ManyToOne
    private PaperBook paperBook;

    @OneToMany
    private Collection<Note> notes;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public AbstractBook getBook() {
        return eBook == null ? paperBook : eBook;
    }

    public void setBook(AbstractBook book) {
        if (book instanceof EBook) {
            this.eBook = (EBook) book;
        } else if (book instanceof PaperBook) {
            this.paperBook = (PaperBook) book;
        } else {
            throw new UnsupportedReadingBookType(book.getClass().getName());
        }
    }

    public Collection<Note> getNotes() {
        return notes;
    }

    public void setNotes(Collection<Note> notes) {
        this.notes = notes;
    }
}