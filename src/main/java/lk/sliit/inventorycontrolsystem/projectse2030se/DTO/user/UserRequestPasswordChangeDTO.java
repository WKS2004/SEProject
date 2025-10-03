package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.user;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.UserDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.UserDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;
import lk.sliit.inventorycontrolsystem.projectse2030se.config.crypto.Argon2Config;

public record UserRequestPasswordChangeDTO(String id, String newPasswordHash, boolean activeStatus) {

    private static final UserDAO userDAO = new UserDAOJdbc();

    public UserRequestPasswordChangeDTO(String id, String newPasswordHash, boolean activeStatus) {
        this.id = id;
        this.newPasswordHash = Argon2Config.hashPassword(newPasswordHash);
        this.activeStatus = activeStatus;
    }

    public User toUser() {
        User user = userDAO.getById(id);
        if (user != null) {
            user.setPasswordHash(newPasswordHash);
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
