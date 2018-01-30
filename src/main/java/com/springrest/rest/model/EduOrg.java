package com.springrest.rest.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Edu_Org")
public class EduOrg {

    private Integer id;
    private Integer parent_id;

    private String orgname;
    private String is_use;
    private Date update_date;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id =id;
    }
    public Integer getParent_id() {
        return parent_id;
    }
    public void setParent_id(Integer parent_id) {
        this.parent_id= parent_id;
    }
    @Column(name="org_name")
    public String getOrgname() {
        return orgname;
    }
    public void setOrgname(String orgname) {
        this.orgname= orgname;
    }
    public String getIs_use() {
        return is_use;
    }
    public void setIs_use(String is_use) {
        this.is_use= is_use;
    }
    public Date getUpdate_date() {
        return update_date;
    }
    public void setUpdate_date(Date update_date) {
        this.update_date= update_date;
    }
    @Override
    public String toString() {
        return"EduOrg [id=" + id + ", parent_id=" + parent_id + ",org_name=" + orgname + ", is_use=" + is_use
                +", update_date=" + update_date + "]";
    }

}