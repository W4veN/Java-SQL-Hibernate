package pl.air.hr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
@NoArgsConstructor @Getter @Setter
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "pro_id", referencedColumnName = "pro_id")
    )
    private List<Project> projects = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;


}
