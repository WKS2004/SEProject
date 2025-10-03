package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.notification;

import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Notification;

import java.util.List;

public record NotificationRequestCreateDTO(String title, String message, String type, List<UserRoles> targetGroups) {

    public Notification toNotification() {
        return new Notification(title, message, type, targetGroups);
    }
}
