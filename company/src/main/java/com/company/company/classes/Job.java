package com.company.company.classes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name="job")
@Table
public class Job {

    @Id
    @SequenceGenerator(
            name="job_id_seq",
            sequenceName = "job_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "job_id_seq"
    )
    @Column(name="id")
    private Long id;

    @Column(name="job_name")
    private String job_name;

    @Column(name = "created_by")
    private String created_by;

    @Column(name="created_date")
    private LocalDate created_date;

    @Column(name="updated_by")
    private String updated_by;

    @Column(name="updated_date")
    private LocalDate updated_date;

    @OneToMany(mappedBy = "job" ,orphanRemoval = true, cascade = CascadeType.PERSIST )
    private List<Employee> employees;

    public Job() {
    }

    public Job(Long id, String job_name, String created_by,
               LocalDate created_date, String updated, LocalDate updated_date) {
        this.id = id;
        this.job_name = job_name;
        this.created_by = created_by;
        this.created_date = created_date;
        this.updated_by = updated;
        this.updated_date = updated_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
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

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", job_name='" + job_name + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_date=" + created_date +
                ", updated_by='" + updated_by + '\'' +
                ", updated_date=" + updated_date +
                '}';
    }
}
