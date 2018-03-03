package net.evercodig.helloblog.service.impl;


import net.evercodig.helloblog.common.MD5;
import net.evercodig.helloblog.common.MD5Util;
import net.evercodig.helloblog.common.UserState;
import net.evercodig.helloblog.dao.UserDao;
import net.evercodig.helloblog.pojo.User;
import net.evercodig.helloblog.pojo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import net.evercodig.helloblog.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserState userSave(UserVO userVO) {
        String password = userVO.getPassword();
        password = MD5Util.generate(password);
        User user = new User();
        user.setUsername(userVO.getUsername());
        user.setPassword(password);
        user.setInintime(System.currentTimeMillis());
        user.setChangetime(System.currentTimeMillis());
        int i = userDao.insert(user);
        UserState result;
        if (i != 0) {
            result = UserState.Success;
        } else {
            result = UserState.Fail;
        }
        return result;
    }

    @Override
    public UserState userUpdate(UserVO userVO) {
        String password = userVO.getPassword();
        password = MD5.getMD5(password);
        User user = new User();
        user.setId(userVO.getId());
        user.setUsername(userVO.getUsername());
        user.setPassword(password);
        user.setChangetime(System.currentTimeMillis());
        int i = userDao.updateByPrimaryKeySelective(user);
        UserState result;
        if (i != 0) {
            result = UserState.Success;
        } else {
            result = UserState.Fail;
        }
        return result;
    }
}
