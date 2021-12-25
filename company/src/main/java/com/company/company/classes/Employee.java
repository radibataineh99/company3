package com.company.company.classes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity(name="employee")
@Table
@SecondaryTable(name = "department", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
@SecondaryTable(name = "project", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
@SecondaryTable(name = "job", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Employee {

    @Id
    @SequenceGenerator(
            name="employee_id_seq",
            sequenceName = "employee_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_seq"
    )
    @Column(name="id")
    private Long id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email")
    private String email;

    @Column(name="dob")
    private LocalDate dob;

    @Transient
    private Integer age;

    @Column(name="created_by")
    private String created_by;

    @Column(name="created_date")
    private LocalDate created_date;

    @Column(name = "updated_by")
    private String updated_by;

    @Column(name = "updated_date")
    private LocalDate updated_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    //@JsonIgnore
    //@JsonIgnoreProperties(value =  "department" , allowSetters = true , allowGetters = true,ignoreUnknown = true)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    //@JsonIgnore
    //@JsonIgnoreProperties(value =  "job" , allowSetters = true , allowGetters = true,ignoreUnknown = true)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    //@JsonIgnore
    //@JsonIgnoreProperties(value =  "project" , allowSetters = true, allowGetters = true,ignoreUnknown = true)
    private Project project;

    public Employee() {
    }

    public Employee(Long id, String first_name, String last_name,
                    String email, LocalDate dob, String created_by,
                    LocalDate created_date, String updated_by, LocalDate updated_date,
                    Long department_id, Long job_id, Long project_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.dob = dob;
        this.created_by = created_by;
        this.created_date = created_date;
        this.updated_by = updated_by;
        this.updated_date = updated_date;

        this.department=new Department();
        this.department.setId(department_id);
        this.job=new Job();
        this.job.setId(job_id);
        this.project=new Project();
        this.project.setId(project_id);

        //System.out.println(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @JsonIgnore
    public Department getDepartment() {
        return department;
    }

    @JsonProperty
    public void setDepartment(Department department) {
        this.department = department;
    }

    @JsonIgnore
    public Job getJob() {
        return job;
    }

    @JsonProperty
    public void setJob(Job job) {
        this.job = job;
    }

    @JsonIgnore
    public Project getProject() {
        return project;
    }

    @JsonProperty
    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", created_by='" + created_by + '\'' +
                ", created_date=" + created_date +
                ", updated_by='" + updated_by + '\'' +
                ", updated_date=" + updated_date +
                '}';
    }
}
