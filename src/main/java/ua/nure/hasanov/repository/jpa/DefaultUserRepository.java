package ua.nure.hasanov.repository.jpa;

import org.springframework.stereotype.Repository;
import ua.nure.hasanov.entity.User;
import ua.nure.hasanov.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@PersistenceContext
@Repository("userRepository")
public class DefaultUserRepository extends AbstractRepository<User> implements UserRepository {

    public DefaultUserRepository() {
        super(User.class);
    }

    @Override
    public User find(String login) {
        EntityManager entityManager = getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot = criteriaQuery.from(User.class);

        criteriaQuery.select(userRoot);
        criteriaQuery.where(criteriaBuilder.equal(userRoot.get("login"), login));

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
