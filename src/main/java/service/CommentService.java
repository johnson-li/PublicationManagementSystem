package service;

import entity.AbstractBook;
import entity.Comment;

import java.util.Collection;

/**
 * Created by johnson on 6/1/15.
 */
public interface CommentService {

    Collection<Comment> collectComment(AbstractBook book);

    void recordComment(AbstractBook book, Collection<Comment> comments);
}
