package pl.air.hr;

import pl.air.hr.dao.DepartmentDAO;
import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.dao.ProjectDAO;
import pl.air.hr.dao.hibernate.DepartmentDAOImpl;
import pl.air.hr.dao.hibernate.EmployeeDAOImpl;
import pl.air.hr.dao.hibernate.ProjectDAOImpl;
import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;
import pl.air.hr.service.DataService;
import pl.air.hr.service.HibernateService;
import pl.air.hr.service.PrintService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("---------- Start ----------");
        // uruchom Hibernate
        HibernateService.startup();

        // wstaw dane do tabel w bazie danych
        DataService.insertInitData();

        //dao
        ProjectDAO projectDAO = new ProjectDAOImpl();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();

        //poczatek transakcji
        HibernateService.beginTransaction();

        Employee mucha = employeeDAO.findByName("Anna","Mucha");
        PrintService.printEmployee(mucha);
        //List<Project> micBooks = projectDAO.findByEmployeeName(mucha);
        //PrintService.printProjectList(micBooks);


        //koniec transakcji
        HibernateService.commitTransaction();

        // zakończ Hibernate
        HibernateService.shutdown();

        System.out.println("---------- Koniec ----------");
    }
}
