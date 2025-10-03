package lk.sliit.inventorycontrolsystem.projectse2030se.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.user.UserRequestRegisterDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.web.WebAppPathConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.services.UserServices;

import java.io.File;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String role = request.getParameter("role");


        UserServices userService = new UserServices();
        boolean success = true;
        if (role.equalsIgnoreCase("customer")) {
            UserRequestRegisterDTO userRequestRegisterDTO = new UserRequestRegisterDTO(userName, password, firstName, lastName, address, email, phoneNumber, UserRoles.CUSTOMER);
            success = userService.registerUser(userRequestRegisterDTO);
        }
        else if (role.equalsIgnoreCase("supplier")) {
            UserRequestRegisterDTO userRequestRegisterDTO = new UserRequestRegisterDTO(userName, password, firstName, lastName, address, email, phoneNumber, UserRoles.SUPPLIER);
            success = userService.registerUser(userRequestRegisterDTO);
        }

        response.sendRedirect(success ? request.getContextPath() + "/register?registrationSuccess=true" : request.getContextPath() + "/register?registrationSuccess=false");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = new File("target/Project-SE2030-SE-1.0-SNAPSHOT").getAbsolutePath();
        WebAppPathConfig.getInstance().setBasePath(basePath);

        request.getRequestDispatcher("/user_register.jsp").forward(request, response);
    }
}
