package lk.sliit.inventorycontrolsystem.projectse2030se.DAO;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;

public interface UserDAO extends GeneralDAO<User> {
    User getByUsername(String username);
    User getByEmail(String email);
}
