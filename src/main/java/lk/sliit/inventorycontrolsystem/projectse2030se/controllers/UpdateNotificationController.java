package lk.sliit.inventorycontrolsystem.projectse2030se.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.notification.NotificationRequestUpdateDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.web.WebAppPathConfig;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.services.NotificationServices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/notification/update")
public class UpdateNotificationController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        String type = request.getParameter("type");
        String targetGroup = request.getParameter("targetGroup");
        boolean activeStatus = Boolean.parseBoolean(request.getParameter("activeStatus"));

        List<UserRoles> allTargetGroups = new ArrayList<>();

        NotificationServices notificationServices = new NotificationServices();
        boolean success = false;
        if (targetGroup.equals("owner")) {
            allTargetGroups.add(UserRoles.OWNER);
        }
        else if (targetGroup.equals("customer")) {
            allTargetGroups.add(UserRoles.CUSTOMER);
        }
        else if (targetGroup.equals("inventoryManager")) {
            allTargetGroups.add(UserRoles.INVENTORY_MANAGER);
        }
        else if (targetGroup.equals("salesManager")) {
            allTargetGroups.add(UserRoles.SALES_MANAGER);
        }
        else if (targetGroup.equals("supplier")) {
            allTargetGroups.add(UserRoles.SUPPLIER);
        }
        else if (targetGroup.equals("systemAdmin")) {
            allTargetGroups.add(UserRoles.SYSTEM_ADMIN);
        }
        else if (targetGroup.equals("warehouseManager")) {
            allTargetGroups.add(UserRoles.WAREHOUSE_MANAGER);
        }

        NotificationRequestUpdateDTO notificationRequestUpdateDTO = new NotificationRequestUpdateDTO(name, message, type, allTargetGroups, activeStatus);
        success = notificationServices.editNotification(notificationRequestUpdateDTO);

        response.sendRedirect(success ? request.getContextPath() + "/notification/update?success=true" : request.getContextPath() + "/notification/update?success=false");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basePath = new File("target/Project-SE2030-SE-1.0-SNAPSHOT").getAbsolutePath();
        WebAppPathConfig.getInstance().setBasePath(basePath);

        request.getRequestDispatcher("/updateNotificationJSP.jsp").forward(request, response);
    }
}
