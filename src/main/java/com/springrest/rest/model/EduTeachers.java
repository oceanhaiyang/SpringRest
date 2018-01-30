package com.springrest.rest.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="edu_teachers")
public class EduTeachers {

    private Integer id;

    private String empno;
    private String name;
    private String sex;
    private String degree;
    private Date update_date;
    private Integer org_id;

    private EduOrg org;

    public EduTeachers() {
        // TODOAuto-generated constructor stub
    }

    public EduTeachers(String empno, String name, String sex, String degree, Date update_date) {
        this.empno =empno;
        this.name =name;
        this.sex =sex;
        this.degree= degree;
        this.update_date= update_date;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id =id;
    }
    @Column(name="emp_no")
    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno =empno;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name =name;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex) {
        this.sex =sex;
    }
    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree= degree;
    }
    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date= update_date;
    }
    @Column(name="org_id",insertable=false,updatable=false)
    public Integer getOrg_id(){
        return org_id;
    }
    public void setOrg_id(Integer org_id) {
        this.org_id= org_id;
    }
    @Override
    public String toString() {
        return"EduTeachers [emp_no=" + empno + ", name=" + name + ",sex=" + sex + ", degree=" + degree
                +", update_date=" + update_date + ", org_id=" + org_id +"]";
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="org_id")
    public EduOrg getOrg(){
        return org;
    }

    public void setOrg(EduOrg org) {
        this.org =org;
    }

}