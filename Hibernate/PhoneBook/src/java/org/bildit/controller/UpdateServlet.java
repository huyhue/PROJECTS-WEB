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

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String req = request.getParameter("update");
        ContactDao contactBo = new ContactDao();
        Contact contact = contactBo.readContactById(Integer.parseInt(req));
        request.setAttribute("contact", contact);
        request.getRequestDispatcher("updateContact.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("submit").equals("cancel")) {
            request.getRequestDispatcher("contacts.jsp").forward(request, response);
        } else {
            String req = request.getParameter("submit");
            Users user = (Users) request.getSession().getAttribute("user");
            ContactDao contactDao = new ContactDao();
            Contact contact = new Contact();
            contact.setFirstname(request.getParameter("firstName"));
            contact.setLastname(request.getParameter("lastName"));
            contact.setPhonenumber(request.getParameter("phoneNumber"));
            contact.setAddress(request.getParameter("address"));
            contact.setEmail(request.getParameter("email"));
            contact.setUserid(user.getId());
            contact.setId(Integer.parseInt(req));
            boolean result = contactDao.updateContact(contact);

            if (result) {
                request.setAttribute("screen", "Contact successfuly updated!");
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else {
                request.setAttribute("screen", "Error! Please try again!");
                request.getRequestDispatcher("contacts.jsp").forward(request, response);
            }
        }
    }
}
