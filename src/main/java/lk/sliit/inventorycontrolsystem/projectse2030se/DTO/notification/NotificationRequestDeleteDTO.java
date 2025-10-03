package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.notification;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.NotificationDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.NotificationDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Notification;

public record NotificationRequestDeleteDTO(String title) {

    private static final NotificationDAO notificationDAO = new NotificationDAOJdbc();

    public Notification toNotification() {
        Notification notification = notificationDAO.getByTitle(title);
        return notification;
    }

    public boolean isNotificationFound() {
        return (notificationDAO.getByTitle(title) != null);
    }

}
