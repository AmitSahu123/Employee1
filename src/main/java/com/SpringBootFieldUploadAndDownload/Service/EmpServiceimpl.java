package com.SpringBootFieldUploadAndDownload.Service;

import java.util.List;

import com.SpringBootFieldUploadAndDownload.entity.Empentity;

public interface EmpServiceimpl {
	
	public Empentity  saveEmp(Empentity emp);
	
	public List<Empentity> getAllEmp();
	
	public Empentity getEmpById(int id);
	
	public boolean deleteEmp(int id);
	
}
