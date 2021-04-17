/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Users;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserModel;

public class HandleGetAllUsersRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserModel userModel = new UserModel();
        ArrayList<Users> users = userModel.getAllUsers();
            
        StringBuffer userXML = new StringBuffer();
        for (Users user : users) {
            userXML.append("<user>");
            userXML.append("<username>" +user.getUserName().trim() + "</username>");
            userXML.append("<userid>" + user.getUserID() + "</userid>");
            userXML.append("<gender>" + user.getSex()+ "</gender>");
            userXML.append("<dateofbirth>" + user.getDateOfBirth()+ "</dateofbirth>");
            userXML.append("</user>");
        }
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write("<users>");
        response.getWriter().write(userXML.toString());
        response.getWriter().write("</users>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
