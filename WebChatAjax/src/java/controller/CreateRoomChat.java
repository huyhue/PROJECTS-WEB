package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RoomModel;
import model.UserModel;

public class CreateRoomChat extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();
        String roomName = "";
        ArrayList<Integer> userIDs = new ArrayList<>();
        for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            if (key.equalsIgnoreCase("roomNameInput")) {
                roomName = value[0];
            } else {
                userIDs.add(Integer.parseInt(key));
            }
        }
        RoomModel roomModel = new RoomModel();
        int roomID = roomModel.createNewRoomWithName(roomName);

        UserModel userModel = new UserModel();
        int currentUserId = userModel.getUserIdFromCookie(request);
        roomModel.addUserToRoom(currentUserId, roomID);

        for (Integer userID : userIDs) {
            roomModel.addUserToRoom(userID, roomID);
        }
        response.sendRedirect("chat.jsp?roomID=" + roomID);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
