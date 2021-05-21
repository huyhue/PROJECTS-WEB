package com.fpt.soft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fpt.soft.model.Attachments;
import com.fpt.soft.model.Department;

@Repository
public interface AttachmentsRepository  extends CrudRepository<Attachments, Integer>{
	Attachments findByName(String name);
	List<Attachments> findAttachmentsByDepartmentId(int id);
}
