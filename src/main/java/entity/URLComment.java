package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.net.URL;

/**
 * Created by johnson on 6/3/15.
 */
@Entity
@Table(name = "URL_COMMENT")
public class URLComment extends AbstractComment {

    URL url;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public StringBuffer getComment() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(url);
        return stringBuffer;
    }
}
