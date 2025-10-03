package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.notification;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.NotificationDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.NotificationDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Notification;

import java.time.LocalDateTime;
import java.util.List;

public record NotificationRequestUpdateDTO(String title, String message, String type, List<UserRoles> targetGroups, boolean activeStatus) {

    private static final NotificationDAO notificationDAO = new NotificationDAOJdbc();

    public Notification toNotification() {
        Notification notification = notificationDAO.getByTitle(title);
        if (notification != null) {
            notification.setUpdatedAt();
            notification.setTitle(title);
            notification.setMessage(message);
            notification.setType(type);
            notification.setTargetGroups(targetGroups);
            notification.setActiveStatus(activeStatus);
        }
        return notification;
    }

    public boolean isNotificationFound() {
        return notificationDAO.getByTitle(title) != null;
    }

}
