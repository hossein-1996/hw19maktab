package Dao;
import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;

public class UserDao extends AbstractJpaDao<User,Integer> {
    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
    public User loadUser(String username, String password) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> fromEmployee = criteriaQuery.from(User.class);
        Predicate predicate = cb.and(cb.equal(fromEmployee.get("userName"), username),
                cb.equal(fromEmployee.get("password"),password));
        criteriaQuery.select(fromEmployee).where(predicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
