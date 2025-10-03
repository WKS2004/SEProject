package lk.sliit.inventorycontrolsystem.projectse2030se.models;

import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Constructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.DBDataRetrieveConstructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Getter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Setter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBColumn;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBTable;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.structure.Model;

import java.time.LocalDateTime;
import java.util.List;

@Model
@DBTable("Notifications")
public class Notification extends DefaultModel {

    @DBColumn("Title")
    private String title;

    @DBColumn("Message")
    private String message;

    @DBColumn("Type")
    private String type;

    @DBColumn("TargetGroups")
    private List<UserRoles> targetGroups;

    @DBColumn("NotificationStatus")
    private boolean activeStatus;

    @Constructor
    public Notification(String title, String message, String type, List<UserRoles> targetGroups) {
        this.title = title;
        this.message = message;
        this.type = type;
        this.targetGroups = targetGroups;
        this.activeStatus = true;
    }

    @Constructor
    @DBDataRetrieveConstructor
    public Notification(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String title, String message, String type, List<UserRoles> targetGroups, boolean activeStatus) {
        super(id, createdAt, updatedAt);
        this.title = title;
        this.message = message;
        this.type = type;
        this.targetGroups = targetGroups;
        this.activeStatus = activeStatus;
    }

    @Setter
    public void setTitle(String title) {
        this.title = title;
    }

    @Setter
    public void setMessage(String message) {
        this.message = message;
    }

    @Setter
    public void setType(String type) {
        this.type = type;
    }

    @Setter
    public void setTargetGroups(List<UserRoles> targetGroups) {
        this.targetGroups = targetGroups;
    }

    @Setter
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Getter
    public String getTitle() {
        return title;
    }

    @Getter
    public String getMessage() {
        return message;
    }

    @Getter
    public String getType() {
        return type;
    }

    @Getter
    public List<UserRoles> getTargetGroups() {
        return targetGroups;
    }

    @Getter
    public boolean isActiveStatus() {
        return activeStatus;
    }

}
