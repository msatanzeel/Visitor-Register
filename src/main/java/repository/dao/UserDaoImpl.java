package repository.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import repository.entities.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        List<User> users = (List<User>) hibernateTemplate.findByNamedParam(
                "from User u where u.email = :email", "email", email);
        return users.isEmpty() ? null : users.get(0);
    }
}
