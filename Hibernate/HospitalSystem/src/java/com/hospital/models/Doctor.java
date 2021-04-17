package com.hospital.models;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@DiscriminatorValue("Doctor")
public class Doctor extends Employee implements Serializable {

	public Doctor() {
	}

}
