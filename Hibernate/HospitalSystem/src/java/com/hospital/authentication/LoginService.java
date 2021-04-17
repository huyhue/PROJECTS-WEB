package com.hospital.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hospital.entities.HospitalService;
import com.hospital.models.Employee;
import com.hospital.utils.PasswordEncryption;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {

    HospitalService hospitalService = HospitalService.getInstance();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Employee employee = (Employee) session.getAttribute("employee");
            if (employee == null) {
                String user = request.getParameter("user");
                String pass = request.getParameter("pass");
                employee = hospitalService.getEmployee(user, PasswordEncryption.encrypt(pass));
                if (employee != null) {
                    session.setAttribute("employee", employee);
                    response.sendRedirect("home.jsp");
                } else {
                    response.sendRedirect("index.jsp?error=true");
                }
            }
        } catch (NoSuchAlgorithmException e) {
            response.sendRedirect("index.jsp?error=true");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
