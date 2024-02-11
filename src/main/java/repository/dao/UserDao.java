package repository.dao;

import repository.entities.User;

public interface UserDao {
    public User getUserByEmail(String email);
}
