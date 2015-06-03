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

    public enum BorrowableStatus {
        AVAILABLE, UNAVAILABLE
    }
}
