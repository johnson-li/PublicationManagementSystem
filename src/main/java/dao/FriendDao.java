package dao;

import entity.Friend;

/**
 * Created by johnson on 6/5/15.
 */
public interface FriendDao {

    Friend addFriend(String name);

    Friend getFriend(String name);
}
