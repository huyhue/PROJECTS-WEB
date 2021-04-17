package model;

import dao.DatabaseDAO;
import entity.Rooms;
import java.util.ArrayList;

public class RoomModel {
    DatabaseDAO databaseDAO = new DatabaseDAO();
    
    public int createNewRoomWithName(String roomName) {
        return databaseDAO.createNewRoomWithName(roomName);
    }
    
    public void addUserToRoom(int userID, int roomID) {
        databaseDAO.addUserToRoom(userID, roomID);
    }
    
    public void deleteUserFromRoom(int userID, int roomID) {
        databaseDAO.deleteUserFromRoom(userID, roomID);
    }
    
    public ArrayList<Integer> getRoomIDsWithUserID(int userID) {
        return databaseDAO.getRoomIDsWithUserID(userID);
    }
    
    public Rooms getRoomInfoByRoomID(int roomID) {
        return databaseDAO.getRoomInfoByRoomID(roomID);
    }
    
    public boolean inUserIdInRoomId(int userID, int RoomID) {
        if (RoomID == 0) return true;
        
        return databaseDAO.inUserIdInRoomId(userID, RoomID);
    }
}
