package model;

import dao.DatabaseDAO;
import entity.Messages;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageModel {
    DatabaseDAO databaseDAO = new DatabaseDAO();
    
    public void createNewMessage(int userId, int RoomId, String content, Date dateUploaded) {
        databaseDAO.createNewMessage(userId, RoomId, content, dateUploaded);
    }
    
    public ArrayList<Messages> getAllMessageInRoom(int roomID) {
        return databaseDAO.getAllMessageInRoom(roomID);
    }
    
    public void AddNewBannerWord(String word){
        databaseDAO.AddNewBannerWord(word);
    }
    public List<String> getAllBannerWords() {
        return databaseDAO.getAllBannerWordst();
    }
}
