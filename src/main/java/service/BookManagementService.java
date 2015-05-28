package service;

import entity.EBook;
import entity.PaperBook;

/**
 * Created by johnson on 5/28/15.
 */
public interface BookManagementService {

    PaperBook getPaperBookByISBN(long isbn);

    void addPaperBook(PaperBook paperBook);

    void addEBook(EBook eBook);
}
