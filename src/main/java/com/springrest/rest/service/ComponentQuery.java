package com.springrest.rest.service;

import com.springrest.rest.dao.TeacherDao;
import com.springrest.rest.model.EduTeachers;
import com.zslin.dao.TeacherDao;
import com.zslin.model.EduTeachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComponentQuery implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;

    @Transactional
    public Page<EduTeachers> query(final String tname, final String sex,
                                   final String degree, final String orgname) {



        Specification querySpecifi = new Specification<EduTeachers>() {
            @Override
            public Predicate toPredicate(Root<EduTeachers> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Path<String> namepath = root.get("name");
                Path<String> sexpath = root.get("sex");
                Path<String> degreepath = root.get("degree");
                List<Predicate> list = new ArrayList< Predicate >();
                if (tname != null && !"".equals(tname)) {
                    list.add(cb.like(namepath, "%" + tname + "%"));
                }
                if (sex != null && !"".equals(sex)) {
                    list.add(cb.like(sexpath, "%" + sex + "%"));
                }
                if (degree != null && !"".equals(degree)) {
                    list.add(cb.like(degreepath, "%" + degree + "%"));
                }
                if (orgname != null && !"".equals(orgname)) {
                    Path<String> orgnamepath = root.get("org").get("orgname");
                    list.add(cb.like(orgnamepath, "%" + orgname + "%"));
                }
                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        };

        PageRequest pageRequest = new PageRequest(0, 2, new Sort(Sort.Direction.DESC, "org.orgname"));
        Page<EduTeachers> datas = teacherDao.findAll(querySpecifi,pageRequest);
        /**
         * List getContent(); // 返回分页后的数据的列表
         int getTotalPages(); // 总页数
         long getTotalElements(); // 总数据量
         boolean isFirst(); // 是否是第一个数据；
         boolean isLast(); // 是否是最后一个数据；
         int getNumber(); // 当前页面索引
         */
        datas.getTotalPages();
        datas.getTotalElements();
        datas.getContent();
        datas.getNumber();

        return datas;
    }
}
