package lk.sliit.inventorycontrolsystem.projectse2030se.DAO.jdbc;

import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.CourseDAO;
import lk.sliit.inventorycontrolsystem.projectse2030se.DAO.GeneralDAOJdbc;
import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;

import java.util.List;

public class CourseDAOJdbc extends GeneralDAOJdbc<Course> implements CourseDAO {
    public CourseDAOJdbc() {
        super(Course.class);
    }

    @Override
    public Course getByName(String name) {
        return getDataByParameter("name", name);
    }

    @Override
    public Course getById(String id) {
        return super.getById(id);
    }

    @Override
    public List<Course> getAll() {
        return super.getAll();
    }

    @Override
    public boolean create(Course course) {
        return super.create(course);
    }

    @Override
    public boolean update(Course course) {
        return super.update(course);
    }

    @Override
    public boolean delete(Course course) {
        return super.delete(course);
    }

}
