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

    public enum BorrowableStatus {
        AVAILABLE, UNAVAILABLE
    }
}
