package com.hospital.models;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@DiscriminatorValue("Xray")
public class Xray extends Employee implements Serializable {

    public Xray() {
    }
}
