package entity;

import javax.persistence.*;
import java.net.URL;

/**
 * Created by johnson on 5/28/15.
 */
@Entity
@Table(name = "E_BOOK")
public class EBook extends AbstractBook{

    private URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EBook{" +
                "url=" + url +
                "} " + super.toString();
    }
}
