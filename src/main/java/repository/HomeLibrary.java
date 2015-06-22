package repository;

import entity.AbstractBook;
import entity.EBook;
import entity.PaperBook;
import service.PersistenceService;

import java.util.Collection;

/**
 * Created by johnson on 5/28/15.
 */
public class HomeLibrary {
    private static HomeLibrary instance = new HomeLibrary();

    PersistenceService persistenceService = PersistenceService.getInstance();

    private HomeLibrary() {
    }

    public static HomeLibrary getInstance() {
        return instance;
    }

    public Collection<AbstractBook> getAllBooks() {
        String hql = "from entity.AbstractBook";
        return (Collection<AbstractBook>) persistenceService.getObjects(hql);
    }

    public Collection<AbstractBook> getBooksByISBN(long isbn) {
        String hql = "from entity.AbstractBook where ISBN = " + isbn;
        return (Collection<AbstractBook>) persistenceService.getObjects(hql);
    }

    public PaperBook getPaperBookByISBN(long isbn) {
        for (AbstractBook book : getBooksByISBN(isbn)) {
            if (book instanceof PaperBook) {
                return (PaperBook) book;
            }
        }
        return null;
    }

    public EBook getEBookByISBN(long isbn) {
        for (AbstractBook book : getBooksByISBN(isbn)) {
            if (book instanceof EBook) {
                return (EBook) book;
            }
        }
        return null;
    }

    public void addBook(AbstractBook book) {
        persistenceService.save(book);
    }
}
