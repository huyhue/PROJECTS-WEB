package filter;

import entity.Rooms;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import model.RoomModel;
import model.UserModel;

public class AccessChatRoomFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RoomModel roomModel = new RoomModel();
        UserModel userModel = new UserModel();
        int roomID = 0;
        int userId = userModel.getUserIdFromCookie(request);
        
        String plainRoomID = request.getParameter("roomID");
        if (plainRoomID == null) {
            roomID = roomModel.getRoomIDsWithUserID(userId).get(0);
            ((HttpServletResponse)response).sendRedirect("chat.jsp?roomID="+roomID);
            return;
        }
        roomID = Integer.parseInt(plainRoomID);
        
        Rooms room = roomModel.getRoomInfoByRoomID(roomID);
        request.setAttribute("room", room);

        if (roomModel.inUserIdInRoomId(userId, roomID)) {
            chain.doFilter(request, response);
        } else {
            roomID = roomModel.getRoomIDsWithUserID(userId).get(0);
            ((HttpServletResponse)response).sendRedirect("chat.jsp?roomID="+roomID);
        }
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
