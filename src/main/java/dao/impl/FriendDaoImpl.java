package dao.impl;

import dao.AccountDao;
import dao.FriendDao;
import entity.Account;
import entity.Friend;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by johnson on 6/5/15.
 */
@Repository
public class FriendDaoImpl implements FriendDao{

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AccountDao accountDao;

    @Override
    @Transactional
    public Friend addFriend(String name) {
        Friend friend = new Friend();
        friend.setName(name);
        sessionFactory.getCurrentSession().save(friend);
        Account account = accountDao.createAccount(friend);
        friend.setAccount(account);
        sessionFactory.getCurrentSession().save(friend);
        return friend;
    }

    @Transactional
    public Friend getFriend(String name) {
        String hql = "from entity.Friend where name = :name";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("name", name);
        List list = query.list();
        if (list == null || list.size() == 0) return null;
        return (Friend)list.get(0);
    }
}
