package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    List<User> readListUsers();

    void update(long id, User updatedUser);

    void delete(long id);

    User show(long id);
}
