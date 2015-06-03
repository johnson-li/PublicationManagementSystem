package dao.impl;

import dao.CommentDao;
import entity.AbstractBook;
import entity.AbstractComment;
import entity.URLComment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by johnson on 6/3/15.
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public AbstractComment updateComment(AbstractComment comment) {
        sessionFactory.getCurrentSession().update(comment);
        return comment;
    }

    @Override
    @Transactional
    public URLComment createUrlComment(URL url) {
        URLComment urlComment = new URLComment();
        urlComment.setUrl(url);
        sessionFactory.getCurrentSession().save(urlComment);
        return urlComment;
    }

    @Override
    @Transactional
    public AbstractBook attachComment(AbstractBook book, AbstractComment comment) {
        Collection<AbstractComment> comments = book.getComments();
        if (comments == null) comments = new HashSet<>();
        comments.add(comment);
        book.setComments(comments);
        sessionFactory.getCurrentSession().update(book);
        return book;
    }
}
