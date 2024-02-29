package com.zcy.common;


import com.zcy.domain.Page;
import com.zcy.domain.User;

public interface UserService {
    public boolean existUser(String email);

    public boolean createUser(User user);

    public User getUser(long id);

    public Page<User> listUser(int pageNo);

}

