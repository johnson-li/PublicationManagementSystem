package entity;

import javax.persistence.*;

/**
 * Created by johnson on 5/28/15.
 */
@Entity
@Table(name = "BOOK")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractBook {

    private String bookName;

    private String author;

    @Id
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

    @Override
    public String toString() {
        return "AbstractBook{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", ISBN=" + ISBN +
                '}';
    }
}
