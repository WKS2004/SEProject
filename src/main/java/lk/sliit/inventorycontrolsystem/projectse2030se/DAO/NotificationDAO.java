package lk.sliit.inventorycontrolsystem.projectse2030se.DAO;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.Notification;

public interface NotificationDAO extends GeneralDAO<Notification> {
    Notification getByTitle(String title);
}
