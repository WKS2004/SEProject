package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.user;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.UserDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.UserDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.data.UserRoles;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;

public record UserRequestUpdateDTO(String id, String userName, String firstName, String lastName, String address, String email, String phoneNumber, UserRoles role) {

    private static final UserDAO userDAO = new UserDAOJdbc();

    public User toUser() {
        User user = userDAO.getById(id);
        if (user != null) {
            user.setUserName(userName);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setDisplayName();
            user.setAddress(address);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
        }
        return user;
    }

    public boolean isUserFound() {
        return (userDAO.getById(id) != null);
    }

    public boolean isUserActive() {
        return userDAO.getById(id).isActiveStatus();
    }

}
