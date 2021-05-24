package pl.air.hr.service;

import pl.air.hr.dao.DepartmentDAO;
import pl.air.hr.dao.EmployeeDAO;
import pl.air.hr.dao.ProjectDAO;
import pl.air.hr.dao.hibernate.DepartmentDAOImpl;
import pl.air.hr.dao.hibernate.EmployeeDAOImpl;
import pl.air.hr.dao.hibernate.ProjectDAOImpl;
import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DataService {
	
	public static void insertInitData() {
		
		// utwórz projekty
		Project fk = createProject("Wdrożenie modułu FK", LocalDate.parse("2020-02-01"), null);
		Project orp = createProject("Opracowanie regulaminu pracy", LocalDate.parse("2021-01-01"),LocalDate.parse("2021-04-15"));
		Project wio = createProject("Przygotowanie strategii sprzedażowej \"WIOSNA 2021\"", LocalDate.parse("2020-09-01"),LocalDate.parse("2021-01-31"));
		Project nadz = createProject("Przejęcie firmy \"NOWA NADZIEJA\"", LocalDate.parse("2020-06-01"), null);
		Project ons = createProject("Opracowanie nowej strony firmowej", LocalDate.parse("2019-04-01"), LocalDate.parse("2019-07-31"));

		// utwórz działy
		Department za = createDepartment("Zarząd","4. piętro");
		Department ma = createDepartment("Marketing","3. piętro, open space");
		Department sp = createDepartment("Sprzedaż","2. piętro, pokoje 2.11-2.30");
		Department ks = createDepartment("Księgowość","2. piętro, pokoje 2.1-2.10");
		Department ad = createDepartment("Administracja","1. piętro");
		Department it = createDepartment("IT", "podziemia");
		
		// utwórz książki
		Employee nowak = createEmployee("Jan","Nowak",BigDecimal.valueOf(Long.parseLong("22000")), LocalDate.parse("1990-01-01"), za, orp);
		Employee mucha = createEmployee("Anna","Mucha",BigDecimal.valueOf(Long.parseLong("14000")), LocalDate.parse("1991-05-01"), sp, fk, wio);
		Employee sruba = createEmployee("Karol","Srubka",BigDecimal.valueOf(Long.parseLong("7500")), LocalDate.parse("2010-09-01"), sp, orp);
		Employee trucz = createEmployee("Urszula","Truczynska",BigDecimal.valueOf(Long.parseLong("5000")), LocalDate.parse("2009-12-15"), sp, wio, ons);
		Employee natol = createEmployee("Aniela","Natolik",BigDecimal.valueOf(Long.parseLong("13000")), LocalDate.parse("2001-06-01"), ks, fk, nadz);
		Employee handke = createEmployee("Karolina","Handke",BigDecimal.valueOf(Long.parseLong("6800")), LocalDate.parse("2017-04-15"), ks, orp);
		Employee banas = createEmployee("Maria","Banasik",BigDecimal.valueOf(Long.parseLong("4800")), LocalDate.parse("2005-08-01"), ks, fk);
		Employee piec = createEmployee("Adam","Pieczynski",BigDecimal.valueOf(Long.parseLong("2600")), LocalDate.parse("2020-02-15"), ks, fk);
		Employee glus = createEmployee("Tomasz","Gluszek",BigDecimal.valueOf(Long.parseLong("8000")), LocalDate.parse("2011-03-01"), it, fk);
		Employee matec = createEmployee("Klara","Matecka",BigDecimal.valueOf(Long.parseLong("15000")), LocalDate.parse("2014-10-15"), it, ons);

		// zapisz dane w bazie danych
		HibernateService.beginTransaction();

		ProjectDAO projectDAO = new ProjectDAOImpl();
		projectDAO.save(fk);
		projectDAO.save(orp);
		projectDAO.save(wio);
		projectDAO.save(nadz);
		projectDAO.save(ons);

		DepartmentDAO departmentDAO = new DepartmentDAOImpl();
		departmentDAO.save(za);
		departmentDAO.save(ma);
		departmentDAO.save(sp);
		departmentDAO.save(ks);
		departmentDAO.save(ad);
		departmentDAO.save(it);

		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.save(nowak);
		employeeDAO.save(mucha);
		employeeDAO.save(sruba);
		employeeDAO.save(trucz);
		employeeDAO.save(natol);
		employeeDAO.save(handke);
		employeeDAO.save(banas);
		employeeDAO.save(piec);
		employeeDAO.save(glus);
		employeeDAO.save(matec);

		HibernateService.commitTransaction();

	}

	private static Project createProject(String name, LocalDate startDate, LocalDate endDate ) {
		Project one = new Project();
		one.setName(name);
		one.setStartDate(startDate);
		one.setEndDate(endDate);
		return one;
	}

	private static Department createDepartment(String name,String location) {
		Department one = new Department();
		one.setName(name);
		one.setLocation(location);
		return one;
	}
	
	private static Employee createEmployee(String firstName, String lastName, BigDecimal salary, LocalDate hireDate, Department department, Project... projects) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		employee.setHireDate(hireDate);
		employee.setProjects(List.of(projects));
		employee.setDepartment(department);
		return employee;
	}

}
