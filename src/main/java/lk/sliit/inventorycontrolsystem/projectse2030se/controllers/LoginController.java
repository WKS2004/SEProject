package lk.sliit.inventorycontrolsystem.projectse2030se.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.web.WebAppPathConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;
import lk.sliit.inventorycontrolsystem.projectse2030se.services.UserServices;

import java.io.IOException;

public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String basePath = getServletContext().getRealPath("/data/");
//        WebAppPathConfig.getInstance().setBasePath(basePath);
//
//        request.getRequestDispatcher("/user/login.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String basePath = getServletContext().getRealPath("/data/");
//        WebAppPathConfig.getInstance().setBasePath(basePath);
//
//        String usernameOrEmail = request.getParameter("usernameOrEmail");
//        String password = request.getParameter("password");
//
//        UserServices userService = new UserServices();
//        User user = userService.loginUser(usernameOrEmail, password);
//
//        if (user != null) {
//            HttpSession session = request.getSession(true);
//            session.setAttribute("loggedUser", user);
//            response.sendRedirect(request.getContextPath() + "/profile");
//        }
//        else {
//            response.sendRedirect(request.getContextPath() + "/login?error=UserDoesNotExist");
//        }
    }
}
