package com.thyme.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.thyme.model.Student;
import com.thyme.repo.StudentRepo;

@Controller
public class controller {

	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/list")
	public ModelAndView listTable() {
		ModelAndView mv=new ModelAndView("studentdata");
		Iterable<Student> it=studentRepo.findAll();
		Iterator<Student> itr=it.iterator();
	    List<Student> data=new LinkedList<>();
	    while (itr.hasNext()) {
			data.add(itr.next());
			mv.addObject("data",data);
		}
	    return mv;
	}
	
// 
//	@ModelAttribute("project")
//	public pro newStudent() {
//		return s
//	}
//	
	@GetMapping("/form")
    public ModelAndView createProjectForm() {
        ModelAndView mv= new ModelAndView("studentform");
      mv.addObject("project", new Student());
        return mv;
    }
	
	@PostMapping("/addstudent")
	public String save(Student student) {
		studentRepo.save(student);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{sid}")
	public String deleteStudent(@PathVariable("sid") Integer sid) {
		studentRepo.deleteById(sid);
		return "redirect:/list";
	}
}
