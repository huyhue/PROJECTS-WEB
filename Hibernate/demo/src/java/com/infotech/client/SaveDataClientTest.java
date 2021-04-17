package com.infotech.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Address;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class SaveDataClientTest {

    public static void main(String[] args) {

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            createEmployee(session);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Integer id = (Integer) session.save(getEmployee());
        System.out.println("Employee is created  with Id::" + id);
        session.getTransaction().commit();

    }

    private static Employee getEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("Barry Bingel");
        employee.setEmail("barry.cs2017@gmail.com");
        employee.setSalary(50000.00);
        employee.setDoj(new Date());

        Address address1 = new Address();
        address1.setCity("Chennai");
        address1.setPincode(9087727L);
        address1.setState("Tamilnadu");
        address1.setStreet("Park Street");

        employee.setAddress(address1);

        return employee;
    }
}
