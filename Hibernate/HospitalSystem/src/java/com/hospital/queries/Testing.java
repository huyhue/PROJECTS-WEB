package com.hospital.queries;

import com.hospital.entities.AdminDAO;
import com.hospital.entities.HospitalService;
import com.hospital.entities.PharmatiestDAO;
import com.hospital.models.EmployeeStatatistic;
import com.hospital.utils.Entity;
import java.util.List;

public class Testing {
    public static void main(String[] args) {
        AdminDAO adminDAO = HospitalService.getInstance();
        List<EmployeeStatatistic> employeeStatatistics = adminDAO.getEmployeeStatistic();
//        for (EmployeeStatatistic e : employeeStatatistics) {
//            System.out.println("test: "+e);
//        }
        System.out.println("Enum: "+Entity.Receptioniest.name());
        PharmatiestDAO pharmatiestDAO = HospitalService.getInstance();
        System.out.println("Max...: "+pharmatiestDAO.getMaxIDObject());
    }
}
