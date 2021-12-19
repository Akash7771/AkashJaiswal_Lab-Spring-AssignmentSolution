package com.greatlearning.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.greatlearning.entities.Student;
import com.greatlearning.services.StudentService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping({"/" , "/student-list"})
	public String mainPage(Model model){
		
		List<Student> theStudents = studentService.getAllStudents();
		model.addAttribute("theStudents", theStudents);
		return "student-list";
	}

	@RequestMapping("/addStudent")
	public String addStudentPage(){
		return "save-student";
	}
	
	@RequestMapping(value = "/saveStudentForm" , method=RequestMethod.POST )
	public String addNewStudent(@ModelAttribute Student theStudent){
		studentService.saveStudent(theStudent);
		return "redirect:/student-list";
	}
	
	
	@RequestMapping(value ="updateStudent")
	public String updateStudentPage(Model model, @Param(value="studentId") Integer studentId){
		Student theStudent = studentService.getStudentById(studentId);		
		model.addAttribute("theStudent",theStudent);
		
		return "edit-student";
	}
	
	@RequestMapping(value = "/updateStudentForm" , method=RequestMethod.POST )
	public String updateNewStudent(Model model , @ModelAttribute Student theStudent , @RequestParam(value="studentId") Integer studentId){
		
		System.out.println("THE STUDENT _ UPDATE - " + theStudent);
		studentService.updateStudent(theStudent , studentId);
		return "redirect:student-list";
	}
	
	@RequestMapping("/deleteStudent")
	public String editStudentPage(@Param(value="studentId") Integer studentId ){		
		studentService.deleteStudent(studentId);
		return "redirect:/student-list";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}

	
}
