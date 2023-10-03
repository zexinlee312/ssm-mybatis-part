package org.example.mapper;

import org.example.bean.User;

import java.util.List;

public interface UserMapper {
    int insertUser(User user);

    int updateUser(User user);

    int deleteUserById(Integer id);

    User selectUserById(Integer id);

    List<User> selectAllUser();
}
