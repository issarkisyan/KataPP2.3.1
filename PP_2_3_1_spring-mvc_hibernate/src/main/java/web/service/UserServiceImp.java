package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional
    public void createUser(User user) {
        this.userDao.createUser(user);
    }
    @Transactional(readOnly = true)
    public List<User> readListUsers() {
        return this.userDao.readListUsers();
    }
    @Transactional
    public void update(long id, User updatedUser) {
        this.userDao.update(id,updatedUser);
    }
    @Transactional
    public void delete(long id) {
        this.userDao.delete(id);
    }
    @Transactional(readOnly = true)
    public User show(long id) {
        return this.userDao.show(id);
    }

}
