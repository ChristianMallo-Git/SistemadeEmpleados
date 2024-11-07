package cm.Employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Column(name = "name_employee")
    private String nameEmployee;
    @Column(name = "department_employee")
    private String departmentEmployee;
    @Column(name = "salary_employee")
    private Double salaryEmployee;
}
