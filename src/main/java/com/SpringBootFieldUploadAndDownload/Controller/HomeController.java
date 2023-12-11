package com.SpringBootFieldUploadAndDownload.Controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringBootFieldUploadAndDownload.Service.EmpServiceimpl;
import com.SpringBootFieldUploadAndDownload.entity.Empentity;

@Controller
public class HomeController {
	
	private static final String AttributeValue = null;
	@Autowired
	private EmpServiceimpl empservice; 
	
	@GetMapping("/")
	public String index(Model m) {
		
		List<Empentity> list = empservice.getAllEmp();
		m.addAttribute("empList",list);
		
		return "index";
	}

	@GetMapping("/edit_emp/{id}")
	public String edit_emp(@PathVariable int id, Model m) {
		//System.out.println(id);
		Empentity emp = empservice.getEmpById(id);
		m.addAttribute("emp",emp);
		
		return "edit_emp";
	}
	@GetMapping("emp_save")
	public String edit_save() {
		return "emp_save";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Empentity emp ,HttpSession session) {
		//System.out.println(emp);
		
		Empentity newEmp = empservice.saveEmp(emp);
		
		if(newEmp!=null)
		{
			//System.out.println("save succesfully");
			session.setAttribute("msg", "register succesfully");
		}
		else
		{
			//System.out.println("something is getting wrong");
			session.setAttribute("msg", "something wrong on server");
		}
		
		return "redirect:/emp_save"; 
		
	}
	
	
	
	@PostMapping("/updateEmp")
	public String updateEmp(@ModelAttribute Empentity emp ,HttpSession session) {
		//System.out.println(emp);
		
		Empentity updateEmp = empservice.saveEmp(emp);
		
		if(updateEmp!=null)
		{
			//System.out.println("save succesfully");
			session.setAttribute("msg", "update succesfully");
		}
		else
		{
			//System.out.println("something is getting wrong");
			session.setAttribute("msg", "something wrong on server");
		}
		
		return "redirect:/"; 
		
	}
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id ,HttpSession session) {
		//System.out.println(emp);
		
		boolean f = empservice.deleteEmp(id);
		
		if(f)
		{
			//System.out.println("save succesfully");
			session.setAttribute("msg", "delete succesfully");
		}
		else
		{
			//System.out.println("something is getting wrong");
			session.setAttribute("msg", "something wrong on server");
		}
		
		return "redirect:/"; 
		
	}
	
	
	

}
