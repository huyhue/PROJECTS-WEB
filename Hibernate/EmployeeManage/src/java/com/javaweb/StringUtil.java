package com.javaweb;

import com.github.javafaker.Faker;
import com.javaweb.bean.Department;
import com.javaweb.bean.Employee;
import com.javaweb.bean.HibernateUtil;
import java.sql.Date;
import java.sql.Time;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StringUtil {

    private static Random random = new Random();

    public static void main(String[] args) {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        System.out.println("Name ramdom: "+name);
    }
    public static Employee getRandomEmployee() {
        Faker faker = new Faker();
        String name =faker.name().firstName();
//        String name = faker.name().fullName();
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(20 + random.nextInt(40));

        int year = 1950 + random.nextInt(40);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(31);

        employee.setBirthday(Date.valueOf(year + "-" + month + "-" + day));
        employee.setDateCreated(new java.util.Date());
        employee.setDescription(faker.address().streetAddress());
//		employee.setDisabled(random.nextInt(10)==9);

        employee.setSex(random.nextInt(3) == 2 ? "M" : "F");
        int hh = 7 + random.nextInt(2);
        int mm = random.nextInt(60);
        int ss = random.nextInt(60);

        employee.setStartTime(Time.valueOf(hh + ":" + mm + ":" + ss));
        int hhh = 16 + random.nextInt(2);
        employee.setEndTime(Time.valueOf(hhh + ":" + mm + ":" + ss));
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction trans = session.beginTransaction();
       
//        employee.setDepartmentById((Department) session.get(Department.class, new Integer(1)));
        double salary = 1000 + random.nextDouble() * 5000;
        employee.setSalary(salary);

        return employee;
    }

    public static boolean isNull(String str) {
        return str == null || "".equals(str);
    }

    public static Object getURL(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        String url = requestURI + "?" + filterQueryString(queryString);
        if (!url.endsWith("?")) {
            url += "&";
        }
        return url;
    }

    private static String filterQueryString(String queryString) {
        if (queryString == null) {
            return "";
        }
        queryString = queryString.replaceAll("[^&]*sort=[^&]*", ""); // [^&]* means anything but & for (0 or 1+) times
        queryString = queryString.replaceAll("[^&]*order=[^&]*", ""); // delete everything between the 2 '&' s
        queryString = queryString.replaceAll("[^&]*action=[^&]*", "");
        queryString = queryString.replaceAll("&{2,}", "");
        queryString = queryString.replaceAll("^&", "");
        queryString = queryString.replaceAll("&$", "");
        return queryString;
    }
}
