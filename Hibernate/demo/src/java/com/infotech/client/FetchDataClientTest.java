package com.infotech.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.entities.Address;
import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class FetchDataClientTest {

    public static void main(String[] args) {
        Employee employee = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            employee = (Employee) session.get(Employee.class, 1);
            System.out.println("Employee: " + employee);
            Address address = employee.getAddress();
            System.out.println("Address: " + address);
            System.out.println("Address city: " + address.getCity());
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
