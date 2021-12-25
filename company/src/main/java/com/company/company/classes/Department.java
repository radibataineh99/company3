package com.company.company.classes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity(name = "department")
@Table
public class Department {

    @Id
    @SequenceGenerator(
            name="department_id_seq",
            sequenceName = "department_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_id_seq"
    )
    @Column(name="id")
    private Long id;

    @Column(name = "department_name")
    private String department_name;

    @Column(name="created_by")
    private String created_by;

    @Column(name="created_date")
    private LocalDate created_date;

    @Column(name="updated_by")
    private String updated_by;

    @Column(name="updated_date")
    private LocalDate updated_date;

    @OneToMany(mappedBy = "department" ,orphanRemoval = true, cascade = CascadeType.PERSIST )
    private List<Employee> employees;

    public Department() {
    }

    public Department(Long id, String department_name,
                      String created_by, LocalDate created_date,
                      String updated_by, LocalDate updated_date) {
        this.id = id;
        this.department_name = department_name;
        this.created_by = created_by;
        this.created_date = created_date;
        this.updated_by = updated_by;
        this.updated_date = updated_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public LocalDate getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDate updated_date) {
        this.updated_date = updated_date;
    }

   /* public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }*/

    @Override
    public String toString() {
        return "department{" +
                "id=" + id +
                ", department_name='" + department_name + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_date=" + created_date +
                ", updated_by='" + updated_by + '\'' +
                ", updated_date=" + updated_date +
                '}';
    }
}
