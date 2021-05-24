package pl.air.hr.dao;

import pl.air.hr.model.Department;
import pl.air.hr.model.Employee;

import java.util.List;

public interface DepartmentDAO {

    //CRUD - create, read, update, delete

    //create, obiekt klasy autor zapisac w bazie danych, zwraca id nowo zapisanego obiektu
    Long save (Department object);

    //read
    Department findById(Long id); //Odczyt z bazy danych autora o podanym id, zwraca wystapienie klasy autor
    Department findByName(String name);
    List<Department> findAll(); //Odczyt z bazy danych wszystkich autorów

    //update, sluzy aktualizacji danych
    void update(Employee object); //odczytujemy dane z bazy danych, potem readem uzyskalismy obiekt klasy autor, zmieniamy dane

    //delete, usuwamy
    void delete(Employee object);
    
}
