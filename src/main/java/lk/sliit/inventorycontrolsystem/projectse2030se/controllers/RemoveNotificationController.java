package lk.sliit.inventorycontrolsystem.projectse2030se.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.notification.NotificationRequestDeleteDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.web.WebAppPathConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.services.NotificationServices;

import java.io.File;
import java.io.IOException;

@WebServlet("/notification/remove")
public class RemoveNotificationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");

        NotificationServices notificationServices = new NotificationServices();
        NotificationRequestDeleteDTO notificationRequestDeleteDTO = new NotificationRequestDeleteDTO(title);

        boolean success = notificationServices.removeNotification(notificationRequestDeleteDTO);
        response.sendRedirect(success ? request.getContextPath() + "/notification/remove?success=true" : request.getContextPath() + "/notification/remove?success=false");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = new File("target/Project-SE2030-SE-1.0-SNAPSHOT").getAbsolutePath();
        WebAppPathConfig.getInstance().setBasePath(basePath);

        request.getRequestDispatcher("/deleteNotificationJSP.jsp").forward(request, response);
    }
}
