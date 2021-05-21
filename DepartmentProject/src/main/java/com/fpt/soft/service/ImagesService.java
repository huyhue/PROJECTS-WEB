package com.fpt.soft.service;

import java.util.List;

import com.fpt.soft.form.DepartmentForm;
import com.fpt.soft.model.Images;

public interface ImagesService {
	List<Images> saveAll(List<Images> entities);
	void register(DepartmentForm df);
	Images findByName(String name);
	List<Images> findImagesByDepartmentId(int id);
	void deleteAll(List<Images> entities);
}
