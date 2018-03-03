package net.evercodig.helloblog.service;

import net.evercodig.helloblog.common.LoginState;
import net.evercodig.helloblog.pojo.UserVO;

public interface LoginService {
    LoginState compare(UserVO userVO);
}
