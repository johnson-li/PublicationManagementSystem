package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by johnson on 6/1/15.
 */
@Entity
@Table(name = "ABSTRACT_COMMENT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractComment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    String author;
    Date date;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract StringBuffer getComment();

}
