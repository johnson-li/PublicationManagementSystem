package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by johnson on 5/28/15.
 */
@Entity
@Table(name = "PAPER_BOOK")
public class PaperBook extends AbstractBook{

    @Column
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PaperBook{" +
                "num=" + num +
                "} " + super.toString();
    }
}
