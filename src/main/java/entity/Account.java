package entity;

import javax.persistence.*;
import java.util.Collection;

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

    @OneToMany
    Collection<Borrowable> borrowables;
}
