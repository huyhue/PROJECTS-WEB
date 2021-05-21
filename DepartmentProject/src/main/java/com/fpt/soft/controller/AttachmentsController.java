package com.fpt.soft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.soft.model.Attachments;
import com.fpt.soft.service.AttachmentsService;

@RequestMapping("/file")
@RestController
public class AttachmentsController {
	@Autowired
	private AttachmentsService attachmentsService;
	
	@GetMapping("/downloadFromDB/{name}")
    ResponseEntity<byte[]> downLoadSingleFile(@PathVariable String name, HttpServletRequest request) {
        Attachments file = attachmentsService.findByName(name);

        String mimeType = request.getServletContext().getMimeType(file.getName());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename())
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;file=" + file.getName())
                .body(file.getDocFile());
    }
}
