package lk.sliit.inventorycontrolsystem.projectse2030se.models.users;

import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base.Constructor;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.database.DBTable;

@DBTable("UserTable")
public class BusinessOwner extends User {

    @Constructor
    public BusinessOwner(String userName, String password, String firstName, String lastName, String address, String email, String phoneNumber) {
        super(userName, password, firstName, lastName, address, email, phoneNumber, UserRoles.OWNER);
    }

}
