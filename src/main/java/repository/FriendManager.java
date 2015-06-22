package repository;

import entity.Account;
import entity.Friend;
import javafx.util.Pair;
import service.PersistenceService;

/**
 * Created by johnson on 6/22/15.
 */
public class FriendManager {
    public static FriendManager instance = new FriendManager();

    public static FriendManager getInstance() {
        return instance;
    }

    public Friend addFriend(String name) {
        Friend friend = new Friend();
        friend.setName(name);
        PersistenceService.getInstance().save(friend);
        Account account = new Account();
        account.setFriend(friend);
        PersistenceService.getInstance().save(account);
        friend.setAccount(account);
        PersistenceService.getInstance().update(friend);
        return friend;
    }

    public Friend getFriend(String name) {
        String hql = "from entity.Friend where name = :name";
        Pair<String, Object> pair = new Pair<>("name", name);
        return (Friend)PersistenceService.getInstance().getObject(hql, pair);
    }
}
