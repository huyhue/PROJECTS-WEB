package com.fpt.soft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fpt.soft.model.Images;

@Repository
public interface ImagesRepository  extends CrudRepository<Images, Integer>{
	Images findByName(String name);
	List<Images> findImagesByDepartmentId(int id);
}
