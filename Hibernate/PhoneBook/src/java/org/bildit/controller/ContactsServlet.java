package org.bildit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bildit.model.hibernate.Contact;

import org.bildit.model.hibernate.ContactDao;
import org.bildit.model.hibernate.Users;

@WebServlet("/ContactsServlet")
public class ContactsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("user");
        List<Contact> contacts = new ArrayList<>();
        ContactDao contactDao = new ContactDao();
        contacts = contactDao.readAll(user.getId());
        request.getSession().setAttribute("contacts", contacts);
    }
}
