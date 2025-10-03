package lk.sliit.inventorycontrolsystem.projectse2030se.models;

import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Constructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.DBDataRetrieveConstructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBColumn;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBTable;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Getter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Setter;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.structure.Model;

import java.time.LocalDateTime;

@Model
@DBTable("Users")
public class User extends DefaultModel {

    @DBColumn("Username")
    protected String userName;

    @DBColumn("PasswordHash")
    protected String passwordHash;

    @DBColumn("FirstName")
    protected String firstName;

    @DBColumn("LastName")
    protected String lastName;

    @DBColumn("DisplayName")
    protected String displayName;

    @DBColumn("Address")
    protected String address;

    @DBColumn("Email")
    protected String email;

    @DBColumn("PhoneNumber")
    protected String phoneNumber;

    @DBColumn("Role")
    protected UserRoles role;

    @DBColumn("ActiveStatus")
    protected boolean activeStatus;

    @Constructor
    public User(String userName, String passwordHash, String firstName, String lastName, String address, String email, String phoneNumber, UserRoles role) {
        super();
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = firstName + " " + lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.activeStatus = true;
    }

    @Constructor
    @DBDataRetrieveConstructor
    public User(String userID, LocalDateTime created_at, LocalDateTime updated_at, String userName, String passwordHash, String firstName, String lastName, String displayName, String address, String email, String phoneNumber, UserRoles role, boolean activeStatus) {
        super(userID, created_at, updated_at);
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.activeStatus = activeStatus;
    }

    @Setter
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Setter
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Setter
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Setter
    public void setDisplayName() {
        this.displayName = this.firstName + " " + this.lastName;
    }

    @Setter
    public void setAddress(String address) {
        this.address = address;
    }

    @Setter
    public void setEmail(String email) {
        this.email = email;
    }

    @Setter
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Setter
    public void setRole(UserRoles role) {
        this.role = role;
    }

    @Setter
    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Getter
    public String getUserName() {
        return userName;
    }

    @Getter
    public String getPasswordHash() {
        return passwordHash;
    }

    @Getter
    public String getFirstName() {
        return firstName;
    }

    @Getter
    public String getLastName() {
        return lastName;
    }

    @Getter
    public String getDisplayName() {
        return displayName;
    }

    @Getter
    public String getAddress() {
        return address;
    }

    @Getter
    public String getEmail() {
        return email;
    }

    @Getter
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Getter
    public UserRoles getRole() {
        return role;
    }

    @Getter
    public boolean isActiveStatus() {
        return activeStatus;
    }

}
