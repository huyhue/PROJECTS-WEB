package filter;

import model.RoomModel;
import model.UserModel;

public class Testing {
    public static void main(String[] args) {
        RoomModel roomModel = new RoomModel();
        UserModel userModel = new UserModel();
        
        int roomID = roomModel.getRoomIDsWithUserID(4).get(0);
        System.out.println("Testing: "+roomID);
    }
}
