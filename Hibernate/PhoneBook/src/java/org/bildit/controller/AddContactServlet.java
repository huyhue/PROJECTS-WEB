package org.bildit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bildit.model.hibernate.Contact;

import org.bildit.model.hibernate.ContactDao;
import org.bildit.model.hibernate.Users;

@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users user = (Users) request.getSession().getAttribute("user");
        Contact contact = new Contact();
        contact.setFirstname(request.getParameter("firstName"));
        contact.setLastname(request.getParameter("lastName"));
        contact.setPhonenumber(request.getParameter("phoneNumber"));
        contact.setAddress(request.getParameter("address"));
        contact.setEmail(request.getParameter("email"));
        contact.setUserid(user.getId());

        ContactDao contactDao = new ContactDao();
        boolean result = contactDao.createContact(contact);
        if (result) {
            request.setAttribute("screen", "Contact successfuly added!");
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("screen", "Error! Try again");
            response.sendRedirect("addContact.jsp");
        }
    }
}
