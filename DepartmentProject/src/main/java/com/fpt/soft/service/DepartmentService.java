package com.fpt.soft.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.fpt.soft.form.DepartmentForm;
import com.fpt.soft.model.Department;

public interface DepartmentService {

	void deleteAll();

	void deleteAll(List<Department> entities);

	void delete(Department entity);

	void deleteById(Integer id);

	long count();

	List<Department> findAllById(List<Integer> ids);

	List<Department> findAll();

	boolean existsById(Integer id);

	Optional<Department> findById(Integer id);

	List<Department> saveAll(List<Department> entities);
	Department updateDepartment(Department entity);
	Department save(Department department);
	Optional<Department> findDepartmentByName(String name);
	Department register(DepartmentForm df);
	
	List<Department> findByNameLikeOrderByName(String name);
	
	Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, String keyword);
}
