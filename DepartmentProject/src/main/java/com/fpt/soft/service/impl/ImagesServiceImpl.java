package com.fpt.soft.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fpt.soft.form.DepartmentForm;
import com.fpt.soft.model.Department;
import com.fpt.soft.model.Images;
import com.fpt.soft.repository.DepartmentRepository;
import com.fpt.soft.repository.ImagesRepository;
import com.fpt.soft.service.ImagesService;

@Service
public class ImagesServiceImpl implements ImagesService{

	@Autowired
	private ImagesRepository imagesRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public <S extends Images> S save(S entity) {
		return imagesRepository.save(entity);
	}

	public Images findByName(String name) {
		return imagesRepository.findByName(name);
	}

	public List<Images> findImagesByDepartmentId(int id) {
		return imagesRepository.findImagesByDepartmentId(id);
	}

	public List<Images> saveAll(List<Images> entities) {
		return (List<Images>) imagesRepository.saveAll(entities);
	}

	public Optional<Images> findById(Integer id) {
		return imagesRepository.findById(id);
	}

	public boolean existsById(Integer id) {
		return imagesRepository.existsById(id);
	}

	public List<Images> findAll() {
		return (List<Images>) imagesRepository.findAll();
	}

	public Iterable<Images> findAllById(Iterable<Integer> ids) {
		return imagesRepository.findAllById(ids);
	}

	public long count() {
		return imagesRepository.count();
	}

	public void deleteById(Integer id) {
		imagesRepository.deleteById(id);
	}

	public void delete(Images entity) {
		imagesRepository.delete(entity);
	}

	public void deleteAll(List<Images> entities) {
		imagesRepository.deleteAll(entities);
	}
	public void deleteAllByDepartmentId() {

	}

	public void deleteAll() {
		imagesRepository.deleteAll();
	}

	public void register(DepartmentForm df){
		Optional<Department> de = departmentRepository.findDepartmentByName(df.getName());	
		List<Images> list = new ArrayList<>();
		
		String name = StringUtils.cleanPath(df.getImage().getOriginalFilename());
		String name1 = StringUtils.cleanPath(df.getImage1().getOriginalFilename());
		String name2 = StringUtils.cleanPath(df.getImage2().getOriginalFilename());
		String name3 = StringUtils.cleanPath(df.getImage3().getOriginalFilename());
		
		try {
			list.add(new Images(name, df.getImage().getBytes(), de.get()));
			list.add(new Images(name1, df.getImage1().getBytes(), de.get()));
			list.add(new Images(name2, df.getImage2().getBytes(), de.get()));
			list.add(new Images(name3, df.getImage3().getBytes(), de.get()));
			System.out.println("Size: "+list.size());
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getName().isEmpty()) {
					list.remove(i);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		imagesRepository.saveAll(list);
    }
}
