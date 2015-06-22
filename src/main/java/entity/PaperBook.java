package entity;

import javafx.util.Pair;
import service.PersistenceService;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by johnson on 5/28/15.
 */
@Entity
@Table(name = "PAPER_BOOK")
public class PaperBook extends AbstractBook {

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PaperBook{" +
                "num=" + num +
                "} " + super.toString();
    }

    public Borrowable addBorrowable() {
        Borrowable borrowable = getBorrowable();
        if (borrowable != null) return borrowable;
        borrowable = new Borrowable();
        borrowable.setPaperBook(this);
        if (num > 0)
            borrowable.setBorrowableStatus(Borrowable.BorrowableStatus.AVAILABLE);
        else
            borrowable.setBorrowableStatus(Borrowable.BorrowableStatus.UNAVAILABLE);
        borrowable.setBorrowableNumber(num);
        PersistenceService.getInstance().save(borrowable);
        return borrowable;
    }

    public Borrowable getBorrowable() {
        String hql = "from entity.Borrowable where paperBook = :paperBook";
        Pair<String, Object> pair = new Pair<>("paperBook", this);
        Borrowable borrowable = (Borrowable)PersistenceService.getInstance().getObject(hql, pair);
        return borrowable;
    }
}
