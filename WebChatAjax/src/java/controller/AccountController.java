package controller;

import entity.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserModel;

public class AccountController extends HttpServlet {

    private UserModel usermodel;
    private static String Home = "chat.jsp";

    public AccountController() throws Exception {
        super();
        usermodel = new UserModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("password");
        Users user = usermodel.getAccountById(id);

        HttpSession session = request.getSession();
        if (usermodel.CheckAuthen(id, pw) == true) {
            session.setAttribute("user", user);
            Cookie userIDCookie = new Cookie("userID", String.valueOf(user.getUserID()));
            userIDCookie.setMaxAge(3600);
            response.addCookie(userIDCookie);
            response.sendRedirect(Home);
            return;
        } else {
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User or password incorrect');");
            out.println("location='login.jsp';");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
