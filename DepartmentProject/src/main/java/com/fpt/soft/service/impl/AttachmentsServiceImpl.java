package com.fpt.soft.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fpt.soft.form.DepartmentForm;
import com.fpt.soft.model.Attachments;
import com.fpt.soft.model.Department;
import com.fpt.soft.repository.AttachmentsRepository;
import com.fpt.soft.repository.DepartmentRepository;
import com.fpt.soft.service.AttachmentsService;

@Service
public class AttachmentsServiceImpl implements AttachmentsService{

	@Autowired
	private AttachmentsRepository attachmentsRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public <S extends Attachments> S save(S entity) {
		return attachmentsRepository.save(entity);
	}

	public List<Attachments> findAttachmentsByDepartmentId(int id) {
		return attachmentsRepository.findAttachmentsByDepartmentId(id);
	}

	public List<Attachments> saveAll(List<Attachments> entities) {
		return (List<Attachments>) attachmentsRepository.saveAll(entities);
	}
	
	public void register(DepartmentForm df){
		Optional<Department> de = departmentRepository.findDepartmentByName(df.getName());	
		List<Attachments> list = new ArrayList<>();
		
		String name = StringUtils.cleanPath(df.getFile().getOriginalFilename());
		String name1 = StringUtils.cleanPath(df.getFile1().getOriginalFilename());
		String name2 = StringUtils.cleanPath(df.getFile2().getOriginalFilename());
		String name3 = StringUtils.cleanPath(df.getFile3().getOriginalFilename());
		try {
			list.add(new Attachments(name, df.getFile().getBytes(), de.get()));
			list.add(new Attachments(name1, df.getFile1().getBytes(), de.get()));
			list.add(new Attachments(name2, df.getFile2().getBytes(), de.get()));
			list.add(new Attachments(name3, df.getFile3().getBytes(), de.get()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		attachmentsRepository.saveAll(list);
    }
	
	public Attachments findByName(String name) {
		return attachmentsRepository.findByName(name);
	}

	public Optional<Attachments> findById(Integer id) {
		return attachmentsRepository.findById(id);
	}

	public boolean existsById(Integer id) {
		return attachmentsRepository.existsById(id);
	}

	public Iterable<Attachments> findAll() {
		return attachmentsRepository.findAll();
	}

	public Iterable<Attachments> findAllById(Iterable<Integer> ids) {
		return attachmentsRepository.findAllById(ids);
	}

	public long count() {
		return attachmentsRepository.count();
	}

	public void deleteById(Integer id) {
		attachmentsRepository.deleteById(id);
	}

	public void delete(Attachments entity) {
		attachmentsRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Attachments> entities) {
		attachmentsRepository.deleteAll(entities);
	}

	public void deleteAll() {
		attachmentsRepository.deleteAll();
	}

	
}
