package com.fpt.soft.service;

import java.util.List;

import com.fpt.soft.form.DepartmentForm;
import com.fpt.soft.model.Attachments;

public interface AttachmentsService {
	List<Attachments> saveAll(List<Attachments> entities);
	void register(DepartmentForm df);
	Attachments findByName(String name);
	List<Attachments> findAttachmentsByDepartmentId(int id);
}
