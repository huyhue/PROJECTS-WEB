package controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MessageModel;

public class HandleSendMessageController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String content = request.getParameter("content");
        String roomIDPlain = request.getParameter("roomID");
        int roomID = Integer.parseInt(roomIDPlain);
        Date timeUpdated = new Date();
        Cookie[] cookies = request.getCookies();
        int userID = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("userID")) {
                userID = Integer.parseInt(cookie.getValue());
                System.out.println("Cookie name===>: "+cookie.getName()+" =Value==> "+cookie.getValue());
            }
        }
        MessageModel messageModel = new MessageModel();
        messageModel.createNewMessage(userID, roomID, content, timeUpdated);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
