package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.*;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void createUser(User user) {
        entityManager.persist(user);
    }

    public List<User> readListUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public User show(long id) {
        return readListUsers().stream().filter(user -> user.getId() == id).findAny().orElse (null);
    }

    public void update(long id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setFirstName(updatedUser.getFirstName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
        entityManager.merge(userToBeUpdated);
    }

    public void delete(long id) {
        entityManager.remove(show(id));
    }
}
