package controller;

import entity.Rooms;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RoomModel;
import model.UserModel;

public class HandleGetRoomController extends HttpServlet {

    RoomModel roomModel = new RoomModel();
    UserModel userModel = new UserModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userID = userModel.getUserIdFromCookie(request);

        ArrayList<Integer> roomIDs = roomModel.getRoomIDsWithUserID(userID);
        ArrayList<Rooms> rooms = new ArrayList<>();
        for (Integer roomID : roomIDs) {
            Rooms room = roomModel.getRoomInfoByRoomID(roomID);
            rooms.add(room);
        }

        StringBuffer messageXML = new StringBuffer();
        for (Rooms room : rooms) {
            messageXML.append("<room>");
            messageXML.append("<name>" + room.getRoomName() + "</name>");
            messageXML.append("<id>" + room.getRoomID() + "</id>");
            messageXML.append("</room>");
        }
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        response.getWriter().write("<rooms>");
        response.getWriter().write(messageXML.toString());
        response.getWriter().write("</rooms>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
