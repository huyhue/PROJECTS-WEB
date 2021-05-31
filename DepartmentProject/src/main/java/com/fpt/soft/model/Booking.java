package com.fpt.soft.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String phone;
	private String mobile;
	private String email;
	private String address;
	private Date dateStart;
	private Date dateEnd;
	private Date dateBooking;
	private int person;
	private String content;
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
	private Department department;

	public Booking(String name, String phone, String mobile, String email, String address, Date dateStart, Date dateEnd,
			Date dateBooking, int person, String content, boolean status, Department department) {
		super();
		this.name = name;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.dateBooking = dateBooking;
		this.person = person;
		this.content = content;
		this.status = status;
		this.department = department;
	}
}
