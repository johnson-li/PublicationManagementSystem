package entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by johnson on 6/3/15.
 */
@Entity
@Table(name = "BORROW_RECORD")
public class BorrowRecord {

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
