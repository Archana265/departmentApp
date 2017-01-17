package com.opus.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import com.opus.model.Department;
import com.opus.model.repository.DepartmentRepository;

@Service
@RefreshScope
public class DepartmentServiceImpl implements DepartmentService 
{

	@Autowired
	DepartmentRepository departmentRep;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRep.save(department); 
	}

	@Override
	public Department getDepartmentById(Long id) {
		return departmentRep.findOne(id);
	}

	@Override
	public List<Department> findAllDepartments() {
		return (List<Department>) departmentRep.findAll();
	}

	@Override
	public void updateUser(Department currentdepartment) {
		departmentRep.save(currentdepartment);
	}

	@Override
	public void deleteDepartment(Long id) {
		departmentRep.delete(id);
	}

}
