package lk.sliit.inventorycontrolsystem.projectse2030se.DAO;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.Course;

public interface CourseDAO extends GeneralDAO<Course> {
    Course getByName(String name);
}
