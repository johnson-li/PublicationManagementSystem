package service;

import entity.Friend;

/**
 * Created by johnson on 6/5/15.
 */
public interface FriendManagementService {

    Friend addFriend(String name);

    Friend getFriend(String name);
}
