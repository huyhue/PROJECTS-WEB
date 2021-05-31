package com.fpt.soft.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int address;
	private int area;
	private int canContain;
	private int limitTimeRental;
	private int rentalPeriod;
	private String descrisption;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	private List<Images> images;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Attachments> attachments;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private List<Booking> booking;
}
