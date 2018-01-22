package com.situ.ssm.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.ssm.entity.Student;
@Controller
@RequestMapping(value="/json")
	public class JsonController {
	    @RequestMapping(value="/findAll")
	    @ResponseBody
	    public List<Student> findAll() {
	        List<Student> list = new ArrayList<Student>();
	        for (int i = 0; i < 100; i++) {
	           Student student = new Student("zhang" + i, 20, "男", "青岛", new Date());
	           list.add(student);
	        }
	        return list;
	    }
	}


