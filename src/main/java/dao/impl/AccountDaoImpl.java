package dao.impl;

import dao.AccountDao;
import entity.Account;
import entity.Friend;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by johnson on 6/5/15.
 */
@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public Account createAccount(Friend friend) {
        Account account = new Account();
        account.setFriend(friend);
        sessionFactory.getCurrentSession().save(account);
        return account;
    }
}
