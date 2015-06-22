package entity;

import exception.BookUnavailbleException;
import javafx.util.Pair;
import service.PersistenceService;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by johnson on 5/28/15.
 */
@Entity
@Table(name = "ACCOUNT")
public class Account {

    @OneToOne
    Friend friend;

    public Friend getFriend() {
        return friend;
    }

    public void setFriend(Friend friend) {
        this.friend = friend;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(fetch = FetchType.EAGER)
    Collection<Borrowable> borrowables;

    public void addBorrowable(Borrowable borrowable) {
        if (borrowables.contains(borrowable)) return;
        borrowables.add(borrowable);
        PersistenceService.getInstance().update(this);
    }

    public BorrowRecord borrowBook(Borrowable borrowable) {
        if (!borrowables.contains(borrowable)) {
            throw new BookUnavailbleException("book " + borrowable.getPaperBook().getBookName() +
                    " is not available for friend " + getFriend().getName());
        }
        if (!borrowable.checkBorrowable())
            throw new BookUnavailbleException("attempt to borrow an unavailable book");

        borrowable.borrow();
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setAccount(this);
        borrowRecord.setBorrowable(borrowable);
        borrowRecord.setBorrowDate(new Date());
        PersistenceService.getInstance().save(borrowRecord);
        return borrowRecord;
    }

    public BorrowRecord returnBook(BorrowRecord borrowRecord) {
        borrowRecord.getBorrowable().giveBack();
        borrowRecord.setReturnDate(new Date());
        PersistenceService.getInstance().update(borrowRecord);
        return borrowRecord;
    }

    public Collection<BorrowRecord> getBorrowRecords() {
        String hql = "from BorrowRecord where account = :account";
        Pair<String, Object> pair = new Pair<>("account", this);
        List list = PersistenceService.getInstance().getObjects(hql, pair);
        return list;
    }
}
