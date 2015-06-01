package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by johnson on 6/1/15.
 */
@Entity
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date startDate;

    private Date endDate;

    //TODO: Could not determine type for: entity.AbstractBook, at table: Reading, for columns: [org.hibernate.mapping.Column(book)]
    private AbstractBook book;

    private ReadingBookType readingBookType;

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
        return book;
    }

    public void setBook(AbstractBook book) {
        this.book = book;
    }

    public enum ReadingBookType {
        PAPER_BOOK, E_BOOK
    }
}
