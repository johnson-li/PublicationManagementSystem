package service.impl;

import dao.FriendDao;
import entity.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.FriendManagementService;

/**
 * Created by johnson on 6/5/15.
 */
@Service
public class FriendManagementServiceImpl implements FriendManagementService{

    @Autowired
    FriendDao friendDao;

    @Override
    public Friend getFriend(String name) {
        return friendDao.getFriend(name);
    }

    @Override
    public Friend addFriend(String name) {
        Friend friend = friendDao.addFriend(name);
        return friend;
    }
}
