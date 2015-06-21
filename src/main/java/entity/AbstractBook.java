package entity;

import javax.persistence.*;
import java.util.Collection;

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
}
