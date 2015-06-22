package entity;

import exception.ReadingNotFoundException;
import exception.UnsupportedReadingBookType;
import javafx.util.Pair;
import service.PersistenceService;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by johnson on 5/28/15.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractBook {

    @OneToMany(fetch = FetchType.EAGER)
    Collection<AbstractComment> comments;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String bookName;
    private String author;
    @Column(unique = true)
    private long ISBN;

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Collection<AbstractComment> getComments() {
        return comments;
    }

    public void setComments(Collection<AbstractComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "AbstractBook{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", ISBN=" + ISBN +
                '}';
    }

    public void recordComment(AbstractComment... abstractComments) {
        if (comments == null) comments = new HashSet<>();
        for (AbstractComment abstractComment : abstractComments) {
            PersistenceService.getInstance().saveOrUpdate(abstractComment);
            comments.add(abstractComment);
            PersistenceService.getInstance().update(this);
        }
    }

    public Reading startReading() {
        Reading reading = new Reading();
        reading.setBook(this);
        reading.setStartDate(new Date());
        PersistenceService.getInstance().save(reading);
        return reading;
    }

    public Reading stopReading(Reading reading) {
        reading.setEndDate(new Date());
        PersistenceService.getInstance().update(reading);
        return reading;
    }

    public Reading stopReading() {
        Reading reading = getReading();
        if (reading == null)
            throw new ReadingNotFoundException();
        return stopReading(reading);
    }

    public Reading getReading() {
        String hql;
        if (this instanceof EBook) {
            hql = "from Reading where endDate is null and eBook = :book";
        } else if (this instanceof PaperBook) {
            hql = "from Reading where endDate is null and paperBook = :book";
        } else {
            throw new UnsupportedReadingBookType(this.getClass().getName());
        }
        Pair<String, Object> pair = new Pair<>("book", this);
        return (Reading) PersistenceService.getInstance().getObject(hql, pair);
    }
}
