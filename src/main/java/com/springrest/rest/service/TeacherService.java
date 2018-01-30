package com.springrest.rest.service;

import com.springrest.rest.model.EduTeachers;
import com.zslin.model.EduTeachers;
import org.springframework.data.domain.Page;

public interface TeacherService {

    public Page<EduTeachers> query(final String tname, final String sex, final String degree, final String orgname);
}
