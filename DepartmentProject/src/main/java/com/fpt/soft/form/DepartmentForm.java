package com.fpt.soft.form;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Component
public class DepartmentForm implements Serializable{
	@Length(min = 5, max = 50)
	@NotEmpty(message = "Please provide a name department")
	private String name;
	
	@NotNull(message = "Please provide a address department")
	private Integer address;
	
	private MultipartFile image;
	private MultipartFile image1;
	private MultipartFile image2;
	private MultipartFile image3;
	
	private MultipartFile file;
	private MultipartFile file1;
	private MultipartFile file2;
	private MultipartFile file3;
	
	@NotNull(message = "Please provide a area department")
	private Integer area;
	
	@NotNull(message = "Please provide a canContain department")
	private Integer canContain;
	
	@NotNull(message = "Please provide a limitTimeRental department")
	private Integer limitTimeRental;
	
	@NotNull(message = "Please provide a rentalPeriod department")
	private Integer rentalPeriod;
	
	@NotEmpty(message = "Please provide a descrisption department")
	private String descrisption;
}
