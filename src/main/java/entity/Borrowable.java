package entity;

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

    public void decrease() {
        if (borrowableNumber == 0) {

        }
        borrowableNumber--;
        if (borrowableNumber == 0) {
            borrowableStatus = BorrowableStatus.UNAVAILABLE;
        }
    }

    public void increate() {
        borrowableNumber++;
        borrowableStatus = BorrowableStatus.AVAILABLE;
    }

    public enum BorrowableStatus {
        AVAILABLE, UNAVAILABLE
    }
}
