package com.situ.ssm.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.situ.ssm.entity.Student;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	@RequestMapping(value="/getPage")
	public ModelAndView getPage(){
		ModelAndView modelAndView = new ModelAndView();
		/*modelAndView.setViewName("/WEB-INF/jsp/student_add.jsp");*/
		modelAndView.setViewName("student_add");
		return modelAndView;
	}
	@RequestMapping(value="/add")
	 public ModelAndView add(Student student) {
	        System.out.println(student);
	        //request.setAttribute("student", student);
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("student", student);
	        //request.getRequestDispatcher("/student_info.jsp").forward();
	       /* modelAndView.setViewName("/WEB-INF/jsp/student_info.jsp");*/
	        modelAndView.setViewName("student_info");
	        return modelAndView;
	    }
	@RequestMapping(value="/add2")
	public String add2(Student student,Model model){
		System.out.println(student);
		model.addAttribute("student", student);
		return "/student_info";
	}
	@RequestMapping(value="/add3",method=RequestMethod.POST)
	public String add3(String	name,int age,Model model){
		System.out.println("name" + name);
		System.out.println("age" + age);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "/student_info";
	}
	
	@RequestMapping(value="add4")
	public void add4(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name + ":" + age);
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.getRequestDispatcher("/WEB-INF/jsp/student_info.jsp").forward(request, response);;
	}

	@RequestMapping(value="/delete")
	public String delete(int id,Model model){
		System.out.println(id);
		model.addAttribute("id",id);
		/*return "/WEB-INF/jsp/student_info.jsp";*/
		return "student_info";
	}

}
