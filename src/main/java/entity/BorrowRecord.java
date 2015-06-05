package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by johnson on 6/3/15.
 */
@Entity
@Table(name = "BORROW_RECORD")
public class BorrowRecord {

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Borrowable getBorrowable() {
        return borrowable;
    }

    public void setBorrowable(Borrowable borrowable) {
        this.borrowable = borrowable;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    Date borrowDate;
    Date returnDate;

    @ManyToOne
    Borrowable borrowable;

    @ManyToOne
    Account account;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
