package entity;

import javax.persistence.*;

/**
 * Created by johnson on 5/28/15.
 */
@Entity
@Table(name = "FRIEND")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @OneToOne
    private Account account;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
