package pl.air.hr.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;
import pl.air.hr.dao.ProjectDAO;
import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;
import pl.air.hr.service.HibernateService;

import java.io.Serializable;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {

    private Session getSession() {
        return HibernateService.getSession();
    }

    @Override
    public Long save(Project object) {
        Serializable id = getSession().save(object); //insert into table
        return (Long) id;
    }

    @Override
    public Project findById(Long id) {
        Project one =getSession().get(Project.class, id);
        return one;
    }

    @Override
    public List<Project> findByEmployeeName(Employee employee) {
        Query<Project> query = getSession().createQuery("from Project where :employee MEMBER OF employees", Project.class);
        query.setParameter("employee",employee);
        List<Project> all = query.getResultList();
        return all;
    }

    @Override
    public Project findByName(String name) {
        Query<Project> query = getSession().createQuery("from Project where name = :name", Project.class); //ma byc czlonkiem w kolekcji employees
        query.setParameter("name", name);

        Project one = query.getSingleResult();

        return one;
    }

    @Override
    public List<Project> findAll() {
        Query<Project> query = getSession().createQuery("from Project", Project.class); //zamienia na select * from authors
        List<Project> all = query.getResultList();
        return all;
    }

    @Override
    public void update(Project object) {
        getSession().update(object);
    }

    @Override
    public void delete(Project object) {
        getSession().delete(object);
    }
}
