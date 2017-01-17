package com.opus.model.service;

import java.util.List;

import com.opus.model.Department;

public interface DepartmentService {
	
	Department saveDepartment(Department department);
	Department getDepartmentById(Long id);
	List<Department> findAllDepartments();
	void updateUser(Department currentdepartment);
	void deleteDepartment(Long id);

}
