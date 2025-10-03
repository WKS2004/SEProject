package lk.sliit.inventorycontrolsystem.projectse2030se.services;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.NotificationDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.NotificationDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.notification.NotificationRequestCreateDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.notification.NotificationRequestDeleteDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DTO.notification.NotificationRequestUpdateDTO;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Notification;

public class NotificationServices {

    private static final NotificationDAO notificationDAO = new NotificationDAOJdbc();

    public boolean addNotification(NotificationRequestCreateDTO notificationRequestCreateDTO) {
        try {
            Notification notification = notificationRequestCreateDTO.toNotification();
            notificationDAO.create(notification);
            System.out.println("Successfully Added a new Notification!");
            return true;
        }
        catch (Exception e) {
            System.out.println("Error while trying to add a new Notification!");
        }
        return false;
    }

    public boolean editNotification(NotificationRequestUpdateDTO notificationRequestUpdateDTO) {
        try {
            if (notificationRequestUpdateDTO.isNotificationFound()) {
                Notification notification = notificationRequestUpdateDTO.toNotification();

                notificationDAO.update(notification);
                System.out.println("Successfully Edited the Notification!");
                return true;
            }
            else {
                System.out.println("Notification not found!");
            }
        }
        catch (Exception e) {
            System.out.println("Error while trying to update the Notification!");
        }
        return false;
    }

    public boolean removeNotification(NotificationRequestDeleteDTO notificationRequestDeleteDTO) {
        try {
            if (notificationRequestDeleteDTO.isNotificationFound()) {
                Notification notification = notificationRequestDeleteDTO.toNotification();

                notificationDAO.delete(notification);
                System.out.println("Successfully Deleted the Notification!");
                return true;
            }
            else {
                System.out.println("Notification not found!");
            }
        }
        catch (Exception e) {
            System.out.println("Error while deleting the Notification!");
        }
        return false;
    }
}
