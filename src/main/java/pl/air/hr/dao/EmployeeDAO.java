package pl.air.hr.dao;

import pl.air.hr.model.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeDAO {

    //CRUD - create, read, update, delete

    //create, obiekt klasy autor zapisac w bazie danych, zwraca id nowo zapisanego obiektu
    Long save (Employee object);

    //read
    Employee findById(Long id); //Odczyt z bazy danych autora o podanym id, zwraca wystapienie klasy autor
    Employee findByName(String firstName, String lastName);
    Employee findByDepartment(String dep_id);
    Employee findByHireDate(LocalDate hire_date);
    List<Employee> findAll(); //Odczyt z bazy danych wszystkich autorów

    //update, sluzy aktualizacji danych
    void update(Employee object); //odczytujemy dane z bazy danych, potem readem uzyskalismy obiekt klasy autor, zmieniamy dane

    //delete, usuwamy
    void delete(Employee object);
    
}
