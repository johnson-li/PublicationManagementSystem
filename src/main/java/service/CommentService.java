package service;

import entity.AbstractBook;
import entity.AbstractComment;
import entity.URLComment;

import java.net.URL;
import java.util.Collection;

/**
 * Created by johnson on 6/1/15.
 */
public interface CommentService {

    Collection<AbstractComment> collectComment(AbstractBook book);

    void recordComment(AbstractBook book, AbstractComment... abstractComments);

    URLComment getUrlComment(URL url);
}
