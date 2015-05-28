package dao;

import entity.AbstractBook;

import java.util.Collection;

/**
 * Created by johnson on 5/28/15.
 */
public interface BookDao {

    Collection<AbstractBook> getBookByISBN(long isbn);

    void addBook(AbstractBook book);
}
