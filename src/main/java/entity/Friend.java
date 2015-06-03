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
}
