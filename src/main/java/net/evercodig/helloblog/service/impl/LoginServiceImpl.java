package net.evercodig.helloblog.service.impl;

import net.evercodig.helloblog.common.MD5Util;
import net.evercodig.helloblog.dao.LoginDao;
import net.evercodig.helloblog.pojo.User;
import net.evercodig.helloblog.pojo.UserVO;
import net.evercodig.helloblog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.evercodig.helloblog.common.LoginState;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDao loginDao;

    @Override
    public LoginState compare(UserVO userVO) {
        try{
            User user = loginDao.findUserByName(userVO.getUsername());
            String password = userVO.getPassword();
            password = MD5Util.generate(password);
            String findPassword = user.getPassword();
            if (password.equals(findPassword)) {
                return LoginState.Success;
            }else{
                return LoginState.Fail;
            }
        }catch (Exception e){
            return LoginState.Error;
        }
    }
}
