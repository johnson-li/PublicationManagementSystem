package entity;

import javax.persistence.*;

/**
 * Created by johnson on 5/28/15.
 */
@Entity
@Table(name = "PAPER_BOOK")
public class PaperBook extends AbstractBook {

    private int num;
    private int readable;

    public int getReadable() {
        return readable;
    }

    public void setReadable(int readable) {
        this.readable = readable;
    }

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
