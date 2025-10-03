package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.user;

import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.crypto.Argon2Config;

public record UserRequestRegisterDTO(String userName, String password, String firstName, String lastName, String address, String email, String phoneNumber, UserRoles role) {

    public UserRequestRegisterDTO(String userName, String password, String firstName, String lastName, String address, String email, String phoneNumber, UserRoles role) {
        this.userName = userName;
        this.password = Argon2Config.hashPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public User toUser() {
        return new User(userName, password, firstName, lastName, address, email, phoneNumber, role);
    }

}