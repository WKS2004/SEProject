package lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.GeneralDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.UserDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserDAOJdbc extends GeneralDAOJdbc<User> implements UserDAO {

    public UserDAOJdbc() {
        super(User.class);
    }

    @Override
    public User getByUsername(String username){
        /*...*/
        return super.getDataByParameter("username", username);
    }

    @Override
    public User getByEmail(String email){
        /*...*/
        return super.getDataByParameter("email", email);
    }

    @Override
    public User getById(String id) {
        return super.getById(id);
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }

    @Override
    public boolean create(User user) {
        return super.create(user);
    }

    @Override
    public boolean update(User user) {
        return super.update(user);
    }

    @Override
    public boolean delete(User user) {
        return super.delete(user);
    }
}
