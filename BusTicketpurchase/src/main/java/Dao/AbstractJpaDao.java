package Dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class AbstractJpaDao<T,U>{
    protected EntityManager entityManager;
    public AbstractJpaDao(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }
    public void save(T entity )
    {entityManager.persist(entity);}
    public T load (U id )
    {
        return entityManager.find(getEntityClass(),id );
    }
    public void delete (T entity)
    {
        entityManager.remove(entity);
    }
    public void update(T entity)
    {
        entityManager.merge(entity);
    }
    public CriteriaBuilder getCriteriaBuilder(){
        return entityManager.getCriteriaBuilder();
    }
    public CriteriaQuery<T> getCriteriaQuery(){
        return getCriteriaBuilder().createQuery(getEntityClass());
    }


    public List<T> loadall ( )
    {
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery=cb.createQuery(getEntityClass());
        criteriaQuery.select(criteriaQuery.from(getEntityClass()));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public abstract Class <T> getEntityClass();
}
