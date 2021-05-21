package com.fpt.soft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "Attachments")
public class Attachments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Column(name = "docfile")
    @Lob
    private byte[] docFile;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
	private Department department;

	public Attachments(String name, byte[] docFile, Department department) {
		this.name = name;
		this.docFile = docFile;
		this.department = department;
	}
	
}
