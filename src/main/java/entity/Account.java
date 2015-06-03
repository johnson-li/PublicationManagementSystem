package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by johnson on 5/28/15.
 */
@Entity
@Table(name = "ACCOUNT")
public class Account {

    String userName;
    @OneToMany
    Collection<Friend> friends;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    Collection<BorrowRecord> borrowRecords;

    @OneToMany
    Collection<Borrowable> borrowables;
}
