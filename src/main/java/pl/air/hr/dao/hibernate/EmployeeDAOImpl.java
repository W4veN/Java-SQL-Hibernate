package pl.air.hr.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;
import pl.air.hr.service.HibernateService;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private Session getSession() {
        return HibernateService.getSession();
    }

    @Override
    public Long save(Employee object) {
        Serializable id = getSession().save(object); //insert into table
        return (Long) id;
    }

    @Override
    public Employee findById(Long id) {
        Employee one =getSession().get(Employee.class, id);
        return one;
    }

    @Override
    public Employee findByName(String firstName, String lastName) {
        Query<Employee> query = getSession().createQuery("from Employee where firstName = :firstName and lastName = :lastName", Employee.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);

        Employee one = query.getSingleResult();

        return one;
    }

    @Override
    public Employee findByDepartment(String dep_id) {
        Query<Employee> query = getSession().createQuery("from Employee where dep_id = :dep_id", Employee.class);
        query.setParameter("dep_id", dep_id);
        Employee one = query.getSingleResult();

        return one;
    }

    @Override
    public Employee findByHireDate(LocalDate hire_date) {
        return null;
    }

    @Override
    public List<Employee> findAll() {

        Query<Employee> query = getSession().createQuery("from Employee", Employee.class); //zamienia na select * from authors
        List<Employee> all = query.getResultList();
        return all;
    }

    @Override
    public void update(Employee object) {
        getSession().update(object);
    }

    @Override
    public void delete(Employee object) {
        getSession().delete(object);
    }
}
