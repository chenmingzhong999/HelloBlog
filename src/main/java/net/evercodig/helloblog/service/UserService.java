package net.evercodig.helloblog.service;

import net.evercodig.helloblog.common.UserState;
import net.evercodig.helloblog.pojo.UserVO;

public interface UserService {
    UserState userSave(UserVO userVO);

    UserState userUpdate(UserVO userVO);
}

