package Dao;

import entity.Direction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;


public class DirectionDao extends AbstractJpaDao<Direction,Integer> {
    public DirectionDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Direction> getEntityClass() {
        return Direction.class;
    }
    public List<Direction> loadDirection(String beginning, String destination, Date dateOfDeparture ){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Direction> criteriaQuery = cb.createQuery(Direction.class);
        Root<Direction> fromDirection = criteriaQuery.from(Direction.class);
        Predicate predicate  =cb.and(cb.equal(fromDirection.get("beginning"),beginning),cb.equal(fromDirection.get("destination"),destination),
                cb.equal(fromDirection.get("dateOfDeparture"),dateOfDeparture));
        criteriaQuery.select(fromDirection).where(predicate).orderBy(cb.asc(fromDirection.get("hourOfDeparture")));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    public Direction loadDirectionById(Integer id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Direction> criteriaQuery = cb.createQuery(Direction.class);
        Root<Direction> fromDirection = criteriaQuery.from(Direction.class);
        criteriaQuery.select(fromDirection).where(cb.equal(fromDirection.get("id"),id));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
//    java.util.Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deliveryDate"));
//    java.util.Date selectedTime = new SimpleDateFormat("hh:mm:ss").parse(request.getParameter("deliveryTime"));
//    // Add the lines below
//    java.sql.Date selectedSQLDate =  new java.sql.Date(selectedDate.getTime());
//    java.sql.Time selectedSQLTime =  new java.sql.Time(selectedTime.getTime());