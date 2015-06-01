package service.impl;

import dao.BookDao;
import entity.AbstractBook;
import entity.EBook;
import entity.PaperBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookManagementService;

import java.util.Collection;

/**
 * Created by johnson on 5/28/15.
 */
@Service(value = "bookManagementService")
public class BookManagementServiceImpl implements BookManagementService {

    @Autowired
    private BookDao bookDao;

    @Override
    public PaperBook getPaperBookByISBN(long isbn) {
        Collection<AbstractBook> collection = bookDao.getBookByISBN(isbn);
        for (AbstractBook book: collection) {
            if (book instanceof PaperBook) {
                return (PaperBook) book;
            }
        }
        return null;
    }

    @Override
    public PaperBook getEBookByISBN(long isbn) {
        Collection<AbstractBook> collection = bookDao.getBookByISBN(isbn);
        for (AbstractBook book : collection) {
            if (book instanceof EBook) {
                return (PaperBook)book;
            }
        }
        return null;
    }

    @Override
    public void addPaperBook(PaperBook paperBook) {
        bookDao.addBook(paperBook);
    }

    @Override
    public void addEBook(EBook eBook) {
        bookDao.addBook(eBook);
    }
}
