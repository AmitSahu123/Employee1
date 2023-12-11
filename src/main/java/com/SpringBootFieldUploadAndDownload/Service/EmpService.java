package com.SpringBootFieldUploadAndDownload.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.SpringBootFieldUploadAndDownload.entity.Empentity;
import com.SpringBootFieldUploadAndDownload.repostiotry.Repostitory;

@Service 
public class EmpService implements EmpServiceimpl {
	
	@Autowired
	private Repostitory empRepo;

	@Override
	public Empentity saveEmp(Empentity emp) {
		Empentity newEmp = empRepo.save(emp);
		return newEmp;
	}

	@Override
	public List<Empentity> getAllEmp() {
		
		return empRepo.findAll();
	}

	@Override
	public Empentity getEmpById(int id) {
		return empRepo.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		Empentity emp = empRepo.findById(id).get();
		if(emp!= null) {
		empRepo.delete(emp);	
			return true;	
		}
		
		
		return false;
	}
	
	
	public void removeSessionMessage() {
		
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
	
		
		session.removeAttribute("msg");
	
	}
	
	

}
