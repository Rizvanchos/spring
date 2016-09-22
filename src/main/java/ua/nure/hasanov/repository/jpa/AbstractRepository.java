package ua.nure.hasanov.repository.jpa;

import ua.nure.hasanov.entity.DomainEntity;
import ua.nure.hasanov.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractRepository<T extends DomainEntity> implements Repository<T> {

    @PersistenceContext
    private EntityManager entityManager;
    private Class<T> clazz;

    public AbstractRepository(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public long count() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<T> root = criteriaQuery.from(clazz);

        criteriaQuery.select(criteriaBuilder.countDistinct(root));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public T load(int id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public Iterable<T> loadAll() {
        CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(clazz);
        criteria.select(criteria.from(clazz));
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public void add(T obj) {
        entityManager.persist(obj);
    }

    @Override
    public void delete(T obj) {
        entityManager.remove(obj);
    }

    @Override
    public void commit() {
        entityManager.flush();
    }
}
