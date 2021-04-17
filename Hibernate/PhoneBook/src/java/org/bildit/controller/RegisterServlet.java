package org.bildit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bildit.model.hibernate.UserDao;
import org.bildit.model.hibernate.Users;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        System.out.println("Info"+username+password+email);
        UserDao userDao = new UserDao();
        Users user = new Users(username, password, email);
        boolean result = userDao.createUser(user);

        if (result) {
            request.setAttribute("screen", "Registration successful!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            user = userDao.readUser(username);
            if (user != null) {
                request.setAttribute("screen", "Username already exists!");
            } else {
                request.setAttribute("screen", "Email already used!");
            }
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
