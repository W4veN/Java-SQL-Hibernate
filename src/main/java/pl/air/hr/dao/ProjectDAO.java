package pl.air.hr.dao;

import pl.air.hr.model.Employee;
import pl.air.hr.model.Project;
import pl.air.hr.model.Project;

import java.util.List;

public interface ProjectDAO {

    //CRUD - create, read, update, delete

    //create, obiekt klasy autor zapisac w bazie danych, zwraca id nowo zapisanego obiektu
    Long save (Project object);

    //read
    Project findById(Long id); //Odczyt z bazy danych autora o podanym id, zwraca wystapienie klasy autor
    Project findByName(String name);
    List<Project> findByEmployeeName(Employee employee);
    List<Project> findAll(); //Odczyt z bazy danych wszystkich autorów

    //update, sluzy aktualizacji danych
    void update(Project object); //odczytujemy dane z bazy danych, potem readem uzyskalismy obiekt klasy autor, zmieniamy dane

    //delete, usuwamy
    void delete(Project object);
    
}
