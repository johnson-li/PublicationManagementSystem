package dao;

import entity.AbstractBook;
import entity.AbstractComment;
import entity.URLComment;

import java.net.URL;

/**
 * Created by johnson on 6/3/15.
 */
public interface CommentDao {

    URLComment createUrlComment(URL url);

    AbstractComment updateComment(AbstractComment comment);

    AbstractBook attachComment(AbstractBook book, AbstractComment comment);
}
