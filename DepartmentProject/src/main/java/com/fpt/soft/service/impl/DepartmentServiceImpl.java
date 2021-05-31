package com.fpt.soft.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fpt.soft.form.DepartmentForm;
import com.fpt.soft.model.Department;
import com.fpt.soft.repository.DepartmentRepository;
import com.fpt.soft.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;

	
	@Override
	public Department save(Department entity) {
		return departmentRepository.save(entity);
	}

	public Department updateDepartment(Department entity) {
		Optional<Department> optDepart = departmentRepository.findById(entity.getId());
		if (optDepart.get() == null) 
		{
			return null;
		}
		BeanUtils.copyProperties(entity, optDepart.get());
		return departmentRepository.save(entity);
	}

	@Override
	public List<Department> saveAll(List<Department> entities) {
		return (List<Department>) departmentRepository.saveAll(entities);
	}

	public Optional<Department> findDepartmentByName(String name) {
		return departmentRepository.findDepartmentByName(name);
	}

	@Override
	public Optional<Department> findById(Integer id) {
		return departmentRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return departmentRepository.existsById(id);
	}

	@Override
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	public List<Department> findAllById(List<Integer> ids) {
		return (List<Department>) departmentRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return departmentRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public void delete(Department entity) {
		departmentRepository.delete(entity);
	}

	@Override
	public void deleteAll(List<Department> entities) {
		departmentRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		departmentRepository.deleteAll();
	}
	@Override
	public List<Department> findByNameLikeOrderByName(String name) {
		return departmentRepository.findByNameLikeOrderByName("%"+name+"%");
	}
	
	public Department register(DepartmentForm df){
		Department d = new Department();
		d.setName(df.getName());
		d.setAddress(df.getAddress());
		d.setArea(df.getArea());
		d.setCanContain(df.getCanContain());
		d.setLimitTimeRental(df.getLimitTimeRental());
		d.setRentalPeriod(df.getRentalPeriod());
		d.setDescrisption(df.getDescrisption());
        return departmentRepository.save(d);
    }
	
	@Override
    public Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, String keyword) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        if (keyword != null && !keyword.isEmpty()) {
			return this.departmentRepository.findDepartmentByName(keyword, pageable);
		}
        return this.departmentRepository.findAll(pageable);
    }
}
