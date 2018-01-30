package com.springrest.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springrest.rest.model.EduTeachers;
import com.springrest.rest.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/query")
    public String test(){
        ObjectMapper objectMapper = new ObjectMapper();

        Page<EduTeachers> datas = teacherService.query("李","1","硕","乐");
        List<EduTeachers> content = datas.getContent();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("totalPage",datas.getTotalPages());
        map.put("totalElements",datas.getTotalElements());
        map.put("content",content);

        try {
            return  objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }



    }
}
