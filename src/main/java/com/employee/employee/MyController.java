package com.employee.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.employee.employee.entity.Employee;
import com.employee.employee.repo.EmployeeRepository;

import movie_crud.entity.Movie;


@Controller
public class MyController {
   
	
	
	@Autowired
	EmployeeRepository emprepo;
	
	
	
	@GetMapping("/")
		public String loadMain() {
			return "main.html";
		}
	@GetMapping("/add")
	public String loadAdd() {
		return "add.html";
	}
	
	@PostMapping("/add")
	
	public String add(@ModelAttribute Employee emp, RedirectAttributes attributes) {
		emprepo.save(emp);
		attributes.addFlashAttribute("message","Data Saved Sucesss");
		return "redirect:/"; 
	}
	
	@GetMapping("/view")
	
	public String view(RedirectAttributes attributes, ModelMap map) {
		List<Employee> list = emprepo.findAll();
		
		if(list.isEmpty()) {
			attributes.addFlashAttribute("message","No Record Prsent");
			return "redirect:/";
		}
		else {
			map.put("list", list);
			return "view.html";
		}
	
	}
	
	@GetMapping("/delete")
	
	public String delete(@RequestParam int id ,RedirectAttributes attributes ) {
		
		emprepo.deleteById(id);
		attributes.addFlashAttribute("message","Record Deleted Successfully");
		return "redirect:/view";
		
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int id, ModelMap map) {
		Employee employee = emprepo.findById(id).orElseThrow();
		map.put("emp", employee);
		return "edit.html";
	}
	
@PostMapping("/update")
	public String update(@ModelAttribute Employee emp, RedirectAttributes attributes) {
		emprepo.save(emp);
		attributes.addFlashAttribute("message","Data Updated Sucesss");
		return "redirect:/view"; 
	}
	
	

	
	
	
	
}
