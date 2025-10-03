package lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.GeneralDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.NotificationDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Notification;

import java.util.List;

public class NotificationDAOJdbc extends GeneralDAOJdbc<Notification> implements NotificationDAO {
    public NotificationDAOJdbc() {
        super(Notification.class);
    }

    @Override
    public Notification getByTitle(String title) {
        /*...*/
        return getDataByParameter("title", title);
    }

    @Override
    public Notification getById(String id) {
        return super.getById(id);
    }

    @Override
    public List<Notification> getAll() {
        return super.getAll();
    }

    @Override
    public boolean create(Notification notification) {
        return super.create(notification);
    }

    @Override
    public boolean update(Notification notification) {
        return super.update(notification);
    }

    @Override
    public boolean delete(Notification notification) {
        return super.delete(notification);
    }
}
