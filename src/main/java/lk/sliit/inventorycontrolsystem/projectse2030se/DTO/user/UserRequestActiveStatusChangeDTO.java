package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.user;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.UserDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.UserDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;

public record UserRequestActiveStatusChangeDTO(String id, boolean activeStatus) {

    private static final UserDAO userDAO = new UserDAOJdbc();

    public User toUser() {
        User user  = userDAO.getById(id);
        if (user != null) {
            user.setActiveStatus(activeStatus);
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
