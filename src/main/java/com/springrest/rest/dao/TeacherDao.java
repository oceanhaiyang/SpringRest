package com.springrest.rest.dao;

import com.springrest.rest.model.EduTeachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherDao extends JpaSpecificationExecutor<EduTeachers>,JpaRepository<EduTeachers ,Integer> {

}
