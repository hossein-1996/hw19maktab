package dao;

import entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDao extends AbstractEntityDao<Employee, Integer> {
    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    public Class<Employee> getClassType() {
        return Employee.class;
    }

    public List<Employee> loadAll( EntityManager entityManager){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder() ;
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> fromEmployee = criteria.from(Employee.class);
        criteria.select(fromEmployee);
        TypedQuery<Employee> query = entityManager.createQuery(criteria);
        return  query.getResultList();
    }
}
