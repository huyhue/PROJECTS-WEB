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

import com.fpt.soft.model.Images;
import com.fpt.soft.service.ImagesService;

@RequestMapping("/image")
@Controller
public class ImagesController {
	@Autowired
	private ImagesService imagesService;
	
	@GetMapping("/downloadFromDB/{name}")
    ResponseEntity<byte[]> downLoadSingleFile(@PathVariable String name, HttpServletRequest request) {
        Images image = imagesService.findByName(name);

        String mimeType = request.getServletContext().getMimeType(image.getName());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mimeType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName="+resource.getFilename())
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline;name=" + image.getName())
                .body(image.getDocFile());
    }
}
