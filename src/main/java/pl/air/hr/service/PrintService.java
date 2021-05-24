package pl.air.hr.service;

import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;
import pl.air.hr.model.Department;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PrintService {

	/* projekt */
	private static String getProject(Project one) {
		Long id = one.getId();
		String name = one.getName();
		LocalDate startDate = one.getStartDate();
		LocalDate endDate = one.getEndDate();
		
		return String.format("%s %s %s (id = %d)", name, startDate, endDate,id);
	}

	public static void printProject(Project one) {
		String printout = getProject(one);
		System.out.println(printout);
	}

	public static void printProjectList(List<Project> list) {
		String printout = "";
		for (Project one : list) {
			printout += getProject(one) + ", ";
		}
		printout = printout.substring(0, printout.lastIndexOf(","));
		System.out.println(printout);
	}

	
	/* książka */
	public static void printEmployee(Employee one) {
		Long id = one.getId();
		String firstName = one.getFirstName();
		String lastName = one.getLastName();
		BigDecimal salary = one.getSalary();
		LocalDate hireDate = one.getHireDate();
		Department dep = one.getDepartment();
		List<Project> Projects = one.getProjects();

		// imie i nazwisko + id
		System.out.println(firstName + " " + lastName + " (id = " + id + ")");

		// autorzy
		/*if (Projects.size() == 1) {
			System.out.print(" - projekt: ");
		}
		else {
			System.out.print(" - projekty: ");
		}
		printProjectList(Projects);
		*/
		// wydawnictwo
		System.out.print(" - dział: ");
		printDepartment(dep);

		// rok wydania
		System.out.println(" - rok zatrudnienia: " + (hireDate != null ? hireDate : "---"));

		// cena
		System.out.println(" - pensja: " + (salary != null ? salary : "---") + " zł");
	}

	public static void printEmployeeList(List<Employee> list) {
		for (Employee one : list) {
			printEmployee(one);
		}
	}

	
	/* wydawnictwo */
	private static String getDepartment(Department one) {
		Long id = one.getId();
		String name = one.getName();
		String location = one.getLocation();
		
		return String.format("%s, %s (id = %d)", name, location, id);
	}
	
	public static void printDepartment(Department one) {
		String printout = getDepartment(one);
		System.out.println(printout);
	}

}
