package service.impl;

import dao.CommentDao;
import entity.AbstractBook;
import entity.AbstractComment;
import entity.URLComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CommentService;

import java.net.URL;
import java.util.Collection;
import java.util.Date;

/**
 * Created by johnson on 6/3/15.
 */
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentDao commentDao;

    @Override
    public void recordComment(AbstractBook book, AbstractComment... abstractComments) {
        for (AbstractComment abstractComment: abstractComments) {
            commentDao.attachComment(book, abstractComment);
        }
    }

    @Override
    public URLComment getUrlComment(URL url) {
        URLComment urlComment = commentDao.createUrlComment(url);
        initUrlComment(urlComment);
        commentDao.updateComment(urlComment);
        return urlComment;
    }

    @Override
    public Collection<AbstractComment> collectComment(AbstractBook book) {
        return book.getComments();
    }

    /**
     * update comment info by content on the web according to url
     */
    void initUrlComment(URLComment urlComment) {
        urlComment.setDate(new Date());
        urlComment.setAuthor("johnson");
    }
}
