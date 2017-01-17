package com.opus.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.opus.model.Department;
import com.opus.model.service.DepartmentService;

@RestController
public class DepartmentController {

	static Logger logger = Logger.getLogger(DepartmentController.class.getName());

	@Autowired
	DepartmentService departmentServiceImpl;

	@RequestMapping(value = "/department/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Department> getDepartment(@PathVariable("id") long id) {
		System.out.println("Fetching Department with id " + id);
		Department department = departmentServiceImpl.getDepartmentById(id);
		if (department == null) {
			System.out.println("Department with id " + id + " not found");
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}

	@RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getAllDepartment() {
		List<Department> allDepartments = departmentServiceImpl.findAllDepartments();
		if (allDepartments.isEmpty()) {
			System.out.println("No Department found");
			return new ResponseEntity<List<Department>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Department>>(allDepartments, HttpStatus.OK);
	}

	@RequestMapping(value = "/department/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id,
			@RequestBody Department department) {
		Department changeDepartments = departmentServiceImpl.saveDepartment(department);
		if (changeDepartments == null) {
			System.out.println("Unable to update Department details");
			return new ResponseEntity<Department>(HttpStatus.NOT_MODIFIED);
		}
		return new ResponseEntity<Department>(changeDepartments, HttpStatus.OK);
	}

	@RequestMapping(value = "/department", method = RequestMethod.POST)
	public ResponseEntity<Department> createDepartment(@RequestBody Department department) {

		Department postedDepartment = departmentServiceImpl.saveDepartment(department);
		if (postedDepartment == null) {
			System.out.println("Unable to save the department");
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Department>(postedDepartment, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/department/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Department> deletedepartment(@PathVariable Long id) {
		if (departmentServiceImpl.getDepartmentById(id) == null) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		} else {
			departmentServiceImpl.deleteDepartment(id);
			return new ResponseEntity<Department>(HttpStatus.OK);
		}

	}

}
