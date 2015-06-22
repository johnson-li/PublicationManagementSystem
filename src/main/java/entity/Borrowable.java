package entity;

import exception.BorrowZeroBookNumException;
import service.PersistenceService;

import javax.persistence.*;

/**
 * Created by johnson on 6/3/15.
 */
@Entity
@Table(name = "BORROWABLE")
public class Borrowable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    BorrowableStatus borrowableStatus;

    @OneToOne
    PaperBook paperBook;

    public int getBorrowableNumber() {
        return borrowableNumber;
    }

    public void setBorrowableNumber(int borrowableNumber) {
        this.borrowableNumber = borrowableNumber;
    }

    int borrowableNumber;

    public PaperBook getPaperBook() {
        return paperBook;
    }

    public void setPaperBook(PaperBook paperBook) {
        this.paperBook = paperBook;
    }

    public BorrowableStatus getBorrowableStatus() {
        return borrowableStatus;
    }

    public void setBorrowableStatus(BorrowableStatus borrowableStatus) {
        this.borrowableStatus = borrowableStatus;
    }

    public void borrow() {
        if (borrowableNumber == 0) {
            throw new BorrowZeroBookNumException();
        }
        borrowableNumber--;
        if (borrowableNumber == 0) {
            borrowableStatus = BorrowableStatus.UNAVAILABLE;
        }
        PersistenceService.getInstance().update(this);
    }

    boolean checkBorrowable() {
        return getBorrowableNumber() > 0 &&
                getBorrowableStatus().equals(Borrowable.BorrowableStatus.AVAILABLE);
    }

    public void giveBack() {
        borrowableNumber++;
        borrowableStatus = BorrowableStatus.AVAILABLE;
        PersistenceService.getInstance().update(this);
    }

    public enum BorrowableStatus {
        AVAILABLE, UNAVAILABLE
    }

    @Override
    public boolean equals(Object obj) {
        Borrowable borrowable = (Borrowable)obj;
        return borrowable.id == id;
    }
}
