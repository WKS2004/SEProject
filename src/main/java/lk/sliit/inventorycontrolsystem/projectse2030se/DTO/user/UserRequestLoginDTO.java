package lk.sliit.inventorycontrolsystem.projectse2030se.DTO.user;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.UserDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc.UserDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;

public record UserRequestLoginDTO(String usernameOrEmail, String password) {

    private static final UserDAO userDAO = new UserDAOJdbc();

    public User toUser() {
        User user = userDAO.getByUsername(usernameOrEmail);
        user = (user == null) ? userDAO.getByEmail(usernameOrEmail) : user;

        return user;
    }

    public boolean isUserFound() {
        return (userDAO.getByUsername(usernameOrEmail) != null || (userDAO.getByEmail(usernameOrEmail) != null));
    }

    public boolean isUserActive() {
        return (userDAO.getByUsername(usernameOrEmail).isActiveStatus() || (userDAO.getByEmail(usernameOrEmail).isActiveStatus()));
    }

}
