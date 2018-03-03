package net.evercodig.helloblog.dao;

import net.evercodig.helloblog.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    User findUserByName(String username);
}
