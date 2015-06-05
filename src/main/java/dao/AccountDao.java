package dao;

import entity.Account;
import entity.Friend;

/**
 * Created by johnson on 6/3/15.
 */
public interface AccountDao {

    Account createAccount(Friend friend);
}
