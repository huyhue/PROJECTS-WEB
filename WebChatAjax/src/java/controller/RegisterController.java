package controller;

import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RoomModel;
import model.UserModel;

public class RegisterController extends HttpServlet {
    private UserModel usermodel;
    private RoomModel roomModel;
    public RegisterController() {
        super();
        usermodel = new UserModel();
        roomModel = new RoomModel();
    }
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String username = request.getParameter("id");
            String pw = request.getParameter("password");
            String Gender = request.getParameter("gender");
            String startDateStr = request.getParameter("DateOfBirth");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
            Date startDate;
            try {
                startDate = df.parse(startDateStr);
                
                int userID = usermodel.Register(username, startDate, pw, Gender);
                int roomID = roomModel.createNewRoomWithName(username);
                
                roomModel.addUserToRoom(userID, roomID);
            } catch (ParseException e) {
                e.printStackTrace();
            }
           response.sendRedirect("login.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
